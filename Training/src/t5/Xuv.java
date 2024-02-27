package t5;

import myException.InvalidValueException;
import utility.Utils;

public class Xuv extends Car {

	private int seats;
	private int airbags;
	private String model;
	private String color;

	public Xuv() {
		super("XUV");
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) throws InvalidValueException {
		Utils.checkRange(2, seats, 7, "Invalid seat count");
		this.seats = seats;
	}

	public int getAirbags() {
		return airbags;
	}

	public void setAirbags(int airbags) throws InvalidValueException {
		Utils.checkRange(0, airbags, 6, "Invalid airbag count");
		this.airbags = airbags;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) throws InvalidValueException {
		Utils.checkNull(model);
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) throws InvalidValueException {
		Utils.checkNull(color);
		this.color = color;
	}

}
