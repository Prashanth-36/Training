package t4;

import myException.InvalidValueException;
import utility.Utils;

public class StringBuilderOperations {

	public StringBuilder getBuilder() {
		return new StringBuilder();
	}

	public StringBuilder getBuilder(String str) {
		return new StringBuilder(str);
	}

	public int length(StringBuilder sb) throws InvalidValueException {
		Utils.checkNull(sb);
		return sb.length();
	}

	public int indexOf(StringBuilder sb, String str) throws InvalidValueException {
		Utils.checkNull(sb);
		Utils.checkNull(str);
		return sb.indexOf(str);
	}

	public int lastIndexOf(StringBuilder sb, String str) throws InvalidValueException {
		Utils.checkNull(sb);
		Utils.checkNull(str);
		return sb.lastIndexOf(str);
	}

	public void append(StringBuilder sb, String str) throws InvalidValueException {
		Utils.checkNull(sb);
		Utils.checkNull(str);
		sb.append(str);
	}

	public void append(StringBuilder sb, String str, String delimiter) throws InvalidValueException {
		Utils.checkNull(str);
		Utils.checkNull(delimiter);
		if (length(sb) > 0) {
			sb.append(delimiter);
			sb.append(str);
		} else {
			sb.append(str);
		}
	}

	public void insert(StringBuilder sb, int index, String str) throws InvalidValueException {
		Utils.checkNull(sb);
		Utils.checkNull(str);
		sb.insert(index, str);
	}

	public void insert(StringBuilder sb, int index, String str, String delimiter) throws InvalidValueException {
		Utils.checkNull(str);
		Utils.checkNull(sb);
		Utils.checkNull(delimiter);
		sb.insert(index, delimiter + str + delimiter);
	}

	public void delete(StringBuilder sb, int start, int end) throws InvalidValueException {
		Utils.checkRange(0, start, length(sb));
		Utils.checkRange(0, end, length(sb));
		if (start > end) {
			throw new InvalidValueException("start and end index invalid.");
		}
		sb.delete(start, end);
	}

	public void replace(StringBuilder sb, int start, int end, String replacement) throws InvalidValueException {
		Utils.checkNull(replacement);
		Utils.checkRange(0, start, length(sb));
		Utils.checkRange(0, end, length(sb));
		if (start > end) {
			throw new InvalidValueException("start and end index invalid.");
		}
		sb.replace(start, end, replacement);
	}

	public void replace(StringBuilder sb, String target, String replacement) throws InvalidValueException {
		Utils.checkNull(replacement);
		int index;
		while ((index = indexOf(sb, target)) != -1) {
			replace(sb, index, index + target.length(), replacement);
		}
	}

	public void reverse(StringBuilder sb) throws InvalidValueException {
		Utils.checkNull(sb);
		sb.reverse();
	}

}
