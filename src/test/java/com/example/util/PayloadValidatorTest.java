package com.example.util;

import com.example.model.ToDo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PayloadValidatorTest {

    @Test
    public void validatePayLoad() {
        ToDo toDo = new ToDo(1, "Sample ToDo 1", true);
        assertFalse(PayloadValidator.validateCreatePayload(toDo));
    }

    @Test
    public void validateInvalidPayLoad() {
        ToDo toDo = new ToDo(0, "Sample ToDo 1", true);
        assertTrue(PayloadValidator.validateCreatePayload(toDo));
    }
}
