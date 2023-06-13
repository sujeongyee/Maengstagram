package com.maeng.main.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maeng.main.model.MainVO;



public interface MainService {

	List<MainVO> getList(HttpServletRequest request , HttpServletResponse response);

	// (메인화면의 좋아요 누를시 like테이블에 id추가)
	void likeUpdate(HttpServletRequest request, HttpServletResponse response); 

	//(메인화면에 좋아요 누를시 post테이블 like 횟수 증가)
	void like(HttpServletRequest request, HttpServletResponse response);

	
	int checkLike(HttpServletRequest request, HttpServletResponse response);
	


}
