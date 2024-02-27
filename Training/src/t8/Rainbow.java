package t8;

public enum Rainbow {

	VIOLET(1), INDIGO(2), BLUE(3), GREEN(4), YELLOW(5), ORANGE(6), RED(7);

	private int colorCode;

	private Rainbow(int colorCode) {
		this.colorCode = colorCode;
	}

	public int getColorCode() {
		return colorCode;
	}

}
