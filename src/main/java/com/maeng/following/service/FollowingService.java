package com.maeng.following.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maeng.following.model.FollowingVO;
import com.maeng.user.model.UserVO;

public interface FollowingService {
	
	public int countFollowing(HttpServletRequest request, HttpServletResponse response);
	
	public int countFollower(HttpServletRequest request, HttpServletResponse response);
	
	public List<UserVO> followList(HttpServletRequest request, HttpServletResponse response);
	
	public List<UserVO> followingList(HttpServletRequest request, HttpServletResponse response);

	public void followPlus(HttpServletRequest request, HttpServletResponse response);

	public List<UserVO> followFriendList(HttpServletRequest request, HttpServletResponse response);
	public List<UserVO> followingFriendList(HttpServletRequest request, HttpServletResponse response);

	public int countFriendFollowing(HttpServletRequest request, HttpServletResponse response);

	public int countFriendFollower(HttpServletRequest request, HttpServletResponse response);

	public int checkFollow(HttpServletRequest request, HttpServletResponse response);

	public int followDelete(HttpServletRequest request, HttpServletResponse response);
}
