package ch.hslu.einfuehrung;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ackermann {

	private static final Logger LOG = LogManager.getLogger(Ackermann.class);
	
	public static void main(final String[] args) {
		LOG.info(ack(4,2));
	}
	
	private static int ack(int n, int m) {
		if(n==0) {
			return m+1;
		} else if(m==0) {
			return(ack(n-1,1));
		} else {
			return(ack(n-1,ack(n,m-1)));
		}
	}
	
	
	
	
}
