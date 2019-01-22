package com.vipul.test.bookstore.service.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vipul.test.bookstore.service.UserAccountService;
import com.vipul.test.bookstore.service.model.UserAccount;

@Configuration
public class BookStoreAuthorization extends GlobalAuthenticationConfigurerAdapter{

	
	@Autowired
	private UserAccountService userAccountService;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService());
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@SuppressWarnings("deprecation")
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

				Optional<UserAccount> dbUser = 	userAccountService.findByUsername(username);
				if(dbUser.isPresent()) {
					return User.withDefaultPasswordEncoder().username(dbUser.get().getUserName()).password(dbUser.get().getUserPass()).roles("USER").build();
				}else {
					throw new UsernameNotFoundException("Could not found user with name '" + username + "'");
				}

			}
	};
	}
}
