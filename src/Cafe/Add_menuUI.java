package Cafe;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Add_menuUI extends JFrame {

	Connection con = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
	String id = "CAFE"; 
	String password = "1234";
	
	private JPanel contentPane;
	private JTextField name, price, Caffeine;
	private JLabel name2, price2, Caffeine2;
	private JButton save, back;
	private JRadioButton coffee;
	private JRadioButton ade;
	private JRadioButton tea;
	int set;
	
	
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

		// 카페인 텍스트 필드
		Caffeine = new JTextField();
		Caffeine.setColumns(10);
		Caffeine.setBounds(139, 205, 160, 27);
		contentPane.add(Caffeine);

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
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coffee.isSelected())
					set = 1;
				if (ade.isSelected())
					set = 2;
				if (tea.isSelected())
					set = 3;
				Menu_Management();
			}
		});
		save.setBounds(212, 311, 87, 59);
		contentPane.add(save);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uB274 \uC815\uBCF4\uB97C \uC785\uB825\uD558\uC138\uC694");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(51, 30, 247, 27);
		contentPane.add(lblNewLabel);
	}

	public void Menu_Management() {
		long milli = System.currentTimeMillis();
		try {
			// 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "CAFE", "1234");
			System.out.println("DB 연결 성공");
			switch (set) {
			case 1:
				ps = con.prepareStatement("INSERT INTO 커피 VALUES(?,?,?,?)");
				break;
			case 2:
				ps = con.prepareStatement("INSERT INTO 에이드 VALUES(?,?,?,?)");
				break;
			case 3:
				ps = con.prepareStatement("INSERT INTO 차 VALUES(?,?,?,?)");
				break;
			}
			ps.setString(1, name.getText());
			ps.setString(2, price.getText());
			ps.setString(3, Caffeine.getText());
			ps.setDate(4,  new java.sql.Date(milli));
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "메뉴등록 완료!", "성공", JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException e) {
			System.out.println(e + "=> 로드 fail(Menu_Mana)");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "잘못된 입력 형식입니다.", "오류", JOptionPane.WARNING_MESSAGE);
		}
	}

	
	
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Add_menuUI frame = new Add_menuUI();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}
