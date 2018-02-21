package test.encrypt;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class EncryptionTest {

	private Encryption encoder;
	
	@Before
	public void before() {
		encoder = new Encryption();
	}
	
	@Test
	public void testEncodeSimpleWord() {
		assertEquals("KHOOR",encoder.encode("HELLO"));
	}

	@Test
	public void testEncodeSimpleNull() {
		assertNull(encoder.encode(null));
	}	

	@Test
	public void testEncodeEmptyString() {
		assertEquals("",encoder.encode(""));
	}
	
	@Test
	public void testEncodeOneCharacter() {
		assertEquals("P",encoder.encode("M"));
	}
	
	@Test
	public void testEncodeWordWithAandZ() {
		assertEquals("CDFN",encoder.encode("ZACK"));
	}
	
	@Test
	public void testEncodeWordsWithSpace() {
		assertEquals("KHOOR CDFN!!!",encoder.encode("HELLO ZACK!!!"));
	}
	
	@Test
	public void testEncodeAlphabet() {
		assertEquals("DEFGHIJKLMNOPQRSTUVWXYZABC",encoder.encode("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	}

	@Test
	public void testDecodeSimpleWord() {
		assertEquals("HELLO",encoder.decode("KHOOR"));
	}

	@Test
	public void testDecodeSimpleNull() {
		assertNull(encoder.decode(null));
	}	

	@Test
	public void testDecodeEmptyString() {
		assertEquals("",encoder.decode(""));
	}
	
	@Test
	public void testDecodeOneCharacter() {
		assertEquals("M",encoder.decode("P"));
	}
	
	@Test
	public void testDecodeWordWithAandZ() {
		assertEquals("ZACK",encoder.decode("CDFN"));
	}
	
	@Test
	public void testDecodeWordsWithSpace() {
		assertEquals("HELLO ZACK",encoder.decode("KHOOR CDFN"));
	}
	
	@Test
	public void testDecodeAlphabet() {
		assertEquals("XYZABCDEFGHIJKLMNOPQRSTUVW",encoder.decode("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	}	
}
