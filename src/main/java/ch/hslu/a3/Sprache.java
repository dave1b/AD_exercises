package ch.hslu.a3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Sprache {

	 private static final Logger LOG = LogManager.getLogger(Sprache.class); 
	
	
	public static boolean isWortLanguage(final String string) {	
		boolean zeroBefore = false;
		int length = string.length();
		
		
		if( string.charAt(0) == '1') {
			return false;
		} 
		zeroBefore = true;
		
		if(string.charAt(length-1) == '1') {
			return false;
		}			
				
		int oneCounter = 0;
		for(int i = 1; i <= length-1; i++) {
			if(string.charAt(i) == '0' && zeroBefore) {
				return false;
			}  else if (string.charAt(i) == '1' ) {
				zeroBefore = false;
				oneCounter++;
			} else if (string.charAt(i) == '0') {
				if(oneCounter%2 == 0) {
					return false;
				}
				oneCounter = 0;
			}
		}
		return true;
	}


}

