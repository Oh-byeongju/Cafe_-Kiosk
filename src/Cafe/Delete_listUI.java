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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Delete_listUI {
	
	String headers[]={"메뉴이름", "가격", "카페인", "종류", "등록일"};
	DefaultTableModel model = new DefaultTableModel (headers, 0);
	
	private JFrame frame;
	private JTable table;
	
	public Delete_listUI() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setTitle("메뉴삭제");
		frame.setBounds(220, 130, 604, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Coffee_Button = new JButton("커피");
		Coffee_Button.setBackground(Color.WHITE);
		Coffee_Button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Coffee_Button.setForeground(Color.BLACK);
		Coffee_Button.setBounds(100, 40, 80, 45);
		frame.getContentPane().add(Coffee_Button);
		
		JButton Ade_Button = new JButton("에이드");
		Ade_Button.setBackground(Color.WHITE);
		Ade_Button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Ade_Button.setForeground(Color.BLACK);
		Ade_Button.setBounds(210, 40, 91, 45);
		frame.getContentPane().add(Ade_Button);
		
		JButton Tea_Button = new JButton("차");
		Tea_Button.setBackground(Color.WHITE);
		Tea_Button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Tea_Button.setForeground(Color.BLACK);
		Tea_Button.setBounds(329, 40, 91, 45);
		frame.getContentPane().add(Tea_Button);
		
		JButton Delete_Button = new JButton("삭제");
		Delete_Button.setBackground(Color.WHITE);
		Delete_Button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Delete_Button.setForeground(Color.BLACK);
		Delete_Button.setBounds(452, 330, 91, 43);
		frame.getContentPane().add(Delete_Button);
		
		table = new JTable(model);
		table.setBounds(60, 140, 463, 215);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		table.setRowHeight(45);		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 109, 505, 201);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("종류");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(40, 38, 48, 45);
		frame.getContentPane().add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon("./image/back.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(45, 44, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JButton Back_Button = new JButton(changeIcon);
		Back_Button.setBounds(40, 333, 67, 45);
		Back_Button.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Back_Button.setForeground(Color.BLACK);
		Back_Button.setBackground(Color.WHITE);
		frame.getContentPane().add(Back_Button);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(80);  //JTable 의 컬럼 길이 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(15);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);

		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
	    dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
	     
	    TableColumnModel tcm = table.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴
	    for(int i = 0 ; i < tcm.getColumnCount() ; i++){
	    	tcm.getColumn(i).setCellRenderer(dtcr);  
	    }
		
		Coffee_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coffee_Button.setEnabled(false);
				Ade_Button.setEnabled(true);
				Tea_Button.setEnabled(true);
				model.setNumRows(0);
				String title = "커피";	
				Menu_show(title);
			}
		});
		
		Ade_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coffee_Button.setEnabled(true);
				Ade_Button.setEnabled(false);
				Tea_Button.setEnabled(true);
				model.setNumRows(0);
				String title = "에이드";	
				Menu_show(title);
			}
		});
		
		Tea_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coffee_Button.setEnabled(true);
				Ade_Button.setEnabled(true);
				Tea_Button.setEnabled(false);
				model.setNumRows(0);
				String title = "차";	
				Menu_show(title);
			}
		});
		
		
		Delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] tempStringrow = Delete_Menu();
				
				if (tempStringrow[0] == null) {
					JOptionPane.showMessageDialog(null, "메뉴를 선택해주세요!", "삭제", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				String Name = tempStringrow[0];
				String Type = tempStringrow[1];
				
				Menu_DAO dao = new Menu_DAO();
				dao.Menu_delete(Name);
				
				model.setNumRows(0);
				Menu_show(Type);
			}
		});
		
		
		Back_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JFrame AdminUI = new AdminUI();
				AdminUI.setVisible(true);
			}
		});
	}
	
	protected void Menu_show(String title) {
		
		Menu_DAO dao = new Menu_DAO();
		ArrayList<Menu_DTO> result = dao.Menu_search(title);
		String row[] = new String[5];
		SimpleDateFormat fmt=new SimpleDateFormat("yy-MM-dd");
		
		for (Menu_DTO i : result) {
			int temp_price = i.getPrice();
			Date temp_date = i.getMenu_Date();
			row[0] = i.getName();
	    	row[1] = Integer.toString(temp_price);
	    	row[2] = i.getCaffeine();
	    	row[3] = i.getType();
	    	row[4] = fmt.format(temp_date);
	    	
	    	model.addRow(row);
	    }
	}
	
	protected String[] Delete_Menu() {
		int number = table.getSelectedRow();
		String row[] = new String[2];

		if (number == -1) {
	        return row;
		}
		
		row[0] = (String) table.getValueAt(number, 0);
		row[1] = (String) table.getValueAt(number, 3);
		
		return row;
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
