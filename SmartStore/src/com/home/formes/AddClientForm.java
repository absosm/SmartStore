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
	private JLabel 	  id_label;

	/**
	 * Create the frame.
	 */
	public AddClientForm() {
		
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
		
		tflastname = new JTextField();
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
		tflastname.setBounds(69, 8, 242, 30);
		panel.add(tflastname);
		tflastname.setColumns(10);
		
		tffirstname = new JTextField();
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
		
		tfaddress = new JTextField();
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
		tfaddress.setBounds(69, 52, 326, 30);
		panel.add(tfaddress);
		
		tffamily = new JTextField();
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
		
		tfzip = new JTextField();
		tfzip.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setZip(tfzip.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		Filter.TextField(tfzip, Filter.ZIP);
		tfzip.setText("0");
		tfzip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfzip.setBounds(69, 93, 63, 30);
		panel.add(tfzip);
		
		JLabel lblWilaya = new JLabel("Wilaya");
		lblWilaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWilaya.setBounds(142, 93, 46, 22);
		panel.add(lblWilaya);
		
		cbcity = new JComboBox<Object>();
		cbcity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.setCity(cbcity.getSelectedIndex());
			}
		});
		cbcity.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbcity.setModel(new DefaultComboBoxModel<Object>(new String[] {""}));
		cbcity.setSelectedIndex(0);
		cbcity.setBounds(465, 92, 165, 29);
		panel.add(cbcity);
		
		cbwilaya = new JComboBox<Object>();
		cbwilaya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbcity.setModel(new DefaultComboBoxModel<Object>(Cities.LoadCities(cbwilaya.getSelectedIndex()+1)));
				client.setWilaya(cbwilaya.getSelectedIndex());
			}
		});
		cbwilaya.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbwilaya.setModel(new DefaultComboBoxModel<Object>(Cities.LoadWilaya()));
		cbwilaya.setSelectedIndex(6);
		cbwilaya.setBounds(191, 92, 178, 29);
		panel.add(cbwilaya);
		
		JLabel lblCommune = new JLabel("Commune");
		lblCommune.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCommune.setBounds(383, 98, 71, 21);
		panel.add(lblCommune);
		
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
		
		tfmobile = new JTextField();
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
		tfmobile.setBounds(69, 138, 326, 30);
		panel.add(tfmobile);
		
		tfphone = new JTextField();
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
		tfphone.setBounds(69, 185, 326, 30);
		panel.add(tfphone);
		
		tffax = new JTextField();
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
		tffax.setBounds(69, 227, 326, 30);
		panel.add(tffax);
		
		id_label = new JLabel("");
		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		id_label.setFont(new Font("Tahoma", Font.BOLD, 14));
		id_label.setBounds(480, 186, 151, 29);
		panel.add(id_label);
		
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
		
		tfnrc = new JTextField();
		tfnrc.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setNRC(tfnrc.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnrc.setForeground(new Color(0, 102, 204));
		tfnrc.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnrc.setBounds(103, 24, 237, 30);
		panel_1.add(tfnrc);
		tfnrc.setColumns(10);
		
		tfnif = new JTextField();
		tfnif.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setNIF(tfnif.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnif.setForeground(new Color(0, 102, 204));
		tfnif.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnif.setColumns(10);
		tfnif.setBounds(103, 84, 237, 30);
		panel_1.add(tfnif);
		
		tfbank_account = new JTextField();
		tfbank_account.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setBank_account(tfbank_account.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfbank_account.setForeground(new Color(0, 102, 204));
		tfbank_account.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfbank_account.setColumns(10);
		tfbank_account.setBounds(103, 136, 237, 30);
		panel_1.add(tfbank_account);
		
		tfmail = new JTextField();
		tfmail.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setMail(tfmail.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfmail.setForeground(new Color(0, 102, 204));
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
		
		tfnart = new JTextField();
		tfnart.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setNART(tfnart.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnart.setForeground(new Color(0, 102, 204));
		tfnart.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnart.setColumns(10);
		tfnart.setBounds(431, 22, 237, 30);
		panel_1.add(tfnart);
		
		tfnis = new JTextField();
		tfnis.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setNIS(tfnis.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfnis.setForeground(new Color(0, 102, 204));
		tfnis.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnis.setColumns(10);
		tfnis.setBounds(431, 82, 237, 30);
		panel_1.add(tfnis);
		
		tfrib = new JTextField();
		tfrib.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setRIB(tfrib.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfrib.setForeground(new Color(0, 102, 204));
		tfrib.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfrib.setColumns(10);
		tfrib.setBounds(431, 134, 237, 30);
		panel_1.add(tfrib);
		
		tfwebsite = new JTextField();
		tfwebsite.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				client.setWebsite(tfwebsite.getText());
			}
			public void changedUpdate(DocumentEvent e) {warn();}
			public void insertUpdate(DocumentEvent e) {warn();}
			public void removeUpdate(DocumentEvent e) {warn();}
			
		});
		tfwebsite.setForeground(new Color(0, 102, 204));
		tfwebsite.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfwebsite.setColumns(10);
		tfwebsite.setBounds(431, 191, 237, 30);
		panel_1.add(tfwebsite);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/images/Money-icon (1).png")));
		lblNewLabel_1.setBounds(3, 135, 32, 32);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tarification", new ImageIcon(this.getClass().getResource("/images/Pricing-icon.png")), panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblModeDeTarif = new JLabel("Mode de Tarif");
		lblModeDeTarif.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModeDeTarif.setBounds(10, 26, 94, 17);
		panel_2.add(lblModeDeTarif);
		
		cbmode = new JComboBox<Object>();
		cbmode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.setMode(cbmode.getSelectedIndex());
			}
		});
		cbmode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbmode.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Aucun Tarif>", "Tarif 1", "Tarif 2", "Tarif 3", "Tarif 4", "Tarif 5"}));
		cbmode.setSelectedIndex(0);
		cbmode.setEditable(true);
		cbmode.setBounds(119, 21, 256, 30);
		panel_2.add(cbmode);
		
		JLabel lblNewLabel_2 = new JLabel("Limitation");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 70, 68, 17);
		panel_2.add(lblNewLabel_2);
		
		tfcredit_limit = new JTextField();
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
		tfcredit_limit.setText("0");
		tfcredit_limit.setBounds(119, 71, 256, 30);
		panel_2.add(tfcredit_limit);
		tfcredit_limit.setColumns(10);
		
		JLabel lblDeCre = new JLabel("de crédit");
		lblDeCre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeCre.setBounds(10, 90, 60, 17);
		panel_2.add(lblDeCre);
		
		JLabel lblsoldeinitial = new JLabel("<html>Solde<br>Initial</html>");
		lblsoldeinitial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsoldeinitial.setBounds(31, 127, 39, 34);
		panel_2.add(lblsoldeinitial);
		
		tfcredit = new JTextField();
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
		tfcredit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfcredit.setColumns(10);
		tfcredit.setBounds(119, 131, 256, 30);
		panel_2.add(tfcredit);
		
		btnOk = new JButton("ok");
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
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setIcon(new ImageIcon(this.getClass().getResource("/images/database-accept-icon.png")));
		btnOk.setBounds(72, 353, 77, 41);
		contentPane.add(btnOk);
		
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
		
		setVisible(true);
	}	
}
