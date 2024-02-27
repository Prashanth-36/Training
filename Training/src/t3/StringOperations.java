package t3;

import myException.InvalidValueException;
import utility.Utils;

public class StringOperations {

	public int length(String str) throws InvalidValueException {
		Utils.checkNull(str);
		return str.length();
	}

	public char[] toCharArray(String string) throws InvalidValueException {
		Utils.checkNull(string);
		return string.toCharArray();
	}

	public char getLastCharAt(String string, int position) throws InvalidValueException {
		int length = length(string);
		Utils.checkRange(1, position, length);
		return string.charAt(length - position);
	}

	public int findOccurrences(String string, char letter) throws InvalidValueException {
		int count = 0, n = length(string);
		for (int i = 0; i < n; i++) {
			if (string.charAt(i) == letter) {
				count++;
			}
		}
		return count;
	}

	public int greatestPosition(String string, char letter) throws InvalidValueException {
		Utils.checkNull(string);
		return string.lastIndexOf(letter);
	}

	public String getLastNChars(String str, int n) throws InvalidValueException {
		int length = length(str);
		Utils.checkRange(1, n, length);
		return str.substring(length - n);
	}

	public String getFirstNChars(String str, int n) throws InvalidValueException {
		Utils.checkRange(1, n, length(str));
		return str.substring(0, n);
	}

	public String replaceFirstNChars(String string, String replacement, int n) throws InvalidValueException {
		Utils.checkRange(0, n, length(replacement), "replacement string is smaller than n chars to replace");
		Utils.checkRange(0, n, length(string), "replacement length longer than actual string");
		return string.replaceFirst(string.substring(0, n), replacement.substring(0, n));
	}

	public boolean startsWith(String string, String start) throws InvalidValueException {
		Utils.checkNull(string);
		Utils.checkNull(start);
		return string.startsWith(start);
	}

	public boolean endsWith(String str, String end) throws InvalidValueException {
		Utils.checkNull(str);
		Utils.checkNull(end);
		return str.endsWith(end);
	}

	public String toUpperCase(String str) throws InvalidValueException {
		Utils.checkNull(str);
		return str.toUpperCase();
	}

	public String toLowerCase(String str) throws InvalidValueException {
		Utils.checkNull(str);
		return str.toLowerCase();
	}

	public String reverse(String str) throws InvalidValueException {
		int size = length(str);
		char rev[] = str.toCharArray();
		for (int i = 0, j = size - 1; i < j; i++, j--) {
			char temp = rev[i];
			rev[i] = rev[j];
			rev[j] = temp;
		}
		return new String(rev);
	}

	public String[] split(String str, String delimiter) throws InvalidValueException {
		Utils.checkNull(str);
		Utils.checkNull(delimiter);
		return str.split(delimiter);
	}

	public String replace(String str, String target, String replacement) throws InvalidValueException {
		Utils.checkNull(str);
		return str.replace(target, replacement);
	}

	public boolean equals(String string1, String string2) throws InvalidValueException {
		Utils.checkNull(string1);
		Utils.checkNull(string2);
		return string1.equals(string2);
	}

	public boolean equalsIgnoreCase(String string1, String string2) throws InvalidValueException {
		Utils.checkNull(string1);
		Utils.checkNull(string2);
		return string1.equalsIgnoreCase(string2);
	}

	public String trim(String string) throws InvalidValueException {
		Utils.checkNull(string);
		return string.trim();
	}

	public String join(String delimiter, String[] strArray) throws InvalidValueException {
		Utils.checkNull(strArray);
		return String.join(delimiter, strArray);
	}
}
