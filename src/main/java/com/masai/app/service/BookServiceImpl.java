package com.masai.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.masai.app.entity.Book;

import jakarta.annotation.PostConstruct;

@Service
public class BookServiceImpl implements BookService {

	private List<Book> books=new ArrayList<Book>();
	
	//to create a book and add it in the list using post request
	public Book createBook(Book book) {
		int flag=0;
		for(Book b:books) {
			if(b.getBookId()==book.getBookId()) {
				flag=1;
				break;
			}
		}
		if(flag==1) {
			System.out.println("Book is already present");
			return null;
		}
		else {
			books.add(book);
			System.out.println("The book has been added");
			return book;
		}
		
	}
	
	
	
	
	//to add all the books as soon as the bean of this class is created
	/**	@PostConstruct
		public void addBooks() {
			Book b1=new Book(101,"C++","Nitesh","Rajput Publication","Computer Programming",
					1500,240,"G452");
			
			Book b2=new Book(102,"Java","Shilp","Karnavati Publication","Computer Programming",
					1600,250,"G453");
			
			Book b3=new Book(103,"Python","Isha","o7 Publication","Computer Programming",
					1700,260,"G454");
			
			Book b4=new Book(104,"Ruby","Revant","Gulmohar Publication","Computer Programming",
					1800,270,"G455");
			
			Book b5=new Book(105,"Javascript","Dhairya","Greens Publication","Computer Programming",
					1900,280,"G456");
			
			books.add(b1);
			books.add(b2);
			books.add(b3);
			books.add(b4);
			books.add(b5);
		} **/
	
	
	@Override
	public List<Book> getAllBooks() {
		return books;
	}
	
	

	@Override
	public Book getBook(int bookId) {
		/**Book book=new Book();
		for(Book b:books) {
			if(b.getBookId()==bookId) {
				book=b;
				break;
			}
		}
		return book; **/
		
		List<Book> books=this.books.stream()
				.filter(b->b.getBookId()==bookId)
				.collect(Collectors.toList());
		System.out.println(books.toString());
		
		return books.get(0);
	}

	@Override
	public void deleteBook(int bookId) {
		int flag=0;
		for(Book b:books) {
			if(b.getBookId()==bookId) {
				flag=1;
				break;
			}
		}
		if(flag==1) {
		Book book=getBook(bookId);
		books.remove(book);
		System.out.println("the book has been deleted");
		}else {
			System.out.println("Book not found hence not deleted");
		}

	}




	@Override
	public void updateBook(Book book) {
	
		
		for(Book b:books) {
			if(b.getBookId()==book.getBookId()) {
				b.setName("MongoDB");
				System.out.println("The book has been updated successfully");
				return;
			}
			
		}
		System.out.println("The book could not be updated as it is not present");
		return;
		
	}




	@Override
	public void updateBookPrice(Book book,int price) {
		for(Book b:books) {
			if(b.getBookId()==book.getBookId()) {
				b.setPrice(price);
				System.out.println("the book has been updated with the given price");
				return;
			}
		}
		return;
		
	}
	
	
	
}
