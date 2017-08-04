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
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainWindow frame = new MainWindow();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //full screen
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
	public MainWindow() {
		setTitle("LIGHT WORK");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images_Resource/logo2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		//this.pack();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Clients");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	new Liste_des_Clients();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon(MainWindow.class.getResource("/images_Resource/Client.png")));
		btnNewButton.setBounds(10, 66, 171, 63);
		contentPane.add(btnNewButton);
		
		JButton btnFournisseur = new JButton("Fournisseurs");
		btnFournisseur.setIcon(new ImageIcon(MainWindow.class.getResource("/images_Resource/fournisseur.png")));
		btnFournisseur.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFournisseur.setBounds(191, 66, 175, 63);
		contentPane.add(btnFournisseur);
		
		JButton btnProduis = new JButton("Produits");
		btnProduis.setIcon(new ImageIcon(MainWindow.class.getResource("/images_Resource/produit.png")));
		btnProduis.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProduis.setBounds(376, 66, 175, 63);
		contentPane.add(btnProduis);
		
		JButton btnBonDachat = new JButton("Achats");
		btnBonDachat.setIcon(new ImageIcon(MainWindow.class.getResource("/images_Resource/achat.png")));
		btnBonDachat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBonDachat.setBounds(561, 66, 175, 63);
		contentPane.add(btnBonDachat);
		
		JButton btnVents = new JButton("Vents");
		btnVents.setIcon(new ImageIcon(MainWindow.class.getResource("/images_Resource/vents.png")));
		btnVents.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVents.setBounds(746, 66, 182, 63);
		contentPane.add(btnVents);
	}
}
