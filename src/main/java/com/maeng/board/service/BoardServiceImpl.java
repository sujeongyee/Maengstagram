package com.maeng.board.service;

import com.maeng.board.model.BoardDAO;
import com.maeng.board.model.BoardVO;
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

        System.out.println(request.getAttribute("user_id"));
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("user_id");

        BoardDAO dao = BoardDAO.getInstance();
        List<BoardVO> list = dao.getList(id);
        System.out.println(id);
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

        System.out.println(number);
        BoardDAO dao = BoardDAO.getInstance();
        dao.delete(number);
    }
}
