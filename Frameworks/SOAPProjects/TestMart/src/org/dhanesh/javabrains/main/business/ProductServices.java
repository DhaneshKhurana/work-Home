package org.dhanesh.javabrains.main.business;

import java.util.ArrayList;
import java.util.List;

public class ProductServices {
	
	List<String> categories = new ArrayList<>();
	List<String> bookList = new ArrayList<>();
	List<String> musicList = new ArrayList<>();
	List<String> movieList = new ArrayList<>();

	public static final String BOOKS = "books";
	public static final String MUSIC = "music";
	public static final String MOVIES = "movies";
	
	public ProductServices() {
		super();
		
		//Initializing categories
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");
		
		//Initializing book list
		bookList.add("Five Point Someone");
		bookList.add("I too had a love story");
		bookList.add("Brief history of time");
		
		//Initializing music list
		musicList.add("Tere Liye");
		musicList.add("Tere bin");
		musicList.add("Tu");
		
		//Initializing movies list
		movieList.add("Hum aapke hain kaun");
		movieList.add("Hum sath-sath hain");
		movieList.add("Sholay");
	}

	public List<String> getProductCategaories(){
		return categories;
	}
	
	
	public List<String> getProducts(String category){
		switch (category) {
		case BOOKS:
			return bookList;
		case MUSIC:
			return musicList;
		case MOVIES:
			return movieList;
		default:
			return new ArrayList<>();
		}
	}
	
	public boolean addProducts(String category, String product){
		switch (category) {
		case BOOKS:
			bookList.add(product);
			return true;
		case MUSIC:
			musicList.add(product);
			return true;
		case MOVIES:
			movieList.add(product);
			return true;
		default:
			return false;
		}
	}
	
	
}
