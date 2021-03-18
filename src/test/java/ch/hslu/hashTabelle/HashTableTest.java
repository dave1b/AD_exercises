package ch.hslu.hashTabelle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HashTableTest {

	HashTable hashTable = new HashTable<>();
	
	
	
	@Test
	void testAdd() {
		hashTable.add(6);
		hashTable.add(3);
		hashTable.add(1);
		hashTable.add(9);
		hashTable.add(9);
	}

	@Test
	void testSearch() {
		hashTable.add(90);
		assertEquals(90,hashTable.search(90));
		hashTable.add(90);
		hashTable.remove(90);
		assertEquals(90,hashTable.search(90));
		hashTable.remove(90);
		assertNull(hashTable.search(90));
	}

	@Test
	void testRemove() {
		hashTable.add(6);
		hashTable.remove(6);
		assertEquals(null,hashTable.search(6));
		hashTable.add(6);
		hashTable.add(6);
//		System.out.println(hashTable);
		hashTable.remove(6);
		assertEquals(6,hashTable.search(6));
	}
	
	@Test
	void testRemove2() {
		hashTable.add(60);
		hashTable.add(60);
		hashTable.add(60);
		hashTable.add(60);
		hashTable.add(60);
		hashTable.add(60);
		hashTable.add(60);
		hashTable.add(60);
		hashTable.add(60);
		assertFalse(hashTable.isFull());
		hashTable.add(60);
		System.out.println(hashTable);
		assertTrue(hashTable.isFull());		
		assertEquals(10,hashTable.size());		
		hashTable.remove(60);
		hashTable.remove(60);
		hashTable.remove(60);
		hashTable.remove(60);
		hashTable.remove(60);
		hashTable.remove(60);
		hashTable.remove(60);
		hashTable.remove(60);
		hashTable.remove(60);
		hashTable.remove(60);
		assertEquals(0,hashTable.size());		
		System.out.println(hashTable);
	}
	
	@Test
	void testSize() {
		hashTable.add(6);
		hashTable.add(3);
		hashTable.add(1);
		hashTable.add(9);
		hashTable.add(9);
		hashTable.add(9);
		assertEquals(6,hashTable.size());		
	}
	
	@Test 
	void testIsFull() {
		assertFalse(hashTable.isFull());
		for(int i = 0; i<10; i++) {
			hashTable.add(i);
		}
		assertEquals(10,hashTable.size());		
		assertTrue(hashTable.isFull());		
	}
	
	
	
	
	@Test
	@Disabled
	void testHash() {
		assertEquals(6,hashTable.hash(654165136));
		assertEquals(2,hashTable.hash(321322));
		assertEquals(0,hashTable.hash(5000));
		
	}

}
