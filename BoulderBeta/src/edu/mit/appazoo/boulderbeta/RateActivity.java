package edu.mit.appazoo.boulderbeta;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.os.Build;

public class RateActivity extends ActionBarActivity {

	String name;
	String difficulty; 
	float rating;
	String style; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rate);
		
		Intent intent = getIntent();
		name = intent.getStringExtra("NAME");

		rating = intent.getFloatExtra("Rating", 0);
		difficulty = intent.getStringExtra("difficulty");
		style = intent.getStringExtra("style");

		
	/*	if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rate, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */

		
	public void updateRoute(View view){
		Intent act = new Intent(this, RouteActivity.class);
		act.putExtra("NAME", name);
		act.putExtra("Rating", rating);
		act.putExtra("style", style);
		act.putExtra("difficulty", difficulty);
		
		
		startActivity(act);
	}


}
