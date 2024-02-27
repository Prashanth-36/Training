package t7;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import myException.InvalidValueException;
import t5.Duck;

public class MapRunner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean run = true;
		MapOperations mapOperations = new MapOperations();

		while (run) {
			System.out.println();
			System.out.println("1.simple create");
			System.out.println("2.map <str,str>");
			System.out.println("3.map <int,int>");
			System.out.println("4.map <str,int>");
			System.out.println("5.map <str,own>");
			System.out.println("6.map with 1 null value");
			System.out.println("7.map with null key");
			System.out.println("8.contains key");
			System.out.println("9.contains value");
			System.out.println("10.replace values");
			System.out.println("11.get value");
			System.out.println("12.get or default");
			System.out.println("13.remove key");
			System.out.println("14.remove key value pair");
			System.out.println("15.replace ");
			System.out.println("16.replace key if value match");
			System.out.println("17.put all");
			System.out.println("18.map iterate");
			System.out.println("19.clear");
			System.out.print("Enter your choice:");
			int ch = sc.nextInt();
			try {
				switch (ch) {
				case 1: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}
				case 2: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key and value strings");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}
				case 3: {
					Map<Integer, Integer> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key and value ints");
						Integer key = sc.nextInt();
						Integer value = sc.nextInt();
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 4: {
					Map<String, Integer> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value int");
						String key = sc.next();
						Integer value = sc.nextInt();
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 5: {
					Map<String, Duck> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str");
						String key = sc.next();
						Duck value = new Duck();
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 6: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value int");
						String key = sc.next();
						String value = sc.next();
						if (i == 0) {
							value = null;
						}
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 7: {
					Map<String, Integer> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value int");
						String key = sc.next();
						Integer value = sc.nextInt();
						if (i == 0) {
							key = null;
						}
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 8: {
					Map<String, Integer> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value int");
						String key = sc.next();
						Integer value = sc.nextInt();
						mapOperations.put(map, key, value);
					}
					System.out.print("Enter key to check existence: ");
					String targetKey = sc.next();
					System.out.println(mapOperations.containsKey(map, targetKey));
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 9: {
					Map<String, Integer> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value int");
						String key = sc.next();
						Integer value = sc.nextInt();
						mapOperations.put(map, key, value);
					}
					System.out.print("Enter value to check existence: ");
					int targetValue = sc.nextInt();
					System.out.println(mapOperations.containsValue(map, targetValue));
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 10: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}

					System.out.println(map + " " + mapOperations.size(map));
					for (String key : map.keySet()) {
						System.out.print("Enter new value for " + key + ": ");
						String value = sc.next();
						mapOperations.replace(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 11: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					System.out.print("Enter name of key to get: ");
					String key = sc.next();
					System.out.println("The value of " + key + " is: " + mapOperations.get(map, key));
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 12: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}
					System.out.print("Enter default value: ");
					String defaultString = sc.next();
					System.out.println(map + " " + mapOperations.size(map));
					System.out.print("Enter key that is not present: ");
					String key = sc.next();
					System.out.println(
							"The value of " + key + " is: " + mapOperations.getOrDefault(map, key, defaultString));
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 13: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					System.out.print("Enter key to remove: ");
					String removeKey = sc.next();
					mapOperations.remove(map, removeKey);
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 14: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					System.out.print("Enter key and value pair to remove: ");
					String removeKey = sc.next();
					String removeValue = sc.next();
					mapOperations.remove(map, removeKey, removeValue);
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 15: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					System.out.print("Enter key  to replace: ");
					String replaceKey = sc.next();
					String replaceValue = sc.next();
					mapOperations.replace(map, replaceKey, replaceValue);
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 16: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					System.out.print("Enter key valur pair to replace: ");
					String replaceKey = sc.next();
					String replaceValue = sc.next();
					System.out.print("Enter new valur to replace: ");
					String newValue = sc.next();
					mapOperations.replace(map, replaceKey, replaceValue, newValue);
					System.out.println(map + " " + mapOperations.size(map));
					break;
				}

				case 17: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}
					Map<String, String> map2 = mapOperations.getMap();
					System.out.println("Enter no of input for map 2");
					int n2 = sc.nextInt();
					for (int i = 0; i < n2; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map2, key, value);
					}
					System.out.println(map + " " + mapOperations.size(map));
					System.out.println(map2 + " " + mapOperations.size(map2));
					mapOperations.putAll(map2, map);
					System.out.println(map + " " + mapOperations.size(map));
					System.out.println(map2 + " " + mapOperations.size(map2));
					break;
				}

				case 18: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}
					Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
					while (itr.hasNext()) {
						Map.Entry<String, String> entry = itr.next();
						System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
					}
					break;
				}

				case 19: {
					Map<String, String> map = mapOperations.getMap();
					System.out.println("Enter no of input");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						System.out.println("enter key str and value ");
						String key = sc.next();
						String value = sc.next();
						mapOperations.put(map, key, value);
					}
					System.out.println("Befor clear " + map);
					mapOperations.clear(map);
					System.out.println("After clear: " + map);
					break;
				}

				default: {
					run = false;
					break;
				}

				}
			} catch (InvalidValueException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		sc.close();
	}
}
