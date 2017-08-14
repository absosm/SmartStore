package com.home.formes;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.home.DataBase;
import com.home.Session;
import com.home.Use_Files;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import javafx.scene.control.ComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddProducts extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static  JTextField tf_Prix_Achat;
	private static JTextField tf_Prix_Vente1;
	private static JTextField tf_Prix_Vente2;
	private static JTextField tf_Prix_Vente3;
	private static JTextField tf_Prix_Vente4;
	private static JTextField tf_Prix_Vente5;
	private static JTextField tf_Prix_Vente6;
	private static JTextField tf_Boni1;
	private static JTextField tf_Boni2;
	private static JTextField tf_Boni3;
	private static JTextField tf_Boni4;
	private static JTextField tf_Boni5;
	private static JTextField tf_Boni6;
	private static JLabel Labe_Image ;
	private static JComboBox comboBox_famille;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AddProducts frame = new AddProducts();
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
	public AddProducts() {
		setTitle("Ajouter Produit");
		setFont(new Font("Tahoma", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_2 = new JButton("Annuler");
		btnNewButton_2.setIcon(new ImageIcon(AddProducts.class.getResource("/images/1490388962_DeleteRed.png")));
		
		JButton btnOk = new JButton("OK");
		btnOk.setIcon(new ImageIcon(AddProducts.class.getResource("/images/database-accept-icon.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(120)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(170))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("G\u00E9n\u00E9ral", new ImageIcon(AddProducts.class.getResource("/images/Download-Folder-icon.png")), panel, null);
		
		JLabel lblNewLabel = new JLabel("Code produit");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDsignation = new JLabel("D\u00E9signation Produit");
		lblDsignation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFamille = new JLabel("Famille");
		lblFamille.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Stock Initial");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Stock actuel");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDateDuStock = new JLabel("Date du stock initial");
		lblDateDuStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		comboBox_famille = new JComboBox();
		comboBox_famille.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBox_famille.removeAllItems();
				DataBase database=Session.getDatabase();
				Remplire_Combobox(database.getResult("Select designation from families"),comboBox_famille);	
			}
		});
		
		JComboBox comboBox_1 = new JComboBox();
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Session.setForm(Session.FAMILIES, new FamiliesForm());
				Session.showForm(Session.FAMILIES);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddProducts.class.getResource("/images/add.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblDsignation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addComponent(lblFamille, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDateDuStock, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(comboBox_famille, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textField_3, Alignment.LEADING)
							.addComponent(textField_2, Alignment.LEADING)
							.addComponent(comboBox_1, Alignment.LEADING, 0, 251, Short.MAX_VALUE)))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblDsignation))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_famille, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFamille)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateDuStock)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(139))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Plus d'info", new ImageIcon(AddProducts.class.getResource("/images/Button-Info-icon.png")), panel_1, null);
		
		JLabel lblNewLabel_3 = new JLabel("Prix d'achat");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrixVente = new JLabel("Prix Vente 1");
		lblPrixVente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrixVente_1 = new JLabel("Prix Vente 2");
		lblPrixVente_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrixVente_2 = new JLabel("Prix Vente 3");
		lblPrixVente_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrixVente_3 = new JLabel("Prix Vente 4");
		lblPrixVente_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrixVente_4 = new JLabel("Prix Vente 5");
		lblPrixVente_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrixVente_5 = new JLabel("Prix Vente 6");
		lblPrixVente_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_Prix_Achat = new JTextField();
		tf_Prix_Achat.setColumns(10);
		
		tf_Prix_Vente1 = new JTextField();
		tf_Prix_Vente1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

				tf_Boni1.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente1.getText().toString())));
				
				
				
			}
		});
		tf_Prix_Vente1.setColumns(10);
		
		tf_Prix_Vente2 = new JTextField();
		tf_Prix_Vente2.setColumns(10);
		
		tf_Prix_Vente3 = new JTextField();
		tf_Prix_Vente3.setColumns(10);
		
		tf_Prix_Vente4 = new JTextField();
		tf_Prix_Vente4.setColumns(10);
		
		tf_Prix_Vente5 = new JTextField();
		tf_Prix_Vente5.setColumns(10);
		
		tf_Prix_Vente6 = new JTextField();
		tf_Prix_Vente6.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("PRIX");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblBoni = new JLabel("BONI");
		lblBoni.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_Boni1 = new JTextField();
		tf_Boni1.setBackground(new Color(204, 255, 204));
		tf_Boni1.setColumns(10);
		
		tf_Boni2 = new JTextField();
		tf_Boni2.setBackground(new Color(204, 255, 204));
		tf_Boni2.setColumns(10);
		
		tf_Boni3 = new JTextField();
		tf_Boni3.setBackground(new Color(204, 255, 204));
		tf_Boni3.setColumns(10);
		
		tf_Boni4 = new JTextField();
		tf_Boni4.setBackground(new Color(204, 255, 204));
		tf_Boni4.setColumns(10);
		
		tf_Boni5 = new JTextField();
		tf_Boni5.setBackground(new Color(204, 255, 204));
		tf_Boni5.setColumns(10);
		
		tf_Boni6 = new JTextField();
		tf_Boni6.setBackground(new Color(204, 255, 204));
		tf_Boni6.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tf_Prix_Achat, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrixVente_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrixVente)
								.addComponent(lblPrixVente_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrixVente_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrixVente_4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrixVente_5, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tf_Prix_Vente5, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(tf_Prix_Vente4, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(tf_Prix_Vente3, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(tf_Prix_Vente2, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(tf_Prix_Vente1, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(tf_Prix_Vente6, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tf_Boni6, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni5, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBoni, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(121, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(tf_Prix_Achat, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(lblBoni, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrixVente)
								.addComponent(tf_Prix_Vente1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrixVente_1)
								.addComponent(tf_Prix_Vente2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrixVente_2)
								.addComponent(tf_Prix_Vente3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrixVente_3)
								.addComponent(tf_Prix_Vente4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrixVente_4)
								.addComponent(tf_Prix_Vente5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrixVente_5)
								.addComponent(tf_Prix_Vente6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Boni6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		
		JLabel lblDateDePremption = new JLabel("<html>Date de <br>p\u00E9remption</br></html>");
		lblDateDePremption.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateDePremption.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("<html>Date de <br>p\u00E9remption</br></html>");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox comboBox_2 = new JComboBox();
		
		JLabel lblnombreDesJours = new JLabel("<html>Nombre des <br> jours d'alerte</br></html>");
		lblnombreDesJours.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnombreDesJours.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox comboBox_3 = new JComboBox();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDateDePremption)
							.addGap(36)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addComponent(lblnombreDesJours, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addGap(38)
							.addComponent(chckbxNewCheckBox)
							.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateDePremption)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblnombreDesJours, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(chckbxNewCheckBox))
					.addContainerGap(207, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Photo Produit", new ImageIcon(AddProducts.class.getResource("/images/photo-camera-x32.png")), panel_2, null);
		
		JPanel Image_panel = new JPanel();
		Image_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnNewButton = new JButton("Ajout\u00E9 une Photo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Labe_Image.setIcon(Use_Files.Image(Use_Files.filechooser_Images()));
					//Labe_Image.seti
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddProducts.class.getResource("/images/add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnAnnulerLaPhoto = new JButton("Annuler la Photo");
		btnAnnulerLaPhoto.setIcon(new ImageIcon(AddProducts.class.getResource("/images/cancel.png")));
		btnAnnulerLaPhoto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(56)
					.addComponent(Image_panel, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAnnulerLaPhoto, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAnnulerLaPhoto, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addComponent(Image_panel, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		Labe_Image = new JLabel("Image");
		Labe_Image.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_Image_panel = new GroupLayout(Image_panel);
		gl_Image_panel.setHorizontalGroup(
			gl_Image_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(Labe_Image, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
		);
		gl_Image_panel.setVerticalGroup(
			gl_Image_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(Labe_Image, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
		);
		Image_panel.setLayout(gl_Image_panel);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
	private static void Remplire_Combobox(ResultSet result , JComboBox combobox){
		try {
			while(result.next()){
				combobox.addItem(result.getString(1));
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	private static double Calcule_Boni(String prix_achat ,String prix_vent)
	{
		if(!prix_achat.equals("")){
			double boni=0.00;
			double prix_Achat=0.00;
			double prix_Vent=0.00;
			double one=1.00;
			double hundred=100.00;
			prix_Achat=Double.parseDouble(prix_achat);
			prix_Vent=Double.parseDouble(prix_vent);
			boni=((prix_Vent/prix_Achat)-one)*hundred;
			return boni;
		}
		return 0.00;
	}
}
