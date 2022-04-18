package com.resume.service;

import java.util.List;

import com.resume.model.Membership;

public interface IMembershipService {
    public List<Membership> getMembershipByResumeId(Long resume_id);
	
	public List<Long> saveMembership(List<Membership> membership);
	
	public boolean deleteMembership(Long membershipId);
	
	public Membership updateMembership(Membership membership, Long membershipId);

}
