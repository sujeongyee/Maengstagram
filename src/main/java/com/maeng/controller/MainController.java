package com.maeng.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maeng.main.model.MainVO;
import com.maeng.main.service.MainService;
import com.maeng.main.service.MainServiceImpl;




@WebServlet("*.main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public MainController() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println(command);


		//---------------------------------------------------
		
		MainService service = new MainServiceImpl();
		
		if(command.equals("/main.main")) {
			System.out.println("메인이동");
			
			List<MainVO> list = service.getList(request, response);
			request.setAttribute("list", list);
			
			String user_id = request.getParameter("user_id");
			request.getRequestDispatcher("main.jsp?user_id="+ user_id).forward(request, response);
			
		} else {
			System.out.println("오류");
		}

	}
}
