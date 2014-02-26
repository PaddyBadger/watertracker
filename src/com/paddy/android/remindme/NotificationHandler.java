package com.paddy.android.remindme;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;

public class NotificationHandler extends Service {
	public static final String TAG = "NH";
	private WakeLock mWakeLock;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public void handleIntent(Intent intent) {
		PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
		mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, TAG);
		mWakeLock.acquire();
		
		ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		if (!cm.getBackgroundDataSetting()) {
			stopSelf();
			return;
		}
		
		new PollTask().execute();
	}
	

	
	private class PollTask extends AsyncTask<Void, Void, Void> {
		// this is where the update needs to happen - for this no need to call anything, but if an  HTTP request is needed it goes here
	
	
		protected Void doInBackground(Void... params) {
			return null;
		}
	
		// here call notification manager
		
		@Override
		protected void onPostExecute(Void result) {
			//handle your data
			stopSelf();
		}
	}
		
	public void onStart(Intent intent, int startId) {
		handleIntent(intent);
	}
	
	public int onStartCommand(Intent intent, int flags, int startId) {
		handleIntent(intent);
		return START_NOT_STICKY;
	}
	
	public void onDestroy() {
		super.onDestroy();
		mWakeLock.release();
	}

}
