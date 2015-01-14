package com.spinach.bean;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.UCDecoder;
import sun.misc.UCEncoder;


public class AES {
	private static final String ALGO = "AES";
    //private static String  keyString = "LTIxfC00NXwtMTF8NjN8Njd8";
	private static String  keyString = "LTIxfC00NXwtMTF8";
	private  final static byte[] keyValue = keyString.getBytes();
    
	
	String toencrypt;
	String todecrypt;
	String encrypted;
	String decrypted;
	
	
	
	
	public String getToencrypt() {
		return toencrypt;
	}

	public void setToencrypt(String toencrypt) {
		this.toencrypt = toencrypt;
	}

	public String getTodecrypt() {
		return todecrypt;
	}

	public void setTodecrypt(String todecrypt) {
		this.todecrypt = todecrypt;
	}

	public String getEncrypted() {
		return encrypt(toencrypt);
	}

	public void setEncrypted(String encrypted) {
		this.encrypted = encrypted;
	}

	public String getDecrypted() {
		return decrypt(todecrypt);
	}

	public void setDecrypted(String decrypted) {
		this.decrypted = decrypted;
	}

	public  String encrypt(String Data)   {
        Key key;
        String encryptedValue=null;
		try {
			key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encVal = c.doFinal(Data.getBytes());
	        encryptedValue = new UCEncoder().encode(encVal);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		return encryptedValue;
        
    }

    public  String decrypt(String encryptedData)  {
        Key key;
        String decryptedValue=null;
		try {
			key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.DECRYPT_MODE, key);
	        byte[] decordedValue = new UCDecoder().decodeBuffer(encryptedData);
	        byte[] decValue = c.doFinal(decordedValue);
	        decryptedValue = new String(decValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return decryptedValue;
    }
    
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
   }
    
    

}
