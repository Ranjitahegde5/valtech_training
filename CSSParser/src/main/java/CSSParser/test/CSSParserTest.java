package CSSParser.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSSParser.CSSParser;

class CSSParserTest {
	
CSSParser css;

	@Test
	void testHexToRgb() {
		assertEquals(52 ,152,219, css.hexToRgb("3498db"));
 
	}

}