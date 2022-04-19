package com.resume.repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.resume.model.RoleMaster;
import com.resume.model.TechStack;

@Repository
public class TechStackRepositoryImpl implements ITechStackRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TechStack> getAllTechStack() {
		// TODO Auto-generated method stub
		String query = "select * from techStack where isVisible=1";
		return jdbcTemplate.query(query, 
				(rs, rowNum) -> {
					TechStack techStack = new TechStack();
					techStack.setTechStackId(rs.getLong("techStackId"));
					techStack.setTechStackName(rs.getString("techStackName"));
					techStack.setTechStackDesc(rs.getString("techStackDesc"));
					techStack.setIsVisible(rs.getBoolean("isVisible"));
					return techStack;
				}
			);
	}

	@Override
	public Optional<TechStack> getTechStackById(Long techStackId) {
		// TODO Auto-generated method stub
		String query = "select * from techStack where techStackId = " + techStackId;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			TechStack techStack = new TechStack();
			techStack.setTechStackId(rs.getLong("techStackId"));
			techStack.setTechStackName(rs.getString("techStackName"));
			techStack.setTechStackDesc(rs.getString("techStackDesc"));
			techStack.setIsVisible(rs.getBoolean("isVisible"));
			return techStack;
		}).stream().findFirst();
	}

	@Override
	public Long saveTechStack(TechStack techStack) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO techStack(techStackName, techStackDesc, isVisible) VALUES( ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(connection ->{
			PreparedStatement ps = connection.prepareStatement(query ,new String[] { "techStackId" });
	     	ps.setString(1, techStack.getTechStackName());
			ps.setString(2, techStack.getTechStackDesc());
			ps.setBoolean(3, techStack.getIsVisible());

	     return ps;
	   }, keyHolder);


	   return  keyHolder.getKey().longValue();
		
	}

	@Override
	public Integer deleteTechStack(Long techStackId) {
		// TODO Auto-generated method stub
		String query = "delete from techStack where techStackId = ?";
		return jdbcTemplate.update(query, techStackId);
	}

	@Override
	public Integer updateTechStack(TechStack techStack, Long techStackId) {
		// TODO Auto-generated method stub
        String query = "update techStack set  techStackName = ?, techStackDesc = ?, isVisible= ?  where techStackId = ?";
		
		return jdbcTemplate.update(query, 
				techStack.getTechStackName(),
				techStack.getTechStackDesc(),
				techStack.getIsVisible(),
				techStackId
				);
	}

	
	
	

}