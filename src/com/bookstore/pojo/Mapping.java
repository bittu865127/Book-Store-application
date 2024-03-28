package com.bookstore.pojo;

public class Mapping {
	private int customerId;
    private int bookId;
    private int numOfBooks;
    
	public Mapping(int customerId, int bookId, int numOfBooks) {
		super();
		this.customerId = customerId;
		this.bookId = bookId;
		this.numOfBooks = numOfBooks;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getNumOfBooks() {
		return numOfBooks;
	}
	public void setNumOfBooks(int numOfBooks) {
		this.numOfBooks = numOfBooks;
	}
}
