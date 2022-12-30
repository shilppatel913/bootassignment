package com.masai.app.service;

import java.util.List;

import com.masai.app.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();
	public Book getBook(int bookId);
	public void deleteBook(int bookId);
	public Book createBook(Book book);
	public void updateBook(Book book);
	//to update the book using the price parameter
	public void updateBookPrice(Book book,int price);
}
