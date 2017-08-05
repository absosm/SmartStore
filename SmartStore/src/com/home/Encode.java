package com.home;

import java.security.MessageDigest;

public class Encode {
	
	public static String sha256(String clear) {
		
		String cipher = null;
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(clear.getBytes("UTF-8"));
			byte[] digest = md.digest();
			cipher = String.format("%064x", new java.math.BigInteger(1, digest));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cipher;
	}

}
