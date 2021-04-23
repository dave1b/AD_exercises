package ch.hslu.a1;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sort implements Comparable {

	private static final Logger LOG = LogManager.getLogger(Sort.class);

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int[] insertionSort(final int[] a) {
		long startTime = System.currentTimeMillis();
		int elt;
		int j;
		for (int i = 1; i < a.length; i++) {
			elt = a[i]; // nexteltforinsert
			j = i; // a[1]..a[j-1] alreadysorted
			while (a[j - 1] > elt) {
				a[j] = a[j - 1]; // shiftright
				j--; // gofurtherleft
			}
			a[j] = elt; // insertelt
		} // a[1]...a[j] sorted
		LOG.info("Die insertionSort hat: " + (System.currentTimeMillis() - startTime) + " Millisekunden gedauert");
		return a;

	}

	public static int[] selectionSort(final int[] a) {

		long startTime = System.currentTimeMillis();
		int elt;
		int curentSmallestIndex;
		int j;
		for (int i = 0; i < a.length; i++) {
			elt = a[i];
			for (j = i; j < (a.length); j++) {
				if (a[j] < elt) {
					curentSmallestIndex = j;
					elt = a[curentSmallestIndex];
				}
				if (elt != a[i]) {
					a[j] = a[i];
					a[i] = elt;
				}
			}
		}
		LOG.info("Die selectionSort hat: " + (System.currentTimeMillis() - startTime) + " Millisekunden gedauert");
		return a;
	}

	public static int[] bubbleSort(final int[] a) {

		long startTime = System.currentTimeMillis();
		int elt;
		int curentBiggestIndex;
		int j;
		for (j = (a.length - 1); j >= 0; --j) {
			for (int i = 0; i < j; i++) {
				if (a[i] > a[i + 1]) {
					elt = a[i];
					a[i] = a[i + 1];
					a[i + 1] = elt;
				}
			}
		}
		LOG.info("Die bubbleSort hat: " + (System.currentTimeMillis() - startTime) + " Millisekunden gedauert");
		return a;
	}

	public static int[] shellSort(final int[] a) {
		long startTime = System.currentTimeMillis();
		int n = a.length;
		// Start with a big gap, then reduce the gap
		for (int gap = n / 2; gap > 0; gap /= 2) {
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int i = gap; i < n; i += 1) {
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				int temp = a[i];
				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				for (j = i; j >= gap && a[j - gap] > temp; j -= gap)
					a[j] = a[j - gap];
				// put temp (the original a[i]) in its correct
				// location
				a[j] = temp;
			}
		}

		LOG.info("Die shellSort hat: " + (System.currentTimeMillis() - startTime) + " Millisekunden gedauert");
		return a;
	}

	static final char[] quickSort(final char[] a, final int left, final int right) {
		int up = left; // linke Grenze
		int down = right - 1; // rechte Grenze (ohne Trennelement)
		char t = a[right]; // rechtes Element als Trennelement
		boolean allChecked = false;
		do {
			while (a[up] < t) {
				up++; // suche grösseres (>=) Element von links an
			}
			while ((a[down] >= t) && (down > up)) {
				down--; // suche echt kleineres (<) Element von rechts an
			}
			if (down > up) { // solange keine Überschneidung
				exchange(a, up, down);
				up++;
				down--; // linke und rechte Grenze verschieben
			} else {
				allChecked = true; // Austauschen beendet
			}
		} while (!allChecked);
		exchange(a, up, right); // Trennelement an endgültige Position (a[up])
		if (left < (up - 1))
			quickSort(a, left, (up - 1)); // linke Hälfte
		if ((up + 1) < right)
			quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
		return a;
	}
	static final int[] quickSort(final int[] a, final int left, final int right) {
		int up = left; // linke Grenze
		int down = right - 1; // rechte Grenze (ohne Trennelement)
		int t = a[right]; // rechtes Element als Trennelement
		boolean allChecked = false;
		do {
			while (a[up] < t) {
				up++; // suche grösseres (>=) Element von links an
			}
			while ((a[down] >= t) && (down > up)) {
				down--; // suche echt kleineres (<) Element von rechts an
			}
			if (down > up) { // solange keine Überschneidung
				exchange(a, up, down);
				up++;
				down--; // linke und rechte Grenze verschieben
			} else {
				allChecked = true; // Austauschen beendet
			}
		} while (!allChecked);
		exchange(a, up, right); // Trennelement an endgültige Position (a[up])
		if (left < (up - 1))
			quickSort(a, left, (up - 1)); // linke Hälfte
		if ((up + 1) < right)
			quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
		return a;
	}

	// Hilfsmethode für quickSort()
	private static final void exchange(final char[] a, final int firstIndex, final int secondIndex) {
		char tmp;
		tmp = a[firstIndex];
		a[firstIndex] = a[secondIndex];
		a[secondIndex] = tmp;
	}
	private static final void exchange(final int[] a, final int firstIndex, final int secondIndex) {
		int tmp;
		tmp = a[firstIndex];
		a[firstIndex] = a[secondIndex];
		a[secondIndex] = tmp;
	}

	public static void printArray(final int[] a) {
		System.out.println();
		for (int n : a) {
			System.out.println(n);
		}
		System.out.println();
	}

	public static void printCharArray(final char[] a) {
		System.out.println();
		for (char n : a) {
			System.out.println(n);
		}
		System.out.println();
	}

	public static char[] randomChars(final int length) {
		char[] charArray = new char[length];
		Random r = new Random();
		for (int i = 1; i < length; i++) {
			charArray[i] = (char) (r.nextInt(26) + 'a');
		}
		return charArray;
	}

	public static int[] randomInts(final int length) {
		int[] intArray = new int[length];
		for (int i = 1; i < length; i++) {
			intArray[i] = (int) (Math.random() * 100000);
		}
		return intArray;
	}
}
