package Cafe.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Update_menuUI extends JFrame{

	private JPanel contentPane;
	private JTextField name, price;
	private JLabel name2, price2, Caffeine2;
	private JButton save, back;
	private JRadioButton coffee;
	private JRadioButton ade;
	private JRadioButton tea;
	String Caffeines [] = {"유", "무"};
	
	public Update_menuUI(String [] info) {
		
		String [] menu_info = info;
		int Caffeine_type = 0;
		String str = menu_info[3];
			
		if (menu_info[2].equals("무")) {
			Caffeine_type = 1;
		}
		
		setTitle("메뉴수정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 375, 490);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 이름 텍스트 필드
		name = new JTextField();
		name.setBounds(139, 91, 160, 27);
		contentPane.add(name);
		name.setColumns(10);
		name.setText(menu_info[0]);
		name.setForeground(Color.black);
		name.setEditable(false);
		
		// 이름 설명
		name2 = new JLabel("\uC774\uB984 : ");
		name2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		name2.setForeground(Color.WHITE);
		name2.setBackground(Color.WHITE);
		name2.setBounds(62, 88, 52, 27);
		contentPane.add(name2);

		// 가격 텍스트 필드
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(139, 147, 160, 27);
		contentPane.add(price);
		price.setText(menu_info[1]);

		// 가격 설명
		price2 = new JLabel("\uAC00\uACA9 : ");
		price2.setForeground(Color.WHITE);
		price2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		price2.setBackground(Color.WHITE);
		price2.setBounds(62, 146, 52, 27);
		contentPane.add(price2);

		// 카페인 체크
		JComboBox combo = new JComboBox(Caffeines);
		combo.setBounds(139, 204, 160, 27);
		combo.setSelectedIndex(Caffeine_type);
		contentPane.add(combo);

		// 카페인 설명
		Caffeine2 = new JLabel("\uCE74\uD398\uC778 :");
		Caffeine2.setForeground(Color.WHITE);
		Caffeine2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Caffeine2.setBackground(Color.WHITE);
		Caffeine2.setBounds(51, 204, 76, 27);
		contentPane.add(Caffeine2);
		
		// 뒤로가기 버튼
		ImageIcon icon = new ImageIcon("C:\\Users\\OBJ\\PROJECT\\Cafe_Kiosk\\image\\back.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(45, 44, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		back = new JButton(changeIcon);
		back.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		back.setForeground(Color.BLACK);
		back.setBackground(Color.WHITE);
		back.setBounds(24, 388, 45, 44);
		contentPane.add(back);
		
		// 뒤로가기 누를 때
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Update_listUI Update_listUI = new Update_listUI(str);
				Update_listUI.setVisible(true);
			}
		});

		// Button Group 생성
		ButtonGroup Group = new ButtonGroup();
		coffee = new JRadioButton("\uCEE4\uD53C");
		coffee.setForeground(Color.WHITE);
		coffee.setBackground(Color.BLACK);
		coffee.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		coffee.setBounds(62, 261, 60, 27);
		contentPane.add(coffee);
		Group.add(coffee);

		ade = new JRadioButton("\uC5D0\uC774\uB4DC");
		ade.setForeground(Color.WHITE);
		ade.setBackground(Color.BLACK);
		ade.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		ade.setBounds(143, 261, 71, 27);
		contentPane.add(ade);
		Group.add(ade);

		tea = new JRadioButton("\uCC28");
		tea.setForeground(Color.WHITE);
		tea.setBackground(Color.BLACK);
		tea.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		tea.setBounds(237, 261, 41, 27);
		contentPane.add(tea);
		Group.add(tea);
		
		switch(str) {
	        case "커피" :
	        	coffee.setSelected(true);
	            break;
	        case "에이드" :
	        	ade.setSelected(true);
	            break;
	        case "차" :
	        	tea.setSelected(true);
	            break;
		}

		save = new JButton("<HTML>메뉴<br>수정<HTML>");
		save.setBackground(Color.WHITE);
		save.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		save.setBounds(212, 311, 87, 59);
		contentPane.add(save);
		
		JLabel lblNewLabel = new JLabel("메뉴 정보를 수정하세요");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(51, 30, 247, 27);
		contentPane.add(lblNewLabel);
		
		// save 버튼 누를 때
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Caffeine = combo.getSelectedItem().toString();
				String text = null;
				int set = 0;
				
				if (coffee.isSelected()) {
					set = 1;
					text = "커피";
				}
				else if (ade.isSelected()) {
					set = 2;
					text = "에이드";
				}
				else{
					set = 3;
					text = "차";
				}
				
				Menu_save(set, Caffeine);
				dispose();
				Update_listUI Update_listUI = new Update_listUI(text);
				Update_listUI.setVisible(true);
				}
		});
	}
	
	protected void Menu_save(int set, String Caffeine) {
		String update_name = name.getText();
		String temp_price = price.getText();
		String insert_Caffeine = Caffeine;
		String temp = "";
		
		if(temp_price.equals(temp)) {
			JOptionPane.showMessageDialog(null, "잘못된 입력 형식입니다.", "오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
	
		update_name = update_name.trim();
		temp_price = temp_price.trim();
		insert_Caffeine = insert_Caffeine.trim();
		int insert_price = Integer.parseInt(temp_price);
		
		Menu_DAO dao = new Menu_DAO();
		Menu_DTO dto = new Menu_DTO();	
		
		dto.setName(update_name);
		dto.setPrice(insert_price);
		dto.setCaffeine(insert_Caffeine);
	
		boolean Success = dao.Menu_update(dto, set);
		if(Success) {
			JOptionPane.showMessageDialog(null, "메뉴수정 완료!", "성공", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "잘못된 입력 형식입니다.", "오류", JOptionPane.WARNING_MESSAGE);
		}
	}
}	

