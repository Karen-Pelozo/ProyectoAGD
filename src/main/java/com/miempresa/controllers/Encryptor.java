package com.miempresa.controllers;

public class Encryptor {
	/*private static String encript(String text) throws Exception {	
		Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, aesKey);

		byte[] encrypted = cipher.doFinal(text.getBytes());
			
		return Base64.encodeBytes(encrypted);
		}

	private static String decrypt(String encrypted) throws Exception {
		byte[] encryptedBytes=Base64.decode( encrypted.replace("\n", "") );
			
		Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, aesKey);

		String decrypted = new String(cipher.doFinal(encryptedBytes));
	        
		return decrypted;
		}*/
}
