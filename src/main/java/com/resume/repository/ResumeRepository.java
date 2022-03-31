package com.resume.repository;

import java.text.SimpleDateFormat;
import com.google.gson.Gson;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.resume.model.Resume;

@Repository
public class ResumeRepository implements IResumeRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String INSERT_RESUME = "INSERT INTO resume(name, role, total_exp, image, about_me, about_me_points, skills, created_at, update_at, status, reviewer, user_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public Integer saveResume(Resume resume) {
		Date now = (Date) resume.getUpdated_at();
		Date now1 = (Date) resume.getCreated_at();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String mysqlDateString = formatter.format(now);
		String mysqlDateString1 = formatter.format(now1);
		return jdbcTemplate.update(INSERT_RESUME, 
				resume.getName(),
				new Gson().toJson(resume.getRole()),
				resume.getTotal_exp(),
				resume.getImage(),
				resume.getAbout_me(),
				new Gson().toJson(resume.getAbout_me_points()),
				new Gson().toJson(resume.getSkills()),
				mysqlDateString1,
				mysqlDateString,
				resume.getStatus(),
				resume.getReviewer(),
				resume.getUserId()
				);
	}

	@Override
	public Integer deleteResume(Long resumeId) {
		String query = "delete from resume where resume_id = ?";
		return jdbcTemplate.update(query, resumeId);
	}

}
