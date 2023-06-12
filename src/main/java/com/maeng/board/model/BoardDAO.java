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

    private String url = "jdbc:oracle:thin:@172.30.1.38:1521:xe";
    private String uid = "JSP";
    private String upw = "JSP";


    // 게시글 쓰기
    public void write(String content, String img) {
        String sql = "INSERT INTO post(post_num, post_content, post_img, post_time) VALUES(post_SEQ.NEXTVAL, ?, ?, SYSDATE)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, uid, upw);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, content);
            pstmt.setString(2, img);

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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    // 목록 불러오기
    public List<BoardVO> getList(){
        List<BoardVO> list = new ArrayList<>();

        String sql = "select * from Post order by number DESC";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, uid, upw);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // 조회된 데이터를 순서대로 vo에 담고 리스트에 추가하는 프로그램코드

            while (rs.next()) {

               int number = rs.getInt("post_num");
               String content = rs.getString("post_content");
               String img = rs.getString("post_img");
               Date time = rs.getDate("post_time");

                BoardVO vo = new BoardVO(number, content, img, time);
                list.add(vo); // list에 추가
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return list;
    }




}
