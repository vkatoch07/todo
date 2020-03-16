package com.vk.todo.spring.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vk.todo.spring.hibernate.model.Todos;

@Repository
@Transactional(readOnly = true)
public class TodosDaoImpl implements TodosDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Todos> getAllTodos(String loggedInUser) throws HibernateException {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Todos where user = :username";	
		Query query = session.createQuery(hql);	
		query.setParameter("username", loggedInUser);
		List<Todos> todos = query.list();		
		return todos;
	}

	 @Transactional(readOnly = false)
	public void insertTodo(Todos todo) {
		 Session session = sessionFactory.getCurrentSession();		
		 session.save(todo);		 	 
	}

	@Override
	public List<Todos> getTodos() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Todos";	
		Query query = session.createQuery(hql);			
		List<Todos> todos = query.list();		
		return todos;
	}

	@Override
	public void updateTodo(Todos todo) {
		Session session = sessionFactory.getCurrentSession();	
		session.update(todo);	
	}

	@Override
	public void deleteTodo(int id) {
		Session session = sessionFactory.getCurrentSession();
		Todos todo = (Todos) session.get(Todos.class, id);	
		session.delete(todo);			
	}

	@Override
	public Todos getTodo(int id) {
		Session session = sessionFactory.getCurrentSession();
		Todos todo = (Todos) session.get(Todos.class, id);
		return todo;
	}

}
