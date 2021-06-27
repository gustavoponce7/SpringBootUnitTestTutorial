package com.example.service;

import com.example.exception.ToDoException;
import com.example.model.ToDo;
import com.example.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("toDoService")
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo getToDoById(long id) throws ToDoException {
        return toDoRepository.findById(id).orElseThrow(() -> new ToDoException("Entity not found"));
    }

    @Override
    public ToDo saveToDo(ToDo todo) {
        return toDoRepository.save(todo);
    }

    @Override
    public void removeToDo(ToDo todo) {
        toDoRepository.delete(todo);
    }
}
