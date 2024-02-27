package t3;

import java.util.Arrays;
import java.util.Scanner;

import myException.InvalidValueException;

public class StringRunner {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StringOperations sop = new StringOperations();
		boolean run = true;

		if (args.length > 0) {
			try {
				System.out.println("Length of " + args[0] + " is " + sop.length(args[0]));
			} catch (InvalidValueException e) {
				e.printStackTrace();
			}
		}

		while (run) {
			System.out.println();
			System.out.println("1.string to char array");
			System.out.println("2.penultimate");
			System.out.println("3.find occurrences");
			System.out.println("4.find greatest position");
			System.out.println("5.last n char");
			System.out.println("6.first n char");
			System.out.println("7.replace first n chars");
			System.out.println("8.starts with");
			System.out.println("9.ends with");
			System.out.println("10.to upper case");
			System.out.println("11.to lower case");
			System.out.println("12.reverse");
			System.out.println("13.accept multiple str line and concate");
			System.out.println("14.multi str line to array");
			System.out.println("15.multi line str with -");
			System.out.println("16.equals");
			System.out.println("17.equals ignore case");
			System.out.println("18.trim str");
			System.out.print("Enter choice: ");
			int ch = sc.nextInt();
			sc.nextLine();
			switch (ch) {
			case 1: {
				System.out.print("Enter the string:");
				String str = sc.nextLine();
				try {
					char[] arr = sop.toCharArray(str);
					System.out.println(str + " converted to " + Arrays.toString(arr));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 2: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				System.out.print("Enter N last nth char position: ");
				int position = sc.nextInt();
				try {
					System.out.println("penultimate: " + sop.getLastCharAt(str, position));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 3: {
				System.out.print("Enter a String: ");
				String str = sc.nextLine();
				System.out.print("Enter any character: ");
				char letter = sc.next().charAt(0);
				try {
					System.out.println(
							"Total occurrence of " + letter + " in " + str + " = " + sop.findOccurrences(str, letter));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 4: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				System.out.print("Enter any character: ");
				char letter = sc.next().charAt(0);
				try {
					int res = sop.greatestPosition(str, letter);
					System.out.println((res != -1) ? res + 1 : "Character not found.");
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 5: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				System.out.print("Enter N last chars to display: ");
				int n = sc.nextInt();
				try {
					System.out.println(sop.getLastNChars(str, n));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 6: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				System.out.print("Enter N first chars to display: ");
				int n = sc.nextInt();
				try {
					System.out.println(sop.getFirstNChars(str, n));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 7: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				System.out.print("Enter a replacement string: ");
				String replacement = sc.nextLine();
				System.out.print("Enter N first chars to replace: ");
				int n = sc.nextInt();
				try {
					System.out.println(sop.replaceFirstNChars(str, replacement, n));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 8: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				System.out.print("Enter starting word: ");
				String word = sc.nextLine();
				try {
					System.out.println(sop.startsWith(str, word));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 9: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				System.out.print("Enter ending word: ");
				String word = sc.nextLine();
				try {
					System.out.println(sop.endsWith(str, word));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 10: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				try {
					System.out.println(sop.toUpperCase(str));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 11: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				try {
					System.out.println(sop.toLowerCase(str));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 12: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				try {
					System.out.println(sop.reverse(str));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 13: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				try {
					System.out.println(sop.replace(str, " ", ""));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 14: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				System.out.print("Enter delimiter: ");
				String delimiter = sc.nextLine();
				try {
					String arr[] = sop.split(str, delimiter);
					System.out.println(Arrays.toString(arr));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 15: {
				System.out.print("Enter total number of strings: ");
				int n = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter " + n + " strings: ");
				String str[] = new String[n];
				for (int i = 0; i < n; i++)
					str[i] = sc.next();
				System.out.print("Enter Delimiter: ");
				String delimiter = sc.next();
				try {
					System.out.println(sop.join(delimiter, str));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 16: {
				System.out.print("Enter a string s1: ");
				String str1 = sc.nextLine();
				System.out.print("Enter a string s2: ");
				String str2 = sc.nextLine();
				try {
					System.out.println("equality = " + sop.equals(str1, str2));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 17: {
				System.out.print("Enter a string s1: ");
				String str1 = sc.nextLine();
				System.out.print("Enter a string s2: ");
				String str2 = sc.nextLine();
				try {
					System.out.println("equality without case = " + sop.equalsIgnoreCase(str1, str2));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 18: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				try {
					System.out.println(sop.trim(str));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			default:
				run = false;
				break;
			}
		}
		sc.close();
	}
}
