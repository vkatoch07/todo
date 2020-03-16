package com.vk.todo;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vk.todo.spring.hibernate.model.Todos;
import com.vk.todo.spring.hibernate.service.TodosService;

@Controller
public class TodoController {

	@Autowired
	private TodosService todoService;	
	
/*
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}*/

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodosList(ModelMap model) {
		//String user = getLoggedInUserName();
		//model.addAttribute("todos", service.retrieveTodos(user));		
		model.addAttribute("todos", todoService.getAllTodos());	
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		//model.addAttribute("todo", new Todo());
		model.addAttribute("todo", new Todos());
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(@ModelAttribute("todo") Todos todo) {
		todo.setUser(getLoggedInUserName());
		if (todo.getId() != null){		
			todoService.updateTodo(todo);			
		} else {
			todoService.insertTodo(todo);
		}
		//service.addTodo(getLoggedInUserName(), todo.getDesc(), todo.getTargetDate(), false);
		

		return "redirect:/list-todos";
	}	

	@RequestMapping(value = "/update-todo/{id}", method = RequestMethod.GET)
	//public String showUpdateTodoPage(ModelMap model, @PathVariable("id") int id) {
	public String showUpdateTodoPage(ModelMap model, @PathVariable int id) {
		model.addAttribute("todo", todoService.getTodo(id));
		return "todo";
		
	}	

	@RequestMapping(value = "/delete-todo/{id}")
	public String deleteTodo(@PathVariable("id") int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

}