package com.resume.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.resume.model.Resume;

public interface IResumeController {

//	public ResponseEntity<List<Resume>> getResume();
	
	public ResponseEntity<Long> saveResume(Resume resume);
}
