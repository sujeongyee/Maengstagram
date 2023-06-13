package com.maeng.comment.model;

import java.sql.Timestamp;

public class CommentVO {
	
	private int com_num;
	private String post_num;
	private String user_id;
	private String com_content;
	private Timestamp com_time;
	
	public CommentVO() {}

	public CommentVO(int com_num, String post_num, String user_id, String com_content, Timestamp com_time) {
		super();
		this.com_num = com_num;
		this.post_num = post_num;
		this.user_id = user_id;
		this.com_content = com_content;
		this.com_time = com_time;
	}

	public int getCom_num() {
		return com_num;
	}

	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}

	public String getPost_num() {
		return post_num;
	}

	public void setPost_num(String post_num) {
		this.post_num = post_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCom_content() {
		return com_content;
	}

	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}

	public Timestamp getCom_time() {
		return com_time;
	}

	public void setCom_time(Timestamp com_time) {
		this.com_time = com_time;
	}
	
	
	
	
	
}
