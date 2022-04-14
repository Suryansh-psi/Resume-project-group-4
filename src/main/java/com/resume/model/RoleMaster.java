package com.resume.model;

public class RoleMaster {
	private Long role_id;
	private String role_name;
	private String role_desc;
	private boolean isVisible;
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	@Override
	public String toString() {
		return "RoleMaster [role_id=" + role_id + ", role_name=" + role_name + ", role_desc=" + role_desc
				+ ", isVisible=" + isVisible + ", getRole_id()=" + getRole_id() + ", getRole_name()=" + getRole_name()
				+ ", getRole_desc()=" + getRole_desc() + ", isVisible()=" + getIsVisible() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public boolean getIsVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	

}
