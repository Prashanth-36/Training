package t9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThreadClass extends Thread {
	static Logger logger = Logger.getLogger(ThreadRunner.class.getName());

	long sleep;

	public MyThreadClass() {
	}

	public MyThreadClass(long sleep) {
		this.sleep = sleep;
	}

	volatile boolean run = true;

	void setCondition(boolean value) {
		run = value;
	}

	@Override
	public void run() {

		logger.log(Level.INFO, "Name: " + getName() + " Priority: " + getPriority() + " State: " + getState());
		logger.log(Level.INFO, "Going to sleep: " + getName());
		try {
			sleep(sleep);
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Sleep exception", e);
		}
		logger.log(Level.INFO, "After sleep: " + getName());

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
