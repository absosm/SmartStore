/**
 * Cette Classe permet de:
 * afficher une formulaire pour Modifier un Client
 */
package com.home.formes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.home.Cities;
import com.home.Client;
import com.home.Session;
import com.home.docfilter.Filter;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;

public class UpdateClientForm extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Client client;
	
	private JPanel contentPane;
	private JTextField tffirstname;
	private JTextField tfaddress;
	private JTextField tffamily;
	private JTextField tfzip;
	private JTextField tfmobile;
	private JTextField tfphone;
	private JTextField tffax;
	private JTextField tfnrc;
	private JTextField tfnif;
	private JTextField tfbank_account;
	private JTextField tfmail;
	private JTextField tfnart;
	private JTextField tfnis;
	private JTextField tfrib;
	private JTextField tfwebsite;
	private JTextField tfcredit_limit;
	private JTextField tfcredit;
	private JComboBox<Object>  cbwilaya;
	private JComboBox<Object>  cbcity;
	private JComboBox<Object>  cbmode;
	private JButton btnModifier;
	private JLabel id_label;
	private JTextField tfId;
	private JTextField tflastname;

	/**
	 * Create the frame.
	 */
	// constructeur avec un paramètre pour la recherche et la modification 
	
	public UpdateClientForm(Client c) {
		setResizable(false);
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		client = c;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Session.removeForm(Session.UPDATECLIENT);
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateClientForm.class.getResource("/images/employeeIcon.png")));

		setTitle("Modifier Client [code: "+client.getId()+" ]");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 719, 517);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(10, 11, 692, 408);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();   
		//panel.setBackground(Color.LIGHT_GRAY);
		panel.setToolTipText("");
		tabbedPane.addTab("G\u00E9n\u00E9ral   ", new ImageIcon(this.getClass().getResource("/images/Download-Folder-icon.png")), panel, "Des informations générales");
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 30, 665, 286);
		panel.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tflastname = new JTextField(client.getLastname());
		tflastname.setForeground(new Color(0, 0, 255));
		Filter.TextField(tflastname, Filter.UPPERCASE);
		tflastname.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setLastname(tflastname.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tflastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tflastname.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffirstname = new JTextField(client.getFirstname());
		tffirstname.setForeground(new Color(0, 0, 255));
		Filter.TextField(tffirstname, Filter.FIRSTUPPERCASE);
		tffirstname.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setFirstname(tffirstname.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tffirstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tffirstname.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfaddress = new JTextField(client.getAddress());
		tfaddress.setForeground(new Color(0, 0, 255));
		tfaddress.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setAddress(tfaddress.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfaddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfaddress.setColumns(10);
		
		JLabel lblFamille = new JLabel("Famille");
		lblFamille.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFamille.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffamily = new JTextField(client.getFamily());
		tffamily.setForeground(new Color(0, 0, 255));
		tffamily.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setFamily(tffamily.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tffamily.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tffamily.setColumns(10);
		
		JLabel lblCode = new JLabel("Code postale");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfzip = new JTextField(client.getZip());
		tfzip.setForeground(new Color(0, 0, 255));
		Filter.TextField(tfzip, Filter.ZIP);
		tfzip.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setZip(tfzip.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfzip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfzip.setColumns(10);
		
		JLabel lblCommune = new JLabel("Commune");
		lblCommune.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCommune.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbcity = new JComboBox<Object>();
		cbcity.setForeground(new Color(0, 0, 255));
		cbcity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbcity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client.setCity(cbcity.getSelectedIndex());
			}
		});
		
		JLabel lblWilaya = new JLabel("Wilaya");
		lblWilaya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWilaya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbwilaya = new JComboBox<Object>(new DefaultComboBoxModel<Object>(Cities.LoadWilaya()));
		cbwilaya.setForeground(new Color(0, 0, 255));
		cbwilaya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbcity.setModel(new DefaultComboBoxModel<Object>(Cities.LoadCities(cbwilaya.getSelectedIndex())));				
				client.setWilaya(cbwilaya.getSelectedIndex());
			}
		});
		cbwilaya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbwilaya.setSelectedIndex(client.getWilaya());
		cbcity.setSelectedIndex(client.getCity());
		
		JLabel lblTel = new JLabel("Mob");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setIcon(new ImageIcon(this.getClass().getResource("/images/Mobile-icon.png")));
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfmobile = new JTextField(client.getMobile());
		tfmobile.setForeground(new Color(0, 0, 255));
		Filter.TextField(tfmobile, Filter.PHONE);
		tfmobile.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setMobile(tfmobile.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfmobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfmobile.setColumns(10);
		
		JLabel lblTl = new JLabel("TEL");
		lblTl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTl.setIcon(new ImageIcon(this.getClass().getResource("/images/phone-icon.png")));
		lblTl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfphone = new JTextField(client.getPhone());
		tfphone.setForeground(new Color(0, 0, 255));
		Filter.TextField(tfphone, Filter.PHONE);
		tfphone.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setPhone(tfphone.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfphone.setColumns(10);
		
		JLabel lblFax = new JLabel("FAX");
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFax.setIcon(new ImageIcon(this.getClass().getResource("/images/Fax-icon.png")));
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffax = new JTextField(client.getFax());
		tffax.setForeground(new Color(0, 0, 255));
		Filter.TextField(tffax, Filter.PHONE);
		tffax.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setFax(tffax.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tffax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tffax.setColumns(10);
		
		id_label = new JLabel("N\u00B0Client");
		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		id_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfId = new JTextField(String.format("%06d", client.getId()));
		tfId.setEditable(false);
		tfId.setHorizontalAlignment(SwingConstants.CENTER);
		tfId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfId.setForeground(new Color(0, 0, 255));
		tfId.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTl, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(3)
									.addComponent(lblFax, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(tfmobile, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfphone, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
								.addComponent(tffax, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
							.addGap(170)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(id_label, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfId, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(13)
							.addComponent(lblFamille, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(tffamily, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addGap(6)
								.addComponent(lblAdresse, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(tfaddress)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblCode)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tfzip, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
								.addGap(23)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_3.createSequentialGroup()
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(tflastname, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_3.createSequentialGroup()
										.addComponent(lblWilaya, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(cbwilaya, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCommune, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
									.addComponent(tffirstname, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
									.addComponent(cbcity, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))))
					.addGap(38))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFamille, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tffamily, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(tflastname, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(tffirstname, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresse, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(tfaddress, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfzip, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWilaya, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(cbwilaya, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCommune, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(cbcity, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblTel)
							.addGap(7)
							.addComponent(lblTl)
							.addGap(7)
							.addComponent(lblFax))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(tfmobile, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(tfphone, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(tffax, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(16)
							.addComponent(id_label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(tfId, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel_3.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblPrenom, lblCommune});
		gl_panel_3.linkSize(SwingConstants.HORIZONTAL, new Component[] {tflastname, tffirstname});
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Plus information   ", new ImageIcon(this.getClass().getResource("/images/Button-Info-icon.png")), panel_1, null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		
		JLabel lblN = new JLabel("N° R C");
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setBounds(47, 16, 46, 32);
		panel_4.add(lblN);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNIF = new JLabel("N° I F");
		lblNIF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNIF.setBounds(47, 64, 46, 32);
		panel_4.add(lblNIF);
		lblNIF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCompte = new JLabel("Compte bank");
		lblCompte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompte.setBounds(10, 112, 83, 32);
		panel_4.add(lblCompte);
		lblCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(29, 160, 64, 32);
		panel_4.add(lblEmail);
		lblEmail.setIcon(new ImageIcon(this.getClass().getResource("/images/email-2-icon (1).png")));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnrc = new JTextField(client.getNRC());
		tfnrc.setBounds(103, 17, 216, 30);
		panel_4.add(tfnrc);
		tfnrc.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setNRC(tfnrc.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnrc.setForeground(new Color(0, 0, 255));
		tfnrc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfnrc.setColumns(10);
		
		tfnif = new JTextField(client.getNIF());
		tfnif.setBounds(103, 65, 216, 30);
		panel_4.add(tfnif);
		tfnif.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setNIF(tfnif.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnif.setForeground(new Color(0, 0, 255));
		tfnif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfnif.setColumns(10);
		
		tfbank_account = new JTextField(client.getBank_account());
		tfbank_account.setBounds(103, 113, 216, 30);
		panel_4.add(tfbank_account);
		tfbank_account.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setBank_account(tfbank_account.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfbank_account.setForeground(new Color(0, 0, 255));
		tfbank_account.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfbank_account.setColumns(10);
		
		tfmail = new JTextField(client.getMail());
		tfmail.setBounds(103, 161, 216, 30);
		panel_4.add(tfmail);
		tfmail.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setMail(tfmail.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfmail.setForeground(new Color(0, 0, 255));
		tfmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfmail.setColumns(10);
		
		JLabel lblNArt = new JLabel("N° Art");
		lblNArt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNArt.setBounds(329, 16, 97, 32);
		panel_4.add(lblNArt);
		lblNArt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNIS = new JLabel("N° I S");
		lblNIS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNIS.setBounds(329, 64, 97, 32);
		panel_4.add(lblNIS);
		lblNIS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRIP = new JLabel("R I B");
		lblRIP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRIP.setBounds(329, 112, 97, 32);
		panel_4.add(lblRIP);
		lblRIP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSiteWeb = new JLabel("Site Web");
		lblSiteWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSiteWeb.setBounds(329, 160, 97, 32);
		panel_4.add(lblSiteWeb);
		lblSiteWeb.setIcon(new ImageIcon(this.getClass().getResource("/images/HTTP-icon (1).png")));
		lblSiteWeb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnart = new JTextField(client.getNART());
		tfnart.setBounds(436, 17, 216, 30);
		panel_4.add(tfnart);
		tfnart.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setNART(tfnart.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnart.setForeground(new Color(0, 0, 255));
		tfnart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfnart.setColumns(10);
		
		tfnis = new JTextField(client.getNIS());
		tfnis.setBounds(436, 65, 216, 30);
		panel_4.add(tfnis);
		tfnis.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setNIS(tfnis.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnis.setForeground(new Color(0, 0, 255));
		tfnis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfnis.setColumns(10);
		
		tfrib = new JTextField(client.getRIB());
		tfrib.setBounds(436, 113, 216, 30);
		panel_4.add(tfrib);
		tfrib.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setRIB(tfrib.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfrib.setForeground(new Color(0, 0, 255));
		tfrib.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfrib.setColumns(10);
		
		tfwebsite = new JTextField(client.getWebsite());
		tfwebsite.setBounds(436, 161, 216, 30);
		panel_4.add(tfwebsite);
		tfwebsite.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setWebsite(tfwebsite.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfwebsite.setForeground(new Color(0, 0, 255));
		tfwebsite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfwebsite.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(68)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tarification   ", new ImageIcon(this.getClass().getResource("/images/Pricing-icon.png")), panel_2, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		
		JLabel lblModeDeTarif = new JLabel("Mode de Tarif");
		lblModeDeTarif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModeDeTarif.setBounds(48, 19, 94, 32);
		panel_5.add(lblModeDeTarif);
		lblModeDeTarif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbmode = new JComboBox<Object>();
		cbmode.setBounds(152, 20, 256, 30);
		panel_5.add(cbmode);
		cbmode.setForeground(new Color(0, 0, 255));
		cbmode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client.setMode(cbmode.getSelectedIndex());
			}
		});
		cbmode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbmode.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Aucun Tarif>", "Tarif 1", "Tarif 2", "Tarif 3", "Tarif 4", "Tarif 5"}));
		cbmode.setSelectedIndex(client.getMode());
		
		tfcredit_limit = new JTextField(""+client.getCredit_limit());
		tfcredit_limit.setBounds(152, 71, 256, 30);
		panel_5.add(tfcredit_limit);
		tfcredit_limit.setForeground(new Color(0, 0, 255));
		Filter.TextField(tfcredit_limit, Filter.CURRENCY);
		tfcredit_limit.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				if (!tfcredit_limit.getText().isEmpty())
					client.setCredit_limit(Double.parseDouble(tfcredit_limit.getText()));
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfcredit_limit.setHorizontalAlignment(SwingConstants.LEFT);
		tfcredit_limit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Limitation de credit");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 70, 132, 32);
		panel_5.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfcredit = new JTextField(""+client.getCredit());
		tfcredit.setBounds(152, 122, 256, 30);
		panel_5.add(tfcredit);
		tfcredit.setForeground(new Color(0, 0, 255));
		Filter.TextField(tfcredit, Filter.CURRENCY);
		tfcredit.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				if (!tfcredit.getText().isEmpty())
					client.setCredit(Double.parseDouble(tfcredit.getText()));
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfcredit.setHorizontalAlignment(SwingConstants.LEFT);
		tfcredit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfcredit.setColumns(10);
		
		JLabel lblsoldeinitial = new JLabel("Solde initial");
		lblsoldeinitial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblsoldeinitial.setBounds(10, 121, 132, 32);
		panel_5.add(lblsoldeinitial);
		lblsoldeinitial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(146)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(86)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAnnuler.setForeground(new Color(255, 51, 51));
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnnuler.setIcon(new ImageIcon(this.getClass().getResource("/images/Misc-Delete-Database-icon.png")));
		btnAnnuler.setBounds(447, 430, 123, 44);
		contentPane.add(btnAnnuler);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (client.update())
					dispose();
				else 
					JOptionPane.showMessageDialog(null, "Modfication pas réussi.");
				Session.showForm(Session.CLIENTS);						
			}
		});
		btnModifier.setIcon(new ImageIcon(UpdateClientForm.class.getResource("/images/if_user_profile_edit_103781.png")));
		btnModifier.setForeground(Color.GREEN);
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModifier.setBounds(162, 433, 123, 41);
		contentPane.add(btnModifier);
		btnModifier.setVisible(true);
	}
}
