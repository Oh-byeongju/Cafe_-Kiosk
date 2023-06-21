package Cafe.UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField Password;
	private JButton Login, Back;
	
	public AdminLogin() {
		setTitle("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 410, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 비밀번호 입력칸
		Password = new JPasswordField();
		Password.setBounds(141, 173, 116, 21);
		contentPane.add(Password);
		Password.setColumns(10);

		// Password 라벨
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(152, 142, 95, 21);
		contentPane.add(lblNewLabel);

		// 뒤로가기 버튼
		Back = new JButton("Back");
		Back.setBackground(Color.WHITE);
		Back.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Back.setBounds(295, 329, 75, 36);
		contentPane.add(Back);
		
		// 뒤로가기 누를 시
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame MainUI = new MainUI();
				MainUI.setVisible(true);
			}
		});
		
		// 로그인 버튼
		Login = new JButton("Login");
		Login.setForeground(Color.BLACK);
		Login.setBackground(Color.WHITE);
		Login.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Login.setBounds(161, 210, 75, 36);
		contentPane.add(Login);
		
		// 로그인 버튼 누를 시
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw = Password.getText();
				if (pw.equals("1234")) {
					dispose();
					JFrame AdminUI = new AdminUI();
					AdminUI.setVisible(true);
				} else
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
					Password.setText("");
			}
		});
	}
}

