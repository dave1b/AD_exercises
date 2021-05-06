package ch.hslu.a3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Sprache {

	 private static final Logger LOG = LogManager.getLogger(Sprache.class); 
	
	
	public static boolean isWortLanguage(final String string) {	
		boolean zeroBefore = false;
		int length = string.length();
		int amountOnes = 0;
		
		if( string.charAt(0) == '1') {
			return false;
		} 
			zeroBefore = true;
			if(string.charAt(length-1) == '1') {
				return false;
			}

				
				
		for(int i = 1; i <= length-2; i++) {
			if(string.charAt(i) == '0' && zeroBefore) {
				return false;
			}  else if (string.charAt(i) == '1' ) {
				zeroBefore = false;
				amountOnes++;
			} 
		}
		if(amountOnes%2 == 0) {
			if(string.length()==1) {
				return true;
			}
			return false;
		} else {
			return true;
		}
	}

	public static void main( String args[]) {
		Sprache.isWortLanguage("111");
		Boolean b = Sprache.isWortLanguage("1111111111");
		System.out.println(b);
	}


}

