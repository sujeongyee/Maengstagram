package com.maeng.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// 본인글만 수정

@WebFilter({"/board/board_modify.board",// 글 작성페이지
    		"/board/board_update.board",
    		"/board/board_delete.board"// 글 수정 and삭제기능
			})

public class BoardAuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		

		//작성자 구하기
	
		//세션에 저장된 작성자구함
		
		
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		String post_id = request.getParameter("id");
		System.out.println(user_id+ " ," + post_id);
		
		if(post_id ==null || user_id==null) {
	         
	         
	         res.setContentType("text/html;charset=UTF-8;");
	         PrintWriter out= res.getWriter();
	         out.println("<script>");
	         out.println("alert('허용되지 않는 접근입니다')");
	         out.println("history.go(-1);");
	         out.println("</script>");
	         return;
	      }
		
		
	      // 작성자와 세션이 같지 않은경우
	      if(!post_id.equals(user_id)) {

	         res.setContentType("text/html;charset=UTF-8;");
	         PrintWriter out= res.getWriter();
	         out.println("<script>");
	         out.println("alert('수정권한이 없습니다')");
	         out.println("history.go(-1);");
	         out.println("</script>");
	         return;
	      }
			
		
		chain.doFilter(request, response);
	}

	
	
}
