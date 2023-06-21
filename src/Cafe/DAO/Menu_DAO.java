package Cafe.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import Cafe.DTO.Menu_DTO;

import java.sql.Date;

public class Menu_DAO {

	private Connection con = null;
	private Statement stmt = null;
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
	
	public ArrayList<Menu_DTO> Menu_search(String title){
		ArrayList<Menu_DTO> result = new ArrayList<Menu_DTO>();
		String query = String.format("select * from 음료 where 종류 = '%s'", title);
		try {
			DB_Connect();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Menu_DTO dto = new Menu_DTO();
		
				String name = rs.getString("이름");
				int price = rs.getInt("가격");
				String Caffeine = rs.getString("카페인");
				String Type = rs.getString("종류");
				Date Menu_Date = rs.getDate("등록일");
				
				dto.setName(name);
				dto.setPrice(price);
				dto.setCaffeine(Caffeine);
				dto.setType(Type);
				dto.setMenu_Date(Menu_Date);
		
				result.add(dto);
			}
			stmt.close();
			rs.close();			
			
		}catch(SQLException e2) {e2.printStackTrace();}
		 finally {
	        try {
	                if (con != null)
	                {
	                 con.close();     
	                }
	        }
	        catch (Exception e2)
	   {e2.printStackTrace();}
	}
		return result;
	}

	
	public boolean Menu_insert(Menu_DTO dto, int set) {
		long milli = System.currentTimeMillis();
		int flag = 0;
		try {
			DB_Connect();
			switch (set) {
			case 1:
				pstmt = con.prepareStatement("INSERT INTO 음료 VALUES(?,?,?,'커피',?)");
				break;
			case 2:
				pstmt = con.prepareStatement("INSERT INTO 음료 VALUES(?,?,?,'에이드',?)");
				break;
			case 3:
				pstmt = con.prepareStatement("INSERT INTO 음료 VALUES(?,?,?,'차',?)");
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
	
	public boolean Menu_update(Menu_DTO dto, int set) {
		long milli = System.currentTimeMillis();
		int flag = 0;
		String query = null;
		try {
			DB_Connect();
			switch (set) {
				case 1:
					query = "UPDATE 음료 SET 가격=?, 카페인=?, 종류='커피', 등록일=? WHERE 이름 = ?";
					break;
				case 2:
					query = "UPDATE 음료 SET 가격=?, 카페인=?, 종류='에이드', 등록일=? WHERE 이름 = ?";
					break;
				case 3:
					query = "UPDATE 음료 SET 가격=?, 카페인=?, 종류='차', 등록일 =? WHERE 이름 = ?";
					break;
			}
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, dto.getPrice());
	        pstmt.setString(2, dto.getCaffeine());
			pstmt.setDate(3, new java.sql.Date(milli));
			pstmt.setString(4, dto.getName());
			
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
	
	public void Menu_delete(String menu_name) {
		String query =  "DELETE FROM 음료 WHERE 이름 = ?";
	    try {
	    	DB_Connect();
	    	pstmt = con.prepareStatement(query);
	    	pstmt.setString(1, menu_name);
	    	pstmt.executeUpdate();
	    	JOptionPane.showMessageDialog(null, "메뉴삭제 완료!", "성공", JOptionPane.INFORMATION_MESSAGE);
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
	}
}
