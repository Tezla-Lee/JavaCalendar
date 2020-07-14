package calendar;

import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Calendar {
	
	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private HashMap <Date, String> planMap;
	
	public Calendar() {
		planMap = new HashMap<Date, String>();
	}
	
	public void registerPlan(String strDate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
//		System.out.println(date);
		planMap.put(date, plan);
	}
	
	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);	
		String plan = planMap.get(date);
		return plan;
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}

	int weekday;
	int day = 0;
	int dayOfYear = 0;

	public void printCalendar(int year, int month) {
		System.out.printf("<<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		for (int i = 1; i < year; i++) {
			if (isLeapYear(i)) {
				dayOfYear += 366;
			} else {
				dayOfYear += 365;
			}
		}
		for (int i = 0; i < month; i++) {
			if (isLeapYear(year)) {
				day += LEAP_MAX_DAYS[i];
			} else {
				day += MAX_DAYS[i];
			}
		}
		for (int i = 0; i < ((day + dayOfYear + 1) % 7); i++) {
			System.out.print("   ");
		}

		int maxDay = getMaxDaysOfMonth(year, month);

		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if ((i + day + dayOfYear + 1) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		day = 0;
		dayOfYear = 0;
	}

	public static void main(String[] args) throws ParseException {
		Calendar calendar = new Calendar();
		calendar.registerPlan("2020-07-14","저녁 약속");
	}
}
