package com.maeng.comment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
	
	private static CommentDAO instance = new CommentDAO();
	private CommentDAO(){		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}
	}
	public static CommentDAO getInstance() {
		return instance;
	}
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "PRO";
	private String upw = "PRO";
	
	public List<CommentVO> getComment(String post_num){
		
		String sql = "SELECT * \r\n"
				+ "FROM COMMENTS\r\n"
				+ "WHERE POST_NUM = ? ORDER BY COM_TIME DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		List<CommentVO> list = new ArrayList<>();
		
		try {
			conn=DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int com_num = rs.getInt("com_num");
				String post_num2 = rs.getString("post_num");
				String user_id = rs.getString("user_id");
				String com_content = rs.getString("com_content");
				Timestamp com_time = rs.getTimestamp("com_time");
				
				CommentVO vo = new CommentVO(com_num,post_num2,user_id,com_content,com_time);
				
				list.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("댓글 불러오는 도중 오류발생");
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
	
	public void registComment(String post_num , String user_id, String com_content) {
		
		String sql = "INSERT INTO COMMENTS(COM_NUM,POST_NUM,USER_ID,COM_CONTENT) VALUES (COMMENT_SEQ.NEXTVAL,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post_num);
			pstmt.setString(2, user_id);
			pstmt.setString(3, com_content);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("댓글 넣는 중에 오류 발생");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
		
	}
	
	public int deleteComment(int com_num) {
		
		String sql = "DELETE FROM COMMENTS WHERE COM_NUM = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, com_num);
			
			result = pstmt.executeUpdate(); //1이면 성공 0이면 실패
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("댓글 삭제 중 오류발생!");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				
			}
		}
				
		
		return 0;
	}
}
