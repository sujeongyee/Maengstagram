package com.maeng.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;







public class UserDAO {
	
	private static UserDAO instance = new UserDAO();
	
	private UserDAO(){		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "PRO";
	private String upw = "PRO";
	
	
	// 기능 구현
	
	//로그인
	public UserVO login(String id , String pw) {

		String sql = "SELECT * FROM USERS WHERE USER_ID = ? AND USER_PW = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO vo = null; // 로그인 실패면 null값이 반환
		try {
			conn = DriverManager.getConnection(url,uid,upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();

			if(rs.next()) { // 로그인 가능

				String nick = rs.getString("user_nick");
				String uPhoto = rs.getString("user_photo");
				String intro = rs.getString("user_intro");
				vo = new UserVO(id,nick,pw,uPhoto,intro);

			} 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 도중 오류가 발생했습니다!");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {

			}
		}

		return vo;
	}
	
	//아이디중복검사
	public int checkId(String id) {
		
		String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		int result = 1;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 중복
				result = 1;
			}else {
				result = 0;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("중복 검사 도중 오류 발생");
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
	
	//가입
	public void join(UserVO vo) {

		String sql = "INSERT INTO USERS(USER_ID,USER_NICK,USER_PW,USER_PHOTO,USER_INTRO) VALUES(?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url,uid,upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getNick());
			pstmt.setString(3,vo.getPw());
			pstmt.setString(4,vo.getPhoto());
			pstmt.setString(5,vo.getIntro());

			pstmt.executeUpdate(); //성공시 1, 실패시 0

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 도중 오류가 발생했습니다.");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	
	
	
	public int delete (String id) {

		int result = 0;
		String sql = "DELETE FROM USERS WHERE USER_ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원삭제 도중 오류 발생!");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}

		return result;
	}
	
	public UserVO getInfo(String id) {
		UserVO vo = null;

		String sql = "SELECT * FROM USERS WHERE USER_ID = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {			
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				String id2 = rs.getString("user_id");
				String name = rs.getString("user_nick");
				String pw = rs.getString("user_pw");
				String photo = rs.getString("user_photo");
				String intro = rs.getString("user_intro");				
				vo = new UserVO(id2,name,pw,photo,intro);				
			}		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원정보 조회 기능에서 오류가 발생했습니다.");
		} finally {
			try {				
				conn.close();
				pstmt.close();
				rs.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return vo;
	}
	
	
	public int updateInfo (UserVO vo) {

		String sql = "UPDATE USERS SET USER_PW = ? , USER_NAME = ? , USER_INTRO = ? , USER_PHOTO = ?  WHERE USER_ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;	
		int a = 0;


		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getNick());
			pstmt.setString(3, vo.getIntro());
			pstmt.setString(4, vo.getPhoto());
			pstmt.setString(5, vo.getId());


			a = pstmt.executeUpdate(); // 성공시 1

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원정보 수정 과정에서 오류 발생!!!");
		} finally {
			try {
				conn.close();
				pstmt.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return a;
	}
	
	

}

	
