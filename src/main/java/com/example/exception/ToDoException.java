package com.example.exception;

public class ToDoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public ToDoException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public ToDoException() {
		super();
	}
}
