package com.vipul.test.bookstore.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vipul.test.bookstore.service.model.BookStore;

public interface BookStoreRepository extends JpaRepository<BookStore, Integer>{

}
