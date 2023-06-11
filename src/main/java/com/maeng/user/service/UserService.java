package com.maeng.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maeng.user.model.UserVO;


public interface UserService {
	
	UserVO login(HttpServletRequest request , HttpServletResponse response);
	
	int checkId (HttpServletRequest request , HttpServletResponse response);	
	
	int join(HttpServletRequest request, HttpServletResponse response);
	
	int delete(HttpServletRequest request, HttpServletResponse response);
	
	int updateInfo(HttpServletRequest request, HttpServletResponse response);
	
	UserVO getInfo(HttpServletRequest request, HttpServletResponse response);
}
