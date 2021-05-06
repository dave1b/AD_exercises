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
		assertEquals(true, Sprache.isWortLanguage("0"));
		assertEquals(true, Sprache.isWortLanguage("010"));
		assertEquals(true, Sprache.isWortLanguage("01110"));
		assertEquals(true, Sprache.isWortLanguage("0111110"));
		assertEquals(true, Sprache.isWortLanguage("011101110"));
		assertEquals(true, Sprache.isWortLanguage("0111010111110"));
		assertEquals(true, Sprache.isWortLanguage("0"));

	}
	@Test
	void testIsWortLanguageFalse() {
		assertEquals(false, Sprache.isWortLanguage("1"));
		assertEquals(false, Sprache.isWortLanguage("00"));
		assertEquals(false, Sprache.isWortLanguage("111"));
		assertEquals(false, Sprache.isWortLanguage("0110"));
		assertEquals(false, Sprache.isWortLanguage("0111"));
		assertEquals(false, Sprache.isWortLanguage("011110"));
		
	}

}
