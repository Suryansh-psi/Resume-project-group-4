package com.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.model.Resume;
import com.resume.model.RoleMaster;
import com.resume.repository.IRoleMasterRepository;
@Service
public class RoleMasterService implements IRoleMasterService{
	
	@Autowired
	private IRoleMasterRepository roleMasterRepository;

	@Override
	public List<RoleMaster> getAllRole() {
		// TODO Auto-generated method stub
		List<RoleMaster> roleMaster = roleMasterRepository.getRoleMaster();
		return roleMaster;
	}

	@Override
	public boolean saveRoleMaster(RoleMaster roleMaster) {
		// TODO Auto-generated method stub
		Integer result = roleMasterRepository.addRoleMaster(roleMaster);
		if(result != null && result > 0) {
			return true;
		}
		return false;
	}
	

	@Override
	public boolean deleteRoleMaster(Long role_id) {
		// TODO Auto-generated method stub
		Integer result = roleMasterRepository.deleteRoleMaster(role_id);
		return (result > 0);
	}

	@Override
	public RoleMaster updateRoleMaster(RoleMaster roleMaster, Long role_id) {
		// TODO Auto-generated method stub
		RoleMaster roleResponse = null;
		int result = roleMasterRepository.updateRoleMaster(roleMaster, role_id);
		if(result > 0) {
			roleResponse = roleMasterRepository.getRoleMasterById(role_id).get();
		}
		return roleResponse;
	}

}
