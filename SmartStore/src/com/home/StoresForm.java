package com.home;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class StoresForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfname;
	private JTextField tfaddress;
	private JTextField tfzip;
	private JComboBox<String> tfwilaya;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the frame.
	 */
	public StoresForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StoresForm.class.getResource("/images/STORE.png")));
		setTitle("D\u00E9p\u00F4ts");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 405);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLUE);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {tabbedPane, panel});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("G\u00E9n\u00E9rale  ", new ImageIcon(StoresForm.class.getResource("/images/Download-Folder-icon.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("D\u00E9signation");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, 6, 79, 30);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adresse");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(0, 42, 79, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Commune");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(255, 78, 79, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblWilaya = new JLabel("Wilaya");
		lblWilaya.setForeground(Color.BLUE);
		lblWilaya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWilaya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWilaya.setBounds(0, 78, 79, 30);
		panel_1.add(lblWilaya);
		
		JLabel lblCodePostale = new JLabel("Code postale");
		lblCodePostale.setForeground(Color.BLUE);
		lblCodePostale.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodePostale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodePostale.setBounds(326, 42, 79, 30);
		panel_1.add(lblCodePostale);
		
		JLabel lblNewLabel_3 = new JLabel("Mob");
		lblNewLabel_3.setIcon(new ImageIcon(StoresForm.class.getResource("/images/Mobile-icon.png")));
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(0, 114, 79, 30);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TEL");
		lblNewLabel_4.setIcon(new ImageIcon(StoresForm.class.getResource("/images/phone-icon.png")));
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(0, 150, 79, 30);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FAX");
		lblNewLabel_5.setIcon(new ImageIcon(StoresForm.class.getResource("/images/Fax-icon.png")));
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(0, 186, 79, 30);
		panel_1.add(lblNewLabel_5);
		
		tfname = new JTextField();
		tfname.setBounds(87, 6, 393, 30);
		tfname.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_1.add(tfname);
		tfname.setColumns(10);
		
		tfaddress = new JTextField();
		tfaddress.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfaddress.setBounds(87, 42, 226, 30);
		panel_1.add(tfaddress);
		tfaddress.setColumns(10);
		
		tfzip = new JTextField();
		tfzip.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfzip.setBounds(413, 42, 67, 30);
		panel_1.add(tfzip);
		tfzip.setColumns(10);
		
		tfwilaya = new JComboBox<String>();
		tfwilaya.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfwilaya.setBounds(87, 78, 139, 30);
		panel_1.add(tfwilaya);
		
		textField_4 = new JTextField();
		textField_4.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_4.setBounds(87, 114, 163, 30);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_5.setBounds(87, 150, 163, 30);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_6.setBounds(87, 186, 163, 30);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBorder(new LineBorder(new Color(30, 144, 255)));
		comboBox.setBounds(341, 78, 139, 30);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Royonnage", new ImageIcon(StoresForm.class.getResource("/images/shelf.png")), panel_2, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(77, 5, 131, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnNewButton_1.setBounds(285, 5, 131, 30);
		panel.add(btnNewButton_1);
		contentPane.setLayout(gl_contentPane);
	}
}
