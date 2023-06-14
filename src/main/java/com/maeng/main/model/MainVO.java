package com.maeng.main.model;

import java.sql.Timestamp;

public class MainVO {


	private String user_photo;
	private String fol_id;
	private String post_img;
	private String content;
	private int post_like; 
	private Timestamp post_time;
	private String number;
	
	public MainVO() {
	}

	public MainVO(String user_photo, String fol_id, String post_img, String content, int post_like, Timestamp post_time,
			String number) {
		super();
		this.user_photo = user_photo;
		this.fol_id = fol_id;
		this.post_img = post_img;
		this.content = content;
		this.post_like = post_like;
		this.post_time = post_time;
		this.number = number;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	

	
	
}