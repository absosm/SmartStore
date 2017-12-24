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
import com.home.Provider;
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
import javax.swing.border.LineBorder;
import java.awt.Component;


public class AddProviderForm extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Provider provider;

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
	private JComboBox<Object>  cbwilaya;
	private JComboBox<Object>  cbcity;
	private JButton    btnOk;
	private JTextField tfcredit;

	/**
	 * Create the frame.
	 */
	public AddProviderForm() {
		setBackground(Color.WHITE);
		setResizable(false);
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		provider = new Provider();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Session.removeForm(Session.ADDPROVIDER);
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddProviderForm.class.getResource("/images/fournisseur - Copie.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("Ajouter Fournisseur");
		
		setBounds(100, 100, 729, 518);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLUE);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();   
		panel.setBackground(Color.WHITE);
		//panel.setBackground(Color.LIGHT_GRAY);
		panel.setToolTipText("");
		tabbedPane.addTab("G\u00E9n\u00E9ral   ", new ImageIcon(this.getClass().getResource("/images/Download-Folder-icon.png")), panel, "Des informations générales");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(35, 48, 46, 32);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tflastname = new JTextField();
		tflastname.setBorder(new LineBorder(new Color(30, 144, 255)));
		tflastname.setBounds(91, 48, 242, 32);
		panel_2.add(tflastname);
		tflastname.setForeground(Color.BLUE);
		Filter.TextField(tflastname, Filter.UPPERCASE);
		tflastname.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setLastname(tflastname.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		
		tflastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		tflastname.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prénom ");
		lblPrenom.setForeground(Color.BLUE);
		lblPrenom.setBounds(340, 48, 63, 32);
		panel_2.add(lblPrenom);
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffirstname = new JTextField();
		tffirstname.setBorder(new LineBorder(new Color(30, 144, 255)));
		tffirstname.setBounds(418, 49, 232, 30);
		panel_2.add(tffirstname);
		tffirstname.setForeground(Color.BLUE);
		Filter.TextField(tffirstname, Filter.FIRSTUPPERCASE);
		tffirstname.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setFirstname(tffirstname.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tffirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		tffirstname.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setForeground(Color.BLUE);
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresse.setBounds(18, 88, 63, 32);
		panel_2.add(lblAdresse);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfaddress = new JTextField();
		tfaddress.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfaddress.setBounds(91, 89, 384, 30);
		panel_2.add(tfaddress);
		tfaddress.setForeground(Color.BLUE);
		tfaddress.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setAddress(tfaddress.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfaddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfaddress.setColumns(10);
		
		JLabel lblFamille = new JLabel("Famille");
		lblFamille.setForeground(Color.BLUE);
		lblFamille.setBackground(Color.WHITE);
		lblFamille.setBounds(25, 8, 56, 32);
		panel_2.add(lblFamille);
		lblFamille.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFamille.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffamily = new JTextField();
		tffamily.setBorder(new LineBorder(new Color(30, 144, 255)));
		tffamily.setBounds(91, 10, 165, 30);
		panel_2.add(tffamily);
		tffamily.setForeground(Color.BLUE);
		tffamily.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setFamily(tffamily.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tffamily.setFont(new Font("Tahoma", Font.BOLD, 14));
		tffamily.setColumns(10);
		
		JLabel lblCode = new JLabel("Code postale");
		lblCode.setForeground(Color.BLUE);
		lblCode.setBounds(482, 88, 90, 32);
		panel_2.add(lblCode);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfzip = new JTextField();
		tfzip.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfzip.setBounds(587, 89, 63, 30);
		panel_2.add(tfzip);
		tfzip.setForeground(Color.BLUE);
		tfzip.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setZip(tfzip.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		Filter.TextField(tfzip, Filter.ZIP);
		tfzip.setText("0");
		tfzip.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblWilaya = new JLabel("Wilaya");
		lblWilaya.setForeground(Color.BLUE);
		lblWilaya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWilaya.setBounds(35, 128, 46, 32);
		panel_2.add(lblWilaya);
		lblWilaya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbcity = new JComboBox<Object>();
		cbcity.setBorder(new LineBorder(new Color(30, 144, 255)));
		cbcity.setBounds(418, 130, 232, 29);
		panel_2.add(cbcity);
		cbcity.setForeground(Color.BLUE);
		cbcity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provider.setCity(cbcity.getSelectedIndex());
			}
		});
		cbcity.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		cbwilaya = new JComboBox<Object>();
		cbwilaya.setBorder(new LineBorder(new Color(30, 144, 255)));
		cbwilaya.setBounds(91, 130, 242, 29);
		panel_2.add(cbwilaya);
		cbwilaya.setForeground(Color.BLUE);
		cbwilaya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbcity.setModel(new DefaultComboBoxModel<Object>(Cities.LoadCities(cbwilaya.getSelectedIndex())));
				provider.setWilaya(cbwilaya.getSelectedIndex());
			}
		});
		cbwilaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbwilaya.setModel(new DefaultComboBoxModel<Object>(Cities.LoadWilaya()));
		cbwilaya.setSelectedIndex(7);
		
		JLabel lblCommune = new JLabel("Commune");
		lblCommune.setForeground(Color.BLUE);
		lblCommune.setBounds(340, 128, 71, 32);
		panel_2.add(lblCommune);
		lblCommune.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTel = new JLabel("Mob");
		lblTel.setForeground(Color.BLUE);
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setBounds(18, 168, 63, 32);
		panel_2.add(lblTel);
		lblTel.setIcon(new ImageIcon(this.getClass().getResource("/images/Mobile-icon.png")));
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfmobile = new JTextField();
		tfmobile.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfmobile.setBounds(91, 169, 165, 30);
		panel_2.add(tfmobile);
		tfmobile.setForeground(Color.BLUE);
		Filter.TextField(tfmobile, Filter.PHONE);
		tfmobile.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setMobile(tfmobile.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfmobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfmobile.setColumns(10);
		
		JLabel lblTl = new JLabel("TEL");
		lblTl.setForeground(Color.BLUE);
		lblTl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTl.setBounds(10, 208, 71, 32);
		panel_2.add(lblTl);
		lblTl.setIcon(new ImageIcon(this.getClass().getResource("/images/phone-icon.png")));
		lblTl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfphone = new JTextField();
		tfphone.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfphone.setBounds(91, 209, 165, 30);
		panel_2.add(tfphone);
		tfphone.setForeground(Color.BLUE);
		Filter.TextField(tfphone, Filter.PHONE);
		tfphone.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setPhone(tfphone.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfphone.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfphone.setColumns(10);
		
		JLabel lblFax = new JLabel("FAX");
		lblFax.setForeground(Color.BLUE);
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFax.setBounds(21, 248, 60, 32);
		panel_2.add(lblFax);
		lblFax.setIcon(new ImageIcon(this.getClass().getResource("/images/Fax-icon.png")));
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffax = new JTextField();
		tffax.setBorder(new LineBorder(new Color(30, 144, 255)));
		tffax.setBounds(91, 249, 165, 30);
		panel_2.add(tffax);
		tffax.setForeground(Color.BLUE);
		Filter.TextField(tffax, Filter.PHONE);
		tffax.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setFax(tffax.getText());
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
					.addGap(16)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Plus information   ", new ImageIcon(this.getClass().getResource("/images/Button-Info-icon.png")), panel_1, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		
		JLabel lblN = new JLabel("N° R C");
		lblN.setForeground(Color.BLUE);
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setBounds(47, 8, 46, 32);
		panel_3.add(lblN);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnrc = new JTextField();
		tfnrc.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfnrc.setBounds(103, 8, 194, 32);
		panel_3.add(tfnrc);
		tfnrc.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setNRC(tfnrc.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnrc.setForeground(Color.BLUE);
		tfnrc.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnrc.setColumns(10);
		
		JLabel lblNArt = new JLabel("N° Art");
		lblNArt.setForeground(Color.BLUE);
		lblNArt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNArt.setBounds(362, 8, 46, 32);
		panel_3.add(lblNArt);
		lblNArt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnart = new JTextField();
		tfnart.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfnart.setBounds(418, 8, 194, 32);
		panel_3.add(tfnart);
		tfnart.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setNART(tfnart.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnart.setForeground(Color.BLUE);
		tfnart.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnart.setColumns(10);
		
		JLabel lblNIF = new JLabel("N° I F");
		lblNIF.setForeground(Color.BLUE);
		lblNIF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNIF.setBounds(47, 48, 46, 32);
		panel_3.add(lblNIF);
		lblNIF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnif = new JTextField();
		tfnif.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfnif.setBounds(103, 48, 194, 32);
		panel_3.add(tfnif);
		tfnif.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setNIF(tfnif.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnif.setForeground(Color.BLUE);
		tfnif.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnif.setColumns(10);
		
		JLabel lblNIS = new JLabel("N° I S");
		lblNIS.setForeground(Color.BLUE);
		lblNIS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNIS.setBounds(362, 48, 46, 32);
		panel_3.add(lblNIS);
		lblNIS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnis = new JTextField();
		tfnis.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfnis.setBounds(418, 48, 194, 32);
		panel_3.add(tfnis);
		tfnis.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setNIS(tfnis.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnis.setForeground(Color.BLUE);
		tfnis.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnis.setColumns(10);
		
		JLabel lblCompte = new JLabel("Compte Bank");
		lblCompte.setForeground(Color.BLUE);
		lblCompte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompte.setBounds(10, 88, 83, 32);
		panel_3.add(lblCompte);
		lblCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfbank_account = new JTextField();
		tfbank_account.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfbank_account.setBounds(103, 88, 194, 32);
		panel_3.add(tfbank_account);
		tfbank_account.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setBank_account(tfbank_account.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfbank_account.setForeground(Color.BLUE);
		tfbank_account.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfbank_account.setColumns(10);
		
		JLabel lblRIP = new JLabel("R I B");
		lblRIP.setForeground(Color.BLUE);
		lblRIP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRIP.setBounds(353, 88, 55, 32);
		panel_3.add(lblRIP);
		lblRIP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfrib = new JTextField();
		tfrib.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfrib.setBounds(418, 88, 194, 32);
		panel_3.add(tfrib);
		tfrib.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setRIB(tfrib.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfrib.setForeground(Color.BLUE);
		tfrib.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfrib.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(29, 128, 64, 32);
		panel_3.add(lblEmail);
		lblEmail.setIcon(new ImageIcon(this.getClass().getResource("/images/email-2-icon (1).png")));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfmail = new JTextField();
		tfmail.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfmail.setBounds(103, 128, 194, 32);
		panel_3.add(tfmail);
		tfmail.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setMail(tfmail.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfmail.setForeground(Color.BLUE);
		tfmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfmail.setColumns(10);
		
		JLabel lblSiteWeb = new JLabel("Site Web");
		lblSiteWeb.setForeground(Color.BLUE);
		lblSiteWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSiteWeb.setBounds(311, 128, 97, 32);
		panel_3.add(lblSiteWeb);
		lblSiteWeb.setIcon(new ImageIcon(this.getClass().getResource("/images/HTTP-icon (1).png")));
		lblSiteWeb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfwebsite = new JTextField();
		tfwebsite.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfwebsite.setBounds(418, 128, 194, 32);
		panel_3.add(tfwebsite);
		tfwebsite.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setWebsite(tfwebsite.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfwebsite.setForeground(Color.BLUE);
		tfwebsite.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfwebsite.setColumns(10);
		
		JLabel lblSolde = new JLabel("Solde:");
		lblSolde.setForeground(Color.BLUE);
		lblSolde.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSolde.setBounds(15, 168, 78, 32);
		panel_3.add(lblSolde);
		lblSolde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfcredit = new JTextField();
		tfcredit.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfcredit.setBounds(103, 168, 194, 32);
		panel_3.add(tfcredit);
		Filter.TextField(tfcredit, Filter.CURRENCY);
		tfcredit.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				if (!tfcredit.getText().isEmpty())
					provider.setCredit(Double.parseDouble(tfcredit.getText()));
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfcredit.setForeground(Color.BLUE);
		tfcredit.setText("0");
		tfcredit.setHorizontalAlignment(SwingConstants.LEFT);
		tfcredit.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfcredit.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(34)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 624, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(66)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		btnOk = new JButton("Ajouter");
		btnOk.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (provider.add())
					dispose();
				else
					JOptionPane.showMessageDialog(null, "pardon, l'insertion de fournisseur pas réussi.");
				Session.showForm(Session.PROVIDERS);
			}
		});
		btnOk.setForeground(new Color(0, 255, 102));
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOk.setIcon(new ImageIcon(this.getClass().getResource("/images/database-accept-icon.png")));
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBorder(new LineBorder(new Color(0, 0, 0)));
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(165)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(165)
							.addComponent(btnAnnuler))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnOk, btnAnnuler});
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);
	}	
}
