package trees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch.hslu.ownDatastructures.Node;
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
	
	

}
