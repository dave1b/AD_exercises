package ch.hslu.a4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class KMPAlgorithmTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testInitNext() {
		int[] a = new int[6];
		a = KMPAlgorithm.initNext("EISBEIN");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	@Test
	void testKmpSearch() {
		String p = "ANANAS";
		String s1 = "xxxxxxxx";
		String s2 = "ANANAScie";
		String s3 = "dANANAScie";
		String s4 = "sdANANAScie";
		String s5 = "ciwndjfANANAkciANAoceANANAScie";
		String s6 = "ciwndjfANANAkciANAoceAsdfNANAScie";
		assertEquals(-1, KMPAlgorithm.kmpSearch(s1, p));
		assertEquals(0, KMPAlgorithm.kmpSearch(s2, p));
		assertEquals(1, KMPAlgorithm.kmpSearch(s3, p));
		assertEquals(2, KMPAlgorithm.kmpSearch(s4, p));
		assertEquals(21, KMPAlgorithm.kmpSearch(s5, p));
		assertEquals(-1, KMPAlgorithm.kmpSearch(s6, p));
	}
	
	
	

	
	
	
	

}
