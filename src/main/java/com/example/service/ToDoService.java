package com.example.service;

import com.example.exception.ToDoException;
import com.example.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllToDo();

    ToDo getToDoById(long id) throws ToDoException;

    ToDo saveToDo(ToDo todo);

    void removeToDo(ToDo todo);
}
