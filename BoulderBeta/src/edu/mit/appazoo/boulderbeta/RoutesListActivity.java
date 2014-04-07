package edu.mit.appazoo.boulderbeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RoutesListActivity extends Activity {

	SimpleCursorAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_routes_list);
		
		Intent intent = getIntent();
		//String[] routes = intent.getStringArrayExtra(SearchActivity.EXTRA_MESSAGE);
		
		final ListView listview = (ListView) findViewById(R.id.listview);
		
		String[] values = new String[] { "The Green Wall", 
				"Orange Dragon", "Easily Aroused" };
		
		final ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < values.length; ++i){
			list.add(values[i]);
		}
        
		final StableArrayAdapter adapter = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1,list);
		
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?>parent,View view,
					int position,long id){
				/*switch( position )
				{
				case 0:	Intent act0 = new Intent(RoutesListActivity.this, RouteActivity.class);
						startActivity(act0);
						break;
				case 1:	Intent act1 = new Intent(RoutesListActivity.this, RouteActivity.class);
						startActivity(act1);
						break;
				case 2:	Intent act2 = new Intent(RoutesListActivity.this, RouteActivity.class);
						startActivity(act2);
						break;
				}*/
				Object o = listview.getItemAtPosition(position);
				String s = listview.getItemAtPosition(position).toString();
				Intent act = new Intent(RoutesListActivity.this, RouteActivity.class);
				act.putExtra("NAME", s);
				startActivity(act);
			}
		});
        
        
	}
	
	private class StableArrayAdapter extends ArrayAdapter<String>{
		
		HashMap<String,Integer> mldMap = new HashMap<String,Integer>();
		
		public StableArrayAdapter(Context context, int textViewResourceId,
				List<String> objects){
			super(context,textViewResourceId,objects);
			for (int i = 0; i < objects.size(); ++i){
				mldMap.put(objects.get(i), i);
			}
		}
		
		@Override
		public long getItemId(int position){
			String item = getItem(position);
			return mldMap.get(item);
		}
		
		@Override
		public boolean hasStableIds(){
			return true;
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.routes_list, menu);
		return true;
	}

}