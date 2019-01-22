package com.vipul.test.bookstore.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vipul.test.bookstore.service.model.UserAccount;

@Service
public class BookStoreService {
 private RestTemplate restTemplate;
 
 private Map<String , String> userMap;
 
 private String restServiceURL;
 
 private String validResponse;
 private HttpHeaders responseHeaders= new HttpHeaders();
 
 
 public BookStoreService() {
	 
	 restTemplate = new RestTemplate();
	 
	 userMap = new HashMap<>();
	 
	 userMap.put("admin","adminpass");
	 
	 String authString = "restadmin" + ":" + "restadminpass";
	 String encodedAuthString =  Base64.getEncoder().encodeToString(authString.getBytes());
	 
	 String authHeader = "Basic "+ encodedAuthString;
	 
	 responseHeaders.set("Authorization", authHeader);
	 
	 restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
 }

 
 public boolean validateUser(String userName , String password) {
	 
	 UserAccount userAccount =  new UserAccount();
	 
	 userAccount.setUserName(userName);
	 userAccount.setUserPass(password);

	 String serviceURL = restServiceURL +"/validateUser";
	 
	 HttpEntity<UserAccount> request = new HttpEntity<>(userAccount, responseHeaders);
	 restTemplate.postForObject(serviceURL, request, String.class);
	 
	 
	 return true;
	 
 }
	
}
