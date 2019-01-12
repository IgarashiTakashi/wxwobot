package io.wxwobot.admin.web.utils;


import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	private static final Logger logger = Logger.getLogger(MD5Util.class);

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++){
			resultSb.append(byteToHexString(b[i]));
		}

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0){
			n += 256;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname)){
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			} else{
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
			}
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String MD5Encrypt(String str) {
		String s = str;
		if (s == null) {
			return null;
		}
		String value = null;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			logger.error("没有此类加密算法", ex);
		}
		sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
		try {
			value = baseEncoder.encode(md5.digest(s.getBytes("utf-8")));
		} catch (Exception ex) {
			logger.error("加密算法执行失败", ex);
		}
		return value;
	}

	public static void main(String[] args) {
		System.out.println(MD5Encrypt("wxwobot"));
	}


}
