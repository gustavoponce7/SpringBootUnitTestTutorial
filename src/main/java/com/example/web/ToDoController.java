package com.example.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ToDoException;
import com.example.model.Response;
import com.example.model.ToDo;
import com.example.service.ToDoService;
import com.example.util.PayloadValidator;

@RestController
public class ToDoController {
	
	private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public ResponseEntity<List<ToDo>> getAllToDo(){
    	logger.info("Returning all the ToDo´s");
		return new ResponseEntity<List<ToDo>>(toDoService.getAllToDo(), HttpStatus.OK);
	}
	
    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public ResponseEntity<ToDo> getToDoById(@PathVariable("id") long id) throws ToDoException{
    	logger.info("ToDo id to return " + id);
    	ToDo toDo = toDoService.getToDoById(id);
    	if (toDo == null || toDo.getId() <= 0){
            throw new ToDoException("ToDo doesn´t exist");
    	}
		return new ResponseEntity<ToDo>(toDoService.getToDoById(id), HttpStatus.OK);
	}

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeToDoById(@PathVariable("id") long id) throws ToDoException{
    	logger.info("ToDo id to remove " + id);
    	ToDo toDo = toDoService.getToDoById(id);
    	if (toDo == null || toDo.getId() <= 0){
            throw new ToDoException("ToDo to delete doesn´t exist");
    	}
		toDoService.removeToDo(toDo);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "ToDo has been deleted"), HttpStatus.OK);
	}
    
    @RequestMapping(value = "/todo", method = RequestMethod.POST)
   	public ResponseEntity<ToDo> saveToDo(@RequestBody ToDo payload) throws ToDoException{
    	logger.info("Payload to save " + payload);
    	if (!PayloadValidator.validateCreatePayload(payload)){
            throw new ToDoException("Payload malformed, id must not be defined");
    	}
		return new ResponseEntity<ToDo>(toDoService.saveToDo(payload), HttpStatus.OK);
   	}
    
    @RequestMapping(value = "/todo", method = RequestMethod.PATCH)
   	public ResponseEntity<ToDo>  updateToDo(@RequestBody ToDo payload) throws ToDoException{
    	logger.info("Payload to update " + payload);
    	ToDo toDo = toDoService.getToDoById(payload.getId());
    	if (toDo == null || toDo.getId() <= 0){
            throw new ToDoException("ToDo to update doesn´t exist");
    	}
		return new ResponseEntity<ToDo>(toDoService.saveToDo(payload), HttpStatus.OK);
   	}
	
}
