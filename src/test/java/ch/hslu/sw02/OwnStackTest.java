package ch.hslu.sw02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OwnStackTest {

	OwnStack stack = new OwnStack(100);

	@Test
	void testpush() {
		stack.push("Erster Eintrag");
		stack.push("Zweiter Eintrag");
		stack.push("Dritter Eintrag");
		assertEquals(3, stack.size());
		
	}

	@Test
	void testpop() {
		stack.push("Erster Eintrag");
		stack.push("Zweiter Eintrag");
		stack.push("Dritter Eintrag");
		assertEquals("Dritter Eintrag", stack.pop());
		assertEquals("Zweiter Eintrag", stack.pop());
		assertEquals("Erster Eintrag", stack.pop());
		assertEquals(0, stack.size());
		
	}

	@Test
	void testClear() {
		stack.push("Erster Eintrag");
		stack.push("Zweiter Eintrag");
		stack.push("Dritter Eintrag");
		assertEquals(3, stack.size());
		stack.clear();
		assertEquals(0, stack.size());
	}

	@Test
	void testSize() {
		stack.push("Erster Eintrag");
		stack.push("Zweiter Eintrag");
		stack.push("Dritter Eintrag");
		stack.push("Vierter Eintrag");
		stack.push("Fünfter Eintrag");
		assertEquals(5, stack.size());
		stack.clear();
		
		for(int i = 1; i <= 100; i++) {
			stack.push("Item");
		}
		assertEquals(100, stack.size());
		assertEquals("Item", stack.pop());
	}
	
	@Test
	void testOverflow() {
		for(int i = 0; i <= 200 ; i++) {
			stack.push("Item");
		}	
	}

}
