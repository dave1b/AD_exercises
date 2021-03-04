package ch.hslu.einfuehrung;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Aha {

	static private final Logger LOG = LogManager.getLogger(Aha.class);
	private static int counter;

	public static void task(final int n) {
		LOG.info(System.currentTimeMillis());
		long a = System.currentTimeMillis();
		task1();
		task1();
		task1();
		task1(); // T ~ 4
		for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
			task2();
			task2();
			task2(); // T ~ n · 3
			for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
				task3();
				task3(); // T ~ n · n· 2
			}
		}
		LOG.info(System.currentTimeMillis());
		LOG.info("Die Rechenzeit in Einheiten beträgt: " + counter);
		LOG.info("Die Rechenzeit in Millisekunden beträgt: " + (System.currentTimeMillis() - a));
	}

	public static void task1() {
		counter++;
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void task2() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		counter++;

	}

	public static void task3() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		counter++;

	}
	
	
	 public static void main(final String[] args) {
		 task(20);
	 }
	
}
