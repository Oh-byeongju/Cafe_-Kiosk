package Cafe.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import Cafe.DTO.Record_DTO;

public class Record_DAO {

	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private CallableStatement cstmt = null;
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
	
	public ArrayList<Record_DTO> Record_Search(String Start, String End){
		ArrayList<Record_DTO> result = new ArrayList<Record_DTO>();
		String query = String.format("select *"
									 + " from 주문기록"
									 + " where 주문일시 >= '%s' and 주문일시 <= '%s'"
									 + " order by 주문번호", Start, End);
		try {
			DB_Connect();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Record_DTO dto = new Record_DTO();
		
				int record_Seq = rs.getInt("주문번호");
				Date Order_Date = rs.getDate("주문일시");
				int total = rs.getInt("합계");
				String packaging = rs.getString("포장여부");
				
				dto.setRecord_Seq(record_Seq);
				dto.setRecord_Date(Order_Date);
				dto.setTotal(total);
				dto.setPackaging(packaging);
				
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
	
	public ArrayList<Record_DTO> Detail_Search(int Seq){
		ArrayList<Record_DTO> result = new ArrayList<Record_DTO>();
		String query = String.format("select *"
									 + " from 음료_주문기록"
									 + " where 주문번호 = '%d'", Seq);
		try {
			DB_Connect();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Record_DTO dto = new Record_DTO();
		
				int record_Seq = rs.getInt("주문번호");
				String name = rs.getString("이름");
				int total = rs.getInt("수량");
				int price = rs.getInt("시가");
				
				dto.setRecord_Seq(record_Seq);
				dto.setName(name);
				dto.setTotal(total);
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
	
	public int Record_insert(Record_DTO dto) {
		int Seq = 0;
		long milli = System.currentTimeMillis();
		String query = "SELECT ORDER_SEQ.CURRVAL FROM dual";
		
		try {
			DB_Connect();
			pstmt = con.prepareStatement("INSERT INTO 주문기록 VALUES(ORDER_SEQ.NEXTVAL,?,?,?)");
			pstmt.setDate(1, new java.sql.Date(milli));
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getPackaging());
			pstmt.executeUpdate();
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				Seq = rs.getInt(1);
			}
			
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
		return Seq;
	}
	
	public void Detail_Record_insert(Record_DTO dto, int seq) {
		try {
			DB_Connect();
			pstmt = con.prepareStatement("INSERT INTO 음료_주문기록 VALUES(?,?,?,?)");
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, seq);
			pstmt.setInt(3, dto.getCount());
			pstmt.setInt(4, dto.getPrice());
			pstmt.executeUpdate();
			
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
	
	public void Record_delete(int Seq) {
		String query =  "DELETE FROM 주문기록 WHERE 주문번호 = ?";
	    try {
	    	DB_Connect();
	    	pstmt = con.prepareStatement(query);
	    	pstmt.setInt(1, Seq);
	    	pstmt.executeUpdate();
	    	
	    	cstmt = con.prepareCall("call CAFE.Delete_record(?)");
	    	cstmt.setInt(1,Seq);
	    	cstmt.executeUpdate();
	    	
	    	JOptionPane.showMessageDialog(null, "기록삭제 완료!", "성공", JOptionPane.INFORMATION_MESSAGE);
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
	
	public int get_Seq() {
		int num = 0;
		String sql="select ORDER_SEQ.nextval from dual";
		try{
			DB_Connect();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				num = rs.getInt(1);
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
		return num;
	}
	
	public void make_Seq(int temp_Seq) {
		int Start = temp_Seq -1;
		String sql1 = "DROP SEQUENCE ORDER_SEQ";
		//String sql2 = "CREATE SEQUENCE ORDER_SEQ START WITH 500";
		String sql2 = String.format("CREATE SEQUENCE ORDER_SEQ"
									+ " START WITH %d", Start);
		try{
			DB_Connect();
			stmt = con.createStatement();
			stmt.executeQuery(sql1);
			stmt.executeQuery(sql2);			
			stmt.close();
			
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
	}
}
