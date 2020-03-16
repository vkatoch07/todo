package com.vk.todo.spring.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.vk.todo.spring.hibernate.model.Todos;

public interface TodosDAO {

	public List<Todos> getTodos();

	public void insertTodo(Todos todo);

	List<Todos> getAllTodos(String username) throws HibernateException;
	
	public void updateTodo(Todos todo);
	
	public void deleteTodo(int id);

	public Todos getTodo(int id);

}
