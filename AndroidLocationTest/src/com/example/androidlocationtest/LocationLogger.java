package com.example.androidlocationtest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class LocationLogger {

	protected LocationListener ll;
	protected String logName;

	public LocationLogger(String ln, LocationManager lm) {

		// indicate what kind of data this logger is logging
		this.logName = ln;

		// make a listener to respond to location updates
		ll = new LocationListener() {
			public void onLocationChanged(Location location) {
				// called when a new location is found by the network location
				// provider
				makeUseOfNewLocation(location);
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
			}

			public void onProviderEnabled(String provider) {
			}

			public void onProviderDisabled(String provider) {
			}
		};

		// Register the listener with the Location Manager to receive location
		// updates
		if (logName == "wifi") {
			lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,
					ll);
		} else { // logName=="gps"
			lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
		}

	}

	// do appropriate things with the new location info
	protected void makeUseOfNewLocation(Location location) {
		String locationString = location.toString();
		System.out.println(locationString);
		appendLog(locationString);
		// ((android.widget.Button)findViewById(R.id.location_text)).setText(locationString);
	}

	// append a string to the log file
	// log is either "GPS" or "WiFi"
	public void appendLog(String text) {
		String filename = "sdcard/" + this.logName + "_log.file";
		File logFile = new File(filename);
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			// BufferedWriter for performance, true to set append to file flag
			BufferedWriter buf = new BufferedWriter(new FileWriter(logFile,
					true));
			buf.append(text);
			buf.newLine();
			buf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
