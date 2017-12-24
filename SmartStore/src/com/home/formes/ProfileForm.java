package com.home.formes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.home.Encode;
import com.home.Session;
import com.home.User;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class ProfileForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tf_identificator1;
	private JTextField tf_user1;
	private JTextField tf_firstname;
	private JTextField tf_lastname;
	private JTextField tf_telephone;
	private JTextField tf_identificator2;
	private JTextField tf_user2;
	private JPasswordField tf_oldpassword;
	private JPasswordField tf_newpassword;
	private JPasswordField tf_confirmpassword;
	private User user;

	/**
	 * Create the frame.
	 */
	public ProfileForm(User user) {
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		/**
		 * importer profile de l'utilisateur en mettant en class "USER"
		 */
		this.user = user;

		setResizable(false);
		setTitle("Profile de l'utilisateur");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 392);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**
		 * centraliser fenètre
		 */
		setLocationRelativeTo(null);
		
		/**
		 * icon de programme
		 */
		URL iconURL = getClass().getResource("/images/favicon.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		
		JButton btnTerminer = new JButton("Fermer");
		btnTerminer.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnTerminer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTerminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLUE);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnTerminer, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTerminer, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		tabbedPane.addTab("Information personnels", null, panel, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Identificateur:");
		lblNewLabel.setBounds(69, 12, 84, 17);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_identificator1 = new JTextField();
		tf_identificator1.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_identificator1.setBounds(163, 9, 295, 23);
		panel_2.add(tf_identificator1);
		tf_identificator1.setForeground(Color.BLUE);
		tf_identificator1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_identificator1.setEditable(false);
		tf_identificator1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Utilisateur:");
		lblNewLabel_1.setBounds(90, 44, 63, 17);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_user1 = new JTextField();
		tf_user1.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_user1.setBounds(163, 41, 295, 23);
		panel_2.add(tf_user1);
		tf_user1.setForeground(Color.BLUE);
		tf_user1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_user1.setEditable(false);
		tf_user1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom:");
		lblNewLabel_2.setBounds(119, 76, 34, 17);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_firstname = new JTextField();
		tf_firstname.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_firstname.setBounds(163, 73, 295, 23);
		panel_2.add(tf_firstname);
		tf_firstname.setForeground(Color.BLUE);
		tf_firstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_firstname.setColumns(10);
		
		tf_lastname = new JTextField();
		tf_lastname.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_lastname.setBounds(163, 105, 295, 23);
		panel_2.add(tf_lastname);
		tf_lastname.setForeground(Color.BLUE);
		tf_lastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_lastname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Pr\u00E9nom:");
		lblNewLabel_3.setBounds(100, 108, 53, 17);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Num\u00E9ro t\u00E9l\u00E9phone:");
		lblNewLabel_4.setBounds(35, 140, 118, 17);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_telephone = new JTextField();
		tf_telephone.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_telephone.setBounds(163, 137, 295, 23);
		panel_2.add(tf_telephone);
		tf_telephone.setForeground(Color.BLUE);
		tf_telephone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_telephone.setColumns(10);
		
		JButton btnApplerModification = new JButton("Appliquer Modification");
		btnApplerModification.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnApplerModification.setBounds(295, 169, 163, 25);
		panel_2.add(btnApplerModification);
		btnApplerModification.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		btnApplerModification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateProfile();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		tabbedPane.addTab("Securité", null, panel_1, null);
		
		JButton button = new JButton("Appler Modification");
		button.setBorder(new LineBorder(new Color(0, 0, 0)));
		button.setBounds(333, 219, 145, 25);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String old = new String(tf_oldpassword.getPassword());
				String new_p = new String(tf_newpassword.getPassword());
				String conf_p = new String(tf_confirmpassword.getPassword());
				
				if (!User.exist(tf_user2.getText(), Encode.sha256(old))) {
					JOptionPane.showMessageDialog(null, "ancien mot de passe est incorrect");
					return;
				}
				
				if (!new_p.equals(conf_p)) {
					JOptionPane.showMessageDialog(null, "les deux mots passes pas identique.");
					return;
				}
				
				Session.getUser().setPassword(Encode.sha256(new_p));
				if (Session.getUser().update()) {
					JOptionPane.showMessageDialog(null, "changement de mot passe est succès.");
					Session.Disconnect();
				}else {
					JOptionPane.showMessageDialog(null, "pardon, changement de mot passe pas en cours.");
				}
			}
		});
		panel_1.setLayout(null);
		panel_1.add(button);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBounds(10, 11, 468, 77);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("Identificateur:");
		label.setForeground(Color.BLUE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(68, 15, 84, 14);
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("Utilisateur:");
		label_1.setForeground(Color.BLUE);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(83, 46, 69, 14);
		panel_3.add(label_1);
		
		tf_user2 = new JTextField();
		tf_user2.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_user2.setForeground(Color.BLUE);
		tf_user2.setBounds(162, 42, 306, 23);
		panel_3.add(tf_user2);
		tf_user2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_user2.setEditable(false);
		tf_user2.setColumns(10);
		
		tf_identificator2 = new JTextField();
		tf_identificator2.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_identificator2.setForeground(Color.BLUE);
		tf_identificator2.setBounds(162, 11, 306, 23);
		panel_3.add(tf_identificator2);
		tf_identificator2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_identificator2.setEditable(false);
		tf_identificator2.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBounds(10, 99, 468, 109);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblMotDePasse = new JLabel("Ancien mot de passe:");
		lblMotDePasse.setForeground(Color.BLUE);
		lblMotDePasse.setBounds(21, 14, 131, 17);
		panel_4.add(lblMotDePasse);
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_oldpassword = new JPasswordField();
		tf_oldpassword.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_oldpassword.setForeground(Color.BLUE);
		tf_oldpassword.setBounds(162, 11, 306, 23);
		panel_4.add(tf_oldpassword);
		tf_oldpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_newpassword = new JPasswordField();
		tf_newpassword.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_newpassword.setForeground(Color.BLUE);
		tf_newpassword.setBounds(162, 40, 306, 23);
		panel_4.add(tf_newpassword);
		tf_newpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNouveauMotDe = new JLabel("Nouveau mot de passe:");
		lblNouveauMotDe.setForeground(Color.BLUE);
		lblNouveauMotDe.setBounds(6, 43, 146, 17);
		panel_4.add(lblNouveauMotDe);
		lblNouveauMotDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblConfirmezMotDe = new JLabel("Confirmez mot de passe:");
		lblConfirmezMotDe.setForeground(Color.BLUE);
		lblConfirmezMotDe.setBounds(0, 72, 152, 17);
		panel_4.add(lblConfirmezMotDe);
		lblConfirmezMotDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_confirmpassword = new JPasswordField();
		tf_confirmpassword.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_confirmpassword.setForeground(Color.BLUE);
		tf_confirmpassword.setBounds(162, 69, 306, 23);
		panel_4.add(tf_confirmpassword);
		tf_confirmpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setLayout(gl_contentPane);
		
		/**
		 * importer profile de l'utilisateur et affecter en dedans champs saisies
		 */
		LoadProfile();
	}
	
	public void LoadProfile() {
		tf_identificator1.setText(user.getId()+"");
		tf_identificator2.setText(user.getId()+"");
		tf_user1.setText(user.getUsername());
		tf_user2.setText(user.getUsername());
		tf_firstname.setText(user.getFirstname());
		tf_lastname.setText(user.getLastname());
		tf_telephone.setText(user.getTelephone());
	}
	
	public void UpdateProfile() {
		
		user.setFirstname(tf_firstname.getText());
		user.setLastname(tf_lastname.getText());
		user.setTelephone(tf_telephone.getText());
		if (user.update()) {
			JOptionPane.showMessageDialog(null, "l'opération est effecter.");
		} else {
			JOptionPane.showMessageDialog(null, "Aucun opération est effecter.");
		}
	}
}
