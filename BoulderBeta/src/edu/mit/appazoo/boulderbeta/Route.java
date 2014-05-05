package edu.mit.appazoo.boulderbeta;


public class Route {
	  	float rating;
	    String name;
	    String setter;
	    String setter_description;
	    String style;
	    int location;
	    String color;
	    int id;
	    String difficulty;

	    public Route(String name, float rating, String style, String difficulty, int location){
	    	this.rating = rating;
	    	this.name= name;
	    	this.style = style;
	    	this.difficulty = difficulty;
	    	this.location = location;
	    }


}
