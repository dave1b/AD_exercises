package ch.hslu.a1;

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

	public static void printArray(final int[] a) {
		System.out.println();
		for (int n : a) {
			System.out.println(n);
		}
		System.out.println();
	}

}
