package com.example.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.user.model.User;

@Repository
public interface Userrepository extends JpaRepository<User, Integer>{

}
