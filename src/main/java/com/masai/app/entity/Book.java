package com.masai.app.entity;


public class Book {
	
	private int bookId;
	private String name;
	private String author;
	private String publication;
	private String category;
	private int pages;
	private int price;
	private String author_no;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor_no() {
		return author_no;
	}
	public void setAuthor_no(String author_no) {
		this.author_no = author_no;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", author=" + author + ", publication=" + publication
				+ ", category=" + category + ", pages=" + pages + ", price=" + price + ", author_no=" + author_no + "]";
	}
	public Book(int bookId, String name, String author, String publication, String category, int pages, int price,
			String author_no) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.pages = pages;
		this.price = price;
		this.author_no = author_no;
	}
	public Book() {
		
	}
	
	
	
}
