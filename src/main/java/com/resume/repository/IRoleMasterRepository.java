package com.resume.repository;


import java.util.List;
import java.util.Optional;

import com.resume.model.RoleMaster;

public interface IRoleMasterRepository {
	public List<RoleMaster> getRoleMaster();
	
	public Optional<RoleMaster> getRoleMasterById(Long role_id);
	public Integer addRoleMaster(RoleMaster roleMaster);
	
	public Integer deleteRoleMaster(Long role_id);
	
	public Integer updateRoleMaster(RoleMaster roleMaster, Long role_id);

}
