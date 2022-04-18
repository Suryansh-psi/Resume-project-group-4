package com.resume.model;

public class Achievement {
	
	private Long achievementId;
	private String achievement_name;
	private String achievement_desc;
	private Long resume_id;
	public Long getAchievementId() {
		return achievementId;
	}
	public void setAchievementId(Long achievementId) {
		this.achievementId = achievementId;
	}
	public String getAchievement_name() {
		return achievement_name;
	}
	public void setAchievement_name(String achievement_name) {
		this.achievement_name = achievement_name;
	}
	public String getAchievement_desc() {
		return achievement_desc;
	}
	public void setAchievement_desc(String achievement_desc) {
		this.achievement_desc = achievement_desc;
	}
	public Long getResume_id() {
		return resume_id;
	}
	public void setResume_id(Long resume_id) {
		this.resume_id = resume_id;
	}
	
	

}
