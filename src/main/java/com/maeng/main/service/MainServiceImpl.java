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
		String id = (String)session.getAttribute("id");
		MainDAO dao = MainDAO.getInstance();
		List<MainVO> list = dao.getList(id);

		return list;
	}

	@Override //좋아요 
	public void likeUpdate(HttpServletRequest request, HttpServletResponse response) {

		String number = request.getParameter("number");
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		MainDAO dao = MainDAO.getInstance();

		dao.likeUpdate(number, id);

	
	}

	@Override
	public void like(HttpServletRequest request, HttpServletResponse response) {
		String number= request.getParameter("number");
		MainDAO dao = MainDAO.getInstance();
		dao.like(number);



	}

	
	@Override
	public int checkLike(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id =(String) session.getAttribute("user_id");
		String number = request.getParameter("number");
		MainDAO dao = MainDAO.getInstance();
		int a =dao.checkLike(id, number); 
		return a;
	}
	
	@Override
	public void likeDelId(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		MainDAO dao = MainDAO.getInstance();
		dao.likeDelId(number, id);

		
		
		
	}
	
	//좋아요 -1 메서드
	@Override
	public void likeDel(HttpServletRequest request, HttpServletResponse response) {
		String number= request.getParameter("number");
		MainDAO dao = MainDAO.getInstance();
		dao.likeDel(number);


		
	}


}
