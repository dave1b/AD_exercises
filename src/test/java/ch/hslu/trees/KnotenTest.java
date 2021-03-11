package ch.hslu.trees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch.hslu.ownDatastructures.Node;
import ch.hslu.trees.Knoten;
import nl.jqno.equalsverifier.EqualsVerifier;

class KnotenTest {

	Knoten knoten1 = new Knoten(1);
	Knoten knoten2 = new Knoten(2);

	@Test
	void testEqualsVerifier() {
		EqualsVerifier.forClass(Knoten.class);
	}
	
	@Test
	void testHashCode() {
		Knoten knotenX = new Knoten(1);
		assertTrue(knoten1.hashCode() == knotenX.hashCode());
	}

	@Test
	void testGetLeftChild() {
		Knoten knoten3 = new Knoten(0);
		knoten1.add(knoten3);
		assertTrue(knoten3 == knoten1.getLeftChild());
	}

	@Test
	void testGetRightChild() {
		Knoten knoten3 = new Knoten(3);
		knoten1.add(knoten3);
		assertTrue(knoten3 == knoten1.getRightChild());
	}

	@Test
	void testGetCurrentValue() {
		assertEquals(1, knoten1.getCurrentValue());
		assertEquals(2, knoten2.getCurrentValue());
	}

	@Test
	void testCompareTo() {
		assertEquals(-1, knoten1.compareTo(knoten2));
		assertEquals(1, knoten2.compareTo(knoten1));
	}

	@Test
	void testEqualsObject() {
		assertFalse(knoten1.equals(knoten2));
		Knoten knotenX = new Knoten(1);
		assertTrue(knoten1.equals(knoten1));
		assertTrue(knoten1.equals(knotenX));
	}

	@Test
	void testAdd() {
		System.out.println(knoten1.toString());
		Knoten knoten3 = new Knoten(3);
		knoten1.add(knoten3);
		knoten1.add(knoten3);
		System.out.println(knoten1.toString());
		assertEquals(3, knoten1.getRightChild().getCurrentValue());
		System.out.println(knoten1.compareTo(knoten3));
	}
	
	
	@Test
	void testSearch() {
		Knoten root = new Knoten(5);
		root.add(new Knoten(2));
		root.add(new Knoten(3));
		root.add(new Knoten(4));
		root.add(new Knoten(26));
		root.add(new Knoten(0));
		root.add(new Knoten(1));
		root.add(new Knoten(-5));
		assertTrue(root.search(new Knoten(2)));
		assertTrue(root.search(new Knoten(-5)));
		assertFalse(root.search(new Knoten(99)));
		assertFalse(root.search(new Knoten(-6)));
	}@Test
	public void testHasChildren() throws Exception {
		throw new RuntimeException("not yet implemented");
	}
	
	

}
