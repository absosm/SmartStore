package com.home;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class ProfileForm extends JFrame {

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
		
		/**
		 * importer profile de l'utilisateur en mettant en class "USER"
		 */
		this.user = user;

		setResizable(false);
		setTitle("Profile de l'utilisateur");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 367);
		contentPane = new JPanel();
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
		btnTerminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
						.addComponent(btnTerminer, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTerminer))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Information personnels", null, panel, null);
		
		tf_identificator1 = new JTextField();
		tf_identificator1.setEditable(false);
		tf_identificator1.setColumns(10);
		
		tf_user1 = new JTextField();
		tf_user1.setEditable(false);
		tf_user1.setColumns(10);
		
		tf_firstname = new JTextField();
		tf_firstname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Identificateur:");
		
		JLabel lblNewLabel_1 = new JLabel("Utilisateur:");
		
		JLabel lblNewLabel_2 = new JLabel("Nom:");
		
		JLabel lblNewLabel_3 = new JLabel("Pr\u00E9nom:");
		
		tf_lastname = new JTextField();
		tf_lastname.setColumns(10);
		
		tf_telephone = new JTextField();
		tf_telephone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Num\u00E9ro t\u00E9l\u00E9phone:");
		
		JButton btnApplerModification = new JButton("Appliquer Modification");
		btnApplerModification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateProfile();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tf_telephone, Alignment.LEADING)
								.addComponent(tf_lastname, Alignment.LEADING)
								.addComponent(tf_firstname, Alignment.LEADING)
								.addComponent(tf_user1, Alignment.LEADING)
								.addComponent(tf_identificator1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnApplerModification, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_identificator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_user1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_firstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(tf_lastname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_telephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addComponent(btnApplerModification)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Securité", null, panel_1, null);
		
		JLabel label = new JLabel("Identificateur:");
		
		JLabel label_1 = new JLabel("Utilisateur:");
		
		tf_identificator2 = new JTextField();
		tf_identificator2.setEditable(false);
		tf_identificator2.setColumns(10);
		
		tf_user2 = new JTextField();
		tf_user2.setEditable(false);
		tf_user2.setColumns(10);
		
		JButton button = new JButton("Appler Modification");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!User.exist(tf_user2.getText(), Encode.sha256(tf_oldpassword.getText()))) {
					JOptionPane.showMessageDialog(null, "ancien mot de passe est incorrect");
					return;
				}
				
				if (!tf_newpassword.getText().equals(tf_confirmpassword.getText())) {
					JOptionPane.showMessageDialog(null, "les deux mots passes pas identique.");
					return;
				}
				
				Session.getUser().setPassword(Encode.sha256(tf_newpassword.getText()));
				if (Session.getUser().update()) {
					JOptionPane.showMessageDialog(null, "changement de mot passe est succès.");
				}else {
					JOptionPane.showMessageDialog(null, "pardon, changement de mot passe pas en cours.");
				}
			}
		});
		
		tf_oldpassword = new JPasswordField();
		
		tf_newpassword = new JPasswordField();
		
		JLabel lblMotDePasse = new JLabel("Ancien mot de passe:");
		
		tf_confirmpassword = new JPasswordField();
		
		JLabel lblNouveauMotDe = new JLabel("Nouveau mot de passe:");
		
		JLabel lblConfirmezMotDe = new JLabel("Confirmez mot de passe:");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNouveauMotDe)
								.addComponent(lblMotDePasse)
								.addComponent(lblConfirmezMotDe)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(tf_identificator2, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
								.addComponent(tf_user2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
								.addComponent(tf_confirmpassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
								.addComponent(tf_newpassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
								.addComponent(tf_oldpassword, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_identificator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_user2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_oldpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMotDePasse))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_newpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNouveauMotDe))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_confirmpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmezMotDe))
					.addGap(26)
					.addComponent(button)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
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
