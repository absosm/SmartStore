/**
 * Cette Classe permet de:
 * afficher une formulaire pour ajouter un client
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


public class AddClientForm extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Client client;

	private JPanel contentPane;
	private JTextField tflastname;
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
	private JButton    btnOk;

	/**
	 * Create the frame.
	 */
	public AddClientForm() {
		setResizable(false);
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		client = new Client();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Session.removeForm(Session.ADDCLIENT);
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddClientForm.class.getResource("/images/employeeIcon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("Ajouter Client");
		
		setBounds(100, 100, 718, 515);
		contentPane = new JPanel();
		setContentPane(contentPane);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel = new JPanel();   
		//panel.setBackground(Color.LIGHT_GRAY);
		panel.setToolTipText("");
		tabbedPane.addTab("G\u00E9n\u00E9ral   ", new ImageIcon(this.getClass().getResource("/images/Download-Folder-icon.png")), panel, "Des informations générales");
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		
		JLabel lblFamille = new JLabel("Famille");
		lblFamille.setBounds(10, 11, 56, 32);
		panel_3.add(lblFamille);
		lblFamille.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFamille.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffamily = new JTextField();
		tffamily.setBounds(76, 12, 165, 32);
		panel_3.add(tffamily);
		tffamily.setForeground(new Color(0, 0, 255));
		tffamily.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setFamily(tffamily.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tffamily.setFont(new Font("Tahoma", Font.BOLD, 14));
		tffamily.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(6, 54, 60, 32);
		panel_3.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tflastname = new JTextField();
		tflastname.setBounds(76, 54, 242, 32);
		panel_3.add(tflastname);
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
		
		tflastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		tflastname.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(328, 54, 63, 32);
		panel_3.add(lblPrenom);
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffirstname = new JTextField();
		tffirstname.setBounds(399, 54, 242, 32);
		panel_3.add(tffirstname);
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
		tffirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		tffirstname.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(6, 97, 60, 32);
		panel_3.add(lblAdresse);
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfaddress = new JTextField();
		tfaddress.setBounds(76, 97, 441, 32);
		panel_3.add(tfaddress);
		tfaddress.setForeground(new Color(0, 0, 255));
		tfaddress.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setAddress(tfaddress.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfaddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfaddress.setColumns(10);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(522, 97, 46, 32);
		panel_3.add(lblCode);
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfzip = new JTextField();
		tfzip.setBounds(578, 98, 63, 32);
		panel_3.add(tfzip);
		tfzip.setForeground(new Color(0, 0, 255));
		tfzip.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setZip(tfzip.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		Filter.TextField(tfzip, Filter.ZIP);
		tfzip.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblCommune = new JLabel("Commune");
		lblCommune.setBounds(320, 139, 71, 32);
		panel_3.add(lblCommune);
		lblCommune.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCommune.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbcity = new JComboBox<Object>();
		cbcity.setBounds(399, 139, 242, 32);
		panel_3.add(cbcity);
		cbcity.setForeground(new Color(0, 0, 255));
		cbcity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.setCity(cbcity.getSelectedIndex());
			}
		});
		cbcity.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		cbwilaya = new JComboBox<Object>();
		cbwilaya.setBounds(76, 139, 242, 32);
		panel_3.add(cbwilaya);
		cbwilaya.setForeground(new Color(0, 0, 255));
		cbwilaya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbcity.setModel(new DefaultComboBoxModel<Object>(Cities.LoadCities(cbwilaya.getSelectedIndex())));
				client.setWilaya(cbwilaya.getSelectedIndex());
			}
		});
		cbwilaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbwilaya.setModel(new DefaultComboBoxModel<Object>(Cities.LoadWilaya()));
		cbwilaya.setSelectedIndex(7);
		
		JLabel lblWilaya = new JLabel("Wilaya");
		lblWilaya.setBounds(20, 140, 46, 30);
		panel_3.add(lblWilaya);
		lblWilaya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWilaya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTel = new JLabel("Mob");
		lblTel.setBounds(0, 181, 66, 32);
		panel_3.add(lblTel);
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setIcon(new ImageIcon(this.getClass().getResource("/images/Mobile-icon.png")));
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfmobile = new JTextField();
		tfmobile.setBounds(76, 181, 165, 32);
		panel_3.add(tfmobile);
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
		tfmobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfmobile.setColumns(10);
		
		JLabel lblTl = new JLabel("TEL");
		lblTl.setBounds(0, 224, 66, 32);
		panel_3.add(lblTl);
		lblTl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTl.setIcon(new ImageIcon(this.getClass().getResource("/images/phone-icon.png")));
		lblTl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfphone = new JTextField();
		tfphone.setBounds(76, 224, 165, 32);
		panel_3.add(tfphone);
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
		tfphone.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfphone.setColumns(10);
		
		JLabel lblFax = new JLabel("FAX");
		lblFax.setBounds(0, 267, 66, 32);
		panel_3.add(lblFax);
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFax.setIcon(new ImageIcon(this.getClass().getResource("/images/Fax-icon.png")));
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffax = new JTextField();
		tffax.setBounds(76, 267, 165, 32);
		panel_3.add(tffax);
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
		tffax.setFont(new Font("Tahoma", Font.BOLD, 14));
		tffax.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
					.addGap(18))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Plus information   ", new ImageIcon(this.getClass().getResource("/images/Button-Info-icon.png")), panel_1, null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		
		JLabel lblN = new JLabel("N° R C");
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setBounds(47, 17, 46, 32);
		panel_4.add(lblN);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnrc = new JTextField();
		tfnrc.setBounds(103, 17, 213, 32);
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
		tfnrc.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnrc.setColumns(10);
		
		JLabel lblNArt = new JLabel("N° Art");
		lblNArt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNArt.setBounds(388, 17, 46, 32);
		panel_4.add(lblNArt);
		lblNArt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnart = new JTextField();
		tfnart.setBounds(444, 17, 213, 32);
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
		tfnart.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnart.setColumns(10);
		
		JLabel lblNIF = new JLabel("N° I F");
		lblNIF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNIF.setBounds(47, 66, 46, 32);
		panel_4.add(lblNIF);
		lblNIF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnif = new JTextField();
		tfnif.setBounds(103, 66, 213, 32);
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
		tfnif.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnif.setColumns(10);
		
		JLabel lblNIS = new JLabel("N° I S");
		lblNIS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNIS.setBounds(388, 66, 46, 32);
		panel_4.add(lblNIS);
		lblNIS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnis = new JTextField();
		tfnis.setBounds(444, 66, 213, 32);
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
		tfnis.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnis.setColumns(10);
		
		JLabel lblCompte = new JLabel("Compte bank");
		lblCompte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompte.setBounds(10, 115, 83, 32);
		panel_4.add(lblCompte);
		lblCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfbank_account = new JTextField();
		tfbank_account.setBounds(103, 115, 213, 32);
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
		tfbank_account.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfbank_account.setColumns(10);
		
		JLabel lblRIP = new JLabel("R I B");
		lblRIP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRIP.setBounds(379, 115, 55, 32);
		panel_4.add(lblRIP);
		lblRIP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfrib = new JTextField();
		tfrib.setBounds(444, 115, 213, 32);
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
		tfrib.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfrib.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(29, 164, 64, 32);
		panel_4.add(lblEmail);
		lblEmail.setIcon(new ImageIcon(this.getClass().getResource("/images/email-2-icon (1).png")));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfmail = new JTextField();
		tfmail.setBounds(103, 164, 213, 32);
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
		tfmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfmail.setColumns(10);
		
		JLabel lblSiteWeb = new JLabel("Site Web");
		lblSiteWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSiteWeb.setBounds(337, 164, 97, 32);
		panel_4.add(lblSiteWeb);
		lblSiteWeb.setIcon(new ImageIcon(this.getClass().getResource("/images/HTTP-icon (1).png")));
		lblSiteWeb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfwebsite = new JTextField();
		tfwebsite.setBounds(444, 164, 213, 32);
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
		tfwebsite.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfwebsite.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 667, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(68)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tarification   ", new ImageIcon(this.getClass().getResource("/images/Pricing-icon.png")), panel_2, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		
		JLabel lblModeDeTarif = new JLabel("Mode de Tarif");
		lblModeDeTarif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModeDeTarif.setBounds(15, 21, 94, 17);
		panel_5.add(lblModeDeTarif);
		lblModeDeTarif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbmode = new JComboBox<Object>();
		cbmode.setBounds(119, 13, 256, 32);
		panel_5.add(cbmode);
		cbmode.setForeground(new Color(0, 0, 255));
		cbmode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.setMode(cbmode.getSelectedIndex());
			}
		});
		cbmode.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbmode.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Aucun Tarif>", "Tarif 1", "Tarif 2", "Tarif 3", "Tarif 4", "Tarif 5"}));
		cbmode.setSelectedIndex(0);
		
		JLabel lblNewLabel_2 = new JLabel("Limitation");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(41, 66, 68, 17);
		panel_5.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfcredit_limit = new JTextField();
		tfcredit_limit.setBounds(119, 58, 256, 32);
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
		tfcredit_limit.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfcredit_limit.setText("0");
		tfcredit_limit.setColumns(10);
		
		JLabel lblsoldeinitial = new JLabel("Solde initial");
		lblsoldeinitial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblsoldeinitial.setBounds(32, 102, 77, 34);
		panel_5.add(lblsoldeinitial);
		lblsoldeinitial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfcredit = new JTextField();
		tfcredit.setBounds(119, 103, 256, 32);
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
		tfcredit.setText("0");
		tfcredit.setHorizontalAlignment(SwingConstants.LEFT);
		tfcredit.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfcredit.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(149)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
					.addGap(150))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(101)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
					.addGap(101))
		);
		panel_2.setLayout(gl_panel_2);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (client.add())
					dispose();
				else
					JOptionPane.showMessageDialog(null, "pardon, l'insertion de client pas réussi.");
				Session.showForm(Session.CLIENTS);
			}
		});
		btnOk.setForeground(new Color(0, 255, 102));
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOk.setIcon(new ImageIcon(this.getClass().getResource("/images/database-accept-icon.png")));
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();					
			}
		});
		btnAnnuler.setForeground(new Color(255, 51, 51));
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnnuler.setIcon(new ImageIcon(this.getClass().getResource("/images/Misc-Delete-Database-icon.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(163)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(163)
					.addComponent(btnAnnuler))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);
	}	
}