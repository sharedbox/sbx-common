package br.com.sbx.common.date.time;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;

public enum Month implements TemporalAccessor, TemporalAdjuster{
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
    JUNE("JUNE", "JUNE", 6),
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
	
	
	private Month(String month, String monthPT, int monthOrdinal) {
		
	}
	
    /**
     * Private cache of all the constants.
     */
    private static final Month[] ENUMS = Month.values();

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
}
