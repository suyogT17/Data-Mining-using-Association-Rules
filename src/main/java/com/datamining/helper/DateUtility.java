package main.java.com.datamining.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	/*
	 * @Author Mehul:
	 * This method will convert date object in to String Object
	 * @param date: should not be null and should be of the type util date
	 * @param pattern: 
	 */
	public static String formatDate(final Date date, final String pattern)
	{
		return new SimpleDateFormat(pattern).format(date);
	}

	public static Date FormateDateString(final String date, final String pattern)
			throws ParseException
	{
		final SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		final Date convertedDate = dateFormat.parse(date);
		return convertedDate;

	}


}
