package com.resume.repository;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.resume.model.WorkExp;


@Repository
public class WorkExpRepositoryImpl implements IWorkExpRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<WorkExp> getWorkExpByWorkExpId(Long workExpId) {
		String query = "select * from workexp where workExp_id = " + workExpId;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			WorkExp workExp = new WorkExp();
			workExp.setWorkExpId(rs.getLong("workExp_id"));
			workExp.setClientDesc(rs.getString("client_desc"));
			workExp.setCountry(rs.getString("country"));
			workExp.setProjectName(rs.getString("projectName"));
			workExp.setRole(new Gson().fromJson(rs.getString("role"), List.class));
			workExp.setStartDate(rs.getDate("startDate"));
			workExp.setEndDate(rs.getDate("endDate"));
			workExp.setBussinessSol(rs.getString("bussiness_sol"));
			workExp.setTechStack(new Gson().fromJson(rs.getString("tech_stack"), List.class));
			workExp.setProjectResp(new Gson().fromJson(rs.getString("project_resp"), List.class));
			workExp.setResumeId(rs.getLong("resume_id"));
			return workExp;
		});
	}
	
	@Override
	public List<WorkExp> getWorkExpByResumeId(Long resumeId) {
		String query = "select * from workexp where resume_id = " + resumeId;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			WorkExp workExp = new WorkExp();
			workExp.setWorkExpId(rs.getLong("workExp_id"));
			workExp.setClientDesc(rs.getString("client_desc"));
			workExp.setCountry(rs.getString("country"));
			workExp.setProjectName(rs.getString("projectName"));
			workExp.setRole(new Gson().fromJson(rs.getString("role"), List.class));
			workExp.setStartDate(rs.getDate("startDate"));
			workExp.setEndDate(rs.getDate("endDate"));
			workExp.setBussinessSol(rs.getString("bussiness_sol"));
			workExp.setTechStack(new Gson().fromJson(rs.getString("tech_stack"), List.class));
			workExp.setProjectResp(new Gson().fromJson(rs.getString("project_resp"), List.class));
			workExp.setResumeId(rs.getLong("resume_id"));
			return workExp;
		});
		
	}

	@Override
	public Long saveWorkExp(WorkExp workExp) {
		String query = "INSERT INTO workexp(client_desc, country, projectName, role, startDate, endDate, bussiness_sol, tech_stack, resume_id, project_resp) VALUES(?, ? ,?, ?, ?, ?, ?, ?, ?, ?)";
		Date start = (Date) workExp.getStartDate();
		Date end = (Date) workExp.getEndDate();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String startDate = formatter.format(start);
		String endDate = formatter.format(end);
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		   jdbcTemplate.update(connection -> {
		       PreparedStatement ps = connection.prepareStatement(query ,new String[] { "workExp_id" });
		         
		         	ps.setString(1, workExp.getClientDesc());
		         	ps.setString(2, workExp.getCountry());
					ps.setString(3, workExp.getProjectName());
					ps.setString(4, new Gson().toJson(workExp.getRole()));
					ps.setString(5, startDate);
					ps.setString(6, endDate);
					ps.setString(7, workExp.getBussinessSol());
					ps.setString(8, new Gson().toJson(workExp.getTechStack()));
					ps.setLong(9, workExp.getResumeId());
					ps.setString(10, new Gson().toJson(workExp.getProjectResp()));
					
		         return ps;
		       }, keyHolder);


		       return  keyHolder.getKey().longValue();

		
		
//		return jdbcTemplate.update(query, 
//					workExp.getClientDesc(),
//					workExp.getCountry(),
//					workExp.getProjectName(),
//					new Gson().toJson(workExp.getRole()),
//					startDate,
//					endDate,
//					workExp.getBussinessSol(),
//					new Gson().toJson(workExp.getTechStack()),
//					workExp.getResumeId(),
//					new Gson().toJson(workExp.getProjectResp())
//				);
	}

	@Override
	public Integer deleteWorkExp(Long workExpId) {
		String query = "delete from workexp where workExp_id = ?";
		return jdbcTemplate.update(query, workExpId);
	}

	@Override
	public Integer updateWorkExp(WorkExp workExp, Long workExpId) {
		String query = "update workexp set client_desc = ?, country = ?, projectName = ?, role = ?, startDate = ?, endDate = ?, bussiness_sol = ?, tech_stack = ?, project_resp = ? where workExp_id = " + workExpId;
		Date start = (Date) workExp.getStartDate();
		Date end = (Date) workExp.getEndDate();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String startDate = formatter.format(start);
		String endDate = formatter.format(end);
		return jdbcTemplate.update(query, workExp.getClientDesc(),
				workExp.getCountry(),
				workExp.getProjectName(),
				new Gson().toJson(workExp.getRole()),
				startDate,
				endDate,
				workExp.getBussinessSol(),
				new Gson().toJson(workExp.getTechStack()),
				new Gson().toJson(workExp.getProjectResp())
				);
	}

	

	
	
	
}
