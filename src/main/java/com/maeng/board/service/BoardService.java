package com.maeng.board.service;

import com.maeng.board.model.BoardVO;
import com.maeng.user.model.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface BoardService {

    // 글 쓰기(등록)
    void write(HttpServletRequest request, HttpServletResponse response); // 등록

    // 게시글 화면
    BoardVO getContent(HttpServletRequest request, HttpServletResponse response);

    // 게시글 수정
    void update(HttpServletRequest request, HttpServletResponse response); // 업데이트

    // 게시글 목록 불러오기
    List<BoardVO> getlist(HttpServletRequest request, HttpServletResponse response);


    int join(HttpServletRequest request, HttpServletResponse response);

    UserVO login(HttpServletRequest request, HttpServletResponse response);

    void delete(HttpServletRequest request, HttpServletResponse response);
}
