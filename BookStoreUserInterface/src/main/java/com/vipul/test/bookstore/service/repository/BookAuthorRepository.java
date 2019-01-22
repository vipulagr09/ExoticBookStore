package com.vipul.test.bookstore.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vipul.test.bookstore.service.model.BookAuthor;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer>{

}
