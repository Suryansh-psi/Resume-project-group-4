package com.resume.model;

import java.util.Date;

public class Education {
	
	private Long educationId;
	private String educationName; 
	private String educationType; 
	private String educationLocation; 
	private Date startDate;
	private Date endDate;
	private int percentage;
	private Long resume_id;
	
	public Long getEducationId() {
		return educationId;
	}
	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}
	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	public String getEducationType() {
		return educationType;
	}
	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}
	public String getEducationLocation() {
		return educationLocation;
	}
	public void setEducationLocation(String educationLocation) {
		this.educationLocation = educationLocation;
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
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public Long getResume_id() {
		return resume_id;
	}
	public void setResume_id(Long resume_id) {
		this.resume_id = resume_id;
	}

	
}
