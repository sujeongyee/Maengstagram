package com.maeng.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.maeng.board.model.BoardVO;

import com.maeng.main.model.MainVO;
import com.maeng.user.model.UserVO;


public interface UserService {
	
	UserVO login(HttpServletRequest request , HttpServletResponse response);
	
	int checkId (HttpServletRequest request , HttpServletResponse response);	
	
	int join(HttpServletRequest request, HttpServletResponse response);
	
	int delete(HttpServletRequest request, HttpServletResponse response);
	
	int updateInfo(HttpServletRequest request, HttpServletResponse response);
	
	UserVO getInfo(HttpServletRequest request, HttpServletResponse response);
	
	List<BoardVO> getlist(HttpServletRequest request, HttpServletResponse response);
	
	UserVO getInfo2(HttpServletRequest request, HttpServletResponse response);
	
	List<BoardVO> getlist2(HttpServletRequest request, HttpServletResponse response);
	
}
