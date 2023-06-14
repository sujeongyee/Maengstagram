package com.maeng.following.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.maeng.user.model.UserVO;

public class FollowingDAO {

	private static FollowingDAO instance = new FollowingDAO();

	private FollowingDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static FollowingDAO getInstance() {
		return instance;
	}

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "PRO";
	private String upw = "PRO";

	// 팔로잉수
	public int countFollowing(String user_id) {

		String sql = "SELECT COUNT(*) AS COUNT FROM  FOLLOWING WHERE USER_ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {

			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user_id);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				count = rs.getInt("count");
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("팔로우 회원 수 를 가져오는 도중 오류 발생");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return count;
	} 
	// 팔로워수
	public int countFollower(String fol_id) {
		String sql = "SELECT COUNT(*) AS COUNT FROM FOLLOWING WHERE FOL_ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {

			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,fol_id);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				count = rs.getInt("count");

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("팔로우 회원 수 를 가져오는 도중 오류 발생");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return count;
	}
	//팔로우리스트
	public List<UserVO> followList(String user_id){
		String sql = "SELECT *\r\n"
				+ "FROM FOLLOWING F \r\n"
				+ "LEFT JOIN USERS U\r\n"
				+ "ON F.FOL_ID = U.USER_ID\r\n"
				+ "WHERE F.USER_ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> list = new ArrayList<>();
		try {

			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user_id);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				String fol_id = rs.getString("fol_id");
				String user_nick = rs.getString("user_nick");
				String user_pw = rs.getString("user_pw");
				String user_photo = rs.getString("user_photo");
				String user_intro = rs.getString("user_intro");
				UserVO vo = new UserVO(fol_id,user_nick,user_pw,user_photo,user_intro);
				list.add(vo);
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("팔로우 회원 수 를 가져오는 도중 오류 발생");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;


	}
	//팔로워리스트
	public List<UserVO> followingList(String fol_id){
		String sql = "SELECT *\r\n"
				+ "FROM FOLLOWING F \r\n"
				+ "LEFT JOIN USERS U\r\n"
				+ "ON F.USER_ID = U.USER_ID\r\n"
				+ "WHERE F.FOL_ID= ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> list = new ArrayList<>();

		try {

			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,fol_id);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				String user_id = rs.getString("user_id");
				String user_nick = rs.getString("user_nick");
				String user_pw = rs.getString("user_pw");
				String user_photo = rs.getString("user_photo");
				String user_intro = rs.getString("user_intro");
				UserVO vo = new UserVO(user_id,user_nick,user_pw,user_photo,user_intro);
				list.add(vo);
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("팔로우 회원 수 를 가져오는 도중 오류 발생");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;
	}

	public void followPlus(String user_id, String fol_id){

		String sql = "insert into following values (?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, fol_id);


			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void followDelete(String user_id, String fol_id){

		String sql = "DELETE FROM FOLLOWING WHERE USER_ID = ? AND FOL_ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, fol_id);

			System.out.println(user_id);
			System.out.println(fol_id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}


	public int checkFollow(String user_id, String fol_id) {

		String sql = "select * from following  where user_id = ?  and fol_id = ?   ";

		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;

		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user_id);
			pstmt.setString(2, fol_id);
			rs = pstmt.executeQuery();

			if(rs.next()) { // 중복
				result = 1;

			}else {
				result = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("foll check 도중 오류 발생");
		} finally {

			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {

			}

		}

		return result;
	}


}
