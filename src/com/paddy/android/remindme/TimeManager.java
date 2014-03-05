package com.paddy.android.remindme;


import java.util.Calendar;
import java.util.Date;

import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;

public class TimeManager {
	public final String TAG = "TTD";
	public int hour;
	public int minute;
	
	public CharSequence currentDate() {
		Date now = new Date();
		CharSequence date = DateFormat.format("EEEE,  MMM d, yyyy, hh:mm", now.getTime());
		return date;
	}
	
	public int currentTime() {
		Time now = new Time();
		now.setToNow();
		hour = now.hour;
		minute = now.minute;
		return hour;
	}

	
	public int timeTillEOD() {
		int hoursToEOD = (23 - currentTime());
		return hoursToEOD;
	}
}
