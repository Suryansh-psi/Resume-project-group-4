package com.resume.repository;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.resume.model.Achievement;

@Repository
public class AchievementRepository implements IAchievementRepository{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Achievement> getAchievementByAchievementId(Long achievementId) {
		// TODO Auto-generated method stub
		String query = "select * from achievement where achievementId = " + achievementId;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			Achievement achievement = new Achievement();
			achievement.setAchievementId(rs.getLong("achievementId"));
			achievement.setAchievement_name(rs.getString("achievement_name"));
			achievement.setAchievement_desc(rs.getString("achievement_desc"));
			achievement.setResume_id(rs.getLong("resume_id"));
			return achievement;
		});
	}

	@Override
	public List<Achievement> getAchievementByResumeId(Long resume_id) {
		// TODO Auto-generated method stub
		String query = "select * from achievement where resume_id = " + resume_id;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			Achievement achievement = new Achievement();
			achievement.setAchievementId(rs.getLong("achievementId"));
			achievement.setAchievement_name(rs.getString("achievement_name"));
			achievement.setAchievement_desc(rs.getString("achievement_desc"));
			achievement.setResume_id(rs.getLong("resume_id"));
			return achievement;
		});
	}

	@Override
	public Long saveAchievement(Achievement achievement) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO achievement(achievement_name, achievement_desc, resume_id) VALUES(?, ? ,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		   jdbcTemplate.update(connection -> {
		       PreparedStatement ps = connection.prepareStatement(query ,new String[] { "achievementId" });
		         
		         	ps.setString(1, achievement.getAchievement_name());
		         	ps.setString(2, achievement.getAchievement_desc());
					ps.setLong(3, achievement.getResume_id());
					
		         return ps;
		       }, keyHolder);


		       return  keyHolder.getKey().longValue();
	}

	@Override
	public Integer deleteAchievement(Long achievementId) {
		// TODO Auto-generated method stub
		String query = "delete from achievement where achievementId = ?";
		return jdbcTemplate.update(query, achievementId);
	}

	@Override
	public Integer deleteAchievementByResumeId(Long resume_id) {
		// TODO Auto-generated method stub
		String query = "delete from achievement where resume_id = ?";
		return jdbcTemplate.update(query, resume_id);
	}

	@Override
	public Integer updateAchievement(Achievement achievement, Long achievementId) {
		// TODO Auto-generated method stub
		String query = "update achievement set achievement_name = ?, achievement_desc = ?  where achievementId = " + achievementId;
		return jdbcTemplate.update(query, achievement.getAchievement_name(),
				achievement.getAchievement_desc()
		
				);
	}


}
