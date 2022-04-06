package com.resume.exceptionHandler;

public class ResumeNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResumeNotFoundException(String msg) {
		super(msg);
	}

}
