package ch.hslu.a4;

public class OptimierterSuchalgorithmus {

	public static int stateSearch(final String a) {

		int i = 0; // indexto stringa
		int state = -1; 
		// means"nothingfound"
		final int notFound = -1;
		do {
			switch (state) {
			case -1:// z0
				if (a.charAt(i) == 'A') {
					state = 1;
				}
				break;
			case 1:// z1
				if (a.charAt(i) == 'N') {
					state = 2;
				} else if (a.charAt(i) == 'A') {
					state = 1;
				} else {
					state = -1;
				}
				break;
			case 2:// z2
				if (a.charAt(i) == 'A') {
					state = 3;
				} else {
					state = -1;
				}
				break;
			case 3:// z3
				if (a.charAt(i) == 'N') {
					state = 4;
				} else if(a.charAt(i) == 'A'){
					state = 1;
				} else {
					state = -1;
				}
				break;
			case 4:// z4
				if (a.charAt(i) == 'A') {
					state = 5;
				} else {
					state = 1;
				}
				break;

			case 5:// z5
				if (a.charAt(i) == 'S') {
					state = 6; // found-> z6
				} else if(a.charAt(i) == 'A') {
					state = 1;
				} else {
					state = -1;
				}
				break;
			}
			i++;
		} while ((state != 6) && (i < a.length()));
		if (state == 6) {
			return (i - "ANANAS".length()); // positionof patternstart
		}
		return notFound;
	}

}
