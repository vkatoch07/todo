package com.vk.todo.spring.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vk.todo.spring.hibernate.dao.TodosDAO;
import com.vk.todo.spring.hibernate.model.Todos;

@Service
public class TodosServiceImpl implements TodosService {

	 @Autowired
	 private TodosDAO todoDao;
	 
	@Override
	@Transactional
	public List<Todos> getAllTodos() {		
		 List<Todos> todos = todoDao.getAllTodos(getLoggedInUserName());
		  return todos;
	}
	
	@Override
	@Transactional
	public List<Todos> retrieveTodos(){
		 List<Todos> todos = todoDao.getTodos();
		  return todos;
	}

	@Override
	@Transactional
	public void insertTodo(Todos todo) {
		todo.setUser(getLoggedInUserName());
		todoDao.insertTodo(todo);		
	}

	@Override
	@Transactional
	public Todos getTodo(int id) {
		return todoDao.getTodo(id);
	}
	

	@Override
	@Transactional
	public void updateTodo(Todos todo) {
		todoDao.updateTodo(todo);		
	}

	@Override
	@Transactional
	public void deleteTodo(int id) {
		todoDao.deleteTodo(id);		
	}
		
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	

}
