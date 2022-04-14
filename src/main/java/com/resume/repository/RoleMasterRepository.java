package com.resume.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.resume.model.RoleMaster;
@Repository
public class RoleMasterRepository implements IRoleMasterRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<RoleMaster> getRoleMaster() {
		// TODO Auto-generated method stub
		String query = "select * from roleMaster";
		return jdbcTemplate.query(query, 
				(rs, rowNum) -> {
					RoleMaster roleMaster = new RoleMaster();
					roleMaster.setRole_id(rs.getLong("role_id"));
					roleMaster.setRole_name(rs.getString("role_name"));
					roleMaster.setRole_desc(rs.getString("role_desc"));
					roleMaster.setVisible(rs.getBoolean("isVisible"));
					return roleMaster;
				}
			);
	}
	
	@Override
	public Optional<RoleMaster> getRoleMasterById(Long role_id) {
		String query = "select * from roleMaster where role_id = " + role_id;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			RoleMaster roleMaster = new RoleMaster();
			roleMaster.setRole_id(rs.getLong("role_id"));
			roleMaster.setRole_name(rs.getString("role_name"));
			roleMaster.setRole_desc(rs.getString("role_desc"));
			roleMaster.setVisible(rs.getBoolean("isVisible"));
			return roleMaster;
		}).stream().findFirst();
	}


	@Override
	public Integer addRoleMaster(RoleMaster roleMaster) {
		// TODO Auto-generated method stub
        String query = "INSERT INTO roleMaster(role_name, role_desc, isVisible) VALUES( ?, ?, ?)";
		
		return jdbcTemplate.update(query,
			 roleMaster.getRole_name(), roleMaster.getRole_desc(), roleMaster.getIsVisible());
	}

	@Override
	public Integer deleteRoleMaster(Long role_id) {
		// TODO Auto-generated method stub
		String query = "delete from roleMaster where role_id = ?";
		return jdbcTemplate.update(query, role_id);
	}

	
	@Override
	public Integer updateRoleMaster(RoleMaster roleMaster, Long role_id) {
		// TODO Auto-generated method stub
        String query = "update roleMaster set  role_name = ?, role_desc = ?, isVisible= ?  where role_id = ?";
		
		return jdbcTemplate.update(query, 
				    roleMaster.getRole_name(),
					roleMaster.getRole_desc(),
					roleMaster.getIsVisible(),
					role_id
				);
	}

}
