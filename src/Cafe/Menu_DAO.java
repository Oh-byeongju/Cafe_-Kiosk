package Cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Menu_DAO {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
	private static final String id = "CAFE"; 
	private static final String password = "1234";
	
	private void DB_Connect() {
		try {
			con = DriverManager.getConnection(url, id, password);
		    System.out.println("DB 연결 성공");
		   } catch (SQLException e) { System.out.println("Connection Fail"); }
		}
	
	public boolean Menu_insert(Menu_DTO dto, int set) {
		long milli = System.currentTimeMillis();
		int flag = 0;
		try {
			DB_Connect();
			switch (set) {
			case 1:
				pstmt = con.prepareStatement("INSERT INTO 커피 VALUES(?,?,?,?)");
				break;
			case 2:
				pstmt = con.prepareStatement("INSERT INTO 에이드 VALUES(?,?,?,?)");
				break;
			case 3:
				pstmt = con.prepareStatement("INSERT INTO 차 VALUES(?,?,?,?)");
				break;
			}
			
			pstmt.setString(1, dto.getName());
	        pstmt.setInt(2, dto.getPrice());
	        pstmt.setString(3, dto.getCaffeine());
			pstmt.setDate(4, new java.sql.Date(milli));
			flag = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
						pstmt.close();
				if (con != null)
						con.close();
			} catch (SQLException e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

}
