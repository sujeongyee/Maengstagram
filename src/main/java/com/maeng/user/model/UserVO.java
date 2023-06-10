package com.maeng.user.model;

public class UserVO {
	
	
	private String id;
	private String nick;
	private String pw;
	private String photo;
	private String intro;
	
	
	UserVO(){}


	public UserVO(String id, String nick, String pw, String photo, String intro) {
		super();
		this.id = id;
		this.nick = nick;
		this.pw = pw;
		this.photo = photo;
		this.intro = intro;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getIntro() {
		return intro;
	}


	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
	
	

}
