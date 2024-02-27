package t11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myException.CustomException;
import myException.InvalidValueException;
import utility.Utils;

public class DatabaseConnectivity {

	public void createEmployeeTable() throws CustomException {
		Connection con = DBConnection.getConnection();
		try (Statement stmt = con.createStatement();) {
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS Employee(EMPLOYEE_ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(30), MOBILE BIGINT, EMAIL VARCHAR(50), DEPARTMENT VARCHAR(20))");
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public void createDependentTable() throws CustomException {
		Connection con = DBConnection.getConnection();
		try (Statement stmt = con.createStatement();) {
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS Dependent(EMPLOYEE_ID INT, NAME VARCHAR(30), AGE INT, RELATIONSHIP VARCHAR(50),CONSTRAINT fk_employee_id FOREIGN KEY(EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID) ON DELETE CASCADE)");
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public void addEmployee(Employee employee) throws InvalidValueException, CustomException {
		Utils.checkNull(employee);
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con
				.prepareStatement("INSERT INTO Employee ( NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?,?,?,?)");) {
			stmt.setString(1, employee.getName());
			stmt.setLong(2, employee.getNumber());
			stmt.setString(3, employee.getEmail());
			stmt.setString(4, employee.getDepartment());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public void addEmployees(List<Employee> employees) throws InvalidValueException, CustomException {
		Utils.checkNull(employees);
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con
				.prepareStatement("INSERT INTO Employee (NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?,?,?,?)");) {
			for (Employee employee : employees) {
				stmt.setString(1, employee.getName());
				stmt.setLong(2, employee.getNumber());
				stmt.setString(3, employee.getEmail());
				stmt.setString(4, employee.getDepartment());
				stmt.addBatch();
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public void addEmployeeDependent(Dependent dependent) throws InvalidValueException, CustomException {
		Utils.checkNull(dependent);
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con
				.prepareStatement("INSERT INTO Dependent (EMPLOYEE_ID, NAME, AGE, RELATIONSHIP) VALUES (?,?,?,?)");) {
			stmt.setInt(1, dependent.getEmployeeId());
			stmt.setString(2, dependent.getName());
			stmt.setInt(3, dependent.getAge());
			stmt.setString(4, dependent.getRelationship());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public void addEmployeeDependent(List<Dependent> dependents) throws InvalidValueException, CustomException {
		Utils.checkNull(dependents);
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con
				.prepareStatement("INSERT INTO Dependent (EMPLOYEE_ID, NAME, AGE, RELATIONSHIP) VALUES (?,?,?,?)");) {
			for (Dependent dependent : dependents) {
				stmt.setInt(1, dependent.getEmployeeId());
				stmt.setString(2, dependent.getName());
				stmt.setInt(3, dependent.getAge());
				stmt.setString(4, dependent.getRelationship());
				stmt.addBatch();
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public List<Dependent> getDependents(int id) throws CustomException {
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con.prepareStatement(
				"SELECT d.* FROM Employee e INNER JOIN Dependent d on e.EMPLOYEE_ID=d.EMPLOYEE_ID WHERE e.EMPLOYEE_ID = ?");) {
			stmt.setInt(1, id);
			try (ResultSet result = stmt.executeQuery();) {
				List<Dependent> datas = new ArrayList<>();
				while (result.next()) {
					Dependent dependent = new Dependent();
					dependent.setEmployeeId(result.getInt("EMPLOYEE_ID"));
					dependent.setAge(result.getInt("AGE"));
					dependent.setName(result.getString("NAME"));
					dependent.setRelationship(result.getString("RELATIONSHIP"));
					datas.add(dependent);
				}
				return datas;
			}
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public Map<Integer, Employee> getSortedDependents(int limit) throws CustomException {
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con
				.prepareStatement("SELECT e.EMPLOYEE_ID ID, e.NAME EMPLOYEE_NAME, d.* FROM Employee e "
						+ "LEFT JOIN Dependent d on e.EMPLOYEE_ID=d.EMPLOYEE_ID " + "WHERE e.EMPLOYEE_ID IN "
						+ "(select * from (SELECT EMPLOYEE_ID FROM Employee ORDER BY e.name limit ?) as emp_table)")) {
			stmt.setLong(1, limit);
			try (ResultSet result = stmt.executeQuery();) {

				Map<Integer, Employee> datas = new HashMap<>();

				while (result.next()) {
					int employeeId = result.getInt("ID");
					Employee employee = datas.get(employeeId);
					if (employee == null) {
						employee = new Employee();
						employee.setId(employeeId);
						employee.setName(result.getString("EMPLOYEE_NAME"));
						datas.put(employeeId, employee);
					}
					Dependent dependent = new Dependent();
					dependent.setEmployeeId(result.getInt("EMPLOYEE_ID"));
					dependent.setAge(result.getInt("AGE"));
					dependent.setName(result.getString("NAME"));
					dependent.setRelationship(result.getString("RELATIONSHIP"));
					employee.addDependent(dependent);
				}

				return datas;
			}
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public List<Employee> getEmployeeByName(String name) throws InvalidValueException, CustomException {
		Utils.checkNull(name);
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM Employee WHERE NAME = ?");) {
			stmt.setString(1, name);
			try (ResultSet result = stmt.executeQuery();) {
				List<Employee> employees = resultSetToEmployees(result);
				return employees;
			}
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public void updateEmployeeMobile(int id, long number) throws CustomException {
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con.prepareStatement("UPDATE Employee SET MOBILE = ? WHERE EMPLOYEE_ID = ?");) {
			stmt.setLong(1, number);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public void updateEmployeeEmail(int id, String email) throws InvalidValueException, CustomException {
		Utils.checkNull(email);
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con.prepareStatement("UPDATE Employee SET EMAIL = ? WHERE EMPLOYEE_ID = ?");) {
			stmt.setString(1, email);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public void updateEmployeeDepartment(int id, String department) throws InvalidValueException, CustomException {
		Utils.checkNull(department);
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con
				.prepareStatement("UPDATE Employee SET DEPARTMENT = ? WHERE EMPLOYEE_ID = ?");) {
			stmt.setString(1, department);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public List<Employee> getFirstNEmployees(int limit) throws CustomException, InvalidValueException {
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM Employee LIMIT ?");) {
			stmt.setInt(1, limit);
			try (ResultSet result = stmt.executeQuery();) {
				List<Employee> employees = resultSetToEmployees(result);
				return employees;
			}
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public List<Employee> getFirstNNameSortedEmployees(int limit) throws CustomException, InvalidValueException {
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM Employee ORDER BY NAME LIMIT ?");) {
			stmt.setInt(1, limit);
			try (ResultSet result = stmt.executeQuery();) {
				List<Employee> employees = resultSetToEmployees(result);
				return employees;
			}
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public void deleteEmployee(int id) throws CustomException {
		Connection con = DBConnection.getConnection();
		try (PreparedStatement stmt = con.prepareStatement("DELETE FROM Employee WHERE EMPLOYEE_ID = ?");) {
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			throw new CustomException("Creation failed.", e);
		}
	}

	public List<Employee> resultSetToEmployees(ResultSet result) throws InvalidValueException, SQLException {
		Utils.checkNull(result);
		List<Employee> employees = new ArrayList<Employee>();
		while (result.next()) {
			Employee employee = new Employee();
			employee.setId(result.getInt("EMPLOYEE_ID"));
			employee.setName(result.getString("NAME"));
			employee.setNumber(result.getLong("MOBILE"));
			employee.setEmail(result.getString("EMAIL"));
			employee.setDepartment(result.getString("DEPARTMENT"));
			employees.add(employee);
		}
		return employees;
	}

}
