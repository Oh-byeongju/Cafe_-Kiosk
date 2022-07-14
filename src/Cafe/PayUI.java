package Cafe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.w3c.dom.css.RGBColor;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.border.*;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

public class PayUI extends JFrame {

	private JPanel contentPane;
	static JPanel Menu_Scroll = new JPanel();
	static JScrollPane scroll;
	int arr_cnt = 0;
	int flag = 0;
	JLabel[] Count = new JLabel[100];
	int arr[] = new int[100];
	static int Sum = 0;
	GridBagConstraints gbc = new GridBagConstraints();
	GridBagLayout grid = new GridBagLayout();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(ArrayList<String> Menu_Name, ArrayList<Integer> Price) {
				try {
					PayUI frame = new PayUI(Menu_Name, Price);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		});
	}

	public PayUI(ArrayList<String> Menu_Name, ArrayList<Integer> Price) {

		int Size = Menu_Name.size();

		JPanel[] Menu = new JPanel[Size];
		JLabel[] Name = new JLabel[Size];
		JLabel[] Pr = new JLabel[Size];
		JButton[] up = new JButton[Size];
		JButton[] down = new JButton[Size];

		setTitle("\uACB0\uC81C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 451, 480);

		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Menu_Scroll.setBackground(SystemColor.menu);

		Menu_Scroll.setBounds(0, 0, 395, 302);
		Menu_Scroll.setLayout(grid);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		JScrollPane scrollPane = new JScrollPane(Menu_Scroll);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setLocation(24, 21);
		scrollPane.setSize(397, 302);
		scrollPane.setPreferredSize(new Dimension(390, 300));
		contentPane.add(scrollPane);

		JLabel Sum_Price = new JLabel();
		Sum_Price.setForeground(Color.WHITE);
		Sum_Price.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Sum_Price.setBounds(377, 340, 59, 23);
		contentPane.add(Sum_Price);

		// int Plus = 10;

		for (int i = 0; i < Size; i++) {
			arr[i] = 1;
			Sum = Sum + (Price.get(i) * arr[i]);
			Name[i] = new JLabel(Menu_Name.get(i));
			Name[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
			// Name[i].setSize(187, 44);
			make(Name[i], 0, i, 1, 1);

			Pr[i] = new JLabel(Integer.toString(Price.get(i)));
			Pr[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
			// Pr[i].setSize(50, 50);
			make(Pr[i], 1, i, 1, 1);

			
			up[i] = new JButton("\u25B2");
			up[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
			up[i].setBackground(SystemColor.menu);
			up[i].setBorderPainted(false);
			// up[i].setSize(45, 45);
			make(up[i], 2, i, 1, 1);

			Count[i] = new JLabel(Integer.toString(arr[i]));
			Count[i].setFont(new Font("맑은고딕", Font.BOLD, 23));
			Count[i].setHorizontalAlignment(SwingConstants.CENTER);
			// Count[i].setSize(45, 45);
			make(Count[i], 3, i, 1, 1);

			down[i] = new JButton("\u25BC");
			down[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
			down[i].setBackground(SystemColor.menu);
			down[i].setBorderPainted(false);
			// down[i].setSize(45, 45);
			make(down[i], 4, i, 1, 1);

			Menu_Scroll.add(Name[i]);
			Menu_Scroll.add(Pr[i]);
			Menu_Scroll.add(up[i]);
			Menu_Scroll.add(Count[i]);
			Menu_Scroll.add(down[i]);
			// Plus += 44;
		}

		scrollPane.setViewportView(Menu_Scroll);
		Sum_Price.setText(Integer.toString(Sum));

		for (int i = 0; i < Size; i++) {

			up[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < Size; i++) {
						if (up[i].equals(e.getSource())) {
							arr[i]++;
							Count[i].setText(Integer.toString(arr[i]));
							Sum = Sum + Price.get(i);
							Sum_Price.setText(Integer.toString(Sum));
						}
					}
				}
			});

		}

		for (int i = 0; i < Size; i++) {

			down[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < Size; i++) {
						if (down[i].equals(e.getSource())) {
							if (arr[i] > 0) {
								arr[i]--;
								Count[i].setText(Integer.toString(arr[i]));
								Sum = Sum - Price.get(i);
								Sum_Price.setText(Integer.toString(Sum));
							}
						}
					}
				}
			});
		}

		JButton btnNewButton = new JButton("\uACB0\uC81C");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton.setBounds(325, 383, 100, 48);
		contentPane.add(btnNewButton);

		ButtonGroup Group = new ButtonGroup();
		JRadioButton takeout = new JRadioButton("\uD3EC\uC7A5");
		takeout.setForeground(Color.WHITE);
		takeout.setBackground(Color.BLACK);
		takeout.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		takeout.setBounds(258, 383, 59, 23);
		contentPane.add(takeout);
		Group.add(takeout);
		JRadioButton hall = new JRadioButton("\uB9E4\uC7A5");
		hall.setForeground(Color.WHITE);
		hall.setBackground(Color.BLACK);
		hall.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		hall.setBounds(258, 408, 59, 23);
		contentPane.add(hall);
		Group.add(hall);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (takeout.isSelected() || hall.isSelected()) {
					JOptionPane.showMessageDialog(null, "카드를 삽입해주세요", "결제", JOptionPane.INFORMATION_MESSAGE);
				}
				else JOptionPane.showMessageDialog(null, "매장 식사, 포장을 선택해주세요!", "결제", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JButton back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back.setBackground(Color.WHITE);
		back.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "주문기록이 삭제됩니다.", "주문취소", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					Menu_Name.clear();
					Price.clear();
					Menu_Scroll.removeAll();
					dispose();
					JFrame OrderUI = new OrderUI();
					OrderUI.setVisible(true);
					Sum = 0;
				}
			}

		});
		back.setBounds(12, 383, 100, 48);
		contentPane.add(back);

		JLabel lblNewLabel = new JLabel("\uCD1D \\");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setBounds(335, 341, 53, 21);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 416, 324);
		contentPane.add(panel);

	}

	public void make(JComponent c, int x, int y, int w, int h) {

		gbc.gridx = x;

		gbc.gridy = y;

		gbc.gridwidth = w;

		gbc.gridheight = h;

		grid.setConstraints(c, gbc);

	}
}