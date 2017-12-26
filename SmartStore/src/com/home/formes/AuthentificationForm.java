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
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		frmAuthentification.setType(Type.UTILITY);
		frmAuthentification.getContentPane().setBackground(Color.WHITE);
		frmAuthentification.setResizable(false);
		frmAuthentification.setTitle("Authentification");
		frmAuthentification.setBounds(100, 100, 442, 317);
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLUE);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frmAuthentification.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
					.addContainerGap(10, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Connexion", null, panel_1, null);
		
		tf_login = new JTextField();
		tf_login.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		tf_login.setForeground(new Color(0, 0, 255));
		tf_login.setBounds(102, 14, 299, 30);
		tf_login.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_login.setText(Configuration.authentification.username);
		tf_login.setColumns(10);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur:");
		lblUtilisateur.setBounds(35, 21, 63, 17);
		lblUtilisateur.setForeground(Color.BLUE);
		lblUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMotDePasse = new JLabel("Mot de passe:");
		lblMotDePasse.setBounds(13, 59, 85, 17);
		lblMotDePasse.setForeground(Color.BLUE);
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_loginpassword = new JPasswordField();
		tf_loginpassword.setForeground(new Color(0, 0, 255));
		tf_loginpassword.setBounds(102, 52, 299, 30);
		tf_loginpassword.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_loginpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_loginpassword.setText(Configuration.authentification.password);
		
		chk_remember = new JCheckBox("Souvenir le mot passe");
		chk_remember.setBounds(102, 97, 159, 25);
		chk_remember.setForeground(Color.BLUE);
		chk_remember.setBackground(Color.WHITE);
		chk_remember.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chk_remember.setSelected(Configuration.authentification.remember);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setIcon(new ImageIcon(AuthentificationForm.class.getResource("/images/refresh.png")));
		btnConnexion.setForeground(Color.BLUE);
		btnConnexion.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnConnexion.setBounds(283, 107, 118, 30);
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
		panel_1.setLayout(null);
		panel_1.add(lblUtilisateur);
		panel_1.add(lblMotDePasse);
		panel_1.add(tf_login);
		panel_1.add(tf_loginpassword);
		panel_1.add(chk_remember);
		panel_1.add(btnConnexion);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Option", null, panel_3, null);
		
		cb_driver = new JComboBox<Object>();
		cb_driver.setBorder(new LineBorder(new Color(30, 144, 255)));
		cb_driver.setForeground(Color.BLUE);
		cb_driver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_driver.setModel(new DefaultComboBoxModel<Object>(new String[] {"MySQL"}));
		cb_driver.setSelectedIndex(Configuration.database.driver);
		
		JLabel lblNewLabel = new JLabel("Moteur de base:");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_host = new JTextField();
		tf_host.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_host.setForeground(Color.BLUE);
		tf_host.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_host.setText(Configuration.database.host);
		tf_host.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Serveur:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_dbname = new JTextField();
		tf_dbname.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_dbname.setForeground(Color.BLUE);
		tf_dbname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_dbname.setText(Configuration.database.name);
		tf_dbname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom de base:");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_username = new JTextField();
		tf_username.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_username.setForeground(Color.BLUE);
		tf_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_username.setText(Configuration.database.username);
		tf_username.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Utilisateur:");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_password = new JPasswordField();
		tf_password.setBorder(new LineBorder(new Color(30, 144, 255)));
		tf_password.setForeground(Color.BLUE);
		tf_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_password.setText(Configuration.database.password);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setForeground(Color.BLUE);
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
					.addComponent(cb_driver, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_1)
					.addGap(10)
					.addComponent(tf_host, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_2)
					.addGap(5)
					.addComponent(tf_dbname, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING, false)
					.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
						.addGap(302)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
						.addGap(46)
						.addComponent(lblNewLabel_3)
						.addGap(5)
						.addComponent(tf_username, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addGap(4)
						.addComponent(lblNewLabel_4)
						.addGap(4)
						.addComponent(tf_password, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel))
						.addComponent(cb_driver, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1))
						.addComponent(tf_host, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_2))
						.addComponent(tf_dbname, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_3))
						.addComponent(tf_username, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_4))
						.addComponent(tf_password, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
					.addContainerGap())
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
