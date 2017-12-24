package com.home.formes;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.home.Session;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.UIManager;

public class ConfigurationForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_18;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;

	/**
	 * Create the frame.
	 */
	public ConfigurationForm() {
		setBackground(Color.WHITE);
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		setResizable(false);
		setTitle("Configuration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 771, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setForeground(Color.BLUE);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 755, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 433, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(667, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Configuration Bon de livraison", null, panel, null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(Color.BLUE);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255), 1, true), "Ent\u00EAte de page de bon de livraison", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 14), new Color(0, 0, 255)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images/logo.png"));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(Color.BLUE);
		lblNewLabel_4.setIcon(new ImageIcon(dimg));
		panel_7.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_11.setBackground(null);
		panel_11.setBounds(10, 29, 513, 145);
		panel_7.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel label_10 = new JLabel("Nom ou raison social:");
		label_10.setForeground(Color.BLUE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_10.setBounds(12, 12, 130, 17);
		panel_11.add(label_10);
		
		textField = new JTextField();
		textField.setForeground(Color.BLUE);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField.setBounds(152, 6, 351, 28);
		panel_11.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLUE);
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_1.setBounds(152, 40, 351, 28);
		panel_11.add(textField_1);
		
		JLabel label_11 = new JLabel("Info 1:");
		label_11.setForeground(Color.BLUE);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(101, 46, 41, 17);
		panel_11.add(label_11);
		
		JLabel label_12 = new JLabel("Info 2:");
		label_12.setForeground(Color.BLUE);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setBounds(101, 80, 41, 17);
		panel_11.add(label_12);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLUE);
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_2.setBounds(152, 74, 351, 28);
		panel_11.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLUE);
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_3.setBounds(152, 108, 351, 28);
		panel_11.add(textField_3);
		
		JLabel label_13 = new JLabel("Info 3:");
		label_13.setForeground(Color.BLUE);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_13.setBounds(101, 114, 41, 17);
		panel_11.add(label_13);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(null);
		panel_8.setBounds(10, 174, 513, 221);
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.setBounds(10, 10, 183, 200);
		panel_8.add(panel_12);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOpaque(false);
		
		JLabel label_14 = new JLabel("");
		label_14.setBackground(Color.YELLOW);
		GroupLayout gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12.setHorizontalGroup(
			gl_panel_12.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 183, Short.MAX_VALUE)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_14, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_12.setVerticalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGap(0, 200, Short.MAX_VALUE)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_14, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ConfigurationForm.class.getResource("/images/add.png")));
		toolBar.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(ConfigurationForm.class.getResource("/images/delete.png")));
		toolBar.add(button_1);
		panel_12.setLayout(gl_panel_12);
		
		JLabel label_15 = new JLabel("New label");
		label_15.setForeground(Color.BLUE);
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_15.setBounds(203, 3, 56, 17);
		panel_8.add(label_15);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLUE);
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_4.setBounds(203, 23, 167, 28);
		panel_8.add(textField_4);
		
		JLabel label_16 = new JLabel("New label");
		label_16.setForeground(Color.BLUE);
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_16.setBounds(203, 54, 56, 17);
		panel_8.add(label_16);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.BLUE);
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_5.setBounds(203, 74, 167, 28);
		panel_8.add(textField_5);
		
		JLabel label_17 = new JLabel("New label");
		label_17.setForeground(Color.BLUE);
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_17.setBounds(203, 105, 56, 17);
		panel_8.add(label_17);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_6.setBounds(203, 125, 300, 28);
		panel_8.add(textField_6);
		
		JLabel label_18 = new JLabel("New label");
		label_18.setForeground(Color.BLUE);
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_18.setBounds(203, 163, 56, 17);
		panel_8.add(label_18);
		
		JLabel label_19 = new JLabel("New label");
		label_19.setForeground(Color.BLUE);
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_19.setBounds(203, 196, 56, 17);
		panel_8.add(label_19);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setForeground(Color.BLUE);
		comboBox.setBorder(new LineBorder(new Color(30, 144, 255)));
		comboBox.setBounds(269, 156, 234, 30);
		panel_8.add(comboBox);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setForeground(Color.BLUE);
		comboBox_1.setBorder(new LineBorder(new Color(30, 144, 255)));
		comboBox_1.setBounds(269, 189, 234, 30);
		panel_8.add(comboBox_1);
		
		textField_7 = new JTextField();
		textField_7.setForeground(Color.BLUE);
		textField_7.setColumns(10);
		textField_7.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_7.setBounds(388, 74, 115, 28);
		panel_8.add(textField_7);
		
		JLabel label_20 = new JLabel("New label");
		label_20.setForeground(Color.BLUE);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_20.setBounds(388, 54, 56, 17);
		panel_8.add(label_20);
		
		textField_8 = new JTextField();
		textField_8.setForeground(Color.BLUE);
		textField_8.setColumns(10);
		textField_8.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_8.setBounds(388, 23, 115, 28);
		panel_8.add(textField_8);
		
		JLabel label_21 = new JLabel("New label");
		label_21.setForeground(Color.BLUE);
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_21.setBounds(388, 3, 56, 17);
		panel_8.add(label_21);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Configuration du facture", null, panel_2, null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setBackground(Color.WHITE);
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ent\u00EAte de page de bon de livraison", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 14), Color.BLUE));
		
		JPanel panel_13 = new JPanel();
		panel_13.setOpaque(false);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_9.createSequentialGroup()
							.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
							.addGap(8))))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		panel_10.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setOpaque(false);
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_14.setBounds(0, 0, 183, 200);
		panel_10.add(panel_14);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setOpaque(false);
		
		JLabel label_4 = new JLabel("");
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(
			gl_panel_14.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 183, Short.MAX_VALUE)
				.addComponent(toolBar_1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_14.setVerticalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGap(0, 200, Short.MAX_VALUE)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button_2.setIcon(new ImageIcon(ConfigurationForm.class.getResource("/images/add.png")));
		toolBar_1.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(ConfigurationForm.class.getResource("/images/delete.png")));
		toolBar_1.add(button_3);
		panel_14.setLayout(gl_panel_14);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(193, 0, 56, 17);
		panel_10.add(label_5);
		
		textField_13 = new JTextField();
		textField_13.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_13.setForeground(Color.BLUE);
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_13.setColumns(10);
		textField_13.setBounds(193, 23, 167, 23);
		panel_10.add(textField_13);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(193, 52, 56, 17);
		panel_10.add(label_6);
		
		textField_14 = new JTextField();
		textField_14.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_14.setForeground(Color.BLUE);
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_14.setColumns(10);
		textField_14.setBounds(193, 73, 167, 23);
		panel_10.add(textField_14);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(193, 111, 56, 17);
		panel_10.add(label_7);
		
		textField_15 = new JTextField();
		textField_15.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_15.setForeground(Color.BLUE);
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_15.setColumns(10);
		textField_15.setBounds(193, 134, 295, 23);
		panel_10.add(textField_15);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(378, 0, 56, 17);
		panel_10.add(label_8);
		
		textField_16 = new JTextField();
		textField_16.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_16.setForeground(Color.BLUE);
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_16.setColumns(10);
		textField_16.setBounds(378, 23, 110, 23);
		panel_10.add(textField_16);
		
		JLabel label_9 = new JLabel("New label");
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(378, 52, 56, 17);
		panel_10.add(label_9);
		
		textField_17 = new JTextField();
		textField_17.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField_17.setForeground(Color.BLUE);
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_17.setColumns(10);
		textField_17.setBounds(378, 73, 110, 23);
		panel_10.add(textField_17);
		panel_13.setLayout(null);
		
		JLabel label = new JLabel("Nom ou raison social:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(0, 8, 130, 17);
		panel_13.add(label);
		
		textField_9 = new JTextField();
		textField_9.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		textField_9.setForeground(Color.BLUE);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(140, 2, 341, 28);
		panel_13.add(textField_9);
		
		JLabel label_1 = new JLabel("Info 1:");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(89, 38, 41, 17);
		panel_13.add(label_1);
		
		textField_10 = new JTextField();
		textField_10.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		textField_10.setForeground(Color.BLUE);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_10.setColumns(10);
		textField_10.setBounds(140, 32, 341, 28);
		panel_13.add(textField_10);
		
		JLabel label_2 = new JLabel("Info 2:");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(89, 68, 41, 17);
		panel_13.add(label_2);
		
		textField_11 = new JTextField();
		textField_11.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		textField_11.setForeground(Color.BLUE);
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_11.setColumns(10);
		textField_11.setBounds(140, 62, 341, 28);
		panel_13.add(textField_11);
		
		JLabel label_3 = new JLabel("Info 3:");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(89, 98, 41, 17);
		panel_13.add(label_3);
		
		textField_12 = new JTextField();
		textField_12.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		textField_12.setForeground(Color.BLUE);
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_12.setColumns(10);
		textField_12.setBounds(140, 92, 341, 28);
		panel_13.add(textField_12);
		
		JLabel label_22 = new JLabel("New label");
		label_22.setForeground(Color.BLUE);
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_22.setBounds(74, 128, 56, 17);
		panel_13.add(label_22);
		
		textField_18 = new JTextField();
		textField_18.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
		textField_18.setForeground(Color.BLUE);
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_18.setColumns(10);
		textField_18.setBounds(140, 122, 130, 28);
		panel_13.add(textField_18);
		panel_9.setLayout(gl_panel_9);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Affichage", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		tabbedPane.addTab("Divers", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		tabbedPane.addTab("Impression", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		tabbedPane.addTab("Bases des donneés", null, panel_6, null);
		contentPane.setLayout(gl_contentPane);

		setLocationRelativeTo(null);
	}
}
