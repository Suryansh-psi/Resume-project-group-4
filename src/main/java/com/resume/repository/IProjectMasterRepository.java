package com.resume.repository;

import java.util.List;
import java.util.Optional;

import com.resume.model.ProjectMaster;
import com.resume.model.RoleMaster;

public interface IProjectMasterRepository {
	
	public List<ProjectMaster> getProjectMaster();
	
	public Optional<ProjectMaster> getProjectMasterById(Long project_id);
	
	public Long addProjectMaster(ProjectMaster projectMaster);
	
	public Integer updateProjectMaster(ProjectMaster projectMaster, Long project_id);
	
	public Integer deleteProjectMaster(Long project_id);

}
