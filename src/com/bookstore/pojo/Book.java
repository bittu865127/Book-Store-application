package com.bookstore.pojo;


public class Book {
	
	private int id;
    private String name;
    private String author;
    private int yearPublished;
    private int numOfBooksLeft;
    
	public Book(int id, String name, String author, int yearPublished, int numOfBooksLeft) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.yearPublished = yearPublished;
		this.numOfBooksLeft = numOfBooksLeft;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	public int getNumOfBooksLeft() {
		return numOfBooksLeft;
	}
	public void setNumOfBooksLeft(int numOfBooksLeft) {
		this.numOfBooksLeft = numOfBooksLeft;
	}
    
}
