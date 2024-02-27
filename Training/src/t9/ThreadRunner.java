package t9;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ThreadRunner {
	static Logger logger = Logger.getLogger(ThreadRunner.class.getName());

	public static void main(String[] args) {
		try {
			FileHandler handler = new FileHandler("ThreadRunner.log");
			handler.setFormatter(new SimpleFormatter());
			logger.addHandler(handler);
			ConsoleHandler handler2 = new ConsoleHandler();
			handler2.setFormatter(new SimpleFormatter() {
				@Override
				public String format(LogRecord record) {
					return record.getMessage() + System.lineSeparator();
				}
			});
			logger.addHandler(handler2);
		} catch (SecurityException | IOException e) {
			logger.log(Level.SEVERE, "File Handler exception", e);
		}
		logger.setUseParentHandlers(false);

		MyRunnableThread myRunnable = new MyRunnableThread(6000);

		MyThreadClass thread0 = new MyThreadClass();
		logger.log(Level.INFO,
				"Name: " + thread0.getName() + " Priority: " + thread0.getPriority() + " State: " + thread0.getState());
		thread0.start();
		logger.log(Level.INFO,
				"Name: " + thread0.getName() + " Priority: " + thread0.getPriority() + " State: " + thread0.getState());

		Thread thread1 = new Thread(myRunnable);
		logger.log(Level.INFO,
				"Name: " + thread1.getName() + " Priority: " + thread1.getPriority() + " State: " + thread1.getState());
		thread1.start();
		logger.log(Level.INFO,
				"Name: " + thread1.getName() + " Priority: " + thread1.getPriority() + " State: " + thread1.getState());

		MyThreadClass extendedThread = new MyThreadClass(5000);
		extendedThread.setName("ExtendedThread");
		logger.log(Level.INFO, "Name: " + extendedThread.getName() + " Priority: " + extendedThread.getPriority()
				+ " State: " + extendedThread.getState());
		extendedThread.start();
		logger.log(Level.INFO, "Name: " + extendedThread.getName() + " Priority: " + extendedThread.getPriority()
				+ " State: " + extendedThread.getState());

		Thread myRunnableThread = new Thread(myRunnable, "myRunnableThread");
		logger.log(Level.INFO, "Name: " + myRunnableThread.getName() + " Priority: " + myRunnableThread.getPriority()
				+ " State: " + myRunnableThread.getState());
		myRunnableThread.start();
		logger.log(Level.INFO, "Name: " + myRunnableThread.getName() + " Priority: " + myRunnableThread.getPriority()
				+ " State: " + myRunnableThread.getState());

		Thread runnableThread = new Thread(myRunnable, "runnable-thread");

		MyThreadClass extendedClassThread = new MyThreadClass();
		extendedClassThread.setName("ExtendedClass-thread");
		runnableThread.start();
		extendedClassThread.start();

		Scanner sc = new Scanner(System.in);

		DumpThreads dumper = new DumpThreads(10000);
		Thread dumperThread = new Thread(dumper);
		dumperThread.start();

		while (thread0.isAlive() || thread1.isAlive() || extendedThread.isAlive() || myRunnableThread.isAlive()
				|| runnableThread.isAlive() || extendedClassThread.isAlive()) {
			System.out.println("1.stop t0");
			System.out.println("2.stop ExtendedThread");
			System.out.println("3.stop ExtendedClass-thread");
			System.out.println("4.stop runnable");
			int ch = sc.nextInt();
			sc.nextLine();
			switch (ch) {
			case 1:
				thread0.setCondition(false);
				break;
			case 2:
				extendedThread.setCondition(false);
				break;
			case 3:
				extendedClassThread.setCondition(false);
				break;
			case 4:
				myRunnable.setCondition(false);
				break;
			default:
//				run=false;
				break;
			}
		}
		dumper.setCondition(false);
		try {
			dumperThread.join();
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "dumper join failed", e);
		}
		logger.log(Level.INFO, "TASK COMPLETED!");
		sc.close();
	}
}
