package com.vipul.test.bookstore.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vipul.test.bookstore.service.BookStoreService;
import com.vipul.test.bookstore.service.model.BookStore;

@RestController
public class BookStoreController {
	
	@Autowired
	private BookStoreService bookStoreService;
	
	@GetMapping("/getAllBooks")
	public List<BookStore> getAllBooks() {
		
		return bookStoreService.getAllBooks();
	}
	
	@GetMapping("/getBookById/{bookId}")
	public ResponseEntity<String> getBookById(@PathVariable Integer bookId){

		ResponseEntity<String> response = null;
		BookStore dbBook = bookStoreService.getBookById(bookId);
		try {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookId).toUri();
			if(dbBook == null) {
				response = ResponseEntity.created(location).body(" NO book found with this Id ");
			}else {
				ObjectMapper objMapper  =new ObjectMapper();
				String contentString  = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dbBook);
				response = ResponseEntity.created(location).body(contentString);
			}
		}catch(Exception ex) {

			ex.printStackTrace();

		}
		return response;
	}
	
	@PostMapping("/addBookToBookStore")
	public ResponseEntity<String> addABook(@RequestBody BookStore aBookToAdd) {
		int bookId = bookStoreService.addBookToBookStore(aBookToAdd);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookId).toUri();
		
		ResponseEntity<String> response = ResponseEntity.created(location).body(" A New Book gets addeed ");
		return response;
	}

}
