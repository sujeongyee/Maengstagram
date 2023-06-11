package com.maeng.main.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maeng.main.model.MainDAO;
import com.maeng.main.model.MainVO;





public class MainServiceImpl implements MainService {

	@Override
	public List<MainVO> getList(HttpServletRequest request, HttpServletResponse response) {
		
		String user_id = request.getParameter("user_id");
		MainDAO dao = MainDAO.getInstance();
		List<MainVO> list = dao.getList(user_id);
		
		return list;
	}
	
}
