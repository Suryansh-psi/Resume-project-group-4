package com.resume.service;

import java.util.List;

import com.resume.model.SkillMaster;


public interface ISkillMasterService {
    public List<SkillMaster> getAllSkills();
	
    public Long saveSkills(SkillMaster skillMaster);
    
    public boolean deleteSkillMaster(Long skillId);
	
	public SkillMaster updateSkillMaster(SkillMaster skillMaster, Long skillId);

	

}
