package com.resume.repository;

import java.util.List;
import java.util.Optional;
import com.resume.model.SkillMaster;

public interface ISkillMasterRepository {
	
    public List<SkillMaster> getSkillMaster();
	
	public Optional<SkillMaster> getSkillMasterById(Long skillId);
	
	public Long addSkillMaster(SkillMaster skillMaster);
	
    public Integer deleteSkillMaster(Long skillId);
	
	public Integer updateSkillMaster(SkillMaster skillMaster, Long skillId);

}
