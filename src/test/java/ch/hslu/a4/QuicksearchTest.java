package ch.hslu.a4;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QuicksearchTest {

	  private static final Logger LOG = LogManager.getLogger(QuicksearchTest.class);
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testQuickSearch() {
		String p = "ANANAS";
		String s1 = "xxxxxxxx";
		String s2 = "ANANAScie";
		String s3 = "dANANAScie";
		String s4 = "sdANANAScie";
		String s5 = "ciwndjfANANAkciANAoceANANAScie";
		String s6 = "ciwndjfANANAkciANAoceAsdfNANAScie";
		assertEquals(-1, Quicksearch.quickSearch(s1, p));
		assertEquals(0, Quicksearch.quickSearch(s2, p));
		assertEquals(1, Quicksearch.quickSearch(s3, p));
		assertEquals(2, Quicksearch.quickSearch(s4, p));
		assertEquals(21, Quicksearch.quickSearch(s5, p));
		assertEquals(-1, Quicksearch.quickSearch(s6, p));
	}

	@Test
	void testQuickSearchBig() {
		String p0 = "Holy Bible";
		String p1 = "EndOfBibel";
		String p2 = "WortDasNichtInDerBibelSteht";
		String p3 = "aeid";
		String p4 = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		String p5 = "a";
		String p6 = "Pro 11:31";
		String file = "C:\\Users\\Dave\\myCloud\\HSLU\\Module\\2. Semester\\AD\\bbe.txt";
		String a = ReadText.readText(file);
//		System.out.println(a);
		
		long startTime = System.currentTimeMillis();
		assertTrue((Quicksearch.quickSearch(a, p0)) == 0);
		LOG.debug("Suche von {} in {} hat {} ms. gedauert.", p0 , "Bibel" ,(java.lang.System.currentTimeMillis()-startTime) );
		
		startTime = System.currentTimeMillis();
		assertTrue((Quicksearch.quickSearch(a, p1)) > 0);
		LOG.debug("Suche von {} in {} hat {} ms. gedauert.", p1 , "Bibel" ,(java.lang.System.currentTimeMillis()-startTime) );

		 startTime = System.currentTimeMillis();
		assertTrue((Quicksearch.quickSearch(a, p2)) == -1);
		LOG.debug("Suche von {} in {} hat {} ms. gedauert.", p2 , "Bibel" ,(java.lang.System.currentTimeMillis()-startTime) );
		
		startTime = java.lang.System.currentTimeMillis();
		assertTrue((Quicksearch.quickSearch(a, p3)) == -1);
		LOG.debug("Suche von {} in {} hat {} ms. gedauert.", p3, "Bibel" ,(System.currentTimeMillis()-startTime) );
		
		startTime = java.lang.System.currentTimeMillis();
		assertTrue((Quicksearch.quickSearch(a, p4)) == -1);
		LOG.debug("Suche von {} in {} hat {} ms. gedauert.", p4 , "Bibel" ,(System.currentTimeMillis()-startTime) );

		startTime = java.lang.System.currentTimeMillis();
		assertTrue((Quicksearch.quickSearch(a, p5)) > -1);
		LOG.debug("Suche von {} in {} hat {} ms. gedauert.", p5, "Bibel" ,(System.currentTimeMillis()-startTime) );

		startTime = java.lang.System.currentTimeMillis();
		assertTrue((Quicksearch.quickSearch(a, p6)) > 0);
		LOG.debug("Suche von {} in {} hat {} ms. gedauert.", p6, "Bibel" ,(System.currentTimeMillis()-startTime) );

		
		
//		assertEquals(0, Quicksearch.quickSearch(s2, p));
//		assertEquals(1, Quicksearch.quickSearch(s3, p));
//		assertEquals(2, Quicksearch.quickSearch(s4, p));
//		assertEquals(21, Quicksearch.quickSearch(s5, p));
//		assertEquals(-1, Quicksearch.quickSearch(s6, p));

				
				
				
	}

}
