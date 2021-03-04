package ch.hslu.einfuehrung;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FibonacciRekursionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testFib() {
		assertEquals(34,FibonacciRekursion.fib(9));
	}

	@Test
	void testFormelFib() {
		assertEquals(34,FibonacciRekursion.fib(9),0.5f);
		
	}
	@Test
	void testIsFibonacci() {
		assertEquals(true,FibonacciRekursion.isFibonacci(144));
		assertEquals(false,FibonacciRekursion.isFibonacci(12));
		
	}



}
