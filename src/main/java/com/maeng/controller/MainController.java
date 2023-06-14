package com.maeng.controller;

import java.io.IOException;

import java.io.PrintWriter;

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
		HttpSession session = request.getSession();
		System.out.println(command);
		//---------------------------------------------------

		MainService service = new MainServiceImpl();
		CommentService service2 = new CommentServiceImpl();

		if(command.equals("/main.main")) {

			UserVO vo = (UserVO)session.getAttribute("vo");
			String id = vo.getId();
			session.setAttribute("id", id);
			List<MainVO> list = service.getList(request, response);
			CommentDAO dao = CommentDAO.getInstance();
			List<List<CommentVO>> list2 = new ArrayList<>(); 
			for(MainVO vo2 :list) {				
				List<CommentVO> voo = dao.getComment(vo2.getNumber());
				list2.add(voo);
			}
			request.setAttribute("list2", list2);
			request.setAttribute("list", list);



			request.getRequestDispatcher("main.jsp").forward(request, response);

		} else if(command.equals("/regist_comment.main")){


			service2.registComment(request, response);
			request.getRequestDispatcher("/main.main").forward(request, response);


			// 좋아요 업데이트	
		}  else if (command.equals("/likeUpdate.main")) {
			int result = service.checkLike(request, response);

			//중복검사
			if(result == 0) {


				service.like(request, response);
				service.likeUpdate(request, response);
				request.setAttribute("msg","❤");	
				request.getRequestDispatcher("/main.main").forward(request, response);


			} else{


				service.likeDel(request, response);
				service.likeDelId(request, response);

				request.setAttribute("msg","🤍");	
				request.getRequestDispatcher("/main.main").forward(request, response);


			}
		}else if(command.equals("/board/regist_comment.main")){


			String post_num = request.getParameter("post_num");
			service2.registComment(request, response);
			request.getRequestDispatcher("/board/board_content.board?post_num="+post_num).forward(request, response);

		}  



	}

}


