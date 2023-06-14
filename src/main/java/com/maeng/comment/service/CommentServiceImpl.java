package com.maeng.comment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maeng.comment.model.CommentDAO;
import com.maeng.comment.model.CommentVO;

public class CommentServiceImpl implements CommentService {

	@Override
	public void registComment(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		String post_num = request.getParameter("number");
		String com_content = request.getParameter("comment");

		CommentDAO dao = CommentDAO.getInstance();
		dao.registComment(post_num, user_id, com_content);
		
	}

	@Override
	public int deleteComment(HttpServletRequest request, HttpServletResponse response) {
		int com_num = Integer.parseInt(request.getParameter("com_num"));
		CommentDAO dao = CommentDAO.getInstance();
		int result = dao.deleteComment(com_num);
		
		
		return result;
	}


}
