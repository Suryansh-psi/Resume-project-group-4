package com.resume.repository;

import java.util.List;

import com.resume.model.Achievement;

public interface IAchievementRepository {
	
	 public List<Achievement> getAchievementByAchievementId(Long achievementId);
		
		public List<Achievement> getAchievementByResumeId(Long resume_id);

		public Long saveAchievement(Achievement achievement);
		
		public Integer deleteAchievement(Long achievementId);
		
		public Integer deleteAchievementByResumeId(Long resume_id);
		
		public Integer updateAchievement(Achievement achievement, Long achievementId);


}
