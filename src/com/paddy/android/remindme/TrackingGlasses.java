package com.paddy.android.remindme;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import android.widget.ToggleButton;

public class TrackingGlasses extends Activity {
	public static final String TAG = "TG"; 
	public int glassesCount;
	public int glassesToDrink = 9;
	public int DEFAULT = 0;
	private ToggleButton toggleButton;
	private static Bundle bundle = new Bundle();
	public ToggleButton[] buttons;
	public TimeManager timeNow = new TimeManager();
	
	public int rateOfDrinking() {
		int timeToGo = timeNow.timeTillEOD();
		if (glassesToDrink > 0) {
			int rateByMinute = (timeToGo / glassesToDrink);
			int hoursRounded = (rateByMinute / 60);
			
			if (hoursRounded < 1) {
				hoursRounded = 1;
			}
			
			return hoursRounded;
		}
		return 0;
	}
	
	public void displayTracking (int glassesCount) {
		if (glassesCount == 1) {
            Toast.makeText(TrackingGlasses.this,  "Way to go! " + glassesCount + " Glass of water drunk today. " + glassesToDrink + " Left today. You should drink a glass of water every " 
             + rateOfDrinking() + " hours to reach the target",  Toast.LENGTH_SHORT).show();  
        
       } else if (glassesCount > 1 && glassesCount < 9){
    	   Toast.makeText(TrackingGlasses.this,  "Way to go! " + glassesCount + " Glasses of water drunk today. "+ glassesToDrink + " Left today. You should drink a glass of water every " 
             + rateOfDrinking() + " hours to reach the target",  Toast.LENGTH_SHORT).show();  
       } else if (glassesCount == 0 ) {
    	   Toast.makeText(TrackingGlasses.this,  "Better get drinking, you're on 0." ,  Toast.LENGTH_SHORT).show();
       } else {
    	   Toast.makeText(TrackingGlasses.this,  "Way to go! You have reached the target!" ,  Toast.LENGTH_SHORT).show();
       }
	}
	
	public void recordGlassesPlus(View v) {
		if (glassesCount < 10 && glassesCount >= 0) {
			glassesCount += 1;	
			glassesToDrink = (9 - glassesCount);
			SharedPreferences sharedPref = getSharedPreferences("GlassesData", Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = sharedPref.edit();
			editor.putBoolean(Integer.toString(v.getId()), true);
			editor.putInt("glasses", glassesCount);
			editor.commit();
			
			displayTracking(glassesCount);
		}
	}
	
	public void recordGlassesMinus(View v) {
		if (glassesCount < 10 && glassesCount >= 0) {
			glassesCount -= 1;	
			glassesToDrink = (9 - glassesCount);
			SharedPreferences sharedPref = getSharedPreferences("GlassesData", Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = sharedPref.edit();
			editor.putBoolean(Integer.toString(v.getId()), false);
			editor.putInt("glasses", glassesCount);
			editor.commit();
			
			displayTracking(glassesCount);
		}
	}
}
