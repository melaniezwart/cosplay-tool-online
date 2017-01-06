package nl.util;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
/*	public static <K, T> Map<K, T> toMapBy(List<T> list, Function<? super T, ? extends K> mapper){
		return list.stream().collect(Collectors.toMap(mapper, Function.identity()));
	}

	public static <T> Map<String, T> mapMe(Collection<T> list){
		Map<String, T> map = new HashMap<String, T>();
		for(T el : list){
			map.put(el.toString(), el);
		}
		return map;
	}*/
}
