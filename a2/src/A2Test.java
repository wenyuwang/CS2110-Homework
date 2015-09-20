import static org.junit.Assert.*;

import org.junit.Test;

public class A2Test {

	@Test
	public void testSumDif() { // assertEquals(expected value, computed value);
	assertEquals(8, A2.sumDif(true, 5, 3)); 
	assertEquals(2, A2.sumDif(false, 5, 3)); 
	assertEquals(8, A2.sumDif(true, 5, 3));
	}
	
	@Test
	public void testAreAnagrams() { // assertEquals(expected value, computed value);
	
	assertEquals(true, A2.areAnagrams("WenYuWang","gnaWuYneW"));
	assertEquals(true,A2.areAnagrams("ABCDDD", "ABCDDD"));
	assertEquals(true,A2.areAnagrams("tom marvolo riddle", "i am lordvoldemort"));
	assertEquals(false,A2.areAnagrams("tommarvoloriddle", "i am lordvoldemort"));
	assertEquals(false,A2.areAnagrams("hello", "world"));
	}
	
	@Test
	public void numOccurrences() { // assertEquals(expected value, computed value);
	assertEquals(1, A2.numOccurrences("ab","b"));
	assertEquals(2, A2.numOccurrences("Luke Skywalker","ke"));
	assertEquals(3, A2.numOccurrences("abababab","aba"));
	assertEquals(3, A2.numOccurrences("aaaa","aa"));
	}
	
	@Test
	public void testFixName() { // assertEquals(expected value, computed value);
	assertEquals("Nate Foster", A2.fixName("foster,    nate"));
	assertEquals("David Gries",A2.fixName( "   gRies,  DAVID     " ));
	assertEquals("James Arthur Gosling",A2.fixName( "GOSLING, JAMES   ARTHUR" ));
	}
	
	@Test
	public void testReplaceConsonants() { // assertEquals(expected value, computed value);
	
	assertEquals("_iNeCRaFT", A2.replaceConsonants("Minecraft"));
	assertEquals("_i_eCRaFT", A2.replaceConsonants("MiNecraft"));
	assertEquals("ALaN _uRiNG", A2.replaceConsonants("Alan Turing"));
	assertEquals("_eN _u _aNG", A2.replaceConsonants("Wen Yu Wang"));
	assertEquals("_oRNeLL ___A _ooD", A2.replaceConsonants("Cornell CTSA Good"));
	assertEquals("_I_A__I _eN _u", A2.replaceConsonants("HITACHI Wen Yu"));
	}
	
	@Test
	public void testDecompress() { // assertEquals(expected value, computed value);
	assertEquals("bbbcxx111bb", A2.decompress("b3c1x2a013b2"));

	}
	
	@Test
	public void testSameBackAndForth() { // assertEquals(expected value, computed value);
	assertEquals(false, A2.sameBackAndForth("WenYuWang"));
	assertEquals(true,A2.sameBackAndForth("ABCCBA"));
	assertEquals(true,A2.sameBackAndForth("aba"));
	assertEquals(false,A2.sameBackAndForth("Madam, I'm Adam"));
	assertEquals(false,A2.sameBackAndForth("MadamImAdam"));
	assertEquals(true,A2.sameBackAndForth("madamimadam"));
	assertEquals(true,A2.sameBackAndForth(""));
	assertEquals(true,A2.sameBackAndForth("b"));
	assertEquals(false,A2.sameBackAndForth("ab"));
	assertEquals(true,A2.sameBackAndForth("abba"));
	assertEquals(false,A2.sameBackAndForth("abBa"));
	

	}
}
