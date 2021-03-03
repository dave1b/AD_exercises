package ch.hslu.sw02;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

class NodeTest {
	

	@Test
	void testGetData() {
		Node node = new Node(null, "erster Node");
		assertEquals("erster Node", node.getData());
	}

	@Test
	void testGetNext() {
		Node node = new Node(null, "erster Node");
		assertEquals(null, node.getNext());
	}

	@Test
	void testSetData() {
		Node node = new Node(null, "erster Node");
		node.setData("Data changed");
		assertEquals("Data changed", node.getData());	
	}
	
	@Test
	void testEqualsVerifier() {
		EqualsVerifier.forClass(Node.class);
	}

	



}
