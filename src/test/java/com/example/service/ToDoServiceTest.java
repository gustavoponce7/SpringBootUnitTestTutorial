package com.example.service;

import com.example.exception.ToDoException;
import com.example.model.ToDo;
import com.example.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ToDoServiceTest {

    @Mock
    private ToDoRepository toDoRepository;

    @InjectMocks
    private ToDoServiceImpl toDoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllToDo() {
        List<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.add(new ToDo(1, "Todo Sample 1", true));
        toDoList.add(new ToDo(2, "Todo Sample 2", true));
        toDoList.add(new ToDo(3, "Todo Sample 3", false));
        when(toDoRepository.findAll()).thenReturn(toDoList);

        List<ToDo> result = toDoService.getAllToDo();
        assertEquals(3, result.size());
    }

    @Test
    public void testGetToDoById() throws ToDoException {
        ToDo toDo = new ToDo(1, "Todo Sample 1", true);
        when(toDoRepository.findById(1L)).thenReturn(Optional.of(toDo));
        ToDo result = toDoService.getToDoById(1);
        assertEquals(1, result.getId());
        assertEquals("Todo Sample 1", result.getText());
        assertTrue(result.isCompleted());
    }

    @Test
    public void saveToDo() {
        ToDo toDo = new ToDo(8, "Todo Sample 8", true);
        when(toDoRepository.save(toDo)).thenReturn(toDo);
        ToDo result = toDoService.saveToDo(toDo);
        assertEquals(8, result.getId());
        assertEquals("Todo Sample 8", result.getText());
        assertTrue(result.isCompleted());
    }

    @Test
    public void removeToDo() {
        ToDo toDo = new ToDo(8, "Todo Sample 8", true);
        toDoService.removeToDo(toDo);
        verify(toDoRepository, times(1)).delete(toDo);
    }
}

