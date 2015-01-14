package com.spinach.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class BaseUtil extends HttpServlet{

	public static String checkId(String id) {
		String code = id.substring(0, 1);
		String value = id.substring(1, id.length());
		String keyValue = String.valueOf(Integer.valueOf(value) + 1);
		for (int x = keyValue.length(); x < value.length(); ++x) {
			keyValue = "0" + keyValue;
		}
		return code + keyValue;
	}
	
	public static String doURLDecoder(String data) throws UnsupportedEncodingException {
		String newdata = URLDecoder.decode(data, "UTF-8");
		return newdata;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public static String getNewPwd(int pwd_len) {//���ͪ��pwd_len���H���K�X
		final int maxNum = 36;
		int i;
		int count = 0;
		char[] str = {'A','B','C','D','E','F','G','H','I','J','K','L',
				'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'0','1','2','3','4','5','6','7','8','9'};
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while(count < pwd_len) {
			i = Math.abs(r.nextInt(maxNum));
			
			if(i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}
	
	public static String getNum(int num_len) {
		final int maxNum = 36;
		int i;
		int count = 0;
		char[] str = {'0','1','2','3','4','5','6','7','8','9'};
		StringBuffer num = new StringBuffer("");
		Random r = new Random();
		while(count < num_len) {
			i = Math.abs(r.nextInt(maxNum));
			
			if(i >= 0 && i < str.length) {
				num.append(str[i]);
				count++;
			}
		}
		return num.toString();
	}
	
	public static String getRan(int num_len) {
		final int maxNum = 36;
		int i;
		int count = 0;
		char[] str = {'0','1','2','3'};
		StringBuffer num = new StringBuffer("");
		Random r = new Random();
		while(count < num_len) {
			i = Math.abs(r.nextInt(maxNum));
			
			if(i >= 0 && i < str.length) {
				num.append(str[i]);
				count++;
			}
		}
		return num.toString();
	}
	
}
