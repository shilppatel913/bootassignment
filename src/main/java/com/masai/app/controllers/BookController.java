package com.masai.app.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.entity.Book;
import com.masai.app.service.BookServiceImpl;

@RestController
@RequestMapping("/bookservice/books") 
public class BookController {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@GetMapping("/")
	public List<Book> getAllBooks() {
		List<Book> books=this.bookServiceImpl.getAllBooks();
		return books;
	}
	
	@GetMapping("/{bookId}")
	public Book getBook(@PathVariable("bookId") int bookId) {
		Book book=this.bookServiceImpl.getBook(bookId);
		return book;
	}
	
	@DeleteMapping("/{bookId}")
	public String deleteBook(@PathVariable("bookId") int bookId) {
		this.bookServiceImpl.deleteBook(bookId);
		return "Book has been deleted successfully";
	}
	
}
