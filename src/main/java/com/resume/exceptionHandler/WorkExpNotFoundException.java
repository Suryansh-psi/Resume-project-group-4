package com.resume.exceptionHandler;

public class WorkExpNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 2L;
	
	public WorkExpNotFoundException(String msg) {
		super(msg);
	}
}
