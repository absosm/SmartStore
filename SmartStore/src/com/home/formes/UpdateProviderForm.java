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

public class UpdateProviderForm extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Provider provider;
	
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
	private JComboBox<Object>  cbwilaya;
	private JComboBox<Object>  cbcity;
	private JButton btnedit;
	private JLabel id_label;
	private JTextField tfid;
	private JTextField tflastname;
	private JTextField tfcredit;

	/**
	 * Create the frame.
	 */
	// constructeur avec un paramètre pour la recherche et la modification 
	
	public UpdateProviderForm(Provider p) {
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		provider = p;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Session.removeForm(Session.UPDATEPROVIDER);
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateProviderForm.class.getResource("/images/fournisseur.png")));

		setTitle("Modifier Fournisseur [code: "+provider.getId()+" ]");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(0, 0, 674, 342);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();   
		//panel.setBackground(Color.LIGHT_GRAY);
		panel.setToolTipText("");
		tabbedPane.addTab("Général", new ImageIcon(this.getClass().getResource("/images/Download-Folder-icon.png")), panel, "Des informations générales");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPrenom = new JLabel("Prénom ");
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrenom.setBounds(321, 11, 63, 14);
		panel.add(lblPrenom);
		
		tflastname = new JTextField(provider.getLastname());
		tflastname.setForeground(new Color(0, 0, 255));
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
		tflastname.setBounds(69, 8, 242, 30);
		panel.add(tflastname);
		tflastname.setColumns(10);
		
		tffirstname = new JTextField(provider.getFirstname());
		tffirstname.setForeground(new Color(0, 0, 255));
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
		tffirstname.setBounds(399, 8, 232, 30);
		panel.add(tffirstname);
		
		JLabel lblAdresse = new JLabel("Adresse ");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdresse.setBounds(10, 58, 63, 14);
		panel.add(lblAdresse);
		
		JLabel lblFamille = new JLabel("Famille ");
		lblFamille.setHorizontalAlignment(SwingConstants.LEFT);
		lblFamille.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFamille.setBounds(409, 58, 56, 14);
		panel.add(lblFamille);
		
		tfaddress = new JTextField(provider.getAddress());
		tfaddress.setForeground(new Color(0, 0, 255));
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
		tfaddress.setBounds(69, 52, 326, 30);
		panel.add(tfaddress);
		
		tffamily = new JTextField(provider.getFamily());
		tffamily.setForeground(new Color(0, 0, 255));
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
		tffamily.setBounds(466, 52, 165, 30);
		panel.add(tffamily);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCode.setBounds(10, 93, 46, 14);
		panel.add(lblCode);
		
		JLabel lblPostal = new JLabel("Postal");
		lblPostal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPostal.setBounds(10, 107, 46, 14);
		panel.add(lblPostal);
		
		tfzip = new JTextField(provider.getZip());
		tfzip.setForeground(new Color(0, 0, 255));
		Filter.TextField(tfzip, Filter.ZIP);
		tfzip.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setZip(tfzip.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfzip.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfzip.setBounds(69, 93, 63, 30);
		panel.add(tfzip);
		tfzip.setColumns(10);
		
		JLabel lblCommune = new JLabel("Commune");
		lblCommune.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCommune.setBounds(383, 98, 71, 21);
		panel.add(lblCommune);
		
		cbcity = new JComboBox<Object>();
		cbcity.setForeground(new Color(0, 0, 255));
		cbcity.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbcity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				provider.setCity(cbcity.getSelectedIndex());
			}
		});
		cbcity.setBounds(465, 92, 165, 29);
		panel.add(cbcity);
		
		JLabel lblWilaya = new JLabel("Wilaya");
		lblWilaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWilaya.setBounds(142, 93, 46, 22);
		panel.add(lblWilaya);
		
		cbwilaya = new JComboBox<Object>(new DefaultComboBoxModel<Object>(Cities.LoadWilaya()));
		cbwilaya.setForeground(new Color(0, 0, 255));
		cbwilaya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbcity.setModel(new DefaultComboBoxModel<Object>(Cities.LoadCities(cbwilaya.getSelectedIndex()+1)));
				provider.setWilaya(cbwilaya.getSelectedIndex());
			}
		});
		cbwilaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbwilaya.setSelectedIndex(provider.getWilaya());
		cbcity.setSelectedIndex(provider.getCity());
		cbwilaya.setBounds(191, 92, 178, 29);
		panel.add(cbwilaya);
		

		
		JLabel lblTel = new JLabel("Tél");
		lblTel.setIcon(new ImageIcon(this.getClass().getResource("/images/Mobile-icon.png")));
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTel.setBounds(7, 132, 56, 32);
		panel.add(lblTel);
		
		JLabel lblTl = new JLabel("Tél");
		lblTl.setIcon(new ImageIcon(this.getClass().getResource("/images/phone-icon.png")));
		lblTl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTl.setBounds(8, 175, 56, 32);
		panel.add(lblTl);
		
		JLabel lblFax = new JLabel("Fax");
		lblFax.setIcon(new ImageIcon(this.getClass().getResource("/images/Fax-icon.png")));
		lblFax.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFax.setBounds(7, 222, 60, 32);
		panel.add(lblFax);
		
		tfmobile = new JTextField(provider.getMobile());
		tfmobile.setForeground(new Color(0, 0, 255));
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
		tfmobile.setBounds(69, 138, 326, 30);
		panel.add(tfmobile);
		
		tfphone = new JTextField(provider.getPhone());
		tfphone.setForeground(new Color(0, 0, 255));
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
		tfphone.setBounds(69, 185, 326, 30);
		panel.add(tfphone);
		
		tffax = new JTextField(provider.getFax());
		tffax.setForeground(new Color(0, 0, 255));
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
		tffax.setBounds(69, 227, 326, 30);
		panel.add(tffax);
		
		id_label = new JLabel("N\u00B0Client");
		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		id_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		id_label.setBounds(526, 149, 86, 29);
		panel.add(id_label);
		
		tfid = new JTextField(String.format("%06d", provider.getId()));
		tfid.setEditable(false);
		tfid.setHorizontalAlignment(SwingConstants.CENTER);
		tfid.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfid.setForeground(new Color(0, 0, 255));
		tfid.setBounds(526, 186, 104, 30);
		panel.add(tfid);
		tfid.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Plus_Information", new ImageIcon(this.getClass().getResource("/images/Button-Info-icon.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblN = new JLabel("N° R C");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblN.setBounds(10, 28, 46, 14);
		panel_1.add(lblN);
		
		JLabel lblNIF = new JLabel("N° I F");
		lblNIF.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNIF.setBounds(10, 90, 46, 14);
		panel_1.add(lblNIF);
		
		JLabel lblCompte = new JLabel("Compte");
		lblCompte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompte.setBounds(38, 129, 55, 26);
		panel_1.add(lblCompte);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setIcon(new ImageIcon(this.getClass().getResource("/images/email-2-icon (1).png")));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 195, 64, 24);
		panel_1.add(lblEmail);
		
		JLabel lblBanq = new JLabel("Bancaire");
		lblBanq.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBanq.setBounds(38, 149, 59, 26);
		panel_1.add(lblBanq);
		
		tfnrc = new JTextField(provider.getNRC());
		tfnrc.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setNRC(tfnrc.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnrc.setForeground(new Color(0, 0, 255));
		tfnrc.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnrc.setBounds(103, 24, 237, 30);
		panel_1.add(tfnrc);
		tfnrc.setColumns(10);
		
		tfnif = new JTextField(provider.getNIF());
		tfnif.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setNIF(tfnif.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnif.setForeground(new Color(0, 0, 255));
		tfnif.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnif.setColumns(10);
		tfnif.setBounds(103, 84, 237, 30);
		panel_1.add(tfnif);
		
		tfbank_account = new JTextField(provider.getBank_account());
		tfbank_account.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setBank_account(tfbank_account.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfbank_account.setForeground(new Color(0, 0, 255));
		tfbank_account.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfbank_account.setColumns(10);
		tfbank_account.setBounds(103, 136, 237, 30);
		panel_1.add(tfbank_account);
		
		tfmail = new JTextField(provider.getMail());
		tfmail.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setMail(tfmail.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfmail.setForeground(new Color(0, 0, 255));
		tfmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfmail.setColumns(10);
		tfmail.setBounds(103, 193, 237, 30);
		panel_1.add(tfmail);
		
		JLabel lblNArt = new JLabel("N° Art");
		lblNArt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNArt.setBounds(358, 25, 46, 14);
		panel_1.add(lblNArt);
		
		JLabel lblNIS = new JLabel("N° I S");
		lblNIS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNIS.setBounds(358, 90, 46, 14);
		panel_1.add(lblNIS);
		
		JLabel lblRIP = new JLabel("R I B");
		lblRIP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRIP.setBounds(358, 136, 55, 26);
		panel_1.add(lblRIP);
		
		JLabel lblSiteWeb = new JLabel("Site Web");
		lblSiteWeb.setIcon(new ImageIcon(this.getClass().getResource("/images/HTTP-icon (1).png")));
		lblSiteWeb.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSiteWeb.setBounds(337, 191, 97, 32);
		panel_1.add(lblSiteWeb);
		
		tfnart = new JTextField(provider.getNART());
		tfnart.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setNART(tfnart.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnart.setForeground(new Color(0, 0, 255));
		tfnart.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnart.setColumns(10);
		tfnart.setBounds(431, 22, 237, 30);
		panel_1.add(tfnart);
		
		tfnis = new JTextField(provider.getNIS());
		tfnis.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setNIS(tfnis.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnis.setForeground(new Color(0, 0, 255));
		tfnis.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnis.setColumns(10);
		tfnis.setBounds(431, 82, 237, 30);
		panel_1.add(tfnis);
		
		tfrib = new JTextField(provider.getRIB());
		tfrib.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setRIB(tfrib.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfrib.setForeground(new Color(0, 0, 255));
		tfrib.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfrib.setColumns(10);
		tfrib.setBounds(431, 134, 237, 30);
		panel_1.add(tfrib);
		
		tfwebsite = new JTextField(provider.getWebsite());
		tfwebsite.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				provider.setWebsite(tfwebsite.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfwebsite.setForeground(new Color(0, 0, 255));
		tfwebsite.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfwebsite.setColumns(10);
		tfwebsite.setBounds(431, 191, 237, 30);
		panel_1.add(tfwebsite);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/images/Money-icon (1).png")));
		lblNewLabel_1.setBounds(3, 135, 32, 32);
		panel_1.add(lblNewLabel_1);
		
		tfcredit = new JTextField(""+provider.getCredit());
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
		tfcredit.setForeground(new Color(0, 0, 255));
		tfcredit.setHorizontalAlignment(SwingConstants.LEFT);
		tfcredit.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfcredit.setBounds(257, 238, 256, 30);
		panel_1.add(tfcredit);
		
		JLabel lblSolde = new JLabel("Solde");
		lblSolde.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSolde.setBounds(208, 234, 39, 34);
		panel_1.add(lblSolde);
		
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAnnuler.setForeground(new Color(255, 51, 51));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnnuler.setIcon(new ImageIcon(this.getClass().getResource("/images/Misc-Delete-Database-icon.png")));
		btnAnnuler.setBounds(507, 350, 113, 44);
		contentPane.add(btnAnnuler);
		
		btnedit = new JButton("Modifier");
		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (provider.update())
					dispose();
				else 
					JOptionPane.showMessageDialog(null, "Modfication pas réussi.");
				Session.showForm(Session.PROVIDERS);						
			}
		});
		btnedit.setIcon(new ImageIcon(UpdateProviderForm.class.getResource("/images/if_user_profile_edit_103781.png")));
		btnedit.setForeground(Color.GREEN);
		btnedit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnedit.setBounds(50, 353, 123, 41);
		contentPane.add(btnedit);
		btnedit.setVisible(true);
	}
}
