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
		Log.i(TAG, "Date is " + date);
		return date;
	}
	
	public int currentTime() {
		Time now = new Time();
		now.setToNow();
		hour = now.hour;
		minute = now.minute;
		Log.i(TAG, "Time is " + now + "hour " + hour + "minute " + minute);
		return hour;
	}

	
	public int timeTillEOD() {
		int hoursToEOD = (23 - currentTime());
		Log.i(TAG, "hour in TimeTillEOD " + hoursToEOD);
		return hoursToEOD;
	}
}
