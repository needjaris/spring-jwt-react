package com.company.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.entity.User;
import com.company.repository.UserRepository;

@Component
public class DemoService {
	
	private static final Logger log = LoggerFactory.getLogger(DemoService.class);
	
	@Autowired
	UserRepository userRepository;
	
  public User addUser(User user) {
	  log.info("Inside DemoService addUser() ->");
	  return userRepository.save(user); 
  }

public User getUserDetail(Integer id) {
	log.info("Inside DemoService get	User() ->");
	Optional<User> user;
	user = userRepository.findById(id);
	
	return user.isPresent() ? user.get() : null;
}
}
