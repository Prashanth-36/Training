package t6;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import myException.InvalidValueException;
import t5.Duck;

public class ListRunner {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println();
			System.out.println("1.empty list creation");
			System.out.println("2.string list");
			System.out.println("3.int list");
			System.out.println("4.add custom obj");
			System.out.println("5.add int and string");
			System.out.println("6.index of");
			System.out.println("7.iterator and for loop");
			System.out.println("8.print string from index");
			System.out.println("9.1st and last of duplicate string in list");
			System.out.println("10.insert");
			System.out.println("11.sub list");
			System.out.println("12.add 2 list to thirsd");
			System.out.println("13.add 2nd list 1rst and 1st as 2nd");
			System.out.println("14.remove");
			System.out.println("15.remove all");
			System.out.println("16.retain all");
			System.out.println("17.clear");
			System.out.println("18.contains");
			System.out.print("Enter your choise: ");
			int ch = sc.nextInt();
			sc.nextLine();
			try {
				switch (ch) {
				case 1: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<Integer> al = listOperations.getList();
					System.out.println(al + " size: " + listOperations.size(al));
					break;
				}

				case 2: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of string inputs: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings: ");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					System.out.println(al + " size: " + listOperations.size(al));
					break;
				}

				case 3: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<Integer> al = listOperations.getList();
					System.out.print("Enter no of int inputs: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " integers: ");
					for (int i = 0; i < n; i++) {
						int value = sc.nextInt();
						listOperations.add(al, value);
					}
					System.out.println(al + " size: " + listOperations.size(al));
					break;
				}

				case 4: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<Duck> al = listOperations.getList();
					Duck duck = new Duck();
					listOperations.add(al, duck);
					System.out.println(al + " size: " + listOperations.size(al));
					break;
				}

				case 5: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<Object> al = listOperations.getList();
					boolean getInput = true;
					while (getInput) {
						System.out.println("1.Integer: ");
						System.out.println("2.String: ");
						System.out.print("Enter choise: ");
						int choice = sc.nextInt();
						sc.nextLine();
						switch (choice) {
						case 1: {
							int value = sc.nextInt();
							listOperations.add(al, value);
							break;
						}
						case 2: {
							String value = sc.nextLine();
							listOperations.add(al, value);
							break;
						}
						default: {
							getInput = false;
							break;
						}
						}
					}
					System.out.println(al + " size: " + listOperations.size(al));
					break;
				}

				case 6: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of string to add: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings: ");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					System.out.print("Enter search string: ");
					String search = sc.next();
					System.out.println("index: " + listOperations.indexOf(al, search));
					System.out.println(al + " size: " + listOperations.size(al));
					break;
				}

				case 7: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of string to add: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings: ");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					System.out.println("using iterator:");
					Iterator<String> itr = al.iterator();
					while (itr.hasNext()) {
						String value = itr.next();
						System.out.print(value + " ");
					}
					System.out.println();
					System.out.println("using for each");
					for (String value : al) {
						System.out.print(value + " ");
					}
					System.out.println();
					break;
				}

				case 8: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of input strings: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings:");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					System.out.print("Enter index to find value: ");
					int index = sc.nextInt();
					System.out.println("value at index " + index + " is: " + listOperations.get(al, index));
					System.out.println(al + " size: " + listOperations.size(al));
					break;
				}

				case 9: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of input strings: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings with duplicates:");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					System.out.print("Enter string to find: ");
					String search = sc.next();
					System.out.println("first index: " + listOperations.indexOf(al, search) + " last index: "
							+ listOperations.lastIndexOf(al, search));
					break;
				}

				case 10: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of input strings: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings:");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					System.out.print("Enter string to add: ");
					String newString = sc.next();
					System.out.print("Enter index for that string: ");
					int index = sc.nextInt();
					listOperations.add(al, index, newString);
					System.out.println(al + " size: " + listOperations.size(al));
					break;
				}

				case 11: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of input strings: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings:");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					System.out.print("Enter start and end index: ");
					int start = sc.nextInt();
					int end = sc.nextInt();
					List<String> al2 = listOperations.subList(al, start, end);
					System.out.println("second list: " + al2);
					break;
				}

				case 12: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of input strings: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings:");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					List<String> al2 = listOperations.getList();
					System.out.print("Enter no of input strings for 2nd list: ");
					int n2 = sc.nextInt();
					System.out.println("Enter " + n2 + " strings:");
					for (int i = 0; i < n2; i++) {
						String value = sc.next();
						listOperations.add(al2, value);
					}
					List<String> al3 = listOperations.getList();
					listOperations.addAll(al3, al);
					listOperations.addAll(al3, al2);
					System.out.println("3rd list: " + al3);
					break;
				}

				case 13: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of input strings: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings:");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					List<String> al2 = listOperations.getList();
					System.out.print("Enter no of input strings for 2nd list: ");
					int n2 = sc.nextInt();
					System.out.println("Enter " + n2 + " strings:");
					for (int i = 0; i < n2; i++) {
						String value = sc.next();
						listOperations.add(al2, value);
					}
					List<String> al3 = listOperations.getList();
					listOperations.addAll(al3, al2);
					listOperations.addAll(al3, al);
					System.out.println("3rd list: " + al3);
					break;
				}

				case 14: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<Integer> al = listOperations.getList();
					System.out.print("Enter no of inputs: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " integers:");
					for (int i = 0; i < n; i++) {
						int value = sc.nextInt();
						listOperations.add(al, value);
					}
					System.out.println("Enter index to remove");
					int index = sc.nextInt();
					listOperations.remove(al, index);
					System.out.println("after remove " + al);
					break;
				}

				case 15: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of input strings: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings:");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					List<String> al2 = listOperations.getList();
					System.out.print("Enter no of input strings for 2nd list: ");
					int n2 = sc.nextInt();
					System.out.println("Enter " + n2 + " strings:");
					for (int i = 0; i < n2; i++) {
						String value = sc.next();
						listOperations.add(al2, value);
					}
					listOperations.removeAll(al, al2);
					System.out.println("after removing list 2 in 1 " + al);
					break;
				}

				case 16: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of input strings: ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings:");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					List<String> al2 = listOperations.getList();
					System.out.print("Enter no of input strings for 2nd list: ");
					int n2 = sc.nextInt();
					System.out.println("Enter " + n2 + " strings:");
					for (int i = 0; i < n2; i++) {
						String value = sc.next();
						listOperations.add(al2, value);
					}
					listOperations.retainAll(al, al2);
					System.out.println("after retaining list 2 in 1 " + al);
					break;
				}

				case 17: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<Long> al = listOperations.getList();
					System.out.print("Enter no of inputs : ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " longs:");
					for (int i = 0; i < n; i++) {
						Long value = sc.nextLong();
						listOperations.add(al, value);
					}
					System.out.println("before clear: " + al + " size: " + listOperations.size(al));
					listOperations.clear(al);
					System.out.println("after clear: " + al + " size: " + listOperations.size(al));
					break;
				}

				case 18: {
					ArrayListOperations listOperations = new ArrayListOperations();
					List<String> al = listOperations.getList();
					System.out.print("Enter no of inputs : ");
					int n = sc.nextInt();
					System.out.println("Enter " + n + " strings:");
					for (int i = 0; i < n; i++) {
						String value = sc.next();
						listOperations.add(al, value);
					}
					System.out.print("Enter search string: ");
					String search = sc.next();
					System.out.println("string cointains: " + listOperations.contains(al, search));
					break;
				}

				default: {
					run = false;
					break;
				}
				}
			} catch (InvalidValueException e) {
				e.printStackTrace();
			}
		}
		sc.close();

	}
}
