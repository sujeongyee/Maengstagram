package com.maeng.following.model;

public class FollowingVO {
	
	private String user_id;
	private String fol_id;
	
	FollowingVO(){}

	public FollowingVO(String user_id, String fol_id) {
		super();
		this.user_id = user_id;
		this.fol_id = fol_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFol_id() {
		return fol_id;
	}

	public void setFol_id(String fol_id) {
		this.fol_id = fol_id;
	}
	
	

}
