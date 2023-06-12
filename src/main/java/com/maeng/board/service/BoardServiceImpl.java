package com.maeng.board.service;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maeng.board.model.BoardDAO;
import com.maeng.board.model.BoardVO;

import java.util.List;

public class BoardServiceImpl implements BoardService{


    // 글쓰기
    @Override
    public void write(HttpServletRequest request, HttpServletResponse response) {
        String content = request.getParameter("content");
        String img = request.getParameter("img");

        BoardDAO dao = BoardDAO.getInstance();
        dao.write(content, img);
    }

    // 게시글 화면
    @Override
    public BoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
        return null;
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

        BoardDAO dao = BoardDAO.getInstance();
        List<BoardVO> list = dao.getList();

        return list;
    }
}
