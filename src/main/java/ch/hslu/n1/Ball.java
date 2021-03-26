package ch.hslu.n1;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Ball implements Runnable {

	static private final Logger LOG = LogManager.getLogger(Ball.class);

	
	Circle circleBall;
	String[] colors = {"blue", "yellow", "green", "mangenta", "red", "black"};

	public Ball() {
	}

	@Override
	public void run() {
		
		// Erstellung des Balls -----------
//		Math.random() * (max - min + 1) + min 
		Random rand = new Random();
		
		int diameter = (int) (Math.random() * (50 - 20 + 1)+20);
		int x = rand.nextInt(600);
		int y = rand.nextInt(400);
		
		int colorCode = rand.nextInt(6);
		Circle circleBall = new Circle(diameter,x, y, colors[colorCode] );		
		LOG.debug("diameter:" + diameter + " x:" + x + " y:" + y + " colorCode:" + colorCode);
		//-----------
		
		circleBall.makeVisible();
		
		while(circleBall.getY() < 380 ) {
			circleBall.moveVertical(10);
		}
		
		while(circleBall.getDiameter() > 0 ) {
			circleBall.changeSize(circleBall.getDiameter()-1);
			try {
				java.util.concurrent.TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
