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
import com.maeng.comment.model.CommentDAO;
import com.maeng.comment.service.CommentService;
import com.maeng.comment.service.CommentServiceImpl;
import com.maeng.following.model.FollowingDAO;
import com.maeng.following.service.FollowingService;
import com.maeng.following.service.FollowingServiceImpl;
import com.maeng.user.model.UserDAO;
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
		FollowingService f_service = new FollowingServiceImpl();
		UserService service = new UserServiceImpl();
		CommentService service2 = new CommentServiceImpl();
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
				out.println("alert('로그인 성공!')");
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
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");				
			out.println("alert('로그아웃 성공')");
			out.println("location.href = 'user_login.user';");
			out.println("</script>");

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
				out.println("location.href = 'user_login.jsp';");
				out.println("</script>");

			}


		}else if(command.equals("/user/user_mypage.user")) {

			session = request.getSession();
			String user_id = (String) session.getAttribute("user_id");
			
			request.setAttribute("user_id", user_id);
			List<BoardVO> list = service.getlist(request, response);
			request.setAttribute("list", list);
			FollowingDAO dao = FollowingDAO.getInstance();
			
			int followerCount = dao.countFollower(user_id);
	        int followingCount = dao.countFollowing(user_id);
	        session.setAttribute("followerCount", followerCount);
	        session.setAttribute("followingCount", followingCount);
	        
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);

		}

		else if (command.equals("/user/user_modify.user")) { // ㅈㅓㅇㅂㅗㅅㅜㅈㅓㅇ


			request.getRequestDispatcher("user_modify.jsp").forward(request, response);

		}else if (command.equals("/user/user_update.user")) { // ㅈㅓㅇㅂㅗ

			int result = service.updateInfo(request,response);
			UserVO vo = service.getInfo(request, response);
			if(result == 0) { // 실패
				response.sendRedirect("user_modify.user");
			}else { // 성공
				session.setAttribute("vo", vo);
				List<BoardVO> list = service.getlist(request, response);
				request.setAttribute("list", list);

				request.getRequestDispatcher("user_mypage.jsp").forward(request, response);

			}			
		} else if (command.equals("/user/user_search.user")) {

			request.getRequestDispatcher("user_search.jsp").forward(request, response);

		} else if (command.equals("/user/search.user")) {
			
			String id = request.getParameter("search_id");
			System.out.println("??????????????????????????" + id);
			session.setAttribute("search_id1", id);
			List<BoardVO> list = service.getlist2(request, response);
			UserDAO dao = UserDAO.getInstance();
			UserVO vo = dao.getInfo(id);
			if(vo==null) {
				String path = request.getContextPath() +"/user/user_search.jsp";
				response.setContentType("text/html; charset = UTF-8;");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('찾으시는 회원이 없습니다');");
				out.println("location.href = '"+path+"';");
				out.println("</script>");
				return;
			}
			session.setAttribute("ddu2", "");

			int followerFriendCount = f_service.countFriendFollower(request, response);
			int followingFriendCount = f_service.countFriendFollowing(request, response);
			
			System.out.println(followerFriendCount+"몇명인가요"+followingFriendCount);
			
			session.setAttribute("followerFriendCount", followerFriendCount);
			session.setAttribute("followingFriendCount", followingFriendCount);
			
			FollowingDAO daoF = FollowingDAO.getInstance();
			String id2 = (String) session.getAttribute("user_id");
			int result = daoF.checkFollow(id2, id); // user_id가 search_id를 팔로우하고있는지
			if (result == 1) {
				session.setAttribute("check", "중복"); // 중복이면 체크에 값이 생김
				System.out.println("이미 팔로우중");
			} else {
				session.setAttribute("check", null); // 팔로우 하고 있지 않으면 null값
				System.out.println("팔로우 중이지 않아요");
			}
			

			request.setAttribute("search_list",list);
			request.setAttribute("search_info", vo);


			request.getRequestDispatcher("search_page.jsp").forward(request, response);

		} else if (command.equals("/user/deleteComment.user")) {

			service2.deleteComment(request, response);

			request.getRequestDispatcher("/board/board_content.board").forward(request, response);

		}else if (command.equals("/user/user_search_followUpdate.user")) {

			String id = (String)session.getAttribute("user_id");
        	String id2 = request.getParameter("search_id");
        	FollowingDAO dao = FollowingDAO.getInstance();
        	dao.followPlus(id, id2);
        	request.getRequestDispatcher("search.user").forward(request, response);

        }else if(command.equals("/user/user_search_followDelete.user")){
        	
        	String id = (String)session.getAttribute("user_id");
        	String id2 = request.getParameter("search_id");
        	FollowingDAO dao = FollowingDAO.getInstance();
        	dao.followDelete(id, id2);
        	request.getRequestDispatcher("search.user").forward(request, response);
        }



	}




}
