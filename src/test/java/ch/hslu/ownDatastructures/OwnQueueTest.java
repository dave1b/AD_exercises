package ch.hslu.ownDatastructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ch.hslu.ownDatastructures.OwnQueue;

class OwnQueueTest {

	OwnQueue queue = new OwnQueue(100);
	OwnQueue queue2 = new OwnQueue(10);

	@Test
	void testAdd() {
		queue.add("erstes Element");
		queue.add("zweites Element");
		queue.add("drittes Element");
		queue.add("viertes Element");
		queue.add("fünftes Element");
		queue.add("sechstes Element");
		assertEquals(6, queue.size());
	}

	@Test
	void testPoll() {
		queue.add("erstes Element");
		queue.add("zweites Element");
		queue.add("drittes Element");
		queue.add("viertes Element");
		queue.add("fünftes Element");
		queue.add("sechstes Element");
		assertEquals("erstes Element", queue.poll());
		assertEquals("zweites Element", queue.poll());
		assertEquals(4, queue.size());
	}
	@Test
	void testSize() {
		queue.add("erstes Element");
		queue.add("zweites Element");
		queue.add("drittes Element");
		queue.add("viertes Element");
		queue.add("fünftes Element");
		queue.add("sechstes Element");
		queue.poll();
		queue.poll();
		queue.poll();
		assertEquals(3, queue.size());
		queue.poll();
		queue.poll();
		queue.poll();
		assertEquals(0, queue.size());
	}

	
	@Test
	void testRotation() {
		for (int i = 1; i <= 10; i++) {
			queue2.add("Element" + i);
		}
		assertEquals(10, queue2.size());
		System.out.println(queue2.toString());
		queue2.poll();
		queue2.poll();
		queue2.poll();
		queue2.poll();
		assertEquals(6, queue2.size());
		System.out.println(queue2.toString());
		for (int i = 11; i < 13; i++) {
			queue2.add("Element" + i);
		}
		System.out.println(queue2.toString());
		assertEquals(8, queue2.size());
	}
	
	@Test
	void testOverflow() {
		for (int i = 1; i <= 15; i++) {
			queue2.add("Element" + i);
		}
		
	}

}
