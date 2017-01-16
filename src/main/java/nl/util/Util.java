package nl.util;

import java.security.NoSuchAlgorithmException;

/**
 * Created by mzwart on 6-1-2017.
 * Utility class for static methods that are useful in any other class
 */
public class Util {

	public static String md5(String input) {

		String md5 = null;

		if(null == input) return null;

		try {

			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(input.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}
}
