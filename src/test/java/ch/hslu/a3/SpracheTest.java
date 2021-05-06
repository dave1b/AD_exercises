package ch.hslu.a3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SpracheTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testIsWortLanguageTrue() {
		assertTrue( Sprache.isWortLanguage("0"));
		assertTrue(Sprache.isWortLanguage("010"));
		assertTrue( Sprache.isWortLanguage("01110"));
		assertTrue(Sprache.isWortLanguage("0111110"));
		assertTrue(Sprache.isWortLanguage("011101110"));
		assertTrue( Sprache.isWortLanguage("0111010111110"));
		assertTrue(Sprache.isWortLanguage("0"));

	}
	@Test
	void testIsWortLanguageFalse() {
		assertFalse( Sprache.isWortLanguage("1"));
		assertFalse( Sprache.isWortLanguage("00"));
		assertFalse( Sprache.isWortLanguage("111"));
		assertFalse( Sprache.isWortLanguage("0110"));
		assertFalse( Sprache.isWortLanguage("0111"));
		assertFalse( Sprache.isWortLanguage("011110"));
		
	}

}
