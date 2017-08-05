package com.home;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class MainForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainForm frame = new MainForm();
					//frame.setUndecorated(true);                    // annuller le rectangle
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainForm() {
		
		setTitle("SmartStore V 0.1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/images_Resource/logo2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);
		setExtendedState( getExtendedState() | JFrame.MAXIMIZED_BOTH );
		/**
		 * centraliser fenètre
		 */
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnfichier = new JMenu("Fichier");
		menuBar.add(mnfichier);
		
		JMenuItem mntmTerminer = new JMenuItem("Terminer");
		mntmTerminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JMenuItem mntmProfile = new JMenuItem("Profile utilisateur");
		mntmProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Session.setProfileForm(new ProfileForm(Session.getUser()));
				Session.showProfileForm();
			}
		});
		mnfichier.add(mntmProfile);
		mntmTerminer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnfichier.add(mntmTerminer);
		
		JMenu mnEdi = new JMenu("Edition");
		menuBar.add(mnEdi);
		
		JMenu mnAffichage = new JMenu("Affichage");
		menuBar.add(mnAffichage);
		
		JMenu mnOutils = new JMenu("Outils");
		menuBar.add(mnOutils);
		
		JMenu mnAide = new JMenu("?");
		menuBar.add(mnAide);
		
		JMenuItem mntmAPropos = new JMenuItem("\u00C2 propos SmartStore");
		mnAide.add(mntmAPropos);
		
		//this.pack();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(640, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("Clients");
		btnNewButton.setSize(getMaximumSize());
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	new Liste_des_Clients();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon(MainForm.class.getResource("/images_Resource/Client.png")));
		
		JButton btnFournisseur = new JButton("Fournisseurs");
		toolBar.add(btnFournisseur);
		btnFournisseur.setIcon(new ImageIcon(MainForm.class.getResource("/images_Resource/fournisseur.png")));
		btnFournisseur.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnProduis = new JButton("Produits");
		toolBar.add(btnProduis);
		btnProduis.setIcon(new ImageIcon(MainForm.class.getResource("/images_Resource/produit.png")));
		btnProduis.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnBonDachat = new JButton("Achats");
		toolBar.add(btnBonDachat);
		btnBonDachat.setIcon(new ImageIcon(MainForm.class.getResource("/images_Resource/achat.png")));
		btnBonDachat.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnVents = new JButton("Vents");
		toolBar.add(btnVents);
		btnVents.setIcon(new ImageIcon(MainForm.class.getResource("/images_Resource/vents.png")));
		btnVents.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setLayout(gl_contentPane);
	}
}
