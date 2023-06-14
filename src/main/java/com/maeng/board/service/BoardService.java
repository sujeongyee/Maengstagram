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

    
    
    
 // (메인화면의 좋아요 누를시 like테이블에 id추가)
 	void BoardLikeUpdate(HttpServletRequest request, HttpServletResponse response); 

 	//(메인화면에 좋아요 누를시 post테이블 like 횟수 증가)
 	void BoardLike(HttpServletRequest request, HttpServletResponse response);

 	//좋아요 중복체크
 	int BoardCheckLike(HttpServletRequest request, HttpServletResponse response);
 	
    

	// 좋아요 한번 더를시 id 삭제
	void BoardLikeDelId(HttpServletRequest request, HttpServletResponse response); 

	// 좋아요 -1 
	void BoardLikeDel(HttpServletRequest request, HttpServletResponse response);
	
	
//  1 . like 지우기
	void delLikes(HttpServletRequest request, HttpServletResponse response);
	//  2. 댓글지우기
	void delComments(HttpServletRequest request, HttpServletResponse response);
	//  3. 게시글지우기
	void delPost(HttpServletRequest request, HttpServletResponse response);
	
 	
}
