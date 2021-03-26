package ch.hslu.n1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JoinAndSleep implements Runnable {

	static private final Logger LOG = LogManager.getLogger(JoinAndSleep.class);
	Thread waitForThread;

	public JoinAndSleep(Thread waitForThread) {
		this.waitForThread = waitForThread;
	}

	public JoinAndSleep() {
	}

	@Override
	public void run() {
		LOG.info(Thread.currentThread().getName() + " läuft");
		try {
			if (this.waitForThread != null) {
				LOG.info(Thread.currentThread().getName() + " wartet bis " + waitForThread.getName() + " beendet ist.");
				waitForThread.start();
				this.waitForThread.join();
				LOG.info("Da " + waitForThread.getName() + " beendet wurde wird nun " + Thread.currentThread().getName()
						+ " weiterarbeiten.");
			}
			LOG.info(Thread.currentThread().getName() + " schläft");
			Thread.currentThread().sleep(200);
		} catch (InterruptedException e) {
			LOG.error("Der " + Thread.currentThread().getName() + " wurde interrupted!");
			e.printStackTrace();
		} finally {
			Thread.currentThread().interrupt();
		}
		LOG.info(Thread.currentThread().getName() + " läuft wieder");

		long x = 0;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			x++;
		}
		LOG.info(Thread.currentThread().getName() + " value:" + x);
		LOG.info(Thread.currentThread().getName() + " beendet.");

	}

	public static void main(String args[]) throws InterruptedException {
		Thread thread3 = new Thread(new JoinAndSleep(), "Thread3");
		Thread thread2 = new Thread(new JoinAndSleep(thread3), "Thread2");
		Thread thread1 = new Thread(new JoinAndSleep(thread2), "Thread1");

		thread1.start();
	}

}
