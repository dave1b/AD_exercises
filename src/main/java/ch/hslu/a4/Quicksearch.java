package ch.hslu.a4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Quicksearch {

	
	private static final Logger LOG = LogManager.getLogger(Quicksearch.class);
	/**
	 * Durchsucht eine Zeichenkette mittels quickSearch.
	 *
	 * @parama Zeichenkette, die durchsucht wird.
	 * @returnIndex der Fundstelle oder -1, falls Pattern in a nicht gefunden wurde.
	 */
	public static int quickSearch(final String a, final String p) {
//		long startTime = System.currentTimeMillis();
		final int n = a.length();
		final int m = p.length();
		final int range = 256; // -> ASCII-Range
		final int[] shift = new int[range];
		// initshift-array
		for (int i = 0; i < range; i++) {
			shift[i] = m + 1;
		}
		// overwritefieldsaccordingpattern
		for (int i = 0; i < m; i++) {
			shift[p.charAt(i)] = m - i;
		}

		// ...
		// search
		int i = 0; // indexto string
		int j = 0; // indexto patternp
		do {
			if (a.charAt(i + j) == p.charAt(j)) { // match
				j++;
			} else { // mismatch
				if ((i + m) < n) { // a.charAt(i1+m) isnot outside a
					i += shift[a.charAt(i + m)]; // jump forward
					j = 0;
				} else {
					break; // (mismatch) && (noshiftispossible)
				}
			}
		} while ((j < m) && ((i + m) <= n));
		// (patternp not found) && (end of a not reached)
		if (j == m) {
			LOG.info("Das Pattern {} befindet sich am Index {}" , p ,i  );
			return i; // patternfound
		} else {
			return -1; // pattern not found
		}
	}
}
