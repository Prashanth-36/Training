package t5;

import myException.InvalidValueException;

public class CarRunner {

	public void carType(Car car) {
		System.out.println(car.getType());
	}

	public void swiftMethod(Swift swift) {
		System.out.println("received swift");
	}

	public static void main(String[] args) {
		try {
			Swift swift = new Swift();
			swift.setAirbags(4);
			swift.setColor("red");
			swift.setModel("2020");
			swift.setSeats(4);
			System.out.println(swift.getAirbags());
			System.out.println(swift.getColor());
			System.out.println(swift.getModel());
			System.out.println(swift.getSeats());
			System.out.println();

			SCross sCross = new SCross();
			sCross.setAirbags(4);
			sCross.setColor("white");
			sCross.setModel("sc01");
			sCross.setSeats(4);
			sCross.setEngineNumber("scross1");
			sCross.setType("Sedan");
			sCross.setYearOfMake(2021);

			System.out.println(sCross.getAirbags());
			System.out.println(sCross.getColor());
			System.out.println(sCross.getEngineNumber());
			System.out.println(sCross.getModel());
			System.out.println(sCross.getSeats());
			System.out.println(sCross.getType());
			System.out.println(sCross.getYearOfMake());
			System.out.println();

			Xuv xuv = new Xuv();
			xuv.setAirbags(4);
			xuv.setColor("silver");
			xuv.setType("SUV");
			xuv.setSeats(7);

			swift.setType("Hatch");

			CarRunner carRunner = new CarRunner();
			carRunner.carType(swift);
			carRunner.carType(sCross);
			carRunner.carType(xuv);

			Swift obj = new Swift();
			carRunner.swiftMethod(obj);

//		Car obj2=new Swift();
//		carRunner.swiftMethod(obj2);

//		carRunner.swiftMethod(sCross);
//		carRunner.swiftMethod(xuv);

			SCross sCross2 = new SCross();
			sCross2.maintanence();

			Car mycar = new SCross();
			mycar.maintanence();

			Car car = new Car();
			car.maintanence();

			Swift swift2 = new Swift();
			swift2.maintanence();

//			Xuv xuv2 = new Xuv();
//		Xuv xuv3=new Xuv("text");
		} catch (InvalidValueException e) {
			e.printStackTrace();
		}
	}

}
