package test.encrypt;

/**
 * This class implements an algorithm to encode and decode an arbitrary string
 * 
 * @author Michel James Murphy
 * @version 1.0
 *
 */
public class Encryption {

	/**
	 * Alphabet String to be used as reference
	 */
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * Increment and subtraction used for encoding and decoding
	 */
	private final int OFFSET = 3;
	
	/**
	 * Define a increment during the encoding 
	 */
	private final int ENCODE_MODE = 1;
	
	/**
	 * Define a subtraction during the decoding
	 */
	private final int DECODE_MODE = -1;
	
	
	/**
	 * Returns a String encoded or decoded depending on the mode informed 
	 * ENCODE_MODE returns a encoded String
	 * DECODE_MODE returns a decoded String
	 * 
	 * @param text	String to be encoded or decoded
	 * @param mode	Operation desired ENCODE_MODE or DECODE_MODE 
	 * @return		Encoded or decoded String depending on the mode informed
	 */
	private String encodeDecode(String text, int mode) {
		if (text == null) 
			return null;
		
		StringBuffer textEncoded = new StringBuffer("");;
		for (int count = 0; count < text.length(); count++) {
			int index = ALPHABET.indexOf(text.charAt(count));
			if ( index != -1) {
				textEncoded.append(ALPHABET.charAt(((index+(OFFSET*mode))+ALPHABET.length()) % ALPHABET.length()));
			} else {
				textEncoded.append(text.charAt(count));
			}
		}
		return textEncoded.toString();
	}
	
	/**
	 * Returns a encoded String
	 * 
	 * @param text	String to be encoded
	 * @return		Encoded String
	 */
	public String encode(String text) {
		return encodeDecode(text, this.ENCODE_MODE);
	}
	
	/**
	 * Returns a decoded String encoded by encode method 
	 * 
	 * @param text 	Encoded String
	 * @return 		Decoded String
	 */
	public String decode(String text) {
		return encodeDecode(text, this.DECODE_MODE);
	}
	
}
