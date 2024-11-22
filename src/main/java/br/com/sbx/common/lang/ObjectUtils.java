package br.com.sbx.common.lang;

/**
 * Object utils
 * 
 * @author Rafael Costi <rafaelcosti@outlook.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {
	/**
	 * Check if both values is same 
	 * 
	 * @param value
	 * @param value2
	 * @return
	 */
	public static boolean checkEqualValues(Object value, Object value2, Class<?> clazz) {
		if (value == null || value2 == null) {
			if (value == value2) {
				return true;
			}
			
			return false;
		}

		if (clazz == Integer.class) {
			return Integer.parseInt(value.toString()) == Integer.parseInt(value2.toString());
		}
		
		if (clazz == Long.class) {
			return Long.parseLong(value.toString()) == Long.parseLong(value2.toString());
		}
		
		if (clazz == Float.class) {
			return Float.parseFloat(value.toString()) == Float.parseFloat(value2.toString());
		}
		
		if (clazz == Double.class) {
			return Double.parseDouble(value.toString()) == Double.parseDouble(value2.toString());
		}
		
		if (clazz == String.class) {
			return value.toString().toUpperCase().trim().equals(value2.toString().toUpperCase().trim());
		}
		
		return false;
	}
}
