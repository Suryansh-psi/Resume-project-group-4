package com.resume.model;

import java.util.Date;

public class Membership {
	private Long membershipId;
	private Long membership_no;
	private String membership_type;
	private Date membership_since;
	private Date expiry_date;
	private Long resume_id;
	public Long getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}
	public Long getMembership_no() {
		return membership_no;
	}
	public void setMembership_no(Long membership_no) {
		this.membership_no = membership_no;
	}
	public String getMembership_type() {
		return membership_type;
	}
	public void setMembership_type(String membership_type) {
		this.membership_type = membership_type;
	}
	public Date getMembership_since() {
		return membership_since;
	}
	public void setMembership_since(Date membership_since) {
		this.membership_since = membership_since;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public Long getResume_id() {
		return resume_id;
	}
	public void setResume_id(Long resume_id) {
		this.resume_id = resume_id;
	}
	

}
