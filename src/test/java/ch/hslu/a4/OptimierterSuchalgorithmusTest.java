package ch.hslu.a4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OptimierterSuchalgorithmusTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testStateSearch() {
		String s1 = "xxxxxxxx";
		String s2 = "ANANAScie";
		String s3 = "dANANAScie";
		String s4 = "sdANANAScie";
		String s5 = "ciwndjfANANAkciANAoceANANAScie";
		String s6 = "ciwndjfANANAkciANAoceAsdfNANAScie";
		assertEquals(-1, OptimierterSuchalgorithmus.stateSearch(s1));
		assertEquals(0, OptimierterSuchalgorithmus.stateSearch(s2));
		assertEquals(1, OptimierterSuchalgorithmus.stateSearch(s3));
		assertEquals(2, OptimierterSuchalgorithmus.stateSearch(s4));
		assertEquals(21, OptimierterSuchalgorithmus.stateSearch(s5));
		assertEquals(-1, OptimierterSuchalgorithmus.stateSearch(s6));
		
	}

}
