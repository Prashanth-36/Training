package t4;

import java.util.Scanner;

import myException.InvalidValueException;

public class BuilderRunner {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		StringBuilderOperations sbo = new StringBuilderOperations();
		while (run) {
			System.out.println();
			System.out.println("1.append");
			System.out.println("2.append with delimiter");
			System.out.println("3.insert in between");
			System.out.println("4.delete first string with delimiter");
			System.out.println("5.replace delimiter");
			System.out.println("6.reverse");
			System.out.println("7.delete substring");
			System.out.println("8.replace ");
			System.out.println("9.first index of delimiter");
			System.out.println("10.last index of delimiter");
			System.out.print("Enter choice: ");
			int ch = sc.nextInt();
			sc.nextLine();
			switch (ch) {
			case 1: {
				StringBuilder sb = sbo.getBuilder();
				try {
					System.out.println("Length of builder: " + sbo.length(sb));
					System.out.print("Enter the string:");
					String str = sc.nextLine();
					sbo.append(sb, str);
					System.out.println("Length of builder: " + sbo.length(sb));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 2: {

				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				StringBuilder sb = sbo.getBuilder(str);
				System.out.print("Enter delimiter: ");
				String delimiter = sc.nextLine();
				System.out.print("Enter number of strings to append: ");
				int n = sc.nextInt();
				try {
					for (int i = 0; i < n; i++) {
						String string = sc.next();
						sbo.append(sb, string, delimiter);
					}
					System.out.println("length: " + sbo.length(sb) + " string: " + sb);
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 3: {
				System.out.print("Enter two delimited Strings: ");
				String str = sc.nextLine();
				StringBuilder sb = sbo.getBuilder(str);
				System.out.print("Enter string to insert in between: ");
				String newString = sc.nextLine();
				System.out.print("Enter delimiter: ");
				String delimiter = sc.nextLine();
				try {
					int start = sbo.indexOf(sb, delimiter);
					System.out.println("before insert length: " + sbo.length(sb) + " " + sb);
					sbo.insert(sb, start, newString, delimiter);
					System.out.println("after insert length: " + sbo.length(sb) + " " + sb);
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 4: {
				System.out.print("Enter two delimited strings: ");
				String str = sc.nextLine();
				StringBuilder sb = sbo.getBuilder(str);
				System.out.print("Enter delimiter: ");
				String delimiter = sc.nextLine();
				try {
					int start = 0;
					int end = sbo.indexOf(sb, delimiter) + delimiter.length();
					sbo.delete(sb, start, end);
					System.out.println("length: " + sbo.length(sb) + " " + sb);
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 5: {
				System.out.print("Enter 3 delimited strings: ");
				String str = sc.nextLine();
				StringBuilder sb = sbo.getBuilder(str);
				System.out.print("Enter current delimiter: ");
				String delimiter = sc.nextLine();
				System.out.print("Enter replacement delimiter: ");
				String replacement = sc.nextLine();
				try {
					System.out.println("before replace length: " + sbo.length(sb) + " " + sb);
					sbo.replace(sb, delimiter, replacement);
					System.out.println("after replace length: " + sbo.length(sb) + " " + sb);
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 6: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				try {
					StringBuilder sb = sbo.getBuilder(str);
					System.out.println("length: " + sbo.length(sb) + " " + sb);
					sbo.reverse(sb);
					System.out.println("length: " + sbo.length(sb) + " " + sb);
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 7: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				StringBuilder sb = sbo.getBuilder(str);
				try {
					System.out.println("length: " + sbo.length(sb) + " " + sb);
					System.out.print("Enter start and end index to delete: ");
					int start = sc.nextInt();
					int end = sc.nextInt();
					sbo.delete(sb, start, end);
					System.out.println("length: " + sbo.length(sb) + " " + sb);
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 8: {
				System.out.print("Enter a string: ");
				String str = sc.nextLine();
				StringBuilder sb = sbo.getBuilder(str);
				System.out.print("Enter replacement string: ");
				String replacement = sc.nextLine();
				try {
					System.out.println("length: " + sbo.length(sb) + " " + sb);
					System.out.print("Enter start and end index to replace: ");
					int start = sc.nextInt();
					int end = sc.nextInt();
					sbo.replace(sb, start, end, replacement);
					System.out.println("length: " + sbo.length(sb) + " " + sb);
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 9: {
				System.out.print("Enter 3 delimited strings: ");
				String str = sc.nextLine();
				StringBuilder sb = sbo.getBuilder(str);
				System.out.print("Enter delimiter: ");
				String delimiter = sc.nextLine();
				try {
					System.out.println("first index of: " + delimiter + " is: " + sbo.indexOf(sb, delimiter));
				} catch (InvalidValueException e) {
					e.printStackTrace();
				}
				break;
			}

			case 10: {
				System.out.print("Enter 3 delimited strings: ");
				String str = sc.nextLine();
				StringBuilder sb = sbo.getBuilder(str);
				System.out.print("Enter delimiter: ");
				String delimiter = sc.nextLine();
				try {
					System.out.println("last index of: " + delimiter + " is: " + sbo.lastIndexOf(sb, delimiter));
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
