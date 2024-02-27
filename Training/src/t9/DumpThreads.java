package t9;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DumpThreads implements Runnable {

	static Logger logger = Logger.getLogger(ThreadRunner.class.getName());

	volatile boolean run = true;

	public void setCondition(boolean value) {
		run = value;
	}

	long sleep;

	public DumpThreads(long sleep) {
		this.sleep = sleep;
	}

	public void run() {
		while (run) {
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, "sleep in dump fail", e);
			}

			ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
			long ids[] = threadMXBean.getAllThreadIds();
			ThreadInfo[] infos = threadMXBean.getThreadInfo(ids, Integer.MAX_VALUE);
			for (ThreadInfo info : infos) {
				logger.log(Level.INFO, info.toString());
			}
		}
	}
}
