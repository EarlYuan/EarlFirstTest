package com.earl.util;

import sun.misc.BASE64Encoder;

/**
 * BASE64���빤����
 * @author Earl
 *
 */
public class Base64Util {
	
	
	/**
	 * ���ַ���ת��ΪBASE64�����ַ���
	 * @param str  �����ַ���
	 * @return  BASE64�ַ���
	 */
	public static String str2Base64(String str){
		
		BASE64Encoder encoder=new BASE64Encoder();
		String base64Str=encoder.encodeBuffer(str.getBytes());
		return base64Str;
	}

	public static void main(String[] args) {
		String username=str2Base64("earlyuan");
		String password=str2Base64("yy900731");
		System.out.println(username+password);
	}

}
