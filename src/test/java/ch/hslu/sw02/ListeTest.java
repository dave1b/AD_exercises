package ch.hslu.sw02;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ListeTest {

	Liste liste = new Liste();
	
	@Test
	void testAddNode() {
		liste.addNode("erster Element");		

	}
	@Test
	void testSetFirst() {
		liste.addNode("erster Element");		
		liste.addNode("zweites Element");
		System.out.println(liste.getFirst());
		liste.setFirst(new Node(liste.getFirst(), "drittes Element"));
		assertEquals("drittes Element", liste.getFirst().getData());
	}

	@Test
	void testGetFirst() {
		liste.addNode("erstes Element");
		assertEquals("erstes Element", liste.getFirst().getData());
	}


	@Test
	void testSize() {
		liste.addNode("erstes Element");		
		liste.addNode("zweites Element");
		liste.addNode("drittes Element");
		assertEquals(3, liste.size());
	}
	
	@Test
	void testContains() {
		liste.addNode("erstes Element");
		liste.addNode("zweites Element");
		liste.addNode("drittes Element");
		assertEquals(false, liste.contains(new Node (null, "nulltes Element")));
	}
	
	@Test
	void testDelet() {
		liste.addNode("erstes Element");
		liste.addNode("zweites Element");
		liste.addNode("drittes Element");
		assertEquals(3, liste.size());
		assertEquals(true, liste.contains(new Node (null, "erstes Element")));
		liste.delet(new Node(null, "erstes Element"));
		assertEquals(2, liste.size());
		assertEquals(false, liste.contains(new Node (null, "erstes Element")));
		liste.delet(new Node(null, "zweites Element"));
		assertEquals(1, liste.size());
		assertEquals(false, liste.contains(new Node (null, "zweites Element")));
		liste.delet(new Node(null, "nichtvorhandenes Element"));
		liste.delet(new Node(null, "drittes Element"));
		assertEquals(0, liste.size());
		assertEquals(false, liste.contains(new Node (null, "zweites Element")));
		
		
	}

}
