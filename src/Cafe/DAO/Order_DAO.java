package Cafe.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Cafe.DTO.Order_DTO;

public class Order_DAO {

	private Connection con = null;
	private Statement stmt = null;
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
	private static final String id = "CAFE"; 
	private static final String password = "1234";
	
	private void DB_Connect() {
		try {
			con = DriverManager.getConnection(url, id, password);
		    System.out.println("DB 연결 성공");
		   } catch (SQLException e) { System.out.println("Connection Fail"); }
		}


	public ArrayList<Order_DTO> Menu_Order(String menu_name) throws SQLException {

		ArrayList<Order_DTO> result = new ArrayList<Order_DTO>();
		String query = String.format("select 이름,가격 from 음료 where 이름 = '%s'", menu_name);

		try { DB_Connect();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				Order_DTO dto = new Order_DTO();
				
				String name = rs.getString("이름");
				int price = rs.getInt("가격");
				dto.setName(name);
				dto.setPrice(price);
				
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
}
