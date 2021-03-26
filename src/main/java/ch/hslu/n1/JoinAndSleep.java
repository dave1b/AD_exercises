package ch.hslu.n1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JoinAndSleep implements Runnable {

	static private final Logger LOG = LogManager.getLogger(JoinAndSleep.class);
	
	public JoinAndSleep() {
		
	}
	
	
	@Override
	public void run() {
		LOG.info(Thread.currentThread().getName() + " läuft");
		LOG.info(Thread.currentThread().getName() + " schläft");
		try {
			Thread.currentThread().sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LOG.info(Thread.currentThread().getName() + " läuft wieder");
		
		
		long x = 0;
		for(long i = 0; i < Integer.MAX_VALUE; i++) {
			x++;
		}
		LOG.info("Thread1 value:" + x);
		LOG.info(Thread.currentThread().getName() + " beendet.");
		
		
	}

	
	public static void main (String args[]) throws InterruptedException {
		Thread thread1 = new Thread(new JoinAndSleep(), "Thread1");
		Thread thread2 = new Thread(new JoinAndSleep(), "Thread2");
		Thread thread3 = new Thread(new JoinAndSleep(), "Thread3");
	
			
			thread1.start();
			thread1.join();
			thread2.start();
			thread2.join();
			thread3.start();
//			thread3.sleep(4000);
//			thread2.sleep(3000);
//			thread1.sleep(2000);

	}
	
	
	
	
	
	
	
	
}
