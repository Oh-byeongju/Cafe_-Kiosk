package Cafe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainUI extends JFrame {

	private JPanel contentPane;
	private JButton Order, Manager;
	
	public MainUI() {
		setTitle("Cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 414, 630);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC5B4\uC11C\uC624\uC138\uC694 \r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(138, 85, 146, 58);
		contentPane.add(lblNewLabel);

		// 주문
		Order = new JButton("\uC8FC\uBB38\uD558\uAE30");
		Order.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Order.setBackground(Color.WHITE);
		Order.setBounds(49, 252, 126, 76);
		contentPane.add(Order);
		
		// 주문 누를 때
		Order.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			JFrame OrderUI = new OrderUI();
			OrderUI.setVisible(true);
		}
	});

		// 관리자
		Manager = new JButton("\uAD00\uB9AC\uC790");
		Manager.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Manager.setBackground(Color.WHITE);
		Manager.setBounds(228, 252, 126, 76);
		contentPane.add(Manager);
		
		// 관리자 버튼 누를 때
		Manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame AdminLogin = new AdminLogin();
				AdminLogin.setVisible(true);
			}
		});

		JLabel lblCafe = new JLabel("길거리 CAFE\uC785\uB2C8\uB2E4.");
		lblCafe.setForeground(Color.WHITE);
		lblCafe.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblCafe.setBounds(95, 140, 250, 52);
		contentPane.add(lblCafe);
	}


public static void main(String[] args) {
		MainUI frame = new MainUI();
		frame.setVisible(true);	
	}
}
