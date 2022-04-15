package com.resume.repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.resume.model.ProjectMaster;
@Repository
public class ProjectMasterRepository implements IProjectMasterRepository{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ProjectMaster> getProjectMaster() {
		// TODO Auto-generated method stub
		String query = "select * from projectMaster where isVisible=1";
		return jdbcTemplate.query(query, 
				(rs, rowNum) -> {
					ProjectMaster projectMaster = new ProjectMaster();
					projectMaster.setProject_id(rs.getLong("project_id"));
					projectMaster.setProject_name(rs.getString("project_name"));
					projectMaster.setProject_desc(rs.getString("project_desc"));
					projectMaster.setIsVisible(rs.getBoolean("isVisible"));
					return projectMaster;
				}
			);
	}

	@Override
	public Optional<ProjectMaster> getProjectMasterById(Long project_id) {
		// TODO Auto-generated method stub
		String query = "select * from projectMaster where project_id = " + project_id;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			ProjectMaster projectMaster = new ProjectMaster();
			projectMaster.setProject_id(rs.getLong("project_id"));
			projectMaster.setProject_name(rs.getString("project_name"));
			projectMaster.setProject_desc(rs.getString("project_desc"));
			projectMaster.setIsVisible(rs.getBoolean("isVisible"));
			return projectMaster;
		}).stream().findFirst();
	}

	@Override
	public Long addProjectMaster(ProjectMaster projectMaster) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO projectMaster(project_name, project_desc, isVisible) VALUES( ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(connection ->{
			PreparedStatement ps = connection.prepareStatement(query ,new String[] { "project_id" });
	     	ps.setString(1, projectMaster.getProject_name());
			ps.setString(2, projectMaster.getProject_desc());
			ps.setBoolean(3, projectMaster.getIsVisible());

	     return ps;
	   }, keyHolder);


	   return  keyHolder.getKey().longValue();
	}

	@Override
	public Integer updateProjectMaster(ProjectMaster projectMaster, Long project_id) {
		// TODO Auto-generated method stub
		 String query = "update projectMaster set  project_name = ?, project_desc = ?, isVisible = ?  where project_id = ?";
			
			return jdbcTemplate.update(query, 
					projectMaster.getProject_name(),
					projectMaster.getProject_desc(),
					projectMaster.getIsVisible(),
					project_id
					);
	}

	@Override
	public Integer deleteProjectMaster(Long project_id) {
		// TODO Auto-generated method stub
		String query = "delete from projectMaster where project_id = ?";
		return jdbcTemplate.update(query, project_id);
	}

}
