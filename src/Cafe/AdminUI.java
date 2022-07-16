package Cafe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;

public class AdminUI extends JFrame {

	private JPanel contentPane;
	private JButton editmenu, addmenu, delmenu, salesinq, orderdel, ordersearch, back;
	
	
	public AdminUI() {
		setTitle("\uAD00\uB9AC\uC790\uC6A9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 372, 505);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790\uC6A9 \uBA54\uB274");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(96, 41, 173, 27);
		contentPane.add(lblNewLabel);
		
		// 메뉴 수정
		editmenu = new JButton("<HTML>\uBA54\uB274<br>\uC218\uC815<HTML>");
		editmenu.setBounds(209, 93, 98, 84);
		contentPane.add(editmenu);
		editmenu.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		editmenu.setBackground(Color.WHITE);
		
		// 메뉴 추가
		addmenu = new JButton("<HTML>\uBA54\uB274<br>\uB4F1\uB85D<HTML>");
		addmenu.setBounds(50, 93, 98, 84);
		contentPane.add(addmenu);
		addmenu.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		addmenu.setBackground(Color.WHITE);

		// 메뉴 삭제
		delmenu = new JButton("<HTML>\uBA54\uB274<br>\uC0AD\uC81C</HTML>");
		delmenu.setBounds(50, 210, 98, 84);
		contentPane.add(delmenu);
		delmenu.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		delmenu.setBackground(Color.WHITE);

		// 매출 조회
		salesinq = new JButton("<HTML>\uB9E4\uCD9C<br>\uC870\uD68C</HTML>");
		salesinq.setBounds(209, 210, 98, 84);
		contentPane.add(salesinq);
		salesinq.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		salesinq.setBackground(Color.WHITE);

		// 주문기록삭제
		orderdel = new JButton("<HTML>\uC8FC\uBB38<br>\uAE30\uB85D<br>\uC0AD\uC81C</HTML>");
		orderdel.setBounds(209, 331, 98, 84);
		contentPane.add(orderdel);
		orderdel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		orderdel.setBackground(Color.WHITE);
		
		// 주문기록조회
		ordersearch = new JButton("<HTML>\uC8FC\uBB38<br>\uAE30\uB85D<br>\uC870\uD68C</HTML>");
		ordersearch.setBounds(50, 331, 98, 84);
		contentPane.add(ordersearch);
		ordersearch.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		ordersearch.setBackground(Color.WHITE);

		// 뒤로가기
		ImageIcon icon = new ImageIcon("./image/back.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(47, 39, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		back = new JButton(changeIcon);
		back.setBounds(12, 10, 47, 39);
		contentPane.add(back);
		back.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		back.setBackground(Color.WHITE);

		// 뒤로가기 누를 시
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame MainUI = new MainUI();
				MainUI.setVisible(true);
			}
		});
						
		// 메뉴 추가 누를 시
		addmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame Add_menuUI = new Add_menuUI();
				Add_menuUI.setVisible(true);
			}
		});
		
		editmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Update_listUI Update_listUI = new Update_listUI();
				Update_listUI.setVisible(true);
			}
		});
		
		delmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Delete_listUI Delete_listUI = new Delete_listUI();
				Delete_listUI.setVisible(true);
			}
		});

	}


public static void main(String[] args) {
	AdminUI frame = new AdminUI();
	frame.setVisible(true);
	}
}