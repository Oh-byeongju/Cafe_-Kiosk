package Cafe.UI;

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

public class Update_listUI {

	String headers[]={"메뉴이름", "가격", "카페인", "종류", "등록일"};
	DefaultTableModel model = new DefaultTableModel (headers, 0);

	private JFrame frame;
	private JTable table;
	
	public Update_listUI(String name) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setTitle("메뉴수정");
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
		
		JButton Update_Button = new JButton("수정");
		Update_Button.setBackground(Color.WHITE);
		Update_Button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Update_Button.setForeground(Color.BLACK);
		Update_Button.setBounds(452, 330, 91, 43);
		frame.getContentPane().add(Update_Button);
		
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
		
		ImageIcon icon = new ImageIcon("C:\\Users\\OBJ\\PROJECT\\Cafe_Kiosk\\image\\back.png");
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
	    
	    switch(name) {
        case "미지정" :
            break;
            
        case "커피" :
        	Coffee_Button.setEnabled(false);
    		Ade_Button.setEnabled(true);
    		Tea_Button.setEnabled(true);
    		model.setNumRows(0);
    		String title = "커피";	
    		Menu_show(title);
            break;
            
        case "에이드" :
        	Coffee_Button.setEnabled(true);
    		Ade_Button.setEnabled(false);
    		Tea_Button.setEnabled(true);
    		model.setNumRows(0);
    		String title2 = "에이드";	
    		Menu_show(title2);
            break;
            
        case "차" :
        	Coffee_Button.setEnabled(true);
    		Ade_Button.setEnabled(true);
    		Tea_Button.setEnabled(false);
    		model.setNumRows(0);
    		String title3 = "차";	
    		Menu_show(title3);
            break;
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
		
		Update_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] tempStringRow = Update_Menu();
				if (tempStringRow[0] == null) {
					JOptionPane.showMessageDialog(null, "메뉴를 선택해주세요!", "수정", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				frame.dispose();
				JFrame Update_menuUI = new Update_menuUI(tempStringRow);
				Update_menuUI.setVisible(true);
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
	
	protected String[] Update_Menu() {
		int number = table.getSelectedRow();
		String row[] = new String[4];
		
		if (number == -1) {
	        return row;
		}
		
		for (int i = 0; i < 4; i++) {
			row[i] = (String) table.getValueAt(number, i);
		}
		
		return row;
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
}
