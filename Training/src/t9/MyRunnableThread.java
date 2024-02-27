package t9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyRunnableThread implements Runnable {
	static Logger logger = Logger.getLogger(ThreadRunner.class.getName());

	long sleep;

	public MyRunnableThread(long sleep) {
		this.sleep = sleep;
	}

	public MyRunnableThread() {

	}

	volatile boolean run = true;

	void setCondition(boolean value) {
		run = value;
	}

	@Override
	public void run() {
		Thread current = Thread.currentThread();
		logger.log(Level.INFO,
				"Name: " + current.getName() + " Priority: " + current.getPriority() + " State: " + current.getState());

		logger.log(Level.INFO, "Going to sleep: " + current.getName());

		logger.log(Level.INFO, "After sleep: " + current.getName());
		while (run) {
//			System.out.println();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, "Thread sleep exception.", e);
			}
		}
	}
}
