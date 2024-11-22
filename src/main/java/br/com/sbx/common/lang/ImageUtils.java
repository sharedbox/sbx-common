package br.com.sbx.common.lang;

import java.io.IOException;

import org.jsoup.Jsoup;

/**
 * Image utilities
 * 
 * @author Rafael Costi <rafaelcosti@outlook.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public class ImageUtils {
	
	/**
	 * 
	 * @param imageUrl
	 * @return
	 * @throws IOException 
	 */
	public static String getImageFromUrl(String imageUrl) throws IOException {
		if (StringUtils.isEmpty(imageUrl)) {
			return null;
		}
		
		byte[] bytes = Jsoup.connect(imageUrl).ignoreContentType(true).execute().bodyAsBytes();
		return StringUtils.byteArrayToBase64(bytes);
	}
}
