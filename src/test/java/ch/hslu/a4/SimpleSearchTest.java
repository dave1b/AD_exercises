package ch.hslu.a4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SimpleSearchTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testSipleSearch() {
		String p = "ANANAS";
		String s1 = "xxxxxxxx";
		String s2 = "ANANAScie";
		String s3 = "dANANAScie";
		String s4 = "sdANANAScie";
		String s5 = "ciwndjfANANAkciANAoceANANAScie";
		String s6 = "ciwndjfANANAkciANAoceAsdfNANAScie";
		assertEquals(-1, SimpleSearch.simpleSearch(s1, p));
		assertEquals(0, SimpleSearch.simpleSearch(s2, p));
		assertEquals(1, SimpleSearch.simpleSearch(s3, p));
		assertEquals(2, SimpleSearch.simpleSearch(s4, p));
		assertEquals(21, SimpleSearch.simpleSearch(s5, p));
		assertEquals(-1, SimpleSearch.simpleSearch(s6, p));


	}
}
