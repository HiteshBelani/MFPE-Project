package com.cts.authorization.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.authorization.exception.UserNotFoundException;
import com.cts.authorization.model.MyUserDeails;
import com.cts.authorization.model.User;
import com.cts.authorization.repository.UserDao;

import lombok.extern.slf4j.Slf4j;

@Service @Slf4j
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@SuppressWarnings("unused")
	@Autowired
	private PasswordEncoder bcryptEncoder;
	Logger log = LoggerFactory.getLogger(JwtUserDetailsService.class);
	
	@Transactional
	public User registerUser(User user) {
		return userDao.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String userName) {
		/** fetching user by userName, if user is null the throw exception, otherwise
		 * return user
		 */
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		log.info("User found");
		log.info("user successfully located");
		org.springframework.security.core.userdetails.User u=new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),new ArrayList<>());
		
		return new MyUserDeails(user);
		//return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),new ArrayList<>());
	}

	@Transactional
	public int getUserIdByUserName(String userName) throws UserNotFoundException {
		User user = userDao.findByUserName(userName);
		if(user!=null) {
			return user.getId();
		}
		else {
			throw new UserNotFoundException("User Details not Found");
		}
	}

}