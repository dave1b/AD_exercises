package ch.hslu.n1;
import java.util.ArrayList;

public class BallspielSequentiell {


		private ArrayList<Ball> balls = new ArrayList<Ball>();
		Canvas canvas = Canvas.getCanvas();

		
		public void generateBalls(int amount) {
			for (int i = 0; i < amount; i++) {
				balls.add(new Ball());
			}
			balls.stream().forEach(p -> p.run());

		}

		
		
		
		public static void main(String args[]) {
			Ballspiel ballspiel = new Ballspiel();
			final int nr = Runtime.getRuntime().availableProcessors();
			System.out.println("Available processors " + nr);
			ballspiel.generateBalls(50);	
		}
		
		
		
		
		

	}


