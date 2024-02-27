package t3;

import java.util.Scanner;

import myException.InvalidValueException;

public class TestRunner {

	public static void main(String args[]) {
		TestRunner obj = new TestRunner();
		try {
			int value = obj.getInput();
			System.out.println(value);
		} catch (InvalidValueException e) {
			e.printStackTrace();
		}
	}

	public int getInput() throws InvalidValueException {
		try {
			return reader();
		} catch (Exception e) {
			throw new InvalidValueException("Input is not a number.", e);
		}
	}

	public int reader() {

		Scanner sc = new Scanner(System.in);
		int readInput = sc.nextInt();
		sc.close();
		return readInput;
	}
}
