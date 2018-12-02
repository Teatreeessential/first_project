package net.myproject.myapp.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

//시간관련한 클래스가 들어있는 곳들
public class Tools {

	LocalDate today = LocalDate.now();
	LocalTime systime = LocalTime.now();
	Calendar c = Calendar.getInstance();

	public String start_date(String sysdate) {
		String day = sysdate;

		int yy = Integer.parseInt(day.substring(0, 4));
		int mm = Integer.parseInt(day.substring(4, 6));
		int dd = Integer.parseInt(day.substring(6));

		c.set(yy, mm - 1, dd); // 현재날짜
		c.add(Calendar.MONTH, -1); // 한달 전으로 되돌아감

		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH) + 1;
		int d = c.get(Calendar.DATE);
		day = String.valueOf(y) + String.valueOf((m > 9 ? m : "0" + m)) + String.valueOf((d > 9 ? d : "0" + d));
		return day; // 현재날짜로 부터 한달전 부분을 리턴
	}

	// 현재날짜
	public String sysdate() {

		String day;

		day = String.valueOf(today.getYear());

		if (today.getMonthValue() < 10) {
			day += "0" + today.getMonthValue();
		} else {
			day += today.getMonthValue();
		}
		if (today.getDayOfMonth() < 10) {
			day += "0" + today.getDayOfMonth();
		} else {
			day += today.getDayOfMonth();
		}

		return day;
	}

	// 현재시각
	public String Getsystime() {
		LocalTime systime = LocalTime.now();
		String time;
		String hh;
		String mm;
		String ss;
		time = String.valueOf(systime);
		hh = time.substring(0, 2);
		mm = time.substring(3, 5);
		ss = time.substring(6, 8);
		time = hh + mm + ss;
		return time;

	}
}
