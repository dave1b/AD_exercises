package ch.hslu.a2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ch.hslu.a1.Sort;

class FixedSizeHeapTest {

	FixedSizeHeap heap1 = new FixedSizeHeap(100);
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	
	}

	
	
	
	
	
	@Test
	void testIsEmpty() {
		assertEquals(true, heap1.isEmpty());
		heap1.insert(4);
		heap1.insert(3);
		heap1.insert(4);
		assertEquals(false, heap1.isEmpty());
		heap1.getMax();
		heap1.getMax();
		heap1.getMax();
		assertEquals(true, heap1.isEmpty());
	}
	@Test
	void testIsFull() {
		assertEquals(false, heap1.isFull());	
		int[] testIntArray = Sort.randomInts(100);
		for(int i : testIntArray) {
			heap1.insert(i);
		}	
		assertEquals(true, heap1.isFull());	
	}
	
	@Test
	void testInsert() {
		int[] testIntArray = Sort.randomInts(100);
		for(int i : testIntArray) {
			heap1.insert(i);
		}	
//		heap1.printHeap();
	}

	
	

	@Test
	void testGetMax() {
		int[] testIntArray = {5,546,88888,2232,4,81,99999};
		for(int i : testIntArray) {
			heap1.insert(i);
		}	
		heap1.printHeap();
		System.out.println();
		
		assertEquals(99999, heap1.getMax());
		heap1.printHeap();
		assertEquals(88888, heap1.getMax());
		heap1.printHeap();
	}
	
}
