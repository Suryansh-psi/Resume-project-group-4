package com.resume.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResumeExceptHandler {
	@ExceptionHandler({ResumeNotFoundException.class})
	public ResponseEntity<Void> handleException(ResumeNotFoundException ex) {
		ex.printStackTrace();
		return ResponseEntity.notFound().build();
	}
	@ExceptionHandler({WorkExpNotFoundException.class})
	public ResponseEntity<Void> handleException(WorkExpNotFoundException ex) {
		ex.printStackTrace();
		return ResponseEntity.notFound().build();
	}
}
