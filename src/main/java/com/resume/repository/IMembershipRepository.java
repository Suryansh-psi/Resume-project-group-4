package com.resume.repository;

import java.util.List;

import com.resume.model.Membership;

public interface IMembershipRepository {
	
    public List<Membership> getMembershipByMembershipId(Long membershipId);
	
	public List<Membership> getMembershipByResumeId(Long resume_id);

	public Long saveMembership(Membership membership);
	
	public Integer deleteMembership(Long membershipId);
	
	public Integer deleteMembershipByResumeId(Long resume_id);
	
	public Integer updateMembership(Membership membership, Long membershipId);

}
