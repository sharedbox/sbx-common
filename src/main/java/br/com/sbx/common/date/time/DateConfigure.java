package br.com.sbx.common.date.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sbx.common.lang.StringUtils;

/**
 * Utilities for dealing with date/times
 * 
 * @author Rafael Costi [rafaelcosti@outlook.com]
 * @version 1.0.0
 * @since 1.0.0
 */
public class DateConfigure {
	/**
	 * Convert String format yyyy-MM-dd to LocalDate
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate stringddMMMMyyyyToLocalDate(String date) {
		dateValidate(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
		
		String[] dt = (date.contains("-")) ? date.split("-") : date.split("/");
		monthValidate(Integer.parseInt(dt[1]));
		dayValidate(Integer.parseInt(dt[0]));

		LocalDate ld = LocalDate.parse(dt[0] + "/" + dt[1] + "/" + dt[2], formatter);
		return ld;
	}
	
	/**
	 * 
	 * @param date
	 * /
	private static void dateValidate(final LocalDateTime date) {
		if (date == null) {
			throw new IllegalArgumentException("Invalid date");
		}
	}
	
	/**
	 * 
	 * @param date
	 */
	private static void dateValidate(String date) {
		if (StringUtils.isEmpty(date)) {
			throw new IllegalArgumentException("Invalid date");
		}
	}
	
	/**
	 * Check month is valid
	 * 
	 * @param month
	 * @return
	 */
	private static void monthValidate(int month) {
		if (month > 12 || month < 1) {
			throw new IllegalArgumentException("Invalid month");
		}
	}
	
	/**
	 * Check day is valid
	 * 
	 * @param month
	 * @return
	 */
	private static void dayValidate(int day) {
		if (day > 31 || day < 1) {
			throw new IllegalArgumentException("Invalid day");
		}
	}
}
