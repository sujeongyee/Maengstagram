package com.maeng.main.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maeng.main.model.MainDAO;
import com.maeng.main.model.MainVO;


public class MainServiceImpl implements MainService {

	@Override
	public List<MainVO> getList(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		MainDAO dao = MainDAO.getInstance();
		List<MainVO> list = dao.getList(user_id);

		return list;
	}

	@Override //좋아요 
	public void likeUpdate(HttpServletRequest request, HttpServletResponse response) {

		String post_num = request.getParameter("post_num");
		HttpSession session = request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		MainDAO dao = MainDAO.getInstance();

		dao.likeUpdate(post_num, user_id);

		System.out.println(post_num + " "+user_id);
	}

	@Override
	public void like(HttpServletRequest request, HttpServletResponse response) {
		String post_num = request.getParameter("post_num");
		MainDAO dao = MainDAO.getInstance();
		dao.like(post_num);
		System.out.println(post_num);
		System.out.println("좋아요 수 증가");

	}

	
	@Override
	public int checkLike(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String user_id =(String) session.getAttribute("user_id");
		String post_num = request.getParameter("post_num");
		MainDAO dao = MainDAO.getInstance();
		int a =dao.checkLike(user_id, post_num); System.out.println(a);
		return a;
	}



}
