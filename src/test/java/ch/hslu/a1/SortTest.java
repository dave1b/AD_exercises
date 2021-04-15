package ch.hslu.a1;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SortTest {

	private static final Logger LOG = LogManager.getLogger(SortTest.class);
	static int[] intArray = { 0, 4, 6, 565, 324, 6543, 27, 34 };
	static int[] intArraySorted = { 0, 4, 6, 27, 34, 324, 565, 6543 };
	Sort sort = new Sort();

	
	// Shell Sort
	@Test
	void testShellSort1() {
		LOG.debug("Array mit: 8 Items");
		assertArrayEquals(intArraySorted, Sort.shellSort(intArray));
	}
	
	
	
	
	// Direktes Austausche -- Bubble Sort
	@Test
	void testBubbleSort1() {
		LOG.debug("Array mit: 8 Items");
		assertArrayEquals(intArraySorted, Sort.bubbleSort(intArray));
	}
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
	@Test
	void testSelectionSort1() {
		LOG.debug("Array mit: 8 Items");
		assertArrayEquals(intArraySorted, Sort.selectionSort(intArray));
	}

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

	@Test
	void testInsertionSort1() {
		LOG.debug("Array mit: 8 Items");
		assertArrayEquals(intArraySorted, Sort.insertionSort(intArray));
	}

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
