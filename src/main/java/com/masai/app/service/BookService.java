package com.masai.app.service;

import java.util.List;

import com.masai.app.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();
	public Book getBook(int bookId);
	public void deleteBook(int bookId);
}
