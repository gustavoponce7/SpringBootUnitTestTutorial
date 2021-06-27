package com.example.service;

import java.util.List;

import com.example.exception.ToDoException;
import com.example.model.ToDo;

public interface ToDoService {
	public List<ToDo> getAllToDo();
	public ToDo getToDoById(long id) throws ToDoException;
	public ToDo saveToDo(ToDo todo);
	public void removeToDo(ToDo todo);
}
