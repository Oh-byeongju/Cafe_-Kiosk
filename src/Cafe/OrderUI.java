package Cafe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JOptionPane;

public class OrderUI extends JFrame {

	// 메뉴 추가관련 변수
	String headers[]={"메뉴이름", "가격"};
	DefaultTableModel model = new DefaultTableModel (headers, 0);
	ArrayList<String> Menu_list = new ArrayList<String>();
	ArrayList<Integer> Price = new ArrayList<Integer>();
	
	private JPanel contentPane;
	private JButton Coffee1, Coffee2, Coffee3, Coffee4, CoffeeMenu, AdeMenu, TeaMenu,
	Ade1, Ade2, Ade3, Ade4, Tea1, Tea2, Tea3, Tea4, Menudelete, Pay, MainBack;
	
	private JTable table;
	private JPanel panel_1;
	private JLabel lblNewLabel_1, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7, lblNewLabel_8;
	private JLabel lblNewLabel_9, lblNewLabel_10, lblNewLabel_11, lblNewLabel_12;
	
	public OrderUI() {
		// 제일 바깥 배경
		setTitle("\uC8FC\uBB38");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 15, 588, 801);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 커피 메뉴 버튼
		CoffeeMenu = new JButton("\uCEE4\uD53C");
		CoffeeMenu.setBounds(27, 47, 91, 46);
		CoffeeMenu.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		CoffeeMenu.setForeground(SystemColor.desktop);
		CoffeeMenu.setBackground(SystemColor.window);
		CoffeeMenu.setEnabled(false);
		contentPane.add(CoffeeMenu);
		
		// 에이드 메뉴 버튼
		AdeMenu = new JButton("\uC5D0\uC774\uB4DC");
		AdeMenu.setBounds(27, 105, 91, 46);
		AdeMenu.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		AdeMenu.setForeground(SystemColor.desktop);
		AdeMenu.setBackground(SystemColor.window);
		contentPane.add(AdeMenu);
		
		// 티 메뉴 버튼
		TeaMenu = new JButton("\uCC28");
		TeaMenu.setBounds(27, 163, 91, 44);
		TeaMenu.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		TeaMenu.setForeground(SystemColor.desktop);
		TeaMenu.setBackground(SystemColor.window);
		contentPane.add(TeaMenu);
		
