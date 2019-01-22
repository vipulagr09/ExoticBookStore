package com.vipul.test.bookstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipul.test.bookstore.service.model.UserAccount;
import com.vipul.test.bookstore.service.repository.UserAccountRepository;

@Service
public class UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepo;
	
	private Map<String,String> userAccounts = new HashMap<>();
	
	public UserAccountService() {
		userAccounts.put("admin", "adminpass");
	}
	
	public boolean validateUser(String userName) {
		
		boolean userExist = false;
		
		for(String user: userAccounts.keySet()) {
			if(user.equals(userName)) {
				userExist = true;
			}
		}
		
		return userExist;
	}
	
	public Optional<UserAccount> findByUsername(String username) {
		
		List<UserAccount> allUsers = userAccountRepo.findAll();
		
		Optional<UserAccount> dbUser = allUsers.stream().filter(user -> user.getUserName().equals(username)).findFirst();
		return dbUser;
	}
	
}
