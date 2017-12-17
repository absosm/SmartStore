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
		setContentPane(contentPane);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel = new JPanel();   
		//panel.setBackground(Color.LIGHT_GRAY);
		panel.setToolTipText("");
		tabbedPane.addTab("G\u00E9n\u00E9ral   ", new ImageIcon(this.getClass().getResource("/images/Download-Folder-icon.png")), panel, "Des informations générales");
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(35, 48, 46, 32);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tflastname = new JTextField();
		tflastname.setBounds(91, 48, 242, 32);
		panel_2.add(tflastname);
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
		tflastname.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prénom ");
		lblPrenom.setBounds(340, 48, 63, 32);
		panel_2.add(lblPrenom);
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffirstname = new JTextField();
		tffirstname.setBounds(418, 49, 232, 30);
		panel_2.add(tffirstname);
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
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresse.setBounds(18, 88, 63, 32);
		panel_2.add(lblAdresse);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfaddress = new JTextField();
		tfaddress.setBounds(91, 89, 384, 30);
		panel_2.add(tfaddress);
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
		
		JLabel lblFamille = new JLabel("Famille");
		lblFamille.setBounds(25, 8, 56, 32);
		panel_2.add(lblFamille);
		lblFamille.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFamille.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffamily = new JTextField();
		tffamily.setBounds(91, 10, 165, 30);
		panel_2.add(tffamily);
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
		
		JLabel lblCode = new JLabel("Code postale");
		lblCode.setBounds(482, 88, 90, 32);
		panel_2.add(lblCode);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfzip = new JTextField();
		tfzip.setBounds(587, 89, 63, 30);
		panel_2.add(tfzip);
		tfzip.setForeground(new Color(0, 0, 255));
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
		lblWilaya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWilaya.setBounds(35, 128, 46, 32);
		panel_2.add(lblWilaya);
		lblWilaya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbcity = new JComboBox<Object>();
		cbcity.setBounds(418, 130, 232, 29);
		panel_2.add(cbcity);
		cbcity.setForeground(new Color(0, 0, 255));
		cbcity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provider.setCity(cbcity.getSelectedIndex());
			}
		});
		cbcity.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbcity.setModel(new DefaultComboBoxModel<Object>(new String[] {""}));
		cbcity.setSelectedIndex(0);
		
		cbwilaya = new JComboBox<Object>();
		cbwilaya.setBounds(91, 130, 242, 29);
		panel_2.add(cbwilaya);
		cbwilaya.setForeground(new Color(0, 0, 255));
		cbwilaya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbcity.setModel(new DefaultComboBoxModel<Object>(Cities.LoadCities(cbwilaya.getSelectedIndex()+1)));
				provider.setWilaya(cbwilaya.getSelectedIndex());
			}
		});
		cbwilaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbwilaya.setModel(new DefaultComboBoxModel<Object>(Cities.LoadWilaya()));
		cbwilaya.setSelectedIndex(6);
		
		JLabel lblCommune = new JLabel("Commune");
		lblCommune.setBounds(340, 128, 71, 32);
		panel_2.add(lblCommune);
		lblCommune.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTel = new JLabel("Mob");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setBounds(18, 168, 63, 32);
		panel_2.add(lblTel);
		lblTel.setIcon(new ImageIcon(this.getClass().getResource("/images/Mobile-icon.png")));
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfmobile = new JTextField();
		tfmobile.setBounds(91, 169, 165, 30);
		panel_2.add(tfmobile);
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
		
		JLabel lblTl = new JLabel("TEL");
		lblTl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTl.setBounds(10, 208, 71, 32);
		panel_2.add(lblTl);
		lblTl.setIcon(new ImageIcon(this.getClass().getResource("/images/phone-icon.png")));
		lblTl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfphone = new JTextField();
		tfphone.setBounds(91, 209, 165, 30);
		panel_2.add(tfphone);
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
		
		JLabel lblFax = new JLabel("FAX");
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFax.setBounds(21, 248, 60, 32);
		panel_2.add(lblFax);
		lblFax.setIcon(new ImageIcon(this.getClass().getResource("/images/Fax-icon.png")));
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tffax = new JTextField();
		tffax.setBounds(91, 249, 165, 30);
		panel_2.add(tffax);
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
		panel_1.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Plus information   ", new ImageIcon(this.getClass().getResource("/images/Button-Info-icon.png")), panel_1, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		
		JLabel lblN = new JLabel("N° R C");
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setBounds(47, 8, 46, 32);
		panel_3.add(lblN);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnrc = new JTextField();
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
		tfnrc.setForeground(new Color(0, 0, 255));
		tfnrc.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnrc.setColumns(10);
		
		JLabel lblNArt = new JLabel("N° Art");
		lblNArt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNArt.setBounds(362, 8, 46, 32);
		panel_3.add(lblNArt);
		lblNArt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnart = new JTextField();
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
		tfnart.setForeground(new Color(0, 0, 255));
		tfnart.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnart.setColumns(10);
		
		JLabel lblNIF = new JLabel("N° I F");
		lblNIF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNIF.setBounds(47, 48, 46, 32);
		panel_3.add(lblNIF);
		lblNIF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnif = new JTextField();
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
		tfnif.setForeground(new Color(0, 0, 255));
		tfnif.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnif.setColumns(10);
		
		JLabel lblNIS = new JLabel("N° I S");
		lblNIS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNIS.setBounds(362, 48, 46, 32);
		panel_3.add(lblNIS);
		lblNIS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfnis = new JTextField();
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
		tfnis.setForeground(new Color(0, 0, 255));
		tfnis.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnis.setColumns(10);
		
		JLabel lblCompte = new JLabel("Compte Bank");
		lblCompte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompte.setBounds(10, 88, 83, 32);
		panel_3.add(lblCompte);
		lblCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfbank_account = new JTextField();
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
		tfbank_account.setForeground(new Color(0, 0, 255));
		tfbank_account.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfbank_account.setColumns(10);
		
		JLabel lblRIP = new JLabel("R I B");
		lblRIP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRIP.setBounds(353, 88, 55, 32);
		panel_3.add(lblRIP);
		lblRIP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfrib = new JTextField();
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
		tfrib.setForeground(new Color(0, 0, 255));
		tfrib.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfrib.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(29, 128, 64, 32);
		panel_3.add(lblEmail);
		lblEmail.setIcon(new ImageIcon(this.getClass().getResource("/images/email-2-icon (1).png")));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfmail = new JTextField();
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
		tfmail.setForeground(new Color(0, 0, 255));
		tfmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfmail.setColumns(10);
		
		JLabel lblSiteWeb = new JLabel("Site Web");
		lblSiteWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSiteWeb.setBounds(311, 128, 97, 32);
		panel_3.add(lblSiteWeb);
		lblSiteWeb.setIcon(new ImageIcon(this.getClass().getResource("/images/HTTP-icon (1).png")));
		lblSiteWeb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfwebsite = new JTextField();
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
		tfwebsite.setForeground(new Color(0, 0, 255));
		tfwebsite.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfwebsite.setColumns(10);
		
		JLabel lblSolde = new JLabel("Solde:");
		lblSolde.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSolde.setBounds(15, 168, 78, 32);
		panel_3.add(lblSolde);
		lblSolde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfcredit = new JTextField();
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
		tfcredit.setForeground(new Color(0, 0, 255));
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
		
		btnOk = new JButton("ok");
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
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setIcon(new ImageIcon(this.getClass().getResource("/images/database-accept-icon.png")));
		
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();					
			}
		});
		btnAnnuler.setForeground(new Color(255, 51, 51));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 14));
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
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);
	}	
}
