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
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.home.Configuration;
import com.home.DataBase;
import com.home.Encode;
import com.home.Session;
import com.home.User;
import com.home.Configuration.authentification;
import com.home.Configuration.database;

import java.awt.Color;
import java.awt.Window.Type;

public class AuthentificationForm {

	private JFrame frmAuthentification;
	private JTextField tf_login;
	private JPasswordField tf_loginpassword;
	private JTextField tf_host;
	private JTextField tf_dbname;
	private JTextField tf_username;
	private JPasswordField tf_password;
	private JComboBox cb_driver;
	private JCheckBox chk_remember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/**
					 * permet de sauvgarde th�me de syst�me.
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
		frmAuthentification.setBounds(100, 100, 442, 345);
		frmAuthentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * centraliser le fen�tre
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
		GroupLayout groupLayout = new GroupLayout(frmAuthentification.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
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
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton btnTerminer = new JButton("Terminer");
		btnTerminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Runtime.getRuntime().exit(0);
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
		
		tf_login = new JTextField();
		tf_login.setText(Configuration.authentification.username);
		tf_login.setColumns(10);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur:");
		
		JLabel lblMotDePasse = new JLabel("Mot de passe:");
		
		tf_loginpassword = new JPasswordField();
		tf_loginpassword.setText(Configuration.authentification.password);
		
		chk_remember = new JCheckBox("Souvenir le mot passe");
		chk_remember.setSelected(Configuration.authentification.remember);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DataBase database = new DataBase();
				
				database.setHost(tf_host.getText());
				database.setName(tf_dbname.getText());
				database.setUsername(tf_username.getText());
				database.setPassword(tf_password.getText());
				
				if (database.Connect()) {
					Session.setDatabase(database);
				}else {
					JOptionPane.showMessageDialog(null, "Connexion du base de donn�e est impossible!");
					return;
				}
				
				if (User.exist(tf_login.getText(), Encode.sha256(tf_loginpassword.getText()))) {
					
					Session.setUser(User.get(tf_login.getText()));
					Session.start();
					frmAuthentification.setVisible(false);
					Configuration.authentification.remember = chk_remember.isSelected();
					if (chk_remember.isSelected()) {
						Configuration.authentification.username = tf_login.getText();
						Configuration.authentification.password = new String( 
								Base64.getEncoder().encode(tf_loginpassword.getText().getBytes()) );
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
					.addContainerGap(28, Short.MAX_VALUE)
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
					.addComponent(chk_remember)
					.addGap(12)
					.addComponent(btnConnexion)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Option", null, panel_3, null);
		
		cb_driver = new JComboBox();
		cb_driver.setModel(new DefaultComboBoxModel(new String[] {"MySQL"}));
		cb_driver.setSelectedIndex(Configuration.database.driver);
		
		JLabel lblNewLabel = new JLabel("Moteur de base:");
		
		tf_host = new JTextField();
		tf_host.setText(Configuration.database.host);
		tf_host.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Serveur:");
		
		tf_dbname = new JTextField();
		tf_dbname.setText(Configuration.database.name);
		tf_dbname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom de base:");
		
		tf_username = new JTextField();
		tf_username.setText(Configuration.database.username);
		tf_username.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Utilisateur:");
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		
		tf_password = new JPasswordField();
		tf_password.setText(Configuration.database.password);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Configuration.database.driver = cb_driver.getSelectedIndex();
				Configuration.database.host = tf_host.getText();
				Configuration.database.name = tf_dbname.getText();
				Configuration.database.username = tf_username.getText();
				Configuration.database.password = new String( 
						Base64.getEncoder().encode(tf_password.getText().getBytes()) );
				Configuration.save();
			}
		});
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
									.addComponent(tf_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tf_password, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
								.addComponent(tf_host, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
								.addComponent(cb_driver, 0, 313, Short.MAX_VALUE)
								.addComponent(tf_dbname, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
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
						.addComponent(cb_driver, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_host, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_dbname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(tf_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		frmAuthentification.getContentPane().setLayout(groupLayout);
	}
	
	private void LoadConfiguration() {
		
		SAXBuilder saxBuilder = new SAXBuilder();
		Element config_db=null, config_auth=null;
        Document document = null;
        try {
            document = saxBuilder.build(new File("./config/main.xml"));
            config_db = document.getRootElement().getChild("database");
            config_auth = document.getRootElement().getChild("authentification");
            
            cb_driver.setSelectedIndex(Integer.parseInt(config_db.getChild("driver").getText()));
            tf_host.setText(config_db.getChild("host").getText());
            tf_dbname.setText(config_db.getChild("name").getText());
            tf_username.setText(config_db.getChild("username").getText());
            tf_password.setText(config_db.getChild("password").getText());
            
            boolean remember = Boolean.parseBoolean(config_auth.getChild("remember").getText());
            if (remember) {
            	tf_login.setText(config_auth.getChild("username").getText());
            	tf_loginpassword.setText( new String(Base64.getDecoder().decode(config_auth.getChild("username").getText().getBytes())) );
            }
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
}

class ImagePanel extends JPanel {

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
