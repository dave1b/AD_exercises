package ch.hslu.a1;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SortTest {

	private static final Logger LOG = LogManager.getLogger(SortTest.class);
	static int[] intArray = { 0, 4, 6, 565, 324, 6543, 27, 34 };
	static int[] intArraySorted = { 0, 4, 6, 27, 34, 324, 565, 6543 };
	static char[] charArray = { 0, 4, 6, 565, 324, 6543, 27, 34 };
	static char[] charArraySorted = { 0, 4, 6, 27, 34, 324, 565, 6543 };
	Sort sort = new Sort();
	

	// Quick Sort
	@Test
	void testQuickSort1() {
		LOG.debug("Array mit: 8 Items");
		assertArrayEquals(charArraySorted, Sort.quickSort(charArray, 0, (intArray.length - 1)));
	}

	@Test
	void testQuickSort2() {
		int length = 100;
//		Sort.printCharArray(Sort.quickSort(Sort.randomChars(length), 0, length - 1));
	}
	
	
	@Test
	void testQuickSort3() {
		int length = 125_000;
		Sort.quickSort(Sort.randomChars(length), 0, length - 1);
		// Time neede for 100: 0.00s for 125k: 0.112s for 250k: 0.31 500k: 
	}
	@Test
	void testQuickSort4() {
		int length = 250_000;
		Sort.quickSort(Sort.randomChars(length), 0, length - 1);
		// Time neede for 100: 0.00s for 125k: 0.112s for 250k: 0.31 500k: 
	}
	
	

	// Shell Sort
	@Disabled
	@Test
	void testShellSort1() {
		LOG.debug("Array mit: 8 Items");
		assertArrayEquals(intArraySorted, Sort.shellSort(intArray));
	}

	// Direktes Austausche -- Bubble Sort
	@Disabled
	@Test
	void testBubbleSort1() {
		LOG.debug("Array mit: 8 Items");
		assertArrayEquals(intArraySorted, Sort.bubbleSort(intArray));
	}

	@Disabled
	@Test
	void testBubbleSort2() {
		int x = 50000;
		int[] intArrayBig = new int[x];
		for (int i = 1; i < x; i++) {
			intArrayBig[i] = (int) (Math.random() * 100000);
		}
		LOG.debug("Array mit: " + x + " Items");
		Sort.bubbleSort(intArrayBig);
	}

	@Disabled
	@Test
	void testBubbleSort3() {
		int x = 100000;
		int[] intArrayBig = new int[x];
		for (int i = 1; i < x; i++) {
			intArrayBig[i] = (int) (Math.random() * 100000);
		}
		LOG.debug("Array mit: " + x + " Items");
		Sort.bubbleSort(intArrayBig);
	}

	@Disabled
	@Test
	void testBubbleSort4() {
		int x = 200000;
		int[] intArrayBig = new int[x];
		for (int i = 1; i < x; i++) {
			intArrayBig[i] = (int) (Math.random() * 100000);
		}
		LOG.debug("Array mit: " + x + " Items");
		Sort.bubbleSort(intArrayBig);
	}

	// Direktes Auswählen -- Selection Sort
	@Disabled
	@Test
	void testSelectionSort1() {
		LOG.debug("Array mit: 8 Items");
		assertArrayEquals(intArraySorted, Sort.selectionSort(intArray));
	}

	@Disabled
	@Test
	void testSelectionSort2() {
		int x = 50000;
		int[] intArrayBig = new int[x];
		for (int i = 1; i < x; i++) {
			intArrayBig[i] = (int) (Math.random() * 100000);
		}
		LOG.debug("Array mit: " + x + " Items");
		Sort.selectionSort(intArrayBig);
	}

	@Disabled
	@Test
	void testSelectionSort3() {
		int x = 100000;
		int[] intArrayBig = new int[x];
		for (int i = 1; i < x; i++) {
			intArrayBig[i] = (int) (Math.random() * 100000);
		}
		LOG.debug("Array mit: " + x + " Items");
		Sort.selectionSort(intArrayBig);
	}

	@Disabled
	@Test
	void testSelectionSort4() {
		int x = 200000;
		int[] intArrayBig = new int[x];
		for (int i = 1; i < x; i++) {
			intArrayBig[i] = (int) (Math.random() * 100000);
		}
		LOG.debug("Array mit: " + x + " Items");
		Sort.selectionSort(intArrayBig);
	}

	// Direktes Einfügen -- Insertion Sort
	@Disabled
	@Test
	void testInsertionSort1() {
		LOG.debug("Array mit: 8 Items");
		assertArrayEquals(intArraySorted, Sort.insertionSort(intArray));
	}

	@Disabled
	@Test
	void testInsertionSort2() {
		int x = 50000;
		int[] intArrayBig = new int[x];
		for (int i = 1; i < x; i++) {
			intArrayBig[i] = (int) (Math.random() * 100000);
		}
		LOG.debug("Array mit: " + x + " Items");
		Sort.insertionSort(intArrayBig);
	}

	@Disabled
	@Test
	void testInsertionSort3() {
		int x = 100000;
		int[] intArrayBig = new int[x];
		for (int i = 1; i < x; i++) {
			intArrayBig[i] = (int) (Math.random() * 100000);
		}
		LOG.debug("Array mit: " + x + " Items");
		Sort.insertionSort(intArrayBig);
	}

	@Disabled
	@Test
	void testInsertionSort4() {
		int x = 200000;
		int[] intArrayBig = new int[x];
		for (int i = 1; i < x; i++) {
			intArrayBig[i] = (int) (Math.random() * 100000);
		}
		LOG.debug("Array mit: " + x + " Items");
		Sort.insertionSort(intArrayBig);
	}

}
