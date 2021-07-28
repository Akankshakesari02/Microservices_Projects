package com.example.demo.user.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.dao.UserDAO;
import com.example.demo.user.exception.UserNotFoundException;
import com.example.demo.user.model.Post;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.Postrepository;
import com.example.demo.user.repository.Userrepository;

@RestController
@RequestMapping("jpa")
public class UserJPAController {

	@Autowired
	UserDAO service;
	
	@Autowired
	Userrepository repo;
	@Autowired
	Postrepository postRepo;
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() {
        List<User> users = repo.findAll();
        if(users==null)
        	throw new UserNotFoundException("No user present");
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable int id) {
        Optional<User> users = repo.findById(id);
        if(!users.isPresent())
        	throw new UserNotFoundException("No such user found -" +id);
        return new ResponseEntity<User>(users.get(), HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		repo.save(user);
		
        return new ResponseEntity<Object>(user,HttpStatus.CREATED);
	}	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        repo.deleteById(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/users/{id}/post")
	public ResponseEntity<Post> getOneUsersPosts(@PathVariable int id,@Valid @RequestBody Post post) {
        Optional<User> users = repo.findById(id);
        if(!users.isPresent())
        	throw new UserNotFoundException("No such user found -" +id);
        User user= users.get();
        post.setUser(user);
        postRepo.save(post);
        
        return new ResponseEntity<Post>(post, HttpStatus.OK);
	}



}
