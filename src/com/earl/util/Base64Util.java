package com.earl.util;

import sun.misc.BASE64Encoder;

/**
 * BASE64±àÂë¹¤¾ßÀà
 * @author Earl
 *
 */
public class Base64Util {
	
	
	/**
	 * ½«×Ö·û´®×ª»»ÎªBASE64±àÂë×Ö·û´®
	 * @param str  ÊäÈë×Ö·û´®
	 * @return  BASE64×Ö·û´®
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