	    // 중간 하얀 배경
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(139, 10, 421, 744);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// 제일 안쪽 배경
		panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 394, 724);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		// 아메리카노 버튼
		ImageIcon icon = new ImageIcon("./image/아메리카노.jpg");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(165, 151, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		Coffee1 = new JButton(changeIcon);
		Coffee1.setBounds(25, 17, 151, 151);
		panel_1.add(Coffee1);
		Coffee1.setText("coffee1");
		Coffee1.setBorderPainted(false);
		
		// 아메리카노 설명
		JLabel lblNewLabel = new JLabel("\uC544\uBA54\uB9AC\uCE74\uB178      1500\\");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel.setBounds(30, 178, 151, 15);
		panel_1.add(lblNewLabel);
		
		// 에스프레소 버튼
		ImageIcon icon1 = new ImageIcon("./image/에스프레소.jpg");
		Image img1 = icon1.getImage();
		Image changeImg1 = img1.getScaledInstance(176, 167, Image.SCALE_SMOOTH);
		ImageIcon changeIcon1 = new ImageIcon(changeImg1);
		Coffee2 = new JButton(changeIcon1);
		Coffee2.setBounds(220, 17, 151, 151);
		panel_1.add(Coffee2);
		Coffee2.setText("coffee2");
		Coffee2.setBorderPainted(false);
		
		// 에스프레소 설명
		lblNewLabel_1 = new JLabel("\uC5D0\uC2A4\uD504\uB808\uC18C     1500\\");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_1.setBounds(230, 178, 140, 15);
		panel_1.add(lblNewLabel_1);
		
		// 카페라떼 버튼
		ImageIcon icon2 = new ImageIcon("./image/아이스카페라떼.jpg");
		Image img2 = icon2.getImage();
		Image changeImg2 = img2.getScaledInstance(176, 167, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);
		Coffee3 = new JButton(changeIcon2);
		Coffee3.setBounds(25, 212, 151, 151);
		panel_1.add(Coffee3);
		Coffee3.setText("coffee3");
		Coffee3.setBorderPainted(false);
		
		// 카페라떼 설명
		lblNewLabel_3 = new JLabel("\uCE74\uD398\uB77C\uB5BC          2000\\");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_3.setBounds(30, 374, 146, 15);
		panel_1.add(lblNewLabel_3);

		// 바닐라라떼 버튼
		ImageIcon icon3 = new ImageIcon("./image/바닐라라떼.jpg");
		Image img3 = icon3.getImage();
		Image changeImg3 = img3.getScaledInstance(176, 167, Image.SCALE_SMOOTH);
		ImageIcon changeIcon3 = new ImageIcon(changeImg3);
		Coffee4 = new JButton(changeIcon3);
		Coffee4.setBounds(220, 212, 151, 151);
		panel_1.add(Coffee4);
		Coffee4.setText("coffee4");
		Coffee4.setBorderPainted(false);
		
		// 바닐라라떼 설명
		lblNewLabel_4 = new JLabel("\uBC14\uB2D0\uB77C\uB77C\uB5BC     3000\\");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_4.setBounds(230, 374, 140, 15);
		panel_1.add(lblNewLabel_4);
		
		// 레몬에이드 버튼
		ImageIcon icon4 = new ImageIcon("./image/레몬에이드.jpg");
		Image img4 = icon4.getImage();
		Image changeImg4 = img4.getScaledInstance(176, 167, Image.SCALE_SMOOTH);
		ImageIcon changeIcon4 = new ImageIcon(changeImg4);
		Ade1 = new JButton(changeIcon4);
		Ade1.setBounds(25, 17, 151, 151);
		panel_1.add(Ade1);
		Ade1.setVisible(false);
		Ade1.setText("Ade1");
		Ade1.setBorderPainted(false);
		
		// 레몬에이드 설명
		JLabel lblNewLabel_5 = new JLabel("\uB808\uBAAC\uC5D0\uC774\uB4DC      3000\\");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_5.setBounds(30, 178, 151, 15);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
	
		// 청포도에이드 설명
		ImageIcon icon5 = new ImageIcon("./image/청포도에이드.jpg");
		Image img5 = icon5.getImage();
		Image changeImg5 = img5.getScaledInstance(250, 176, Image.SCALE_SMOOTH);
		ImageIcon changeIcon5 = new ImageIcon(changeImg5);
		Ade2 = new JButton(changeIcon5);
		Ade2.setBounds(220, 17, 151, 151);
		panel_1.add(Ade2);
		Ade2.setVisible(false);
		Ade2.setText("Ade2");
		Ade2.setBorderPainted(false);
		
		// 청포도에이드 설명
		lblNewLabel_6 = new JLabel("\uCCAD\uD3EC\uB3C4\uC5D0\uC774\uB4DC    3000\\");
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_6.setBounds(230, 178, 140, 15);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		// 자몽에이드 버튼
		ImageIcon icon6 = new ImageIcon("./image/자몽에이드.jpg");
		Image img6 = icon6.getImage();
		Image changeImg6 = img6.getScaledInstance(220, 170, Image.SCALE_SMOOTH);
		ImageIcon changeIcon6 = new ImageIcon(changeImg6);
		Ade3 = new JButton(changeIcon6);
		Ade3.setBounds(25, 212, 151, 151);
		panel_1.add(Ade3);
		Ade3.setVisible(false);
		Ade3.setText("Ade3");
		Ade3.setBorderPainted(false);
		
		// 자몽에이드 설명
		lblNewLabel_7 = new JLabel("\uC790\uBABD\uC5D0\uC774\uB4DC      3000\\");
		lblNewLabel_7.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_7.setBounds(30, 374, 146, 15);
		panel_1.add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
			
		// 체리콕 버튼
		ImageIcon icon7 = new ImageIcon("./image/체리콕.jpg");
		Image img7 = icon7.getImage();
		Image changeImg7 = img7.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
		ImageIcon changeIcon7 = new ImageIcon(changeImg7);
		Ade4 = new JButton(changeIcon7);
		Ade4.setBounds(220, 212, 151, 151);
		panel_1.add(Ade4);
		Ade4.setVisible(false);
		Ade4.setText("Ade4");
		Ade4.setBorderPainted(false);
		
		// 체리콕 설명
		lblNewLabel_8 = new JLabel("\uCCB4\uB9AC\uCF55         3000\\");
		lblNewLabel_8.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_8.setBounds(230, 374, 140, 15);
		panel_1.add(lblNewLabel_8);
		lblNewLabel_8.setVisible(false);
		
		// 아이스티 버튼
		ImageIcon icon8 = new ImageIcon("./image/아이스티6.jpg");
		Image img8 = icon8.getImage();
		Image changeImg8 = img8.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
		ImageIcon changeIcon8 = new ImageIcon(changeImg8);
		Tea1 = new JButton(changeIcon8);
		Tea1.setBounds(25, 17, 151, 151);
		panel_1.add(Tea1);
		Tea1.setVisible(false);
		Tea1.setText("Tea1");
		Tea1.setBorderPainted(false);
		
		// 아이스티 설명
		lblNewLabel_9 = new JLabel("\uC544\uC774\uC2A4\uD2F0         2000\\");
		lblNewLabel_9.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_9.setBounds(30, 178, 151, 15);
		panel_1.add(lblNewLabel_9);
		lblNewLabel_9.setVisible(false);
		
		//유자차 버튼
		ImageIcon icon9 = new ImageIcon("./image/유자차.jpg");
		Image img9 = icon9.getImage();
		Image changeImg9 = img9.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
		ImageIcon changeIcon9 = new ImageIcon(changeImg9);
		Tea2 = new JButton(changeIcon9);
		Tea2.setBounds(220, 17, 151, 151);
		panel_1.add(Tea2);
		Tea2.setVisible(false);
		Tea2.setText("Tea2");
		Tea2.setBorderPainted(false);
		
		// 유자차 설명
		lblNewLabel_10 = new JLabel("\uC720\uC790\uCC28         2500\\");
		lblNewLabel_10.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_10.setBounds(230, 178, 140, 15);
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setVisible(false);
		
		// 캐모마일 버튼
		ImageIcon icon10 = new ImageIcon("./image/캐모마일.jpg");
		Image img10 = icon10.getImage();
		Image changeImg10 = img10.getScaledInstance(230, 170, Image.SCALE_SMOOTH);
		ImageIcon changeIcon10 = new ImageIcon(changeImg10);
		Tea3 = new JButton(changeIcon10);
		Tea3.setBounds(25, 212, 151, 151);
		panel_1.add(Tea3);
		Tea3.setVisible(false);
		Tea3.setText("Tea3");
		Tea3.setBorderPainted(false);
		
		// 캐모마일 설명
		lblNewLabel_11 = new JLabel("\uCE90\uBAA8\uB9C8\uC77C         2500\\");
		lblNewLabel_11.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_11.setBounds(30, 374, 146, 15);
		panel_1.add(lblNewLabel_11);
		lblNewLabel_11.setVisible(false);
		
		// 페퍼민트 버튼
		ImageIcon icon11 = new ImageIcon("./image/페퍼민트.jpg");
		Image img11 = icon11.getImage();
		Image changeImg11 = img11.getScaledInstance(230, 170, Image.SCALE_SMOOTH);
		ImageIcon changeIcon11 = new ImageIcon(changeImg11);
		Tea4 = new JButton(changeIcon11);
		Tea4.setBounds(220, 212, 151, 151);
		panel_1.add(Tea4);
		Tea4.setVisible(false);	
		Tea4.setText("Tea4");
		Tea4.setBorderPainted(false);
		
		// 페퍼민트 설명
		lblNewLabel_12 = new JLabel("\uD398\uD37C\uBBFC\uD2B8         2500\\");
		lblNewLabel_12.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_12.setBounds(230, 374, 140, 15);
		panel_1.add(lblNewLabel_12);
		lblNewLabel_12.setVisible(false);
		
		// 주문 리스트 메뉴
		table = new JTable(model);
		table.setBounds(27, 285, 452, 219);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		table.setRowHeight(30);
		JScrollPane jscp1 = new JScrollPane(table);
		jscp1.setBounds(31, 410, 339, 169);
		panel_1.add(jscp1);
		jscp1.setVisible(true);
		
		// 메뉴 삭제 버튼
		Menudelete = new JButton("\uBA54\uB274\uC0AD\uC81C");
		Menudelete.setForeground(Color.WHITE);
		Menudelete.setFont(new Font("굴림", Font.BOLD, 14));
		Menudelete.setBackground(Color.BLACK);
		Menudelete.setBounds(264, 599, 107, 46);
		panel_1.add(Menudelete);
		
		// 결제 버튼
		Pay = new JButton("\uACB0\uC81C\uD558\uAE30");
		Pay.setForeground(Color.WHITE);
		Pay.setBackground(Color.BLACK);
		Pay.setFont(new Font("굴림", Font.BOLD, 14));
		Pay.setBounds(264, 657, 107, 46);
		panel_1.add(Pay);
		
		// 메인화면 복귀 버튼
		MainBack = new JButton("<HTML>\uBA54\uC778<br>\uD654\uBA74<HTML>");
		MainBack.setBackground(Color.WHITE);
		MainBack.setForeground(Color.BLACK);
		MainBack.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		MainBack.setBounds(30, 695, 80, 46);
		contentPane.add(MainBack);
					
			
		// 메뉴 삭제 누를 시
		Menudelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						Menudelete();
						}
					}
				);
			
		// 아메리카노 누를 때
		Coffee1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "아메리카노";
				String title = "커피";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
		
		// 에스프레소 누를 때
		Coffee2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "에스프레소";
				String title = "커피";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
		
		// 카페라떼 누를 때
		Coffee3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "카페라떼";
				String title = "커피";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
		
		// 바닐라라떼 누를 때
		Coffee4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "바닐라라떼";
				String title = "커피";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
			
		
		// 레몬에이드 누를 때
		Ade1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "레몬에이드";
				String title = "에이드";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
		
		// 청포도에이드 누를 때
		Ade2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "청포도에이드";
				String title = "에이드";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
				
		// 자몽에이드 누를 때
		Ade3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "자몽에이드";
				String title = "에이드";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
				
		// 체리콕 누를 때
		Ade4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "체리콕";
				String title = "에이드";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
				
		// 아이스티 누를 때
		Tea1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "아이스티";
				String title = "차";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
				
		// 유자차 누를 때
		Tea2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "유자차";
				String title = "차";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
				
		// 캐모마일 누를 때
		Tea3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "캐모마일";
				String title = "차";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
					
		// 페퍼민트 누를 때
		Tea4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "페퍼민트";
				String title = "차";
				if (Menu_list.contains(name) == false) {
					try {
						Menu_Call(name, title);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				else {
						JOptionPane.showMessageDialog(null, "이미 추가된 메뉴입니다.", "!!", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
		);
		
		
		// 커피버튼 누를 때
		CoffeeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coffee1.setVisible(true); Coffee2.setVisible(true); Coffee3.setVisible(true); Coffee4.setVisible(true);
				Ade1.setVisible(false); Ade2.setVisible(false); Ade3.setVisible(false); Ade4.setVisible(false);
				Tea1.setVisible(false); Tea2.setVisible(false); Tea3.setVisible(false); Tea4.setVisible(false);
				lblNewLabel.setVisible(true); lblNewLabel_1.setVisible(true); lblNewLabel_3.setVisible(true); lblNewLabel_4.setVisible(true);
				lblNewLabel_5.setVisible(false); lblNewLabel_6.setVisible(false); lblNewLabel_7.setVisible(false); lblNewLabel_8.setVisible(false);
				lblNewLabel_9.setVisible(false); lblNewLabel_10.setVisible(false); lblNewLabel_11.setVisible(false); lblNewLabel_12.setVisible(false);
				contentPane.repaint();
				CoffeeMenu.setEnabled(false);
				AdeMenu.setEnabled(true);
				TeaMenu.setEnabled(true);
				}
			}
		);	  
					
		// 에이드 버튼 누를 때
		AdeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coffee1.setVisible(false); Coffee2.setVisible(false); Coffee3.setVisible(false); Coffee4.setVisible(false);
				Ade1.setVisible(true); Ade2.setVisible(true); Ade3.setVisible(true); Ade4.setVisible(true);
				Tea1.setVisible(false);	Tea2.setVisible(false); Tea3.setVisible(false); Tea4.setVisible(false);
				lblNewLabel.setVisible(false); lblNewLabel_1.setVisible(false); lblNewLabel_3.setVisible(false); lblNewLabel_4.setVisible(false);
				lblNewLabel_5.setVisible(true); lblNewLabel_6.setVisible(true); lblNewLabel_7.setVisible(true); lblNewLabel_8.setVisible(true);
				lblNewLabel_9.setVisible(false); lblNewLabel_10.setVisible(false); lblNewLabel_11.setVisible(false); lblNewLabel_12.setVisible(false);
				CoffeeMenu.setEnabled(true);
				AdeMenu.setEnabled(false);
				TeaMenu.setEnabled(true);
				contentPane.repaint();			        
				}
			}
		);		
				
		// 차 누를때
		TeaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coffee1.setVisible(false); Coffee2.setVisible(false); Coffee3.setVisible(false); Coffee4.setVisible(false);
				Ade1.setVisible(false); Ade2.setVisible(false); Ade3.setVisible(false); Ade4.setVisible(false);
				Tea1.setVisible(true); Tea2.setVisible(true); Tea3.setVisible(true); Tea4.setVisible(true);
				lblNewLabel.setVisible(false); lblNewLabel_1.setVisible(false); lblNewLabel_3.setVisible(false); lblNewLabel_4.setVisible(false);
				lblNewLabel_5.setVisible(false); lblNewLabel_6.setVisible(false); lblNewLabel_7.setVisible(false); lblNewLabel_8.setVisible(false);
				lblNewLabel_9.setVisible(true); lblNewLabel_10.setVisible(true); lblNewLabel_11.setVisible(true); lblNewLabel_12.setVisible(true);
				CoffeeMenu.setEnabled(true);
				AdeMenu.setEnabled(true);
				TeaMenu.setEnabled(false);
				contentPane.repaint();      
				}
			}
		);
		
		// 결제 버튼 누를 때
		Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Menu_list.size() > 0) {
	                JFrame PayUI = new PayUI(Menu_list, Price);
	                dispose();
	                PayUI.setVisible(true);
	                }
					else JOptionPane.showMessageDialog(null, "메뉴를 추가해주세요!", "!!", JOptionPane.WARNING_MESSAGE);
			}
		});
			
		// 뒤로가기 버튼 누를 때
		MainBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame mainUI = new MainUI();
				mainUI.setVisible(true);
			}
		});
}

// 메뉴 추가 함수
public void Menu_Call(String name, String title) throws SQLException {
	
	Order_DAO dao = new Order_DAO();
	ArrayList<Order_DTO> result = dao.Menu_Order(name, title);
	String row[] = new String[2];
	int temp_price = 0;
	
    for (Order_DTO i : result) {
    	temp_price = i.getPrice();
        row[0] = i.getName();
        row[1] = Integer.toString(temp_price);
        model.addRow(row);
        Menu_list.add(row[0]);
        Price.add(Integer.parseInt(row[1]));
    }
}	

	
// 메뉴 삭제 버튼 누를시
public void Menudelete() {
	int row = table.getSelectedRow();
	
	// 메뉴 선택을 안하고 메뉴를 삭제한 경우
	if (row == -1) {
        JOptionPane.showMessageDialog(null, "메뉴를 선택해주세요!", "삭제", JOptionPane.INFORMATION_MESSAGE);
        return;
	}

	model.removeRow(row);
	Menu_list.remove(row); 
	Price.remove(row); 

}


public static void main(String[] args) {
		OrderUI frame = new OrderUI();
		frame.setVisible(true);
	}
}
