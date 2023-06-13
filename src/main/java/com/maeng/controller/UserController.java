package com.maeng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maeng.board.model.BoardVO;
import com.maeng.user.model.UserVO;
import com.maeng.user.service.UserService;
import com.maeng.user.service.UserServiceImpl;



@WebServlet("*.user")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public UserController() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();

		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println(command);

		UserService service = new UserServiceImpl();

		HttpSession session = request.getSession();

		if(command.equals("/user/user_login.user")) {

			request.getRequestDispatcher("user_login.jsp").forward(request, response);

		} else if (command.equals("/user/user_join.user")){

			request.getRequestDispatcher("user_join.jsp").forward(request, response);

		} else if (command.equals("/user/loginForm.user")) {

			UserVO vo = service.login(request, response);

			if(vo == null) { // 로그인 실패
				request.setAttribute("error", "로그인에 실패했습니다..");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
				
				
			}else { // 로그인 성공				
				session = request.getSession();
				session.setAttribute("vo", vo);
				session.setAttribute("user_id", vo.getId());
				
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");				
				out.println("alert('방가방가')");
				out.println("location.href = '../main.main';");
				out.println("</script>");
			}

		} else if (command.equals("/user/user_join.user")) {
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
		} else if (command.equals("/user/joinForm.user")) {

			int result = service.join(request, response);

			if(result == 1) { // 중복
				request.setAttribute("msg", "중복된 아이디 입니다");
				request.getRequestDispatcher("user_join.jsp").forward(request, response);
			} else { //가입성공

				response.sendRedirect("user_login.user");

			}

		} else if (command.equals("/user/user_logout.user")) {

			session.invalidate();
			response.sendRedirect("user_login.jsp");

		} else if (command.equals("/user/user_delete.user")) {

			UserVO vo = (UserVO)session.getAttribute("vo");
			session = request.getSession();
			session.setAttribute("vo", vo);

			int result = service.delete(request, response);

			if(result == 1) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");				
				out.println("alert('회원 탈퇴 성공')");
				out.println("location.href = '../main.main';");
				out.println("</script>");
				session.invalidate();
			}else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");				
				out.println("alert('회원 탈퇴 실패')");
				out.println("location.href = '/user/user_login.jsp';");
				out.println("</script>");

			}
			

		}else if(command.equals("/user/user_mypage.user")) {
				
			session = request.getSession();
			String user_id = (String) session.getAttribute("user_id");
			request.setAttribute("user_id", user_id);
			List<BoardVO> list = service.getlist(request, response);
			request.setAttribute("list", list);

			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);
			
		}
		
		
		else if (command.equals("/user/user_modify.user")) { // ㅈㅓㅇㅂㅗㅅㅜㅈㅓㅇ
			
			System.out.println("도착");
			UserVO vo = service.getInfo(request, response);
			request.setAttribute("vo", vo);

			request.getRequestDispatcher("user_modify.jsp").forward(request, response);

		}else if (command.equals("/user/user_update.user")) { // ㅈㅓㅇㅂㅗ
	
			int result = service.updateInfo(request,response);
			
			if(result == 0) { // 실패
				response.sendRedirect("user_modify.user");
				System.out.println("실패");
			}else { // 성공
				
				String name = request.getParameter("name");
				session.setAttribute("user_name", name);
				
				//out객체를 이용한 메시지 전달
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");				
				out.println("alert('안녕하세요')");
				out.println("location.href = 'user_mypage.user';");
				out.println("</script>");			
			}			
		} else if (command.equals("/user/user_search.user")) {
			
			request.getRequestDispatcher("user_search.jsp").forward(request, response);
			
		} else if (command.equals("/user/search.user")) {
			
			String id = request.getParameter("search_id");
			request.setAttribute("search_id", id);
			request.getRequestDispatcher("찬한님이 만드시는 게시판으로 아이디 보내기!").forward(request, response);
			
		} 
		
		
		
	}




}
