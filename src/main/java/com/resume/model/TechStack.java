package com.resume.model;

public class TechStack {
	private Long techStackId;
	private String techStackName;
	private String techStackDesc; 
	private boolean isVisible;
	
	
	public Long getTechStackId() {
		return techStackId;
	}
	public void setTechStackId(Long techStackId) {
		this.techStackId = techStackId;
	}
	public String getTechStackName() {
		return techStackName;
	}
	public void setTechStackName(String techStackName) {
		this.techStackName = techStackName;
	}
	public String getTechStackDesc() {
		return techStackDesc;
	}
	public void setTechStackDesc(String techStackDesc) {
		this.techStackDesc = techStackDesc;
	}
	public boolean getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	

}
