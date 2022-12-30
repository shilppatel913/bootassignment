package com.masai.app.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/")
	public ResponseEntity<?> createBook(@RequestBody Book book) {
		Book b=this.bookServiceImpl.createBook(book);
		if(b==null) {
			return ResponseEntity.ok("The Book already exists hence could not be created");
		}
		return ResponseEntity.ok(b);
	}
	
	/**@PutMapping("/{bookId}")
	public ResponseEntity<?> updateBook(@PathVariable("bookId") int bookId){
		//get which book to update
		Book book=this.bookServiceImpl.getBook(bookId);
		if(book!=null) {
			this.bookServiceImpl.updateBook(book);
			return ResponseEntity.ok("The book has been updated successfully");
		}
		return ResponseEntity.ok("Book is not present in the list");
	}**/
	
	@PutMapping("/{bookId}")
	public ResponseEntity<?> updateBook(@RequestBody String price,@PathVariable("bookId") int bookId){
//		System.out.println(price.substring(15,18));
		int bookPrice=Integer.parseInt(price.substring(15,18)); 
		Book book=this.bookServiceImpl.getBook(bookId);
		 if(book!=null) {
			 this.bookServiceImpl.updateBookPrice(book, bookPrice);
			 return ResponseEntity.ok("the price of the book has been updated with "
			 		+ "the given value");
		 }
		 return ResponseEntity.ok("the book is not present");
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
