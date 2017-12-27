package com.example.dateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Java LocalDate class is used for dealing with dates(creating dates and
 * manipulating them). Default parsing format is yyyy-MM-dd.
 * 
 * @author Debapriya
 *
 */
public class DateTimeTest {

	public static void main(String[] args) {
		 testDateCreation();
		 testDateManipulation();
		testTimeCreation();
	}

	/**
	 * This method explains some of the ways to create LocalDate object for further
	 * operations with date.
	 * 
	 */
	public static void testDateCreation() {
		// Get the current date in yyyy-MM-dd format
		LocalDate currentDate = LocalDate.now();
		System.out.println("Current Date: " + currentDate);

		// Create date with year, month and dayOfMonth
		LocalDate simpleDate = LocalDate.of(2016, 3, 22); // Also works with 2016,03,22
		System.out.println("Simple Date: " + simpleDate);

		// Create date using Month Enum
		LocalDate dateUsingMonthEnum = LocalDate.of(2016, Month.AUGUST, 15);
		System.out.println("Date using Month Enum: " + dateUsingMonthEnum);

		// Create date using dateString in yyyy-MM-dd format
		LocalDate dateUsingString = LocalDate.parse("2015-03-10"); // Note: it can not parse "2015-3-10"
		System.out.println("Date using String: " + dateUsingString);

		// Create date using dateString in format other than yyyy-MM-dd
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate dateNotInDefaultFormat = LocalDate.parse("03-23-2014", dateTimeFormatter);
		System.out.println("Date not in default Format: " + dateNotInDefaultFormat);// Note: date will be converted to
																					// yyyy-MM-dd after parsing
	}

	/**
	 * This method explains some of the ways to do date related
	 * operation/manipulation
	 * 
	 */
	public static void testDateManipulation() {
		LocalDate dateUnderTest = LocalDate.of(2015, 4, 22);
		// Change date format
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
		String dateInChangedFormat = dateUnderTest.format(dateTimeFormatter); // Note: it returns string
		System.out.println("Date in changed format: " + dateInChangedFormat);

		// Add or subtract Day/Month/Year
		LocalDate shiftedDate = dateUnderTest.minusYears(2).plusMonths(4).plusDays(11).minusWeeks(3);
		System.out.println("Shifted Date: " + shiftedDate);

		// Use TemporalAdjusters
		String firstDayOfNextMonth = dateUnderTest.with(TemporalAdjusters.firstDayOfNextMonth()).getDayOfWeek().name();
		System.out.println("First day of next month: " + firstDayOfNextMonth);

		// Length of month
		int lengthOfMonth = dateUnderTest.lengthOfMonth();
		System.out.println("Length of month: " + lengthOfMonth);

		// Is past or future date
		LocalDate futureDate = LocalDate.of(2015, 4, 26);
		boolean isAfter = futureDate.isAfter(dateUnderTest);
		System.out.println("2015-04-26 date is after 2015-04-22: " + isAfter);

		// Difference in Days between two dates
		long days = ChronoUnit.DAYS.between(dateUnderTest, futureDate); // DAYS is one of the enum defined in ChronoUnit
		System.out.println("Days between: " + days);
	}

	/**
	 * This method explains different strategies for LocalTime Creation
	 * 
	 */
	public static void testTimeCreation() {
		// Get the current time in HH:mm:ss.SSS format
		LocalTime currentTime = LocalTime.now();
		System.out.println("Current Time: " + currentTime);

		// Create Time with Hour, Minute & Second
		LocalTime simpleTime = LocalTime.of(13, 25, 56);
		System.out.println("Simple Time: " + simpleTime);

		// Create LocalTime using Time String
		LocalTime timeUsingString = LocalTime.parse("01:23:29");
		System.out.println("Time using String: " + timeUsingString);

	}

}
