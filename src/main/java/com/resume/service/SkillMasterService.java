package com.resume.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.resume.model.SkillMaster;
import com.resume.repository.ISkillMasterRepository;

@Service
public class SkillMasterService implements ISkillMasterService{
	
	@Autowired
	private ISkillMasterRepository skillMasterRepository;

	@Override
	public List<SkillMaster> getAllSkills() {
		// TODO Auto-generated method stub
		List<SkillMaster> skillMaster = skillMasterRepository.getSkillMaster();
		return skillMaster;
	}

	@Override
	public Long saveSkills(SkillMaster skillMaster) {
		// TODO Auto-generated method stub
		Long result = skillMasterRepository.addSkillMaster(skillMaster);
		return result;
	}

	@Override
	public boolean deleteSkillMaster(Long skillId) {
		// TODO Auto-generated method stub
		Integer result = skillMasterRepository.deleteSkillMaster(skillId);
		return (result > 0);
	}

	@Override
	public SkillMaster updateSkillMaster(SkillMaster skillMaster, Long skillId) {
		// TODO Auto-generated method stub
		SkillMaster skillResponse = null;
		int result = skillMasterRepository.updateSkillMaster(skillMaster, skillId);
		if(result > 0) {
			skillResponse = skillMasterRepository.getSkillMasterById(skillId).get();
		}
		return skillResponse;
	}

}
