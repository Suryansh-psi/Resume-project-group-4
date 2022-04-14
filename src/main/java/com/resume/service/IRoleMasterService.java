package com.resume.service;

import java.util.List;

import com.resume.model.Resume;
import com.resume.model.RoleMaster;

public interface IRoleMasterService {
	public List<RoleMaster> getAllRole();
	
    public boolean saveRoleMaster(RoleMaster roleMaster);
	
	public boolean deleteRoleMaster(Long role_id);
	
	public RoleMaster updateRoleMaster(RoleMaster roleMaster, Long role_id);

}
