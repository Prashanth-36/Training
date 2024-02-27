package t8;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DateTimeRunner {

	static Logger logger = Logger.getLogger(DateTimeRunner.class.getName());

	static Scanner sc;

	public static void main(String[] args) {

		DateTime dt = new DateTime();
		ArrayList<String> zones = new ArrayList<>(ZoneId.getAvailableZoneIds());
		zones.sort((a, b) -> a.compareTo(b));
		boolean run = true;
		sc = new Scanner(System.in);

		try {
			FileHandler handler = new FileHandler("DateTimeRunner.log");
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
			logger.setUseParentHandlers(false);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		long currentMilli = dt.getCurrentMillis();
		ZonedDateTime london = dt.getZonedDateTime(1708367400000l, ZoneId.of("Europe/London"));
		System.out.println("London now:" + london);
		logger.log(Level.INFO, "London now:" + london);
		ZonedDateTime london2 = dt.getZonedDateTime(1714674600000l, ZoneId.of("Europe/London"));
		System.out.println("London may:" + london2);
		logger.info("London may:" + london2);
		ZonedDateTime newYork = dt.getZonedDateTime(currentMilli, ZoneId.of("America/New_York"));
		System.out.println("New york" + newYork);
		logger.info("New york" + newYork);

		while (run) {
			System.out.println();
			System.out.println("1.date time");
			System.out.println("2.current time millis");
			System.out.println("3.current date time in zone");
			System.out.println("4.get week day");
			System.out.println("5.get month");
			System.out.println("6.get year");
			int ch = sc.nextInt();
			sc.nextLine();
			switch (ch) {
			case 1:
				LocalDateTime currentDateTime = dt.getDateTime(dt.getCurrentMillis(), ZoneId.systemDefault());
				System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
				break;

			case 2:
				System.out.println("current time in millis:");
				System.out.println(dt.getCurrentMillis());
				System.out.println("using system class");
				System.out.println(System.currentTimeMillis());
				break;

			case 3:
				System.out.println("current date time in new york");
				long currentMillis = dt.getCurrentMillis();
				ZonedDateTime date = dt.getZonedDateTime(currentMillis, getZoneId(zones));
				System.out.println(date);
				break;

			case 4:
				String day = dt.getWeekDay(dt.getCurrentMillis(), ZoneId.systemDefault());
				System.out.println(day);
				break;

			case 5:
				String month = dt.getMonth(dt.getCurrentMillis(), ZoneId.systemDefault());
				System.out.println(month);
				break;

			case 6:
				int year = dt.getYear(dt.getCurrentMillis(), ZoneId.systemDefault());
				System.out.println(year);
				break;
			default: {
				run = false;
				break;
			}
			}
		}

//  283- india     169-newyork  452- london

		sc.close();
	}

	static ZoneId getZoneId(ArrayList<String> zones) {
		System.out.println();
		for (int i = 0; i < zones.size(); i++) {
			System.out.println(i + " " + zones.get(i));
		}
		System.out.println();
		System.out.print("Enter zone number:");
		int zone = sc.nextInt();
		String zoneName = zones.get(zone);
		System.out.println("Selected zone: " + zoneName);
		return ZoneId.of(zoneName);
	}
}
