package com.maeng.main.model;

import java.sql.Timestamp;

public class MainVO {


	private String user_photo;
	private String fol_id;
	private String post_img;
	private String post_title;
	private int post_like; 
	private Timestamp post_time;
	
	public MainVO() {
		// TODO Auto-generated constructor stub
	}

	public MainVO(String user_photo, String fol_id, String post_img, String post_title, int post_like,
			Timestamp post_time) {
		
		super();
		this.user_photo = user_photo;
		this.fol_id = fol_id;
		this.post_img = post_img;
		this.post_title = post_title;
		this.post_like = post_like;
		this.post_time = post_time;
	}

	
	public String getUser_photo() {
		return user_photo;
	}

	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}

	public String getFol_id() {
		return fol_id;
	}

	public void setFol_id(String fol_id) {
		this.fol_id = fol_id;
	}

	public String getPost_img() {
		return post_img;
	}

	public void setPost_img(String post_img) {
		this.post_img = post_img;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public int getPost_like() {
		return post_like;
	}

	public void setPost_like(int post_like) {
		this.post_like = post_like;
	}

	public Timestamp getPost_time() {
		return post_time;
	}

	public void setPost_time(Timestamp post_time) {
		this.post_time = post_time;
	}
	
	
	
}
