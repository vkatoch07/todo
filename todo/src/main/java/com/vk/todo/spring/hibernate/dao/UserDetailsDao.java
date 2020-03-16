package com.vk.todo.spring.hibernate.dao;

import com.vk.todo.spring.hibernate.model.User;

public interface UserDetailsDao {
	  User findUserByUsername(String username);
	}