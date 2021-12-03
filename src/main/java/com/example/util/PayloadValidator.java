package com.example.util;

import com.example.model.ToDo;

public class PayloadValidator {

    public static boolean validateCreatePayload(ToDo toDo) {
		return toDo.getId() <= 0;
	}

}
