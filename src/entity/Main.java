package entity;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.security.auth.login.LoginException;

public class Main {

	public static void main(String[] args) throws LoginException, 
	NoSuchAlgorithmException,
	NoSuchPaddingException, 
	InvalidKeyException, 
	BadPaddingException,
	IllegalBlockSizeException { 
		System.out.println("An example of implementing an encryption algorithm");
		System.out.println("AES");
		System.out.println("Based on a 128 bit random key ");
		System.out.println("-----------------------");
		System.out.println("enter the word for encryption");
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		Cipher cipher = Cipher.getInstance("AES");
		
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128);
		SecretKey key =  kgen.generateKey();
		
		
		cipher.init(Cipher.ENCRYPT_MODE, key); 
		
		System.out.println("The result of encryption: ");
		byte[] bytes = cipher.doFinal(s.getBytes());
		for(byte b : bytes){
			
			System.out.print(b);
			
		}
		System.out.println();
	System.out.print("Decryption text: ");
		Cipher deñriptCipher = Cipher.getInstance("AES");
		
		deñriptCipher.init(Cipher.DECRYPT_MODE, key);
		
		byte[] deñriptedbyets = deñriptCipher.doFinal(bytes);
		
		for(byte b : deñriptedbyets){
			System.out.print(  (char) b);
		}
	}
}
