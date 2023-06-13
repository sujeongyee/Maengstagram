package com.maeng.comment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maeng.comment.model.CommentDAO;
import com.maeng.comment.model.CommentVO;



public interface CommentService {
		
	public void registComment(HttpServletRequest request, HttpServletResponse response);

}
