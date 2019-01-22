package com.vipul.test.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipul.test.bookstore.service.model.BookAuthor;
import com.vipul.test.bookstore.service.model.BookStore;
import com.vipul.test.bookstore.service.repository.BookAuthorRepository;
import com.vipul.test.bookstore.service.repository.BookStoreRepository;

@Service
public class BookStoreService {

	
	@Autowired
	private BookStoreRepository bookStoreRepo;
	@Autowired
	private BookAuthorRepository bookAutherRepo;
	
	public List<BookStore> getAllBooks() {
		return bookStoreRepo.findAll();
	}
	
	public BookStore getBookById(Integer bookId) {
		List<BookStore> allBooks = bookStoreRepo.findAll();
		
		Optional<BookStore> dbBook = allBooks.stream().filter(book -> book.getBookId() == bookId).findFirst();
		
		if(dbBook.isPresent()) {
			return dbBook.get();
		}else {
			return null;
		}
	}
	
	public Integer addBookToBookStore(BookStore aBookToAdd) {
		
		BookAuthor anAuthor = aBookToAdd.getBookAuthor();
		bookAutherRepo.save(anAuthor);
		bookStoreRepo.save(aBookToAdd);
		return aBookToAdd.getBookId();
	}
}
