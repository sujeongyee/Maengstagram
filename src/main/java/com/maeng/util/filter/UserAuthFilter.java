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



@WebFilter(urlPatterns = {"/user/user_mypage.user",
						  "/user/user_modify.user",
						  "/user/user_update.user",
						  "/board/writeForm.board",
						  "/main.main",
						  "/regist_comment.main",
						  "/board/regist_comment.main",
						  "/user/search.user"
})
public class UserAuthFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res =(HttpServletResponse)response;
		HttpSession session=req.getSession();
		String user_id=(String)session.getAttribute("user_id");

		if(user_id==null) {
			String path = req.getContextPath() +"/user/user_login.jsp";
			res.setContentType("text/html; charset = UTF-8;");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다');");
			out.println("location.href = '"+path+"';");
			out.println("</script>");
			return;
		}
		chain.doFilter(request, response);

	}



}
