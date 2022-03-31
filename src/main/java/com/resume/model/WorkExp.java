package com.resume.model;

import java.util.Date;
import java.util.List;

public class WorkExp {
	
	private Long workExpId;
	private String clientDesc;
	private String country;
	private String projectName;
	private List<String> role;
	private Date startDate;
	private Date endDate;
	private String bussinessSol;
	private List<String> techStack;
	private List<String> projectResp;
	private Long resumeId;
	
	public Long getWorkExpId() {
		return workExpId;
	}
	public void setWorkExpId(Long workExpId) {
		this.workExpId = workExpId;
	}
	public String getClientDesc() {
		return clientDesc;
	}
	public void setClientDesc(String clientDesc) {
		this.clientDesc = clientDesc;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> role) {
		this.role = role;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getBussinessSol() {
		return bussinessSol;
	}
	public void setBussinessSol(String bussinessSol) {
		this.bussinessSol = bussinessSol;
	}
	public List<String> getTechStack() {
		return techStack;
	}
	public void setTechStack(List<String> techStack) {
		this.techStack = techStack;
	}
	public List<String> getProjectResp() {
		return projectResp;
	}
	public void setProjectResp(List<String> projectResp) {
		this.projectResp = projectResp;
	}
	public Long getResumeId() {
		return resumeId;
	}
	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}
	
	
	
	

}
