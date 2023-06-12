package com.maeng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maeng.comment.model.CommentDAO;
import com.maeng.comment.model.CommentVO;
import com.maeng.comment.service.CommentService;
import com.maeng.comment.service.CommentServiceImpl;
import com.maeng.main.model.MainVO;
import com.maeng.main.service.MainService;
import com.maeng.main.service.MainServiceImpl;
import com.maeng.user.model.UserVO;




@WebServlet("*.main")
public class MainController extends HttpServlet {

	public MainController() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println(command);
		HttpSession session = request.getSession();

		//---------------------------------------------------

		MainService service = new MainServiceImpl();
		CommentService service2 = new CommentServiceImpl();

		if(command.equals("/main.main")) {
			System.out.println("메인이동");
			UserVO vo = (UserVO)session.getAttribute("vo");
			String user_id = vo.getId();
			session.setAttribute("user_id", user_id);
			List<MainVO> list = service.getList(request, response);
			CommentDAO dao = CommentDAO.getInstance();
			List<List<CommentVO>> list2 = new ArrayList<>(); 
			for(MainVO vo2 :list) {				
				List<CommentVO> voo = dao.getComment(vo2.getPost_num());
				list2.add(voo);
			}
			request.setAttribute("list2", list2);
			request.setAttribute("list", list);



			request.getRequestDispatcher("main.jsp").forward(request, response);

		} else if(command.equals("/regist_comment.main")){

			System.out.println("도착@");
			service2.registComment(request, response);
			request.getRequestDispatcher("/main.main").forward(request, response);

		}   else if (command.equals("/likeUpdate.main")) {

			System.out.println("들어와랏");
			String user_id = (String)session.getAttribute("user_id");


			System.out.println(request.getParameter("post_num"));
			System.out.println(user_id);

			service.like(request, response);
			service.likeUpdate(request, response);
			request.setAttribute("msg","좋아용!👄");   

			request.getRequestDispatcher("/main.main").forward(request, response);

		}else if(command.equals("/regist_comment.main")){

			System.out.println("도착@");
			service2.registComment(request, response);
			request.getRequestDispatcher("/main.main").forward(request, response);

		}



}


}
