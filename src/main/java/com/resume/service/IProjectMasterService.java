package com.resume.service;

import java.util.List;
import com.resume.model.ProjectMaster;

public interface IProjectMasterService {
	
	public List<ProjectMaster> getAllProject();
	
	public Long saveProjectMaster(ProjectMaster projectMaster);
	
	public ProjectMaster updateProjectMaster(ProjectMaster projectMaster, Long project_id);
	
	public boolean deleteProjectMaster(Long project_id);


}
