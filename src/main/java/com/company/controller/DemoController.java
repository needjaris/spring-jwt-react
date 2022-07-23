package com.company.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.User;
import com.company.service.DemoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	DemoService demoService;
	
	@GetMapping("getUserNames")
	public String getUserNames() {
		logger.info("Inside getUserDetils method");
		return "Welcome to Bangalore";
	}
	
	@GetMapping("getUserById/{id}")
	public User getUserDetail(@PathVariable Integer id) {
		logger.info("Inside DemoController getUserDetail()");
		return  demoService.getUserDetail(id);
	}
	
	@PostMapping("addUser")
	public User addUser(@RequestBody @Validated User user) {
		logger.info("Inside DemoController addUser()");
		return demoService.addUser(user);
	}

}
