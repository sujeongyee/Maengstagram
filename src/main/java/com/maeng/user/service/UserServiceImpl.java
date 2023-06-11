package com.maeng.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maeng.user.model.UserDAO;
import com.maeng.user.model.UserVO;

public class UserServiceImpl implements UserService {

	
	@Override
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		UserDAO dao = UserDAO.getInstance();
		UserVO vo =dao.login(id,pw);


		return vo;
	}

	@Override
	public int checkId(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		UserDAO dao = UserDAO.getInstance();
		int result = dao.checkId(id);
		return result;
	}
	
	
	public int join(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String nick = request.getParameter("name");
		String pw = request.getParameter("pw");
		String photo = request.getParameter("photo");
		String intro = request.getParameter("intro");

		
		UserDAO dao =UserDAO.getInstance();
		int result = dao.checkId(id);

		System.out.println("결과 : "+result);

		if(result == 1) { // 중복
			return 1;
		}else { // 가입처리
			
			UserVO vo = new UserVO(id,nick,pw,photo,intro);
			dao.join(vo);

			return 0;			
		}

	}

	@Override
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("vo");
		String id = vo.getId();
		UserDAO dao = UserDAO.getInstance();
		System.out.println("userserviceImplㅇㅔㅅㅓㅇㅡㅣ "+id);
		int result = dao.delete(id);

	
		return result;
	}
	
	

}
