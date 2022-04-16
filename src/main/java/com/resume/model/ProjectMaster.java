package com.resume.model;

public class ProjectMaster {
	private Long project_id;
	private String project_name;
	private String project_desc;
	private Boolean isVisible;
	public Long getProject_id() {
		return project_id;
	}
	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_desc() {
		return project_desc;
	}
	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}
	public Boolean getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
	@Override
	public String toString() {
		return "ProjectMaster [project_id=" + project_id + ", project_name=" + project_name + ", project_desc="
				+ project_desc + ", isVisible=" + isVisible + ", getProject_id()=" + getProject_id()
				+ ", getProject_name()=" + getProject_name() + ", getProject_desc()=" + getProject_desc()
				+ ", getIsVisible()=" + getIsVisible() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
