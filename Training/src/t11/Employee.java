package t11;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private int id;
	private String name;
	private String department;
	private String email;
	private long number;
	private List<Dependent> dependents;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Employee{ name: " + name + ", id = " + id + ", department = " + department + ", email = " + email
				+ ",number = " + number + ",dependents = " + dependents + "}";
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	public void addDependent(Dependent dependent) {
		if (dependents == null) {
			dependents = new ArrayList<>();
		}
		dependents.add(dependent);
	}

}
