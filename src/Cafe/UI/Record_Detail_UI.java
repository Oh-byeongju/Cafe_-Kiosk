package Cafe.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Record_Detail_UI extends JFrame {

	private JPanel contentPane;
	JPanel Menu_Scroll = new JPanel();
	JScrollPane scroll;
	int arr_cnt = 0;
	int flag = 0;
	JLabel[] Count = new JLabel[100];
	int arr[] = new int[100];
	static int Sum = 0;
	GridBagConstraints gbc = new GridBagConstraints();
	GridBagLayout grid = new GridBagLayout();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	public Record_Detail_UI(ArrayList<String> temp_Array) {
		
		int size = temp_Array.size();
		String[] Array = temp_Array.toArray(new String[size]);
		
		JLabel[] Seq = new JLabel[size];
		JLabel[] name = new JLabel[size];
		JLabel[] total = new JLabel[size];
		JLabel[] price = new JLabel[size];
		
		setTitle("세부내역");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 200, 395, 291);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 357, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("주문번호");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel.setBounds(15, 20, 69, 27);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("메뉴이름");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel_1.setBounds(98, 23, 69, 21);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("주문횟수");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel_2.setBounds(190, 21, 75, 24);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("가격");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel_3.setBounds(280, 21, 38, 24);
		panel.add(lblNewLabel_3);
		Menu_Scroll.setBackground(SystemColor.menu);
		
		Menu_Scroll.setBounds(0, 0, 395, 302);
		Menu_Scroll.setLayout(grid);
		
		JScrollPane scrollPane = new JScrollPane(Menu_Scroll);
		scrollPane.setBounds(12, 57, 335, 162);
		panel.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(390, 300));
		
		for (int i = 0; i < size/4; i++) {
			Seq[i] = new JLabel(Array[i*4]);
			Seq[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
			make(Seq[i], 10, i, 1, 1);
			Seq[i].setBorder(BorderFactory.createEmptyBorder(12, 10 , 20 , 0));

			name[i] = new JLabel(Array[1+(i*4)]);
			name[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
			make(name[i], 20, i, 1, 1);
			name[i].setBorder(BorderFactory.createEmptyBorder(12, 15 , 20 , 0));
			
			total[i] = new JLabel(Array[2+(i*4)]);
			total[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
			make(total[i], 30, i, 1, 1);
			total[i].setBorder(BorderFactory.createEmptyBorder(12, 15 , 20 , 0));
			
			price[i] = new JLabel(Array[3+(i*4)]);
			price[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
			make(price[i], 40, i, 1, 1);
			price[i].setBorder(BorderFactory.createEmptyBorder(12, 20 , 20 , 0));
			
			Menu_Scroll.add(Seq[i]);
			Menu_Scroll.add(name[i]);
			Menu_Scroll.add(total[i]);
			Menu_Scroll.add(price[i]);
				
		}
	}
	
	public void make(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		grid.setConstraints(c, gbc);
	}
}
