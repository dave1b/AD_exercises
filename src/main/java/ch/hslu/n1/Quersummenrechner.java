package ch.hslu.n1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Quersummenrechner implements Runnable {

	static private final Logger LOG = LogManager.getLogger(Quersummenrechner.class);

	private Integer number;
	private String numberString;
	private int quersumme;

	public Quersummenrechner(Integer number) {
		this.number = number;
	}

	@Override
	public void run() {
		quersumme = 0;
//		LOG.debug("Current Thread:" + Thread.currentThread().toString() + " " + " Anzal Cores:" + Runtime.getRuntime().availableProcessors());

		numberString = number.toString();
		String s;

		try {
			while (Thread.currentThread().isInterrupted() == false) {

				for (int i = 0; i < numberString.length(); i++) {
//			LOG.debug(numberString.charAt(i));
					s = String.valueOf(numberString.charAt(i));
					quersumme += Integer.valueOf(s);
					Thread.currentThread().sleep(200);

				}
				LOG.info(Thread.currentThread().getName() + " Zahl:" + number + " Quersumme:" + quersumme);
				return;

			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			Thread.currentThread().interrupt();
		}
	}

}
