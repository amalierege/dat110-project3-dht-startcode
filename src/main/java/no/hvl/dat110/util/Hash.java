package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf (String entity) {
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.

        try {
			// we use MD5 with 128 bits digest
            MessageDigest messageDigest5 = MessageDigest.getInstance("MD5");
			messageDigest5.update(entity.getBytes());

			// compute the hash of the input 'entity'
			byte [] digest = messageDigest5.digest();

			// convert the hash into hex format - ?
			// convert the hex into BigInteger	- ?

			// convert the hash into BigInteger
			hashint = new BigInteger(1, digest);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
		
		// return the BigInteger
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		return new BigInteger ("2").pow(128);

//		BigInteger bigint;
//
//		// compute the number of bits = bitSize()
//		int bits = bitSize();
//
//		// compute the address size = 2 ^ number of bits
//		bigint = new BigInteger ("2").pow(bits);
//
//		// return the address size
//		return bigint;
	}
	
	public static int bitSize() {

		// find the digest length
		int digestlen = 128;
		
		return digestlen;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
