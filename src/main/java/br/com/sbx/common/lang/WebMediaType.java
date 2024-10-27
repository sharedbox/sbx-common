package br.com.sbx.common.lang;

import java.util.Arrays;
import java.util.Optional;

/**
 * 
 *   
 * @author Rafael Costi [rafaelcosti@outlook.com]
 * @version 1.0.0
 * @since 1.0.0
 */
public enum WebMediaType {
	WEBSITE(1, ""),
	WHATSAPP(2, "https://www.whatsapp.com/"),
	INSTAGRAM(3, "https://www.instagram.com/"),
	X(4, "https://x.com/"),
	FACEBOOK(5, "https://facebook.com"),
	YOUTUBE(6, "https://youtube.com"),
	RUMBLE(7, "https://rumble.com/"),
	DISCORD(8, "https://discord.com/"),
	TWITCH(9, "https://www.twitch.tv/"),
	SLACK(10, "https://slack.com/"),
	ODYSEE(11, "https://odysee.com/");
	
	/**
	 * 
	 */
	private int code;

	
	/**
	 * 
	 */
	private String url;
	
	/**
	 * 
	 * @param code
	 */
	private WebMediaType(int code, String url) {
		this.url = url;
		this.code = code;
	}
	
	/**
	 * 
	 * @return
	 */
	public int code() {
		return this.code;
	}
	
	/**
	 * 
	 * @return
	 */
	public String url() {
		return this.url;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static WebMediaType getByName(String name) {
		if (StringUtils.isEmpty(name)) {
			throw new RuntimeException("Invalid arg name");
		}
		
		Optional<WebMediaType> response = Arrays.asList(values())
				.stream()
				.filter(i -> i.name().toUpperCase().trim().equals(name.toUpperCase().trim()))
				.findFirst();
		
		return response.isPresent() ? response.get() : null;
	}
}
