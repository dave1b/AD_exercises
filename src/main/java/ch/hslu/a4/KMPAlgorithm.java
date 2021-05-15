package ch.hslu.a4;

public class KMPAlgorithm {

	
	public static int[] initNext(final String p) {
		final int m = p.length();
		final int[] next= new int[m];
		int i = 0;
		int j = -1;
		next[0] = -1;
		// specialvalue! (-1 = noreferenceto a followingstate)
		do{
		if((j == -1) || (p.charAt(i) == p.charAt(j))) {
		// (j == -1) must befirst operand!
		i++;
		j++;
		next[i] = j;
		} else{
		j = next[j];
		}
		} while(i < (m -1));
		return next;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	public static int kmpSearch(final String a, final String p) {
		final int n = a.length();
		final int m = p.length();
		int i = 0; // indexto stringa
		int j = 0; // indexto patternp respectivelystate
		// 1. generatenext
		int[] next= initNext(p);
		// 2. searchfor p
		do{
		if((j == -1) || (a.charAt(i) == p.charAt(j))) { // (j == -1) first!
		i++; // processnextcharacter
		j++;
		} else{
		j = next[j]; // goto nextstate
		}
		} while((j < m) && (i < n));
		if(j == m) {
		return(i -m); // patternfound: indexto positionin a
		} else{
		return-1; // patternnot found
		}
		}
}
