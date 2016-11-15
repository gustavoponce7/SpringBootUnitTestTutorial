package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ToDo;

@Repository("toDoRepository")
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}
