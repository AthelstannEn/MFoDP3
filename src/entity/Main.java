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
		System.out.println("Приклад реалізації  алгоритму шифрування");
		System.out.println("AES");
		System.out.println("На основі 128 бітного рандомного ключа ");
		System.out.println("-----------------------");
		System.out.println("введіть слово для шифрування");
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		Cipher cipher = Cipher.getInstance("AES");
		
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128);
		SecretKey key =  kgen.generateKey();
		
		
		cipher.init(Cipher.ENCRYPT_MODE, key); 
		
		System.out.println("Результат шифрування: ");
		byte[] bytes = cipher.doFinal(s.getBytes());
		for(byte b : bytes){
			
			System.out.print(b);
			
		}
		System.out.println();
	System.out.print("Дешифрований текст: ");
		Cipher deсriptCipher = Cipher.getInstance("AES");
		
		deсriptCipher.init(Cipher.DECRYPT_MODE, key);
		
		byte[] deсriptedbyets = deсriptCipher.doFinal(bytes);
		
		for(byte b : deсriptedbyets){
			System.out.print(  (char) b);
		}
	}
}
