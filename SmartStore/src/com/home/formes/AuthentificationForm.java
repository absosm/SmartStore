package com.home.formes;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Base64;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import com.home.Configuration;
import com.home.DataBase;
import com.home.Encode;
import com.home.Session;
import com.home.User;

import java.awt.Color;
import java.awt.Font;

public class AuthentificationForm {

	private JFrame frmAuthentification;
	private JTextField tf_login;
	private JPasswordField tf_loginpassword;
	private JTextField tf_host;
	private JTextField tf_dbname;
	private JTextField tf_username;
	private JPasswordField tf_password;
	private JComboBox<Object> cb_driver;
	private JCheckBox chk_remember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/**
					 * permet de sauvgarde thème de système.
					 */
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AuthentificationForm window = new AuthentificationForm();
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
	public AuthentificationForm() {
		Configuration.initialize();
		Configuration.Load();
		initialize();
		Session.setForm(Session.AUTHENTIFICATION, frmAuthentification);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAuthentification = new JFrame();
		frmAuthentification.setResizable(false);
		frmAuthentification.setTitle("Authentification");
		frmAuthentification.setBounds(100, 100, 442, 350);
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
		
		
		ImagePanel panel = new ImagePanel(new ImageIcon("images/banner.png").getImage());
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_2 = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frmAuthentification.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(tabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
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
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		
		JButton btnTerminer = new JButton("Terminer");
		btnTerminer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTerminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Runtime.getRuntime().exit(0);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(310, Short.MAX_VALUE)
					.addComponent(btnTerminer, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
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
		
		tf_login = new JTextField();
		tf_login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_login.setText(Configuration.authentification.username);
		tf_login.setColumns(10);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur:");
		lblUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMotDePasse = new JLabel("Mot de passe:");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_loginpassword = new JPasswordField();
		tf_loginpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_loginpassword.setText(Configuration.authentification.password);
		
		chk_remember = new JCheckBox("Souvenir le mot passe");
		chk_remember.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chk_remember.setSelected(Configuration.authentification.remember);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DataBase database = new DataBase();
				
				database.setHost(tf_host.getText());
				database.setName(tf_dbname.getText());
				database.setUsername(tf_username.getText());
				database.setPassword(new String(tf_password.getPassword()));
				
				if (database.Connect()) {
					Session.setDatabase(database);
				}else {
					JOptionPane.showMessageDialog(null, "Connexion du base de donnée est impossible!");
					return;
				}
				
				if (User.exist(tf_login.getText(), Encode.sha256(new String(tf_loginpassword.getPassword())))) {
					
					Session.setUser(User.get(tf_login.getText()));
					Session.start();
					frmAuthentification.setVisible(false);
					Configuration.authentification.remember = chk_remember.isSelected();
					if (chk_remember.isSelected()) {
						Configuration.authentification.username = tf_login.getText();
						Configuration.authentification.password = new String( 
								Base64.getEncoder().encode(new String(tf_loginpassword.getPassword()).getBytes()) );
					}else {
						Configuration.authentification.username = "";
						Configuration.authentification.password = "";
					}
					
					Configuration.save();
				}else {
					JOptionPane.showMessageDialog(null, "le nom d'utilisateur ou le mot de passe et incorrect!");
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUtilisateur)
								.addComponent(lblMotDePasse))
							.addGap(4)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tf_login)
								.addComponent(tf_loginpassword, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
								.addComponent(chk_remember)))
						.addComponent(btnConnexion, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUtilisateur))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblMotDePasse))
						.addComponent(tf_loginpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(chk_remember)
							.addGap(35))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnConnexion)
							.addContainerGap())))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Option", null, panel_3, null);
		
		cb_driver = new JComboBox<Object>();
		cb_driver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_driver.setModel(new DefaultComboBoxModel<Object>(new String[] {"MySQL"}));
		cb_driver.setSelectedIndex(Configuration.database.driver);
		
		JLabel lblNewLabel = new JLabel("Moteur de base:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_host = new JTextField();
		tf_host.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_host.setText(Configuration.database.host);
		tf_host.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Serveur:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_dbname = new JTextField();
		tf_dbname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_dbname.setText(Configuration.database.name);
		tf_dbname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom de base:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_username = new JTextField();
		tf_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_username.setText(Configuration.database.username);
		tf_username.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Utilisateur:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_password = new JPasswordField();
		tf_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_password.setText(Configuration.database.password);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Configuration.database.driver = cb_driver.getSelectedIndex();
				Configuration.database.host = tf_host.getText();
				Configuration.database.name = tf_dbname.getText();
				Configuration.database.username = tf_username.getText();
				Configuration.database.password = new String( 
						Base64.getEncoder().encode(new String(tf_password.getPassword()).getBytes()) );
				Configuration.save();
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(cb_driver, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(56)
					.addComponent(lblNewLabel_1)
					.addGap(5)
					.addComponent(tf_host, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_2)
					.addGap(5)
					.addComponent(tf_dbname, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(46)
					.addComponent(lblNewLabel_3)
					.addGap(5)
					.addComponent(tf_username, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblNewLabel_4)
					.addGap(4)
					.addComponent(tf_password, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(302)
					.addComponent(btnNewButton))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(cb_driver, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(tf_host, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2))
						.addComponent(tf_dbname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3))
						.addComponent(tf_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_4))
						.addComponent(tf_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addComponent(btnNewButton))
		);
		panel_3.setLayout(gl_panel_3);
		frmAuthentification.getContentPane().setLayout(groupLayout);
	}
}

class ImagePanel extends JPanel {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) 
	  {
	    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	  }
}
