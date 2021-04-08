package ch.hslu.n1;

import java.util.Random;

public class Calculator {

	public static void main(String args[]) throws InterruptedException {

		int x = 10;
		Random rand = new Random();

		for (int i = 0; i < x; i++) {
			Quersummenrechner qRechner = new Quersummenrechner(rand.nextInt(1000000000));
			final Thread thread = new Thread(qRechner, "Nr:" + i);
			java.util.concurrent.TimeUnit.MILLISECONDS.sleep(100);
			thread.start();
//			Thread.sleep(200);
			qRechner.stopIt();

//			thread.interrupt();
//			thread.stop();

		}

	}
}
