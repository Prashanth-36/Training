package t8;

import java.io.Serializable;

public final class SingletonClass implements Serializable {

	private static final long serialVersionUID = 1L;
	private static String name;

	private SingletonClass() {

	}

	private SingletonClass(String name) {
		SingletonClass.name = name;
	}

	private final static class MyInstance {
		private final static SingletonClass obj = new SingletonClass("Name");
	}

	public static SingletonClass getInstance() {
		return MyInstance.obj;
	}

	public void setName(String name) {
		SingletonClass.name = name;
	}

	public String getName() {
		return name;
	}

	private Object readResolve() {
		return MyInstance.obj;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cannot clone singleton");
	}
}
