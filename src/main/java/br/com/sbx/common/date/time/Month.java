package br.com.sbx.common.date.time;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.util.Optional;
import java.util.stream.Stream;

import br.com.sbx.common.lang.StringUtils;

/**
 * 
 * @author Rafael Costi [rafaelcosti@outlook.com]
 * @version 1.0.0
 * @since 1.0.0
 */
public enum Month implements TemporalAccessor, TemporalAdjuster{
	/**
     * The singleton instance for the month of January with 31 days.
     * This has the numeric value of {@code 1}.
     */
    NOT_FOUND(null, null, 0),
    
	/**
     * The singleton instance for the month of January with 31 days.
     * This has the numeric value of {@code 1}.
     */
    JANUARY("JANUARY", "JANEIRO", 1),
    /**
     * The singleton instance for the month of February with 28 days, or 29 in a leap year.
     * This has the numeric value of {@code 2}.
     */
    FEBRUARY("FEBRUARY", "FEVEREIRO", 2),
    /**
     * The singleton instance for the month of March with 31 days.
     * This has the numeric value of {@code 3}.
     */
    MARCH("MARCH", "MARÇO", 3),
    /**
     * The singleton instance for the month of April with 30 days.
     * This has the numeric value of {@code 4}.
     */
    APRIL("APRIL", "ABRIL", 4),
    /**
     * The singleton instance for the month of May with 31 days.
     * This has the numeric value of {@code 5}.
     */
    MAY("MAY", "MAIO", 5),
    /**
     * The singleton instance for the month of June with 30 days.
     * This has the numeric value of {@code 6}.
     */
    JUNE("JUNE", "JUNHO", 6),
    /**
     * The singleton instance for the month of July with 31 days.
     * This has the numeric value of {@code 7}.
     */
    JULY("JULY", "JULHO", 7),
    /**
     * The singleton instance for the month of August with 31 days.
     * This has the numeric value of {@code 8}.
     */
    AUGUST("AUGUST", "AGOSTO", 8),
    /**
     * The singleton instance for the month of September with 30 days.
     * This has the numeric value of {@code 9}.
     */
    SEPTEMBER("SEPTEMBER", "SETEMBRO", 9),
    /**
     * The singleton instance for the month of October with 31 days.
     * This has the numeric value of {@code 10}.
     */
    OCTOBER("OCTOBER", "OUTUBRO", 10),
    /**
     * The singleton instance for the month of November with 30 days.
     * This has the numeric value of {@code 11}.
     */
    NOVEMBER("NOVEMBER", "NOVEMBRO", 11),
    /**
     * The singleton instance for the month of December with 31 days.
     * This has the numeric value of {@code 12}.
     */
    DECEMBER("DECEMBER", "DEZEMBRO", 12);
	
	/**
	 * 
	 */
	private String month;
	
	/**
	 * 
	 */
	private String monthPT;
	
	/**I
	 * 
	 */
	private int ordinalMonth;
	
	/**
	 * 
	 * @param month
	 * @param monthPT
	 * @param monthOrdinal
	 */
	private Month(String month, String monthPT, int ordinalMonth) {
		this.month = month;
		this.monthPT = monthPT;
		this.ordinalMonth = ordinalMonth;
	}
	
    @Override
	public Temporal adjustInto(Temporal temporal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSupported(TemporalField field) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getLong(TemporalField field) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 
	 * @param month
	 * @return
	 */
	public static Integer getOrdinalMonth(final String value) {
		if (StringUtils.isEmpty(value)) {
			return NOT_FOUND.ordinalMonth;
		}
		Optional<Month> response = null;
		
		if(StringUtils.isNumeric(value)) {
			response = Stream.of(values())
				.filter(i -> i.ordinalMonth == Integer.parseInt(value))
				.findFirst();
		} else {
			response = Stream.of(values())
					.filter(i -> (!StringUtils.isEmpty(i.month) && i.month.equals(value.trim().toUpperCase()))
							|| (!StringUtils.isEmpty(i.monthPT) && i.monthPT.equals(value.trim().toUpperCase())))
					.findFirst();
		}
		
		if (!response.isPresent()) {
			throw new IllegalArgumentException("Error get month");
		}
		
		return response.get().ordinalMonth;
	}
}
