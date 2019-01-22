package com.vipul.test.bookstore.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vipul.test.bookstore.service.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{

}
