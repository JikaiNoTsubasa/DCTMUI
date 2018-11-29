package fr.triedge.dctm.test;

import fr.triedge.dctm.utils.SBIEncrypter;

public class GeneratePWD {

	public static void main(String[] args) {
		System.out.println(SBIEncrypter.encrypt("password"));
	}

}
