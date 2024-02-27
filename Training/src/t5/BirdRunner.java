package t5;

public class BirdRunner {
	public static void main(String[] args) {
//		BirdAbstract bird=new BirdAbstract();
		ParrotMod parrot = new ParrotMod();
		parrot.fly();
		parrot.speak();

		Duck duck = new Duck();
		duck.fly();
		duck.speak();
	}
}
