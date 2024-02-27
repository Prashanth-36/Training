package t8;

public class PrintInstance {
	String instance;

	public PrintInstance() {
		instance = null;
	}

	public PrintInstance(String value) {
		instance = value;
	}

	@Override
	public String toString() {
		return "PrintInstance { instance = " + instance + " }";
	}
}
