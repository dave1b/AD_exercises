package ch.hslu.n1;

import java.util.ArrayList;

public class Ballspiel  {

	private ArrayList<Thread> thread = new ArrayList<Thread>();
	Canvas canvas = Canvas.getCanvas();

	
	public void generateBalls(int amount) {
		for (int i = 0; i < amount; i++) {
			thread.add(new Thread(new Ball(), "i"));
		}
		thread.stream().forEach(p -> p.start());

	}


	public static void main(String args[]) {
		Ballspiel ballspiel = new Ballspiel();
		final int nr = Runtime.getRuntime().availableProcessors();
		System.out.println("Available processors " + nr);
		ballspiel.generateBalls(50);	
	}
	
	
	
	
	

}
