package Cafe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Add_menuUI extends JFrame {

	private JPanel contentPane;
	private JTextField name, price;
	private JLabel name2, price2, Caffeine2;
	private JButton save, back;
	private JRadioButton coffee;
	private JRadioButton ade;
	private JRadioButton tea;
	String Caffeines [] = {"유", "무"};
	
	public Add_menuUI() {
		setTitle("\uBA54\uB274\uB4F1\uB85D");
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
		contentPane.add(combo);

		// 카페인 설명
		Caffeine2 = new JLabel("\uCE74\uD398\uC778 :");
		Caffeine2.setForeground(Color.WHITE);
		Caffeine2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Caffeine2.setBackground(Color.WHITE);
		Caffeine2.setBounds(51, 204, 76, 27);
		contentPane.add(Caffeine2);
		
		// 뒤로가기 버튼
		ImageIcon icon = new ImageIcon("./image/back.png");
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
				JFrame AdminUI = new AdminUI();
				AdminUI.setVisible(true);
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

		save = new JButton("<HTML>\uBA54\uB274<br>\uB4F1\uB85D<HTML>");
		save.setBackground(Color.WHITE);
		save.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		save.setBounds(212, 311, 87, 59);
		contentPane.add(save);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uB274 \uC815\uBCF4\uB97C \uC785\uB825\uD558\uC138\uC694");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(51, 30, 247, 27);
		contentPane.add(lblNewLabel);
		
		// save 버튼 누를 때
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Caffeine = combo.getSelectedItem().toString();
				int set = 0;
				if (coffee.isSelected())
					set = 1;
				if (ade.isSelected())
					set = 2;
				if (tea.isSelected())
					set = 3;
			
				if (set == 0) {
					JOptionPane.showMessageDialog(null, "잘못된 입력 형식입니다.", "오류", JOptionPane.WARNING_MESSAGE);
				}
				else {
					Menu_save(set, Caffeine);
				}
			}
		});
	}
	
	protected void Menu_save(int set, String Caffeine) {
		String insert_name = name.getText();
		String temp_price = price.getText();
		String insert_Caffeine = Caffeine;
		String temp = "";
		
		if(insert_name.equals(temp) || temp_price.equals(temp)) {
			JOptionPane.showMessageDialog(null, "잘못된 입력 형식입니다.", "오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
	
		insert_name = insert_name.trim();
		temp_price = temp_price.trim();
		insert_Caffeine = insert_Caffeine.trim();
		int insert_price = Integer.parseInt(temp_price);
		
		Menu_DAO dao = new Menu_DAO();
		Menu_DTO dto = new Menu_DTO();	
		
		dto.setName(insert_name);
		dto.setPrice(insert_price);
		dto.setCaffeine(insert_Caffeine);
	
		boolean Success = dao.Menu_insert(dto, set);
		if(Success) {
			JOptionPane.showMessageDialog(null, "메뉴등록 완료!", "성공", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "잘못된 입력 형식입니다.", "오류", JOptionPane.WARNING_MESSAGE);
		}
	}
}
