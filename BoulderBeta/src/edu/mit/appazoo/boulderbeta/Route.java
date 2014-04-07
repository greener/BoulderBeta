package edu.mit.appazoo.boulderbeta;


public class Route {
	  	private Rating rating;
	    private String name;
	    private String setter;
	    private String setter_description;
	    private int style[];
	    private int location;
	    private String color;
	    private int id;
	    private String difficulty;

	    public Route(String name, Rating rating, int style[], String difficulty){
	    	this.rating = rating;
	    	this.name = name;
	    	this.style = style;
	    	this.difficulty = difficulty;
	    }
}
