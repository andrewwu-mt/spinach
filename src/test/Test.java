package test;

import java.io.IOException;

import com.spinach.bean.AES;

public class Test {

	public static void  main(String[] args) throws IOException{
		String id = "1411492664389";
		AES aes = new AES();
		
		System.out.println(aes.encrypt(id));

		
	}
}
