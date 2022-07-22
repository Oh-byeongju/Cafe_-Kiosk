package Cafe;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Record_DAO {

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
	
	public ArrayList<Record_DTO> Menu_search(String Start, String End){
		ArrayList<Record_DTO> result = new ArrayList<Record_DTO>();
		String query = String.format("select 주문일시, count(주문번호) as 주문횟수, sum(합계) as 매출합계"
									 + " from 주문기록"
									 + " where 주문일시 >= '%s' and 주문일시 <= '%s'"
									 + " group by 주문일시"
									 + " order by 주문일시", Start, End);
		try {
			DB_Connect();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Record_DTO dto = new Record_DTO();
		
				Date Order_Date = rs.getDate("주문일시");
				int count = rs.getInt("주문횟수");
				int total = rs.getInt("매출합계");
				
				dto.setRecord_Date(Order_Date);
				dto.setCount(count);
				dto.setTotal(total);
				
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
	
	public ArrayList<Record_DTO> Menu_search2(String Start, String End){
		ArrayList<Record_DTO> result = new ArrayList<Record_DTO>();
		String query = String.format("select rank() over (order by count(수량) desc) as 순위, 이름, count(수량) as 판매횟수"
									 + " from 음료_주문기록"
									 + " where 음료_주문기록.주문번호 IN"
									 + " (select 주문기록.주문번호 "
									 + " from 주문기록"
									 + " where 주문일시 >= '%s' and 주문일시 <= '%s')"
									 + " group by 이름", Start, End);
		try {
			DB_Connect();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Record_DTO dto = new Record_DTO();
		
				int rank = rs.getInt("순위");
				String name = rs.getString("이름");
				int count = rs.getInt("판매횟수");
				
				dto.setRank(rank);
				dto.setName(name);
				dto.setCount(count);
				
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
