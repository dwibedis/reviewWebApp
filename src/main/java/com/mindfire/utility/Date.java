package com.mindfire.utility;

public class Date {
	private int date;
	private int month;
	private int year;

	private static final String DELIMETER = "-";

	public Date(int dd, int mm, int yyyy) {
		date = dd;
		month = mm;
		year = yyyy;
	}

	public String getDate() {
		return Integer.toString(date) + DELIMETER + Integer.toString(month) + DELIMETER + Integer.toString(year);
	}
}
