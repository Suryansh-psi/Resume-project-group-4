package com.resume.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.model.Membership;
import com.resume.repository.IMembershipRepository;

@Service
public class MembershipService implements IMembershipService{
	
	@Autowired
	private IMembershipRepository membershipRepository;

	@Override
	public List<Membership> getMembershipByResumeId(Long resume_id) {
		// TODO Auto-generated method stub
		List<Membership> membership = membershipRepository.getMembershipByResumeId(resume_id);
		return membership;
	}

	@Override
	public List<Long> saveMembership(List<Membership> membership) {
		// TODO Auto-generated method stub
		List<Long> arr = new ArrayList<>();
		int size = membership.size();
		for(int i=0; i<size; i++ ) {
			arr.add(membershipRepository.saveMembership(membership.get(i)));
		}
		return arr;
	}

	@Override
	public boolean deleteMembership(Long membershipId) {
		// TODO Auto-generated method stub
		Integer result = membershipRepository.deleteMembership(membershipId);
		return (result > 0);
	}

	@Override
    public Membership updateMembership(Membership membership, Long membershipId) {
		// TODO Auto-generated method stub
		Membership membershipResponse = null;
		int result = membershipRepository.updateMembership(membership, membershipId);
	    if(result > 0) {
			membershipResponse = membershipRepository.getMembershipByMembershipId(membershipId).get(result - 1);
		}
		return membershipResponse;
	}

}
