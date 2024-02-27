package t5;

import myException.InvalidValueException;
import utility.Utils;

public class Car {

	private int yearOfMake;
	private String engineNumber;
	private String type;

	public Car() {

	}

	public Car(String str) {
		System.out.println(str);
	}

	public int getYearOfMake() {
		return yearOfMake;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public String getType() {
		return type;
	}

	public void setEngineNumber(String engineNumber) throws InvalidValueException {
		Utils.checkNull(engineNumber);
		this.engineNumber = engineNumber;
	}

	public void setType(String type) throws InvalidValueException {
		Utils.checkNull(type);
		this.type = type;
	}

	public void setYearOfMake(int yearOfMake) throws InvalidValueException {
		Utils.checkRange(1900, yearOfMake, 2024, "Invalid year of make");
		this.yearOfMake = yearOfMake;
	}

	public void maintanence() {
		System.out.println("Car under maintanence.");
	}

}