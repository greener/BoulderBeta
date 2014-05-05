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
	ArrayList<Route> routes = new ArrayList<Route>(); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_routes_list);
		
	 
		routes.add(new Route("A", 5.0f, "blue", "v4", 1));
		routes.add(new Route("B", 5.0f, "yellow", "v0", 1));
		routes.add(new Route("C", 5.0f, "blue", "v1/2", 1));
		routes.add(new Route("D", 5.0f, "yellow", "v0", 1));
		routes.add(new Route("E", 5.0f, "orange/blue", "v1/2", 1));
		routes.add(new Route("F", 5.0f, "pink/purple", "v2+", 1));
		routes.add(new Route("G", 5.0f, "pink", "v5", 2));
		routes.add(new Route("H", 5.0f, "green", "v0", 2));
		routes.add(new Route("I", 5.0f, "blue/brown", "v2+", 2));
		routes.add(new Route("J", 5.0f, "green/blue", "v2+", 2));
		routes.add(new Route("K", 5.0f, "red/yellow", "v4", 2));
		routes.add(new Route("L", 5.0f, "white/green rectangles", "v3", 2));
		routes.add(new Route("M", 5.0f, "orang/brown", "v2+", 2));
		routes.add(new Route("N", 5.0f, "dark blue/green", "v5", 2));
		routes.add(new Route("O", 5.0f, "orange", "v5", 3));
		routes.add(new Route("P", 5.0f, "pink", "v1", 3));
		routes.add(new Route("Q", 5.0f, "orange", "v2+", 3));
		routes.add(new Route("R", 5.0f, "red/yellow", "v2", 3));
		routes.add(new Route("S", 5.0f, "green", "v1", 3));
		routes.add(new Route("T", 5.0f, "green/black", "v2", 3));
		routes.add(new Route("U", 5.0f, "blue", "v0+", 4));
		routes.add(new Route("V", 5.0f, "orange/blue", "v5", 4));
		routes.add(new Route("W", 5.0f, "red", "v1", 4));
		routes.add(new Route("X", 5.0f, "blue", "v1+", 4));
		routes.add(new Route("Y", 5.0f, "pink", "v3+", 4));
		routes.add(new Route("Z", 5.0f, "yellow", "v2", 4));
		routes.add(new Route("AA", 5.0f, "orange", "v5-", 4));
		routes.add(new Route("AB", 5.0f, "red", "v2", 4));
		routes.add(new Route("AC", 5.0f, "red/black", "v6", 4));
		routes.add(new Route("AD", 5.0f, "green", "v2", 4));
		routes.add(new Route("AE", 5.0f, "pink", "v3", 4));




		
		

		Intent intent = getIntent();
		String diff = intent.getStringExtra("EXTRA_DIFF");
		String hold = intent.getStringExtra("EXTRA_HOLD");
		
		//.out.println("diff " + diff); 
		//System.out.println("hold " + hold);
		
		
		final ArrayList<Route> list1 = new ArrayList<Route>();
		final ArrayList<Route> list2 = new ArrayList<Route>();
		
		final ListView listview = (ListView) findViewById(R.id.listview);
		final ArrayList<String> list = new ArrayList<String>();
		
		/*sorts difficulty*/
		/*for (int i = 0; i < routes.size(); i++) {
		    Route r = routes.get(i);
		    if (diff == "0.0"){ 
		    	list.add(r.name);
		    	}
		    else{
		    	if (r.difficulty == diff){
		    		list.add(r.name);
		    	}			    	
		    }
		    }*/
		/*sorts holds*/
		/*for (int i1 = 0; i1 < list1.size(); i1++) {
		    Route l = list1.get(i1);
		    if (hold == " "){ 
		    	list2.add(l);
		    	}
		    else{
		    	if (l.style == hold){
		    		list2.add(l);
		    	}			    	
		    }
		    } */		
		
		
		
		/*makes list of names of routes that it will display later*/
		/*for (int i1 = 0; i1 < list2.size(); ++i1){
			Route s = routes.get(i1);
			//list.add(s.name);
		} */
		
		/*for (int i = 0; i<routes.size(); i++){
        	Route r = routes.get(i); 
        	//System.out.println(r.style);
        	if (hold.contentEquals("any")|| hold.contentEquals(r.style)) {
        		if (Double.parseDouble(diff) == 0.0 || Double.parseDouble(r.difficulty) == Double.parseDouble(diff)) {
        			list.add(r.name);
        		}
        	}
        }*/
		
		for (int i = 0; i<routes.size(); i++){
        	Route r = routes.get(i); 
        	//System.out.println(r.style);
        	if (hold.contentEquals("Any")|| hold.contentEquals(r.style)) {
        		//String tester = String.valueOf(diff);
        		String rdiff = r.difficulty;
        		if (diff.equals("Any") || rdiff.equals(String.valueOf(diff))) {
        			list.add(r.name);
        		}
        	}
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
				Route route = null; 
				
				for (int i = 0; i<routes.size(); i++){
					Route arr = routes.get(i);
					if(s == arr.name) {
						route = arr; 
					}
				}
				
				Intent act = new Intent(RoutesListActivity.this, RouteActivity.class);
				act.putExtra("NAME", s);
				System.out.println(route.rating);
				act.putExtra("Rating", route.rating);
				act.putExtra("style", route.style);
				act.putExtra("difficulty", route.difficulty);
				act.putExtra("desc", route.setter_description);
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