package com.example.demo.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.dao.UserDAO;
import com.example.demo.user.exception.UserNotFoundException;
import com.example.demo.user.model.User;

@RestController
public class UserController {

	@Autowired
	UserDAO service;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() {
        List<User> users = service.findAll();
        if(users==null)
        	throw new UserNotFoundException("No user present");
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable int id) {
        User users = service.findOne(id);
        if(users==null)
        	throw new UserNotFoundException("No such user found -" +id);
        return new ResponseEntity<User>(users, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		service.save(user);
		
        return new ResponseEntity<Object>(user,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
        User users = service.deleteById(id);
        if(users==null)
        	throw new UserNotFoundException("No such user found -" +id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}


}
