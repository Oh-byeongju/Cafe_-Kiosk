package Cafe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Record_Search_UI {

	private JFrame frame;
	private static JTextField StartDay;
	private static JTextField EndDay;
	String headers[]={"주문번호", "주문일시", "합계", "포장여부"};
	DefaultTableModel model = new DefaultTableModel (headers, 0);
	private JTable table;
	
	public Record_Search_UI() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setTitle("주문기록점검");
		frame.setBounds(220, 130, 544, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		StartDay = new JTextField();
		StartDay.setBounds(85, 50, 60, 21);
		frame.getContentPane().add(StartDay);
		StartDay.setColumns(10);
		StartDay.setForeground(Color.black);
		StartDay.setEditable(false);
		
		EndDay = new JTextField();
		EndDay.setBounds(232, 50, 60, 21);
		frame.getContentPane().add(EndDay);
		EndDay.setColumns(10);
		EndDay.setForeground(Color.black);
		EndDay.setEditable(false);
		
		JLabel StartDay_lbl = new JLabel("기간");
		StartDay_lbl.setFont(new Font("굴림", Font.BOLD, 15));
		StartDay_lbl.setBounds(46, 53, 38, 18);
		StartDay_lbl.setForeground(Color.WHITE);
		StartDay_lbl.setBackground(Color.WHITE);
		frame.getContentPane().add(StartDay_lbl);
		
		JLabel EndDay_lbl = new JLabel("~");
		EndDay_lbl.setBounds(207, 53, 21, 15);
		EndDay_lbl.setFont(new Font("굴림", Font.BOLD, 15));
		EndDay_lbl.setForeground(Color.WHITE);
		EndDay_lbl.setBackground(Color.WHITE);
		frame.getContentPane().add(EndDay_lbl);
		
		ImageIcon icon = new ImageIcon("./image/calendar.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(28, 25, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JButton Open_Cal = new JButton(changeIcon);
		Open_Cal.setForeground(Color.BLACK);
		Open_Cal.setBackground(Color.WHITE);
		Open_Cal.setBounds(157, 49, 38, 23);
		frame.getContentPane().add(Open_Cal);

		JButton Open_Cal2 = new JButton(changeIcon);
		Open_Cal2.setForeground(Color.BLACK);
		Open_Cal2.setBackground(Color.WHITE);
		Open_Cal2.setBounds(304, 49, 38, 23);
		frame.getContentPane().add(Open_Cal2);
		
		table = new JTable(model);
		table.setBounds(60, 100, 463, 215);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		table.setRowHeight(45);			
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(48, 95, 403, 193);
		frame.getContentPane().add(scrollPane);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);  //JTable 의 컬럼 길이 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
	    dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
	     
	    TableColumnModel tcm = table.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴
	    for(int i = 0 ; i < tcm.getColumnCount() ; i++){
	    	tcm.getColumn(i).setCellRenderer(dtcr);  
	    }
		
		JButton SearchButton = new JButton("검색");
		SearchButton.setBounds(362, 42, 66, 36);
		SearchButton.setBackground(Color.WHITE);
		SearchButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		frame.getContentPane().add(SearchButton);
		
		ImageIcon icon2 = new ImageIcon("./image/back.png");
		Image img2 = icon2.getImage();
		Image changeImg2 = img2.getScaledInstance(45, 44, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);
		
		JButton Back_Button = new JButton(changeIcon2);
		Back_Button.setBounds(46, 307, 67, 45);
		Back_Button.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Back_Button.setForeground(Color.BLACK);
		Back_Button.setBackground(Color.WHITE);
		frame.getContentPane().add(Back_Button);
		
		JButton Detail_Button = new JButton("<HTML>세부<BR>조회</HTML>");
		Detail_Button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Detail_Button.setBackground(Color.WHITE);
		Detail_Button.setBounds(263, 307, 77, 44);
		frame.getContentPane().add(Detail_Button);
		
		JButton Delete_Button = new JButton("<HTML>기록<BR>삭제</HTML>");
		Delete_Button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Delete_Button.setBackground(Color.WHITE);
		Delete_Button.setBounds(372, 307, 79, 45);
		frame.getContentPane().add(Delete_Button);
		
		Open_Cal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = "Start_Record";
				Calendar_SearchUI Calendar_Search = new Calendar_SearchUI(type);
				Calendar_Search.setVisible(true);
			}		
		});
		
		Open_Cal2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = "End_Record";
				Calendar_SearchUI Calendar_Search = new Calendar_SearchUI(type);
				Calendar_Search.setVisible(true);
			}		
		});
		
		Back_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JFrame AdminUI = new AdminUI();
				AdminUI.setVisible(true);
			}		
		});
		
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				String Start = StartDay.getText();
				String End = EndDay.getText();
				Record_show(Start, End);
			}		
		});
		
		Detail_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> temp_Array = new ArrayList<String>();
				int num = get_Seq();
				
				if (num == -1)
					return;
				
				Record_DAO dao = new Record_DAO();
				ArrayList<Record_DTO> result = dao.Detail_Search(num);
				
				for (Record_DTO i : result) {
					int temp_Record = i.getRecord_Seq();
					int temp_Total = i.getTotal();
					int temp_Price = i.getPrice();
					
					temp_Array.add(Integer.toString(temp_Record));
					temp_Array.add(i.getName());
					temp_Array.add(Integer.toString(temp_Total));
					temp_Array.add(Integer.toString(temp_Price));
				}
								
				Record_Detail_UI Record_Detail_UI = new Record_Detail_UI(temp_Array);
				Record_Detail_UI.setVisible(true);
			}		
		});
		
		Delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempStringrow = Delete_Record();
				int temp_Seq = 0;
				
				if (tempStringrow == null) {
					JOptionPane.showMessageDialog(null, "기록을 선택해주세요!", "삭제", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				int Seq = Integer.parseInt(tempStringrow);
				Record_DAO dao = new Record_DAO();
				
				dao.Record_delete(Seq);
				temp_Seq = dao.get_Seq();
				dao.make_Seq(temp_Seq);
								
				model.setNumRows(0);
				String Start = StartDay.getText();
				String End = EndDay.getText();
				Record_show(Start, End);
			}	
		});
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
	public static void setStartDay(String Start) {
		StartDay.setText(Start);
	}
	
	public static void setEndDay(String End) {
		EndDay.setText(End);
	}
	
	protected void Record_show(String Start, String End) {
		
		Record_DAO dao = new Record_DAO();
		ArrayList<Record_DTO> result = dao.Record_Search(Start, End);
		String row[] = new String[4];
		SimpleDateFormat fmt=new SimpleDateFormat("yy-MM-dd");
		
		for (Record_DTO i : result) {
			int temp_Seq = i.getRecord_Seq();
			Date temp_date = i.getRecord_Date();
			int temp_total = i.getTotal();
			
			row[0] = Integer.toString(temp_Seq);
	    	row[1] = fmt.format(temp_date);
	    	row[2] = Integer.toString(temp_total);
	    	row[3] = i.getPackaging();
	    			
	    	model.addRow(row);
	    }
	}
	
	public int get_Seq() {
		int row = table.getSelectedRow();
		
		if (row == -1) {
	        JOptionPane.showMessageDialog(null, "기록을 선택해주세요!", "세부", JOptionPane.INFORMATION_MESSAGE);
	        return -1;
		}
		
		Object temp = table.getValueAt(row, 0);
		int result = Integer.valueOf((String) temp);

		return result;

	}
	
	protected String Delete_Record() {
		int number = table.getSelectedRow();
		String row = null;

		if (number == -1) {
	        return row;
		}
		
		row = (String) table.getValueAt(number, 0);
		return row;
	}
}