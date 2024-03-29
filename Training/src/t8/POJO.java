package t8;

public class POJO {

	private int id;

	private String name;

	public POJO() {
		id = 0;
		name = null;
	}

	public POJO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "POJO { id = " + id + ", name = " + name + " }";
	}

}
