package com.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.model.ProjectMaster;
import com.resume.repository.IProjectMasterRepository;

@Service
public class ProjectMasterService implements IProjectMasterService{
	
	@Autowired
	private IProjectMasterRepository projectMasterRepository;
	

	@Override
	public List<ProjectMaster> getAllProject() {
		// TODO Auto-generated method stub
		List<ProjectMaster> projectMaster = projectMasterRepository.getProjectMaster();
		return projectMaster;
	}

	@Override
	public Long saveProjectMaster(ProjectMaster projectMaster) {
		// TODO Auto-generated method stub
		Long result = projectMasterRepository.addProjectMaster(projectMaster);
		return result;
	}

	@Override
	public ProjectMaster updateProjectMaster(ProjectMaster projectMaster, Long project_id) {
		// TODO Auto-generated method stub
		ProjectMaster projectResponse = null;
		int result = projectMasterRepository.updateProjectMaster(projectMaster, project_id);
		if(result > 0) {
			projectResponse = projectMasterRepository.getProjectMasterById(project_id).get();
		}
		return projectResponse;
	}

	@Override
	public boolean deleteProjectMaster(Long project_id) {
		// TODO Auto-generated method stub
		Integer result = projectMasterRepository.deleteProjectMaster(project_id);
		return (result > 0);
	}
}


