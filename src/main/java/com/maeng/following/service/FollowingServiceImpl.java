package com.maeng.following.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maeng.following.model.FollowingDAO;
import com.maeng.user.model.UserVO;

public class FollowingServiceImpl implements FollowingService {

	@Override
	public int countFollowing(HttpServletRequest request, HttpServletResponse response) {
		
		String user_id = "";
		FollowingDAO dao = FollowingDAO.getInstance(); 
		int count = dao.countFollowing(user_id);
		
		return count;
	}

	@Override
	public int countFollower(HttpServletRequest request, HttpServletResponse response) {
		
		String fol_id = "";
		FollowingDAO dao = FollowingDAO.getInstance(); 
		int count = dao.countFollower(fol_id);
		
		return count;
	}

	@Override
	public List<UserVO> followList(HttpServletRequest request, HttpServletResponse response) {
		FollowingDAO dao = FollowingDAO.getInstance();
		String user_id = "";
		List<UserVO> list = dao.followList(user_id);
		return list;
	}

	@Override
	public List<UserVO> followingList(HttpServletRequest request, HttpServletResponse response) {
		FollowingDAO dao = FollowingDAO.getInstance();
		String fol_id = "";
		List<UserVO> list = dao.followingList(fol_id);
		return list;
	}

}
