package com.example.androidlocationtest;

import android.location.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity {
	
	protected LocationManager lm;
	protected LocationLogger wifiLogger;
	protected LocationLogger gpsLogger;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// acquire a reference to the system location manager
		lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		// create loggers for wifi and gps signals
		// note: these start logging as soon as they're created
		wifiLogger = new LocationLogger("wifi", lm);
		gpsLogger = new LocationLogger("gps", lm);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
