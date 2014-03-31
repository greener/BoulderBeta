package com.example.androidlocationtest;

import android.location.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity {
	
	protected LocationManager lm;
	protected LocationListener ll;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// acquire a reference to the system location manager
		lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		// make a listener to respond to location updates
		ll = new LocationListener() {
			public void onLocationChanged(Location location) {
				// called when a new location is found by the network location provider
				makeUseOfNewLocation(location);
			}
			
			public void onStatusChanged(String provider, int status, Bundle extras) {}

		    public void onProviderEnabled(String provider) {}

		    public void onProviderDisabled(String provider) {}
		};
		
		// Register the listener with the Location Manager to receive location updates
		// alternatively, could use LocationManager.GPS_PROVIDER
		lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, ll);
	}
	
	// do appropriate things with the new location info
	protected void makeUseOfNewLocation(Location location){
		String locationString = location.toString();
		((android.widget.Button)findViewById(R.id.location_text)).setText(locationString);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
