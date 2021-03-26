package ch.hslu.n1;

import java.util.Random;

public class Calculator {

	public static void main(String args[]) {

		
		int x = 10;
		Random rand = new Random();
		
		for(int i = 0; i < x; i++) {
			Quersummenrechner qRechner = new Quersummenrechner(rand.nextInt(1000000000));
			final Thread thread = new Thread(qRechner, "Nr:" + i );
			thread.start();
//			thread.wait(500);
//			thread.interrupt();

		}
		
		
		
	}

}
