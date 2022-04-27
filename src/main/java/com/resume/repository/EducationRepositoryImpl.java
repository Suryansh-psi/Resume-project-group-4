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

import com.resume.model.Education;

@Repository
public class EducationRepositoryImpl implements IEducationRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Education> getEducationByEducationId(Long educationId) {
		// TODO Auto-generated method stub
		String query = "select * from education where educationId = " + educationId;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			Education education = new Education();
			education.setEducationId(rs.getLong("educationId"));
			education.setEducationName(rs.getString("educationName"));
			education.setEducationType(rs.getString("educationType"));
			education.setEducationLocation(rs.getString("educationLocation"));
			education.setStartDate(rs.getDate("startDate"));
			education.setEndDate(rs.getDate("endDate"));
			education.setPercentage(rs.getInt("percentage"));
			education.setResume_id(rs.getLong("resume_id"));
			return education;
		});
	}

	@Override
	public List<Education> getEducationByResumeId(Long resumeId) {
		String query = "select * from education where resume_id = " + resumeId;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			Education education = new Education();
			education.setEducationId(rs.getLong("educationId"));
			education.setEducationName(rs.getString("educationName"));
			education.setEducationType(rs.getString("educationType"));
			education.setEducationLocation(rs.getString("educationLocation"));
			education.setStartDate(rs.getDate("startDate"));
			education.setEndDate(rs.getDate("endDate"));
			education.setPercentage(rs.getInt("percentage"));
			education.setResume_id(rs.getLong("resume_id"));
			return education;
		});
	}

	@Override
	public Long saveEducation(Education education) {
		String query = "INSERT INTO education(educationName, educationType, educationLocation, startDate, endDate, percentage, resume_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
		Date start = (Date) education.getStartDate();
		Date end = (Date) education.getEndDate();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String startDate = formatter.format(start);
		String endDate = formatter.format(end);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		   jdbcTemplate.update(connection -> {
		       PreparedStatement ps = connection.prepareStatement(query ,new String[] { "educationId" });
		         
		         	ps.setString(1, education.getEducationName());
		         	ps.setString(2, education.getEducationType());
					ps.setString(3, education.getEducationLocation());
					ps.setString(4, startDate);
					ps.setString(5, endDate);
					ps.setInt(6, education.getPercentage());
					ps.setLong(7, education.getResume_id());
					
		         return ps;
		       }, keyHolder);


		       return  keyHolder.getKey().longValue();
	}

	@Override
	public Integer deleteEducation(Long educationId) {
		String query = "delete from education where educationId = ?";
		return jdbcTemplate.update(query, educationId);
	}

	@Override
	public Integer deleteEducationByResumeId(Long resumeId) {
		String query = "delete from education where resume_id = ?";
		return jdbcTemplate.update(query, resumeId);
	}

	@Override
	public Integer updateEducation(Education education, Long educationId) {
		String query = "update education set educationName = ?, educationType = ?, educationLocation = ?, startDate = ?, endDate = ?, percentage = ? where educationId = " + educationId;
		Date start = (Date) education.getStartDate();
		Date end = (Date) education.getEndDate();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String startDate = formatter.format(start);
		String endDate = formatter.format(end);
		return jdbcTemplate.update(query, 
				education.getEducationName(),
				education.getEducationType(),
				education.getEducationLocation(),
				startDate,
				endDate,
				education.getPercentage()
				);
	}

}
