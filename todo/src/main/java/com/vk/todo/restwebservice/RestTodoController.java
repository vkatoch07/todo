package com.vk.todo.restwebservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vk.todo.spring.hibernate.model.Todos;
import com.vk.todo.spring.hibernate.service.TodosService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class RestTodoController {

	@Autowired
	TodosService service;
	
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public List<Todos> listAllTodos() {
		List<Todos> users = service.retrieveTodos();
		return users;
	}
	
	@RequestMapping(value = "/todo/{id}")
	public Todos listTodo(@PathVariable int id) {
		return service.getTodo(id);
	}
}
