package com.maeng.board.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {
		// 생성자에서 드라이버클래서 호출
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BoardDAO getInstance() {
		return instance;
	}

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "PRO";
	private String upw = "PRO";


	// 게시글 쓰기
	public void write(String id, String content, String img) {
		String sql = "INSERT INTO post VALUES(POST_SEQ.NEXTVAL, ? ,?, ?, SYSDATE,0)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, content);
			pstmt.setString(3, img);

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

	// 게시글 수정
	public void update(String number, String content, String img) {
		String sql = "update post set post_content = ?, post_img = ? where post_num = ?";


		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setString(2, img);
			pstmt.setString(3, number);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 목록 불러오기
	public List<BoardVO> getList(String id) {
		List<BoardVO> list = new ArrayList<>();

		String sql = "SELECT * FROM POST P join USERS U ON u.user_id = p.user_id WHERE U.USER_id = ? ORDER BY POST_TIME DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			// 조회된 데이터를 순서대로 vo에 담고 리스트에 추가하는 프로그램코드

			while (rs.next()) {

				String number = rs.getString("post_num");
				String id2 = rs.getString("user_id");
				String content = rs.getString("post_content");
				String img = rs.getString("post_img");
				Timestamp time = rs.getTimestamp("post_time");
				int post_like = rs.getInt("post_like");

				BoardVO voo = new BoardVO(number, id2, content, img, time,post_like);
				list.add(voo); // list에 추가
			}


		} catch (Exception e) {
			e.printStackTrace();
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


	//
	public BoardVO getContent(String number) {

		BoardVO vo =new BoardVO();
		String sql = "SELECT * FROM POST P join USERS U ON u.user_id = p.user_id WHERE p.post_num = ? ORDER BY POST_TIME DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String number2 = rs.getString("post_num");
				String id1 = rs.getString("user_id");
				String content = rs.getString("post_content");
				String img = rs.getString("post_img");
				Timestamp time = rs.getTimestamp("post_time");
				int post_like = rs.getInt("post_like");

				vo = new BoardVO(number2, id1, content, img, time,post_like);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return vo;
	}




	public void BoardLikeUpdate(String number, String id) {
		String sql = "INSERT INTO LIKES VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;


		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.setString(2, id);


			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 좋아요수 업데이트 하다가 오류발생");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// like likeUpate 실행시 post테이블의 좋아요수 +1 하는 메서드

	public void BoardLike(String number) {
		String sql = "update post set post_like = post_like + 1 where post_num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;


		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);

			pstmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 좋아요 오류 발생");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	//좋아요 중복
	public int BoardCheckLike(String id, String post_num) {

		String sql = "select * from likes where user_id = ?  and post_num =  ? ";

		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;

		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, post_num);
			rs = pstmt.executeQuery();

			if(rs.next()) { // 중복
				result = 1;

			}else {
				result = 0;
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("좋아요 여부 검사 중 오류 발생(Board)");
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

	//좋아요 1번더 누를시 아이디삭제기능
	public void BoardLikeDelId(String number, String id) {
		String sql = "delete from likes where post_num= ? and user_id = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;


		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.setString(2, id);


			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("좋아요 취소 중 오류 발생 (board)");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}




	//좋아요 -1 메서드

	public void BoardLikeDel(String number) {
		String sql = "update post set post_like = post_like -1 where post_num =?";
		Connection conn = null;
		PreparedStatement pstmt = null;


		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);

			pstmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("likeDel오류");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}


	// 1.  해당 게시물 좋아요삭제
	public void delLikes(String number) {
		String sql = "delete from likes where post_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
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

	//2. 해당 게시물 댓글 삭제
	public void delComments(String number) {
		String sql = "delete from comments where post_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
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

	//3. 해당 게시물 삭제
	public void delPost(String number) {
		String sql = "delete from post where post_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
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





}
