package com.maeng.controller;

import com.maeng.board.model.BoardDAO;
import com.maeng.board.model.BoardVO;
import com.maeng.board.service.BoardService;
import com.maeng.board.service.BoardServiceImpl;
import com.maeng.comment.model.CommentDAO;
import com.maeng.comment.model.CommentVO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.coyote.http11.filters.VoidOutputFilter;

import java.io.IOException;
import java.util.List;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long seriaVersionUID = 1L;

	public BoardController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println(command);

		// 게시글 서비스 선언
		BoardService service = new BoardServiceImpl();

		//글쓰기 화면에 대한 처리
		if (command.equals("/board/writeForm.board")) {

			service.write(request, response);

			// 포워드는 가져갈 데이터가 있을 때
			response.sendRedirect("../user/user_mypage.user");

			// 상세페이지 보기
		} else if (command.equals("/board/board_content.board")) {

			BoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo); // 그 게시물의 boardvo 포스트넘(number)
			HttpSession session = request.getSession();
			String user_id = (String)session.getAttribute("user_id");
			BoardDAO dao2 = BoardDAO.getInstance();

			int result = dao2.BoardCheckLike(user_id, vo.getNumber());
			if(result == 1 ) { // 중복인거
				session.setAttribute("ddu", "수정");
			}else {
				session.setAttribute("ddu", null);
			}




			CommentDAO dao = CommentDAO.getInstance();
			String post_num = request.getParameter("number");
			List<CommentVO> list = dao.getComment(post_num);
			session.setAttribute("c_list", list);
			request.getRequestDispatcher("board_content.jsp").forward(request, response);

			// 게시글 -> 게시글 수정
		} else if (command.equals("/board/board_modify.board")) {
			BoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("board_modify.jsp").forward(request, response);

			// 게시글 수정 -> 게시글
		} else if (command.equals("/board/board_update.board")) {
			service.update(request, response);
			String number = request.getParameter("number");

			// 게시글 페이지로 다시 이동
			response.sendRedirect("board_content.board?number=" + number);

			// 게시글 삭제
		} else if (command.equals("/board/likeUpdate.board")) {


			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("user_id");


			service.BoardLike(request, response);
			service.BoardLikeUpdate(request, response);
			request.getRequestDispatcher("/board/board_content.board").forward(request, response);


		}else if (command.equals("/board/likeDelete.board")) {

			service.BoardLikeDel(request, response);
			service.BoardLikeDelId(request, response);
			request.getRequestDispatcher("/board/board_content.board").forward(request, response);
		} 
		else if (command.equals("/board/board_delete.board")) {
			service.delLikes(request, response);
			service.delComments(request, response);
			service.delPost(request, response);
			response.sendRedirect("../user/user_mypage.user");}




	}

}
