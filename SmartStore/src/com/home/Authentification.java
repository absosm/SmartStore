package com.home;

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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.awt.Color;
import java.awt.Window.Type;

public class Authentification {

	private JFrame frmAuthentification;
	private JTextField tf_login;
	private JPasswordField tf_loginpassword;
	private JTextField tf_host;
	private JTextField tf_dbname;
	private JTextField tf_username;
	private JPasswordField tf_password;
	private JComboBox cb_driver;

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
		initialize();
		Session.setAuthentification(frmAuthentification);
		LoadConfiguration();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAuthentification = new JFrame();
		frmAuthentification.setType(Type.UTILITY);
		frmAuthentification.setResizable(false);
		frmAuthentification.setTitle("Authentification");
		frmAuthentification.setBounds(100, 100, 442, 337);
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
		tf_login.setText("admin");
		tf_login.setColumns(10);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur:");
		
		JLabel lblMotDePasse = new JLabel("Mot de passe:");
		
		tf_loginpassword = new JPasswordField();
		
		JCheckBox chckbxSouvenirLeMot = new JCheckBox("Souvenir le mot passe");
		
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
					JOptionPane.showMessageDialog(null, "Connexion du base de donnée est impossible!");
					return;
				}
				
				if (User.exist(tf_login.getText(), Encode.sha256(tf_loginpassword.getText()))) {
					Session.setUser(User.get(tf_login.getText()));
					Session.setMainForm(new MainForm());
					Session.showMainForm();
					frmAuthentification.setVisible(false);
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
								.addComponent(chckbxSouvenirLeMot)))
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
					.addComponent(chckbxSouvenirLeMot)
					.addGap(12)
					.addComponent(btnConnexion)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Option", null, panel_3, null);
		
		cb_driver = new JComboBox();
		cb_driver.setModel(new DefaultComboBoxModel(new String[] {"MySQL"}));
		
		JLabel lblNewLabel = new JLabel("Moteur de base:");
		
		tf_host = new JTextField();
		tf_host.setText("localhost");
		tf_host.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Serveur:");
		
		tf_dbname = new JTextField();
		tf_dbname.setText("smart_store");
		tf_dbname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom de base:");
		
		tf_username = new JTextField();
		tf_username.setText("root");
		tf_username.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Utilisateur:");
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		
		tf_password = new JPasswordField();
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Element root = new Element("root");
				Element element = new Element("driver");
				element.addContent(cb_driver.getSelectedIndex()+"");
				root.addContent(element);
				element = new Element("host");
				element.addContent(tf_host.getText());
				root.addContent(element);
				element = new Element("name");
				element.addContent(tf_dbname.getText());
				root.addContent(element);
				element = new Element("username");
				element.addContent(tf_username.getText());
				root.addContent(element);
				element = new Element("password");
				element.addContent(tf_password.getText());
				root.addContent(element);
				Document doc_write = new Document(root);
		        try {
		        	XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		        	sortie.output(doc_write, new FileOutputStream("./config/main.xml"));
		        }
		        catch (Exception e){
		        	e.printStackTrace();
		        }
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
		Element element =  null;
        Document document = null;
        try {
            document = saxBuilder.build(new File("./config/main.xml"));
            element = document.getRootElement().getChild("driver");
            cb_driver.setSelectedIndex(Integer.parseInt(document.getRootElement().getChild("driver").getText()));
            tf_host.setText(document.getRootElement().getChild("host").getText());
            tf_dbname.setText(document.getRootElement().getChild("name").getText());
            tf_username.setText(document.getRootElement().getChild("username").getText());
            tf_password.setText(document.getRootElement().getChild("password").getText());
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
