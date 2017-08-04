package com.home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Window.Type;

public class Authentification {

	private JFrame frmAuthentification;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtLocalhost;
	private JTextField txtSmartstore;
	private JTextField txtRoot;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification window = new Authentification();
					window.frmAuthentification.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Authentification() {
		/**
		 * permet de sauvgarde thème de système.
		 */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuthentification = new JFrame();
		frmAuthentification.setType(Type.UTILITY);
		frmAuthentification.setResizable(false);
		frmAuthentification.setTitle("Authentification");
		frmAuthentification.setBounds(100, 100, 450, 337);
		frmAuthentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * centraliser le fenètre
		 */
		frmAuthentification.setLocationRelativeTo(null);
		
		/**
		 * icon de programme
		 */
		
		URL iconURL = getClass().getResource("/images/favicon.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		frmAuthentification.setIconImage(icon.getImage());
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_2 = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frmAuthentification.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(tabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JButton btnTerminer = new JButton("Terminer");
		btnTerminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAuthentification.dispose();
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(339, Short.MAX_VALUE)
					.addComponent(btnTerminer, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(btnTerminer)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Connexion", null, panel_1, null);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur:");
		
		JLabel lblMotDePasse = new JLabel("Mot de passe:");
		
		passwordField = new JPasswordField();
		
		JCheckBox chckbxSouvenirLeMot = new JCheckBox("Souvenir le mot passe");
		
		JButton btnConnexion = new JButton("Connexion");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(28, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUtilisateur)
								.addComponent(lblMotDePasse))
							.addGap(4)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
								.addComponent(chckbxSouvenirLeMot)))
						.addComponent(btnConnexion, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUtilisateur))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblMotDePasse))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxSouvenirLeMot)
					.addGap(12)
					.addComponent(btnConnexion)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Option", null, panel_3, null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MySQL"}));
		
		JLabel lblNewLabel = new JLabel("Moteur de base:");
		
		txtLocalhost = new JTextField();
		txtLocalhost.setText("localhost");
		txtLocalhost.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Serveur:");
		
		txtSmartstore = new JTextField();
		txtSmartstore.setText("smart_store");
		txtSmartstore.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom de base:");
		
		txtRoot = new JTextField();
		txtRoot.setText("root");
		txtRoot.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Utilisateur:");
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		
		passwordField_1 = new JPasswordField();
		
		JButton btnNewButton = new JButton("Enregistrer");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(txtRoot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
								.addComponent(txtLocalhost, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 313, Short.MAX_VALUE)
								.addComponent(txtSmartstore, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addContainerGap(310, Short.MAX_VALUE)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLocalhost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSmartstore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRoot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		frmAuthentification.getContentPane().setLayout(groupLayout);
	}
}
