package com.home.formes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.home.Session;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class MainForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainForm() {
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est d�connect�.");
			Runtime.getRuntime().exit(0);
		}
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Session.Disconnect();
			}
		});
		
		setTitle("SmartStore V 0.1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/images/logo2.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1521, 690);
		setExtendedState( getExtendedState() | JFrame.MAXIMIZED_BOTH );
		/**
		 * centraliser fen�tre
		 */
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnfichier = new JMenu("Fichier");
		menuBar.add(mnfichier);
		
		JMenuItem mntmTerminer = new JMenuItem("Terminer");
		mntmTerminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Session.Disconnect();
			}
		});
		
		JMenuItem mntmProfile = new JMenuItem("Profile utilisateur");
		mntmProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Session.isSetForm(Session.PROFILE))
					Session.setForm(Session.PROFILE, new ProfileForm(Session.getUser()));
				Session.showForm(Session.PROFILE);
			}
		});
		mnfichier.add(mntmProfile);
		
		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		mntmDconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Session.Disconnect();
			}
		});
		mnfichier.add(mntmDconnexion);
		mntmTerminer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnfichier.add(mntmTerminer);
		
		JMenu mnProduits = new JMenu("Produits");
		menuBar.add(mnProduits);
		
		JMenuItem mntmFamilleDeProduit = new JMenuItem("Famille de produit");
		mntmFamilleDeProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Session.isSetForm(Session.FAMILIES))
					Session.setForm(Session.FAMILIES, new FamiliesForm());
				Session.showForm(Session.FAMILIES);
			}
		});
		mnProduits.add(mntmFamilleDeProduit);
		
		JMenuItem mntmListesDesProduits = new JMenuItem("Listes des produits");
		mntmListesDesProduits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Session.isSetForm(Session.PRODUCTS))
					Session.setForm(Session.PRODUCTS, new ProductsForm());
				Session.showForm(Session.PRODUCTS);
			}
		});
		mnProduits.add(mntmListesDesProduits);
		
		JMenu mnAffichage = new JMenu("Affichage");
		menuBar.add(mnAffichage);
		
		JMenu mnOutils = new JMenu("Outils");
		menuBar.add(mnOutils);
		
		JMenuItem mntmConfiguration = new JMenuItem("Configuration");
		mntmConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!Session.isSetForm(Session.CONFIGURATION))
					Session.setForm(Session.CONFIGURATION, new ConfigurationForm());
				Session.showForm(Session.CONFIGURATION);
			}
		});
		mnOutils.add(mntmConfiguration);
		
		JMenu mnAide = new JMenu("?");
		menuBar.add(mnAide);
		
		JMenuItem mntmAPropos = new JMenuItem("\u00C2 propos SmartStore");
		mnAide.add(mntmAPropos);
		
		//this.pack();
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOpaque(false);
		toolBar.setRollover(true);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1887, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(219, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("Clients");
		btnNewButton.setOpaque(false);
		btnNewButton.setSize(getMaximumSize());
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!Session.isSetForm(Session.CLIENTS))
					Session.setForm(Session.CLIENTS, new ClientsForm());
				Session.showForm(Session.CLIENTS);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon(MainForm.class.getResource("/images/Client.png")));
		
		JButton btnFournisseur = new JButton("Fournisseurs");
		btnFournisseur.setOpaque(false);
		btnFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!Session.isSetForm(Session.PROVIDERS))
					Session.setForm(Session.PROVIDERS, new ProvidersForm());
				Session.showForm(Session.PROVIDERS);
			}
		});
		toolBar.add(btnFournisseur);
		btnFournisseur.setIcon(new ImageIcon(MainForm.class.getResource("/images/fournisseur.png")));
		btnFournisseur.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnProduis = new JButton("Produits");
		btnProduis.setOpaque(false);
		btnProduis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!Session.isSetForm(Session.PRODUCTS))
					Session.setForm(Session.PRODUCTS, new ProductsForm());
				Session.showForm(Session.PRODUCTS);
			}
		});
		toolBar.add(btnProduis);
		btnProduis.setIcon(new ImageIcon(MainForm.class.getResource("/images/produit.png")));
		btnProduis.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnBonDachat = new JButton("Achats");
		btnBonDachat.setOpaque(false);
		btnBonDachat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		toolBar.add(btnBonDachat);
		btnBonDachat.setIcon(new ImageIcon(MainForm.class.getResource("/images/achat.png")));
		btnBonDachat.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnVents = new JButton("Vents");
		btnVents.setOpaque(false);
		btnVents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		toolBar.add(btnVents);
		btnVents.setIcon(new ImageIcon(MainForm.class.getResource("/images/vents.png")));
		btnVents.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setLayout(gl_contentPane);
	}
}
