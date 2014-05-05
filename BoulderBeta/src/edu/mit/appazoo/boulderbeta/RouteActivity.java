package edu.mit.appazoo.boulderbeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

/*
 * This is the class Route Activity, which is a screen with information about a route
 */

public class RouteActivity extends ActionBarActivity {
	String name;
	String difficulty;
	String style; 
	Float rating;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_route);
		
		Intent intent = getIntent();
		name = intent.getStringExtra("NAME");
		TextView r = (TextView) findViewById(R.id.route_name);
		r.setText(name);
		
		rating = intent.getFloatExtra("Rating", 0);
		difficulty = intent.getStringExtra("difficulty");
		style = intent.getStringExtra("style");
		
		System.out.println(rating); 
		
		RatingBar bar = (RatingBar) findViewById(R.id.RatingValue);  
		bar.setRating(rating);
		
		TextView dText = (TextView) findViewById(R.id.DifficultyValue);
		dText.setText(difficulty);
		TextView sText = (TextView) findViewById(R.id.StyleValue);
		sText.setText(style);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void openRate(View view){
		System.out.println("here");
		Intent act = new Intent(this, RateActivity.class);
		act.putExtra("NAME", name);
		act.putExtra("Rating", rating);
		act.putExtra("style", style);
		act.putExtra("difficulty",difficulty);
		
		startActivity(act);
	}


}