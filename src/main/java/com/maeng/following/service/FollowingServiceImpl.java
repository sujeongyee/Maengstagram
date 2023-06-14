package com.maeng.following.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maeng.following.model.FollowingDAO;
import com.maeng.following.model.FollowingVO;
import com.maeng.user.model.UserDAO;
import com.maeng.user.model.UserVO;

public class FollowingServiceImpl implements FollowingService {

	@Override
	public int countFollowing(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("search_id1");
		if(id==null) {
			id= (String)session.getAttribute("user_id");
		}
		FollowingDAO dao = FollowingDAO.getInstance();
		int count = dao.countFollowing(id);

		return count;
	}

	@Override
	public int countFollower(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("search_id1");
		if(id==null) {
			id= (String)session.getAttribute("user_id");
		}
		FollowingDAO dao = FollowingDAO.getInstance();

		int count = dao.countFollower(id);

		return count;
	}

	@Override
	public List<UserVO> followList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		FollowingDAO dao = FollowingDAO.getInstance();
		List<UserVO> list = dao.followList(id);
		return list;
	}

	@Override
	public List<UserVO> followingList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		FollowingDAO dao = FollowingDAO.getInstance();
		List<UserVO> list = dao.followingList(id);

		return list;
	}

	@Override
	public List<UserVO> followFriendList(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		FollowingDAO dao = FollowingDAO.getInstance();
		List<UserVO> list = dao.followList(id);
		return list;
	}

	@Override
	public List<UserVO> followingFriendList(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		FollowingDAO dao = FollowingDAO.getInstance();
		List<UserVO> list = dao.followingList(id);
		return list;
	}

	@Override
	public void followPlus(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		String search_id = request.getParameter("search_id");
		FollowingDAO dao = FollowingDAO.getInstance();
		dao.followPlus(id, search_id);
	}

	public int countFriendFollowing(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("search_id");
		FollowingDAO dao = FollowingDAO.getInstance();
		int count = dao.countFollowing(id);

		return count;
	}

	@Override
	public int countFriendFollower(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("search_id");
		FollowingDAO dao = FollowingDAO.getInstance();

		int count = dao.countFollower(id);

		return count;
	}


	@Override
	public int checkFollow(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		String search_id= request.getParameter("search_id");

		FollowingDAO dao = FollowingDAO.getInstance();

		int a = dao.checkFollow(id,search_id);

		return a;
	}

	@Override
	public int followDelete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		String search_id = request.getParameter("search_id");
		FollowingDAO dao = FollowingDAO.getInstance();
		dao.followDelete(id,search_id);
		System.out.println(id);
		System.out.println(search_id);

		return 0;
	}
}
