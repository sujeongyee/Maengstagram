package com.maeng.controller;



import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.maeng.board.model.BoardVO;
import com.maeng.board.service.BoardService;
import com.maeng.board.service.BoardServiceImpl;

import java.io.IOException;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

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
        if (command.equals("/board/board_write.board")) {
            request.getRequestDispatcher("board_write.jsp").forward(request, response);

            // 게시글 등록
        } else if (command.equals("/board/writeForm.board")) {

            // 컨트롤러에서 서비스로
            service.write(request, response);
            // 포워드는 가져갈 데이터가 있을 때
            //request.getRequestDispatcher("board_list.jsp").forward(request, response);
            response.sendRedirect("user_mypage.board");

            // 상세페이지 보기
        } else if (command.equals("/board/board_content.board")) {

            BoardVO vo = service.getContent(request, response);
            request.setAttribute("vo", vo);
            request.getRequestDispatcher("board_content.jsp").forward(request, response);

            // 게시글 -> 게시글 수정
        } else if (command.equals("/board/board_modify.board")) {
            // getcontent 기능은 bno를 필요로함
            BoardVO vo = service.getContent(request, response);
            request.setAttribute("vo", vo);
            request.getRequestDispatcher("board_modify.jsp").forward(request, response);

            // 게시글 수정 -> 게시글
        } else if (command.equals("board_update.board")) {
            service.update(request, response);
            String number = request.getParameter("number");

            // 게시글 페이지로 다시 이동
            response.sendRedirect("board_content.board?bno=" + number);
            
        }
    }
}