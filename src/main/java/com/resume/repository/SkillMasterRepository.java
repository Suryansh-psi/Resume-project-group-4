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
import com.resume.model.SkillMaster;

@Repository
public class SkillMasterRepository implements ISkillMasterRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<SkillMaster> getSkillMaster() {
		// TODO Auto-generated method stub
		String query = "select * from skillMaster where isVisible=1";
		return jdbcTemplate.query(query, 
				(rs, rowNum) -> {
					SkillMaster skillMaster = new SkillMaster();
					skillMaster.setSkillId(rs.getLong("skillId"));
					skillMaster.setSkill(rs.getString("skill"));
					skillMaster.setCategory(rs.getString("category"));
					skillMaster.setIsVisible(rs.getBoolean("isVisible"));
					return skillMaster;
				}
			);
	}

	@Override
	public Optional<SkillMaster> getSkillMasterById(Long skillId) {
		// TODO Auto-generated method stub
		String query = "select * from skillMaster where skillId = " + skillId;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			SkillMaster skillMaster = new SkillMaster();
			skillMaster.setSkillId(rs.getLong("skillId"));
			skillMaster.setSkill(rs.getString("skill"));
			skillMaster.setCategory(rs.getString("category"));
			skillMaster.setIsVisible(rs.getBoolean("isVisible"));
			return skillMaster;
		}).stream().findFirst();
	}

	@Override
	public Long addSkillMaster(SkillMaster skillMaster) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO skillMaster(skill, category, isVisible) VALUES( ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(connection ->{
			PreparedStatement ps = connection.prepareStatement(query ,new String[] { "skillId" });
	     	ps.setString(1, skillMaster.getSkill());
			ps.setString(2, skillMaster.getCategory());
			ps.setBoolean(3, skillMaster.getIsVisible());

	     return ps;
	   }, keyHolder);


	   return  keyHolder.getKey().longValue();
	}

	@Override
	public Integer deleteSkillMaster(Long skillId) {
		// TODO Auto-generated method stub
		String query = "delete from skillMaster where skillId = ?";
		return jdbcTemplate.update(query, skillId);
	}

	@Override
	public Integer updateSkillMaster(SkillMaster skillMaster, Long skillId) {
		// TODO Auto-generated method stub
        String query = "update skillMaster set  skill = ?, category = ?, isVisible= ?  where skillId = ?";
		
		return jdbcTemplate.update(query, 
				skillMaster.getSkill(),
				skillMaster.getCategory(),
				skillMaster.getIsVisible(),
			    skillId
				);
	}

}
