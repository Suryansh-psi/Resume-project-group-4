package com.resume.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.model.Achievement;
import com.resume.repository.IAchievementRepository;

@Service
public class AchievementService implements IAchievementService{
	
	@Autowired
	private IAchievementRepository achievementRepository;

	@Override
	public List<Achievement> getAchievementByResumeId(Long resume_id) {
		// TODO Auto-generated method stub
		List<Achievement> achievement = achievementRepository.getAchievementByResumeId(resume_id);
		return achievement;
	}

	@Override
	public List<Long> saveAchievement(List<Achievement> achievement) {
		// TODO Auto-generated method stub
		List<Long> arr = new ArrayList<>();
		int size = achievement.size();
		for(int i=0; i<size; i++ ) {
			arr.add(achievementRepository.saveAchievement(achievement.get(i)));
		}
		return arr;
	}

	@Override
	public boolean deleteAchievement(Long achievementId) {
		// TODO Auto-generated method stub
		Integer result = achievementRepository.deleteAchievement(achievementId);
		return (result > 0);
	}

	@Override
	public Achievement updateAchievement(Achievement achievement, Long achievementId) {
		// TODO Auto-generated method stub
        Achievement achievementResponse = null;
		int result = achievementRepository.updateAchievement(achievement, achievementId);
	    if(result > 0) {
			achievementResponse = achievementRepository.getAchievementByAchievementId(achievementId).get(result - 1);
		}
		return achievementResponse;
	}

}
