package com.resume.model;

import java.util.Date;
import java.util.List;

public class Resume {
	
	private Long resumeId;
	private String name;
	private List<String> role;
	private int total_exp;
	private byte[] image;
	private String about_me;
	private List<String> about_me_points;
	private List<String> skills;
	private Date created_at;
	private Date updated_at;
	private String status;
	private String reviewer;
	private List<String> achievement;
	private List<String> certificate;
	private List<String> training;
	private List<String> membership;
	private int share;
	private String comment;
	private int managerId;
	private Long userId;
	private List<WorkExp> workExps;
	private List<Education> educations;
	
	public List<Education> getEducations() {
		return educations;
	}
	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
	public List<WorkExp> getWorkExps() {
		return workExps;
	}
	public void setWorkExps(List<WorkExp> workExps) {
		this.workExps = workExps;
	}
	public Long getResumeId() {
		return resumeId;
	}
	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> role) {
		this.role = role;
	}
	public int getTotal_exp() {
		return total_exp;
	}
	public void setTotal_exp(int total_exp) {
		this.total_exp = total_exp;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getAbout_me() {
		return about_me;
	}
	public void setAbout_me(String about_me) {
		this.about_me = about_me;
	}
	public List<String> getAbout_me_points() {
		return about_me_points;
	}
	public void setAbout_me_points(List<String> about_me_points) {
		this.about_me_points = about_me_points;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<String> getAchievement() {
		return achievement;
	}
	public void setAchievement(List<String> achievement) {
		this.achievement = achievement;
	}
	public List<String> getCertificate() {
		return certificate;
	}
	public void setCertificate(List<String> certificate) {
		this.certificate = certificate;
	}
	public List<String> getTraining() {
		return training;
	}
	public void setTraining(List<String> training) {
		this.training = training;
	}
	public List<String> getMembership() {
		return membership;
	}
	public void setMembership(List<String> membership) {
		this.membership = membership;
	}
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	

}
