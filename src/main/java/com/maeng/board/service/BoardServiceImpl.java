package com.maeng.board.service;

import com.maeng.board.model.BoardDAO;
import com.maeng.board.model.BoardVO;
import com.maeng.main.model.MainDAO;
import com.maeng.user.model.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BoardServiceImpl implements BoardService{


	// 글쓰기
	@Override
	public void write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		String content = request.getParameter("content");
		String img = request.getParameter("img");

		BoardDAO dao = BoardDAO.getInstance();
		dao.write(id, content, img);
	}

	// 게시글 화면
	@Override
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response) {

		String number = request.getParameter("number");

		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(number);

		return vo;
	}

	// 게시글 수정
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		String content = request.getParameter("content");
		String img = request.getParameter("img");

		BoardDAO dao = BoardDAO.getInstance();
		dao.update(number, content, img);

	}

	// 게시글 목록 불러오기
	@Override
	public List<BoardVO> getlist(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");

		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> list = dao.getList(id);

		return list;
	}

	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		return 0;
	}

	@Override
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");

		BoardDAO dao = BoardDAO.getInstance();
		dao.delete(number);
	}

	@Override //좋아요  아이디추가
	public void BoardLikeUpdate(HttpServletRequest request, HttpServletResponse response) {

		String number = request.getParameter("number");
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("user_id");
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardLikeUpdate(number, id);

	}

	@Override  //좋아요 수올리기
	public void BoardLike(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardLike(number);


	}


	@Override// 좋아요중복체크
	public int BoardCheckLike(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String number = request.getParameter("number");
		BoardDAO dao = BoardDAO.getInstance();

		int a =dao.BoardCheckLike(id, number); 
		return a;
	}

	// 좋아요 아이디삭제 메서드실행
	@Override
	public void BoardLikeDelId(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardLikeDelId(number, id);



	}

	//좋아요 -1 메서드
	@Override
	public void BoardLikeDel(HttpServletRequest request, HttpServletResponse response) {
		String number= request.getParameter("number");
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardLikeDel(number);



	}

}
