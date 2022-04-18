package com.resume.service;

import java.util.List;

import com.resume.model.Achievement;

public interface IAchievementService {
    public List<Achievement> getAchievementByResumeId(Long resume_id);
	
	public List<Long> saveAchievement(List<Achievement> achievement);
	
	public boolean deleteAchievement(Long achievementId);
	
	public Achievement updateAchievement(Achievement achievement, Long achievementId);

}
