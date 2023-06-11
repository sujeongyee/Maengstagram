package com.maeng.main.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



public class MainDAO {

	private static MainDAO instance = new MainDAO();
	private MainDAO(){		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}
	}
	public static MainDAO getInstance() {
		return instance;
	}
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP";
	private String upw = "JSP";

	//--------------------------------------------------------

	public List<MainVO> getList(String user_id) {
		
		List<MainVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT U.USER_PHOTO, \r\n"
				+ "       F.FOL_ID, \r\n"
				+ "       P.POST_IMG,\r\n"
				+ "       P.POST_TITLE,\r\n"
				+ "       P.POST_LIKE,\r\n"
				+ "       P.POST_TIME\r\n"
				+ "FROM FOLLOWING F\r\n"
				+ "JOIN POST P ON F.FOL_ID = P.USER_ID\r\n"
				+ "JOIN USERS U ON U.USER_ID = P.FOL_ID\r\n"
				+ "WHERE F.USER_ID = ? \r\n"
				+ "ORDER BY P.POST_TIME DESC";
		
		try {

			conn = DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				String user_photo = rs.getString("user_photo");
				String fol_id = rs.getString("fol_id");
				String post_img = rs.getString("post_img");
				String post_title = rs.getString("post_title");
				int post_like = rs.getInt("post_like"); 
				Timestamp post_time = rs.getTimestamp("post_time");
				MainVO vo = new MainVO( user_photo, fol_id,post_img, post_title, post_like, post_time);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}

}
