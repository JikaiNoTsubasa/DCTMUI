package fr.triedge.dctm.utils;

import org.apache.commons.codec.binary.Base64;

public class SBIEncrypter {
	
	private static final String START					= "sbi-";

	public static String encrypt(String pwd) {
		return START + new String(Base64.encodeBase64(pwd.getBytes()));
	}
	
	public static String decode(String pwd) {
		if (!pwd.startsWith(START)) 
			return pwd;
		return new String(Base64.decodeBase64(pwd.getBytes()));
	}
}
