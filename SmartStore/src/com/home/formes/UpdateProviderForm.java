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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		setResizable(false);
		
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
		setBounds(100, 100, 710, 498);
		contentPane = new JPanel();
		setContentPane(contentPane);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 684, 388);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel = new JPanel();   
		//panel.setBackground(Color.LIGHT_GRAY);
		panel.setToolTipText("");
		tabbedPane.addTab("G\u00E9n\u00E9ral   ", new ImageIcon(this.getClass().getResource("/images/Download-Folder-icon.png")), panel, "Des informations générales");
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(24, 46, 46, 32);
		panel_2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(322, 46, 71, 32);
		panel_2.add(lblPrenom);
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tflastname = new JTextField(provider.getLastname());
		tflastname.setBounds(81, 46, 242, 32);
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
		tflastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tflastname.setColumns(10);
		
		tffirstname = new JTextField(provider.getFirstname());
		tffirstname.setBounds(403, 46, 242, 32);
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
		tffirstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tffirstname.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(14, 85, 56, 32);
		panel_2.add(lblAdresse);
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFamille = new JLabel("Famille");
		lblFamille.setBounds(14, 7, 56, 32);
		panel_2.add(lblFamille);
		lblFamille.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFamille.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfaddress = new JTextField(provider.getAddress());
		tfaddress.setBounds(81, 85, 400, 32);
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
		tfaddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfaddress.setColumns(10);
		
		tffamily = new JTextField(provider.getFamily());
		tffamily.setBounds(81, 7, 165, 32);
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
		tffamily.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tffamily.setColumns(10);
		
		JLabel lblCode = new JLabel("Code postale");
		lblCode.setBounds(486, 85, 86, 32);
		panel_2.add(lblCode);
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfzip = new JTextField(provider.getZip());
		tfzip.setBounds(582, 85, 63, 32);
		panel_2.add(tfzip);
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
		tfzip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfzip.setColumns(10);
		
		JLabel lblCommune = new JLabel("Commune");
		lblCommune.setBounds(322, 124, 71, 32);
		panel_2.add(lblCommune);
		lblCommune.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCommune.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbcity = new JComboBox<Object>();
		cbcity.setBounds(403, 124, 242, 32);
		panel_2.add(cbcity);
		cbcity.setForeground(new Color(0, 0, 255));
		cbcity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbcity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				provider.setCity(cbcity.getSelectedIndex());
			}
		});
		
		JLabel lblWilaya = new JLabel("Wilaya");
		lblWilaya.setBounds(24, 124, 46, 32);
		panel_2.add(lblWilaya);
		lblWilaya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWilaya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbwilaya = new JComboBox<Object>(new DefaultComboBoxModel<Object>(Cities.LoadWilaya()));
		cbwilaya.setBounds(81, 124, 242, 32);
		panel_2.add(cbwilaya);
		cbwilaya.setForeground(new Color(0, 0, 255));
		cbwilaya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbcity.setModel(new DefaultComboBoxModel<Object>(Cities.LoadCities(cbwilaya.getSelectedIndex())));
				provider.setWilaya(cbwilaya.getSelectedIndex());
			}
		});
		cbwilaya.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbwilaya.setSelectedIndex(provider.getWilaya());
		cbcity.setSelectedIndex(provider.getCity());
		
		JLabel lblTel = new JLabel("Mob");
		lblTel.setBounds(0, 163, 70, 32);
		panel_2.add(lblTel);
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setIcon(new ImageIcon(this.getClass().getResource("/images/Mobile-icon.png")));
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTl = new JLabel("TEL");
		lblTl.setBounds(10, 202, 60, 32);
		panel_2.add(lblTl);
		lblTl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTl.setIcon(new ImageIcon(this.getClass().getResource("/images/phone-icon.png")));
		lblTl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFax = new JLabel("FAX");
		lblFax.setBounds(10, 241, 60, 32);
		panel_2.add(lblFax);
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFax.setIcon(new ImageIcon(this.getClass().getResource("/images/Fax-icon.png")));
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfmobile = new JTextField(provider.getMobile());
		tfmobile.setBounds(81, 163, 165, 32);
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
		tfmobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfmobile.setColumns(10);
		
		tfphone = new JTextField(provider.getPhone());
		tfphone.setBounds(81, 202, 165, 32);
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
		tfphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfphone.setColumns(10);
		
		tffax = new JTextField(provider.getFax());
		tffax.setBounds(81, 241, 165, 32);
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
		tffax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tffax.setColumns(10);
		
		id_label = new JLabel("N\u00B0Client");
		id_label.setBounds(398, 178, 107, 32);
		panel_2.add(id_label);
		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		id_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfid = new JTextField(String.format("%06d", provider.getId()));
		tfid.setBounds(398, 214, 107, 32);
		panel_2.add(tfid);
		tfid.setEditable(false);
		tfid.setHorizontalAlignment(SwingConstants.CENTER);
		tfid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfid.setForeground(new Color(0, 0, 255));
		tfid.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 655, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Plus information", new ImageIcon(this.getClass().getResource("/images/Button-Info-icon.png")), panel_1, null);
		
		JPanel panel_3 = new JPanel();
		
		JLabel lblN = new JLabel("N° R C");
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNIF = new JLabel("N° I F");
		lblNIF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNIF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCompte = new JLabel("Compte bank");
		lblCompte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setIcon(new ImageIcon(this.getClass().getResource("/images/email-2-icon (1).png")));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
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
		tfnrc.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		tfnif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfnif.setColumns(10);
		
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
		tfbank_account.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfbank_account.setColumns(10);
		
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
		tfmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfmail.setColumns(10);
		
		JLabel lblNArt = new JLabel("N° Art");
		lblNArt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNArt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNIS = new JLabel("N° I S");
		lblNIS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNIS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRIP = new JLabel("R I B");
		lblRIP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRIP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSiteWeb = new JLabel("Site Web");
		lblSiteWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSiteWeb.setIcon(new ImageIcon(this.getClass().getResource("/images/HTTP-icon (1).png")));
		lblSiteWeb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
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
		tfnart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfnart.setColumns(10);
		
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
		tfnis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfnis.setColumns(10);
		
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
		tfrib.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfrib.setColumns(10);
		
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
		tfwebsite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfwebsite.setColumns(10);
		
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
		tfcredit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSolde = new JLabel("Solde");
		lblSolde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(10)
					.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tfnrc, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNArt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(tfnart, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNIF, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tfnif, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNIS, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(tfnis, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(10)
					.addComponent(lblCompte)
					.addGap(10)
					.addComponent(tfbank_account, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblRIP, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(tfrib, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(10)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tfmail, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblSiteWeb, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(tfwebsite, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(208)
					.addComponent(lblSolde, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tfcredit, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfnrc, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNArt, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfnart, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNIF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfnif, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNIS, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfnis, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCompte, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfbank_account, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRIP, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfrib, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSiteWeb)
						.addComponent(tfwebsite, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSolde, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfcredit, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
		);
		panel_3.setLayout(gl_panel_3);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 636, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(42)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.setBounds(427, 410, 123, 44);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAnnuler.setForeground(new Color(255, 51, 51));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnnuler.setIcon(new ImageIcon(this.getClass().getResource("/images/Misc-Delete-Database-icon.png")));
		
		btnedit = new JButton("Modifier");
		btnedit.setBounds(152, 413, 123, 41);
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
		contentPane.setLayout(null);
		contentPane.add(tabbedPane);
		contentPane.add(btnedit);
		contentPane.add(btnAnnuler);
		btnedit.setVisible(true);
	}
}
