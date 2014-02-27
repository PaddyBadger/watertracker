package com.paddy.android.remindme;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class NotificationCreator extends Activity {

	public NotificationCompat.Builder createNotification(Context context) {
		
		 Intent intent = new Intent(this, NotificationReceiver.class);
		   PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
		
		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context);
			notificationBuilder.setSmallIcon(R.drawable.water);
			notificationBuilder.setContentTitle("Water Tracker");
			notificationBuilder.setContentText("Time to drink!");
			notificationBuilder.setAutoCancel(true);
			
		NotificationManager mNotificationBuilder = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		return notificationBuilder;
	}	
}
