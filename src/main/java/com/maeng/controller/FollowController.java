package com.maeng.controller;

import com.maeng.board.service.BoardService;
import com.maeng.board.service.BoardServiceImpl;
import com.maeng.following.service.FollowingService;
import com.maeng.following.service.FollowingServiceImpl;
import com.maeng.user.model.UserVO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("*.follow")
public class FollowController extends HttpServlet {
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
        FollowingService service = new FollowingServiceImpl();

        HttpSession session = request.getSession();

        if (command.equals("/user/user_following.follow")){

            session = request.getSession();
            String user_id = (String) session.getAttribute("user_id");
            request.setAttribute("user_id", user_id);
            List<UserVO> list = service.followList(request, response);
            request.setAttribute("list", list);

            request.getRequestDispatcher("user_following.jsp").forward(request, response);

        } else if (command.equals("/user/user_follower.follow")){
            session = request.getSession();
            String user_id = (String) session.getAttribute("user_id");
            request.setAttribute("user_id", user_id);
            List<UserVO> list = service.followingList(request, response);
            request.setAttribute("list", list);
            request.getRequestDispatcher("user_follower.jsp").forward(request, response);

        } else if (command.equals("/user/user_followerFriend.follow")){
            String id = request.getParameter("id");
            request.setAttribute("id", id);
            List<UserVO> list = service.followFriendList(request, response);
            request.setAttribute("list", list);
            request.getRequestDispatcher("user_follower.jsp").forward(request, response);


        } else if (command.equals("/user/user_followingFriend.follow")){
            String id = request.getParameter("id");
            request.setAttribute("id", id);
            List<UserVO> list = service.followingFriendList(request, response);
            request.setAttribute("list", list);

            request.getRequestDispatcher("user_following.jsp").forward(request, response);

        }


    }
}
