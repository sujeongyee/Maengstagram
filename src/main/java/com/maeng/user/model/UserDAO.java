package com.maeng.user.model;


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
	private String uid = "JSP";
	private String upw = "JSP";
	
	
	// 기능 구현
	
	
	

}
