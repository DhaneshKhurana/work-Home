package org.dhanesh.javabrains.dtos;

public class Book {
	
	private int bookId;
	private long barcode;
	private String name;
	private String author;
	private String publisher;
	private String description;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public long getBarcode() {
		return barcode;
	}
	public void setBarcode(long barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
