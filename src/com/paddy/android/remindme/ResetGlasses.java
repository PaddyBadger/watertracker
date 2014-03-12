package com.paddy.android.remindme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class ResetGlasses extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    Intent intent = getIntent();
		Log.i("onCreate ResetGlasses", "get's called");
	    zeroGlasses();
	   }
	
	public void zeroGlasses() {
		Log.i("zeroGlasses", "get's called");
		
		SharedPreferences sharedPref = getSharedPreferences("GlassesData", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.clear();
		editor.commit();
	}
}