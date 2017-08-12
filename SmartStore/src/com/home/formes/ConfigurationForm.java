package com.home.formes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JComboBox;

public class ConfigurationForm extends JFrame {

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
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurationForm frame = new ConfigurationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConfigurationForm() {
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		setResizable(false);
		setTitle("Configuration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 771, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 753, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(688, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Configuration Bon de livraison", null, panel, null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Ent\u00EAte de page de bon de livraison", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Nom ou raison social:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Info 1:");
		
		JLabel lblNewLabel_2 = new JLabel("Info 2:");
		
		JLabel lblNewLabel_3 = new JLabel("Info 3:");
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images/logo.png"));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		JLabel image_logo = new JLabel("");
		image_logo.setBackground(Color.YELLOW);
		image_logo.setIcon(new ImageIcon(dimg));
		
		JSeparator separator = new JSeparator();
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		
		JComboBox comboBox_1 = new JComboBox();
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_7.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textField_6, Alignment.LEADING)
									.addComponent(textField_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_7))
							.addGap(18)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_8)
								.addComponent(lblNewLabel_6)
								.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
						.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
						.addComponent(lblNewLabel_9)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_10)
								.addComponent(lblNewLabel_11))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_1, 0, 282, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 282, Short.MAX_VALUE))))
					.addGap(18))
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(121)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_8))
							.addGap(4)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(15)
							.addComponent(lblNewLabel_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_10))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_11))))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(Color.BLUE);
		lblNewLabel_4.setIcon(new ImageIcon(dimg));
		
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(image_logo, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(image_logo, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ConfigurationForm.class.getResource("/images/add.png")));
		toolBar.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(ConfigurationForm.class.getResource("/images/delete.png")));
		toolBar.add(button_1);
		panel_8.setLayout(gl_panel_8);
		panel_7.setLayout(gl_panel_7);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Configuration du facture", null, panel_2, null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Ent\u00EAte de page de bon de livraison", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("Nom ou raison social:");
		
		JLabel label_1 = new JLabel("Info 1:");
		
		JLabel label_2 = new JLabel("Info 2:");
		
		JLabel label_3 = new JLabel("Info 3:");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		BufferedImage img1 = null;
		try {
		    img1 = ImageIO.read(new File("images/logo.png"));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		Image dimg1 = img1.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		JLabel label_4 = new JLabel("");
		label_4.setBackground(Color.YELLOW);
		label_4.setIcon(new ImageIcon(dimg1));
		
		
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 183, Short.MAX_VALUE)
				.addComponent(toolBar_1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGap(0, 200, Short.MAX_VALUE)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(ConfigurationForm.class.getResource("/images/add.png")));
		toolBar_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(ConfigurationForm.class.getResource("/images/delete.png")));
		toolBar_1.add(btnNewButton_2);
		panel_10.setLayout(gl_panel_10);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		
		JLabel label_5 = new JLabel("New label");
		
		JLabel label_6 = new JLabel("New label");
		
		JLabel label_7 = new JLabel("New label");
		
		JLabel label_8 = new JLabel("New label");
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		
		JLabel label_9 = new JLabel("New label");
		
		JSeparator separator_1 = new JSeparator();
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGap(0, 571, Short.MAX_VALUE)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_9.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textField_13, Alignment.LEADING)
									.addComponent(textField_14, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_5)
								.addComponent(label_6))
							.addGap(18)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(label_7)
								.addComponent(label_8)
								.addComponent(textField_15, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(textField_16, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
						.addComponent(textField_17, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
						.addComponent(label_9))
					.addGap(18))
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(lblNewLabel_12))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
								.addComponent(textField_10, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
								.addComponent(textField_11, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
								.addComponent(textField_12, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
							.addGap(10))))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_12))
					.addGap(9)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5)
								.addComponent(label_8))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_6)
								.addComponent(label_7))
							.addGap(4)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(15)
							.addComponent(label_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Affichage", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Divers", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Impression", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Bases des donneés", null, panel_6, null);
		contentPane.setLayout(gl_contentPane);

		setLocationRelativeTo(null);
	}
}
