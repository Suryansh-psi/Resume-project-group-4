package com.resume.repository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.resume.model.WorkExp;


@Repository
public class WorkExpRepositoryImpl implements IWorkExpRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer saveWorkExp(WorkExp workExp) {
		String query = "INSERT INTO workexp(client_desc, country, role, startDate, endDate, bussiness_sol, tech_stack, resume_id, project_resp) VALUES(?, ? ,?, ?, ?, ?, ?, ?, ?)";
		Date start = (Date) workExp.getStartDate();
		Date end = (Date) workExp.getEndDate();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String startDate = formatter.format(start);
		String endDate = formatter.format(end);
		return jdbcTemplate.update(query, 
					workExp.getClientDesc(),
					workExp.getCountry(),
					new Gson().toJson(workExp.getRole()),
					startDate,
					endDate,
					workExp.getBussinessSol(),
					new Gson().toJson(workExp.getTechStack()),
					workExp.getResumeId(),
					new Gson().toJson(workExp.getProjectResp())
				);
	}

	@Override
	public Integer deleteWorkExp(Long workExpId) {
		String query = "delete from workexp where workExp_id = ?";
		return jdbcTemplate.update(query, workExpId);
	}
	
	
}
