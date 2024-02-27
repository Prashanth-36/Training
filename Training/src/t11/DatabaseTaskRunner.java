package t11;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import myException.CustomException;
import myException.InvalidValueException;
import utility.Utils;

public class DatabaseTaskRunner {

	static Logger logger = Logger.getLogger(DatabaseTaskRunner.class.getName());

	public static void main(String[] args) {

		DatabaseConnectivity db = new DatabaseConnectivity();
		Utils.customLogger(logger, "DatabaseTaskRunner.log");

		try {
			db.createEmployeeTable();
			db.createDependentTable();
		} catch (CustomException e) {
			e.printStackTrace();
		}

		boolean run = true;
		Scanner sc = new Scanner(System.in);
		while (run) {
			try {
				System.out.println();
				System.out.println("1.add n employee");
				System.out.println("2.get details by name");
				System.out.println("3.update department");
				System.out.println("4.update mobile");
				System.out.println("5.update email");
				System.out.println("6.n employee details");
				System.out.println("7.n sorted employees");
				System.out.println("8.delete employee");
				System.out.println("9.add dependents");
				System.out.println("10. get dependents");
				System.out.println("11.get details for n employees");
				System.out.print("Enter your choice: ");
				int ch = sc.nextInt();
				switch (ch) {
				case 1: {
					logger.log(Level.INFO, "Enter no of employees");
					List<Employee> employeeList = new ArrayList<Employee>();

					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						Employee emp = new Employee();
//						logger.log(Level.INFO, "Enter id: ");
//						emp.setId(sc.nextInt());
						logger.log(Level.INFO, "Enter name: ");
						emp.setName(sc.next());
						logger.log(Level.INFO, "Enter mobile number: ");
						emp.setNumber(sc.nextLong());
						logger.log(Level.INFO, "Enter email: ");
						emp.setEmail(sc.next());
						logger.log(Level.INFO, "Enter department: ");
						emp.setDepartment(sc.next());
						employeeList.add(emp);
					}
					db.addEmployees(employeeList);
					break;
				}

				case 2: {
					logger.log(Level.INFO, "Enter name of employee: ");
					String name = sc.next();
					List<Employee> employees = db.getEmployeeByName(name);
					logger.log(Level.INFO, employees.toString());
					break;
				}

				case 3: {
					logger.log(Level.INFO, "Enter employee id: ");
					int id = sc.nextInt();
					logger.log(Level.INFO, "Enter new department: ");
					String department = sc.next();
					db.updateEmployeeDepartment(id, department);
					break;
				}

				case 4: {
					logger.log(Level.INFO, "Enter employee id: ");
					int id = sc.nextInt();
					logger.log(Level.INFO, "Enter new mobile number: ");
					long number = sc.nextLong();
					db.updateEmployeeMobile(id, number);
					break;
				}

				case 5: {
					logger.log(Level.INFO, "Enter employee id: ");
					int id = sc.nextInt();
					logger.log(Level.INFO, "Enter new email: ");
					String email = sc.next();
					db.updateEmployeeEmail(id, email);
					break;
				}

				case 6: {
					logger.log(Level.INFO, "enter n for 1st n employee: ");
					int n = sc.nextInt();
					List<Employee> list = db.getFirstNEmployees(n);
					logger.log(Level.INFO, list.toString());
					break;
				}

				case 7: {
					logger.log(Level.INFO, "enter n for 1st n employee in ascending : ");
					int n = sc.nextInt();
					List<Employee> list = db.getFirstNNameSortedEmployees(n);
					logger.log(Level.INFO, list.toString());
					break;
				}

				case 8: {
					logger.log(Level.INFO, "Employee id: ");
					int id = sc.nextInt();
					db.deleteEmployee(id);
					logger.log(Level.INFO, "enter n for 1st n employee: ");
					int n = sc.nextInt();
					sc.nextLine();
					List<Employee> list = db.getFirstNEmployees(n);
					logger.log(Level.INFO, list.toString());
					break;
				}

				case 9: {
					logger.log(Level.INFO, "Enter employee id: ");
					int id = sc.nextInt();
					logger.log(Level.INFO, "Enter no of dependents: ");
					int n = sc.nextInt();
					List<Dependent> dependents = new ArrayList<Dependent>();
					for (int i = 0; i < n; i++) {
						Dependent dep = new Dependent();
						dep.setEmployeeId(id);
						logger.log(Level.INFO, "Enter name: ");
						dep.setName(sc.next());
						logger.log(Level.INFO, "Enter age: ");
						dep.setAge(sc.nextInt());
						logger.log(Level.INFO, "Enter relation: ");
						dep.setRelationship(sc.next());
						dependents.add(dep);
					}
					db.addEmployeeDependent(dependents);
					break;
				}

				case 10: {
					logger.log(Level.INFO, "Enter employee id: ");
					int id = sc.nextInt();
					List<Dependent> list = db.getDependents(id);
					for (Dependent dependent : list) {
						logger.log(Level.INFO, dependent.toString());
					}
					break;
				}

				case 11: {
					logger.log(Level.INFO, "Enter number of employee details n: ");
					int n = sc.nextInt();
					Map<Integer, Employee> map = db.getSortedDependents(n);
					for (Map.Entry<Integer, Employee> employee : map.entrySet()) {
						logger.log(Level.INFO, employee.getKey() + " " + employee.getValue());
					}
					break;
				}

				default:
					run = false;
					break;
				}

			} catch (InvalidValueException | CustomException e) {
				logger.log(Level.SEVERE, "Exception", e);
			}

		}
		try {
			DBConnection.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "DB close Exception", e);
		}
		sc.close();
	}
}
