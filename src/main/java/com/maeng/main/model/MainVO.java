package com.maeng.main.model;

import java.sql.Timestamp;

public class MainVO {


	private String user_photo;
	private String fol_id;
	private String post_img;
	private String post_content;
	private int post_like; 
	private Timestamp post_time;
	private String post_num;
	
	public MainVO() {
		// TODO Auto-generated constructor stub
	}

	public MainVO(String user_photo, String fol_id, String post_img, String post_content, int post_like,
			Timestamp post_time, String post_num) {
		super();
		this.user_photo = user_photo;
		this.fol_id = fol_id;
		this.post_img = post_img;
		this.post_content = post_content;
		this.post_like = post_like;
		this.post_time = post_time;
		this.post_num = post_num;
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

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
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

	public String getPost_num() {
		return post_num;
	}

	public void setPost_num(String post_num) {
		this.post_num = post_num;
	}

	

	
	
}
