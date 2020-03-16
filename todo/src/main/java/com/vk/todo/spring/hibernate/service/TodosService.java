package com.vk.todo.spring.hibernate.service;

import java.util.List;

import com.vk.todo.spring.hibernate.model.Todos;

public interface TodosService {
	
	public List<Todos> getAllTodos();

	public void insertTodo(Todos todo);

	public Todos getTodo(int id);

	public void updateTodo(Todos todo);

	public void deleteTodo(int id);
	
	public List<Todos> retrieveTodos();

}
