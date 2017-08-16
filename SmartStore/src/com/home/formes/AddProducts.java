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
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

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
	private static JLabel lb_path_Image;
	private static JPanel Image_panel;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	

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
		setBounds(100, 100, 750, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_2 = new JButton("Annuler");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AddProducts.class.getResource("/images/1490388962_DeleteRed.png")));
		
		JButton btnOk = new JButton("OK");
		btnOk.setIcon(new ImageIcon(AddProducts.class.getResource("/images/database-accept-icon.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(120)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(170))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
			public void mouseReleased(MouseEvent e) {
				comboBox_famille.removeAllItems();
				DataBase database=Session.getDatabase();
				Remplire_Combobox(database.getResult("Select designation from families"),comboBox_famille);
				}
		});
		
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
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setIcon(new ImageIcon(AddProducts.class.getResource("/images/calendar.png")));
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
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textField_3, Alignment.LEADING)
							.addComponent(textField_2, Alignment.LEADING))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(dateChooser_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(comboBox_famille, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(114, Short.MAX_VALUE))
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
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDateDuStock)
						.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
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
		tf_Prix_Achat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Auto_update_of_Prix_achat();
			}
		});
		tf_Prix_Achat.setColumns(10);
		
		tf_Prix_Vente1 = new JTextField();
		tf_Prix_Vente1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_Boni1.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente1.getText().toString())));
			}
		});
		tf_Prix_Vente1.setColumns(10);
		
		tf_Prix_Vente2 = new JTextField();
		tf_Prix_Vente2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tf_Boni2.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente2.getText().toString())).replace(" ", ""));
			}
		});
		tf_Prix_Vente2.setColumns(10);
		
		tf_Prix_Vente3 = new JTextField();
		tf_Prix_Vente3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tf_Boni3.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente3.getText().toString())).replace(" ", ""));
			}
		});
		tf_Prix_Vente3.setColumns(10);
		
		tf_Prix_Vente4 = new JTextField();
		tf_Prix_Vente4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_Boni4.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente4.getText().toString())).replace(" ", ""));
			}
		});
		tf_Prix_Vente4.setColumns(10);
		
		tf_Prix_Vente5 = new JTextField();
		tf_Prix_Vente5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_Boni5.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente5.getText().toString())).replace(" ", ""));
			}
		});
		tf_Prix_Vente5.setColumns(10);
		
		tf_Prix_Vente6 = new JTextField();
		tf_Prix_Vente6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_Boni6.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente6.getText().toString())).replace(" ", ""));
			}
		});
		tf_Prix_Vente6.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("PRIX");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblBoni = new JLabel("BONI %");
		lblBoni.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_Boni1 = new JTextField();
		tf_Boni1.setBackground(new Color(204, 255, 204));
		tf_Boni1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_Prix_Vente1.setText(String.format("%12.2f",Calcule_Prix_Vent(tf_Prix_Achat.getText().toString() , tf_Boni1.getText().toString())).replace(" ", ""));
			}
		});
		tf_Boni1.setColumns(10);
		
		tf_Boni2 = new JTextField();
		tf_Boni2.setBackground(new Color(204, 255, 204));
		tf_Boni2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_Prix_Vente2.setText(String.format("%12.2f",Calcule_Prix_Vent(tf_Prix_Achat.getText().toString() , tf_Boni2.getText().toString())).replace(" ", ""));
			}
		});
		tf_Boni2.setColumns(10);
		
		tf_Boni3 = new JTextField();
		tf_Boni3.setBackground(new Color(204, 255, 204));
		tf_Boni3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_Prix_Vente3.setText(String.format("%12.2f",Calcule_Prix_Vent(tf_Prix_Achat.getText().toString() , tf_Boni3.getText().toString())).replace(" ", ""));
			}
		});
		tf_Boni3.setColumns(10);
		
		tf_Boni4 = new JTextField();
		tf_Boni4.setBackground(new Color(204, 255, 204));
		tf_Boni4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_Prix_Vente4.setText(String.format("%12.2f",Calcule_Prix_Vent(tf_Prix_Achat.getText().toString() , tf_Boni4.getText().toString())).replace(" ", ""));
			}
		});
		tf_Boni4.setColumns(10);
		
		tf_Boni5 = new JTextField();
		tf_Boni5.setBackground(new Color(204, 255, 204));
		tf_Boni5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_Prix_Vente5.setText(String.format("%12.2f",Calcule_Prix_Vent(tf_Prix_Achat.getText().toString() , tf_Boni5.getText().toString())).replace(" ", ""));
			}
		});
		tf_Boni5.setColumns(10);
		
		tf_Boni6 = new JTextField();
		tf_Boni6.setBackground(new Color(204, 255, 204));
		tf_Boni6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				tf_Prix_Vente6.setText(String.format("%12.2f",Calcule_Prix_Vent(tf_Prix_Achat.getText().toString() , tf_Boni6.getText().toString())).replace(" ", ""));
			}
		});
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
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 301, Short.MAX_VALUE)
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
								.addComponent(tf_Boni6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(57, Short.MAX_VALUE))))
		);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		
		JLabel lblDateDePremption = new JLabel("<html>Date de <br>p\u00E9remption</br></html>");
		lblDateDePremption.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label = new JLabel("<html>Date de <br>p\u00E9remption</br></html>");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblnombreDesJours = new JLabel("<html>Nombre des <br> jours d'alerte</br></html>");
		lblnombreDesJours.setIcon(new ImageIcon("C:\\Users\\DocteurTnou\\Desktop\\event.png"));
		lblnombreDesJours.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnombreDesJours.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
				, "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		JComboBox comboBox_4 = new JComboBox();
		
		JComboBox comboBox_5 = new JComboBox();
		
		JComboBox comboBox_6 = new JComboBox();
		
		JLabel lbldpotmagasin = new JLabel("D\u00E9pot Magasin");
		lbldpotmagasin.setHorizontalAlignment(SwingConstants.CENTER);
		lbldpotmagasin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblunitDemesure = new JLabel("<html>Unit\u00E8 de<br>Mesure</br></html>");
		lblunitDemesure.setHorizontalAlignment(SwingConstants.CENTER);
		lblunitDemesure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblstockmin = new JLabel("Stock Min");
		lblstockmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblstockmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblColissage = new JLabel("Colissage");
		lblColissage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTva = new JLabel("TVA %");
		lblTva.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lbllocalisationrayonnage = new JLabel("<html>Localisation/<br>Rayonnage</br></html>");
		lbllocalisationrayonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lbllocalisationrayonnage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblLimiteDePrix = new JLabel("Limite de prix de vente");
		lblLimiteDePrix.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setIcon(new ImageIcon(AddProducts.class.getResource("/images/calendar.png")));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblColissage)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(10)
									.addComponent(chckbxNewCheckBox))
								.addComponent(lblstockmin, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateDePremption))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addGap(56)
									.addComponent(lblnombreDesJours, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
										.addComponent(lblunitDemesure, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_5, 0, 140, Short.MAX_VALUE)
										.addComponent(comboBox, 0, 140, Short.MAX_VALUE)
										.addComponent(lblTva, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(dateChooser, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbllocalisationrayonnage, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_4, 0, 110, Short.MAX_VALUE)
										.addComponent(lbldpotmagasin)
										.addComponent(comboBox_3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
						.addComponent(lblLimiteDePrix)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateDePremption)))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(7)
							.addComponent(lblnombreDesJours)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
							.addComponent(comboBox_3, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
							.addComponent(chckbxNewCheckBox)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblunitDemesure, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbldpotmagasin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblstockmin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblColissage)
							.addComponent(lblTva))
						.addComponent(lbllocalisationrayonnage, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(2)
							.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLimiteDePrix, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Photo Produit", new ImageIcon(AddProducts.class.getResource("/images/photo-camera-x32.png")), panel_2, null);
		
		Image_panel = new JPanel();
		Image_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnNewButton = new JButton("Ajout\u00E9 une Photo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String ImagePath=Use_Files.filechooser_Images();
					Labe_Image.setIcon(Use_Files.Image(ImagePath));
					lb_path_Image.setText(ImagePath);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddProducts.class.getResource("/images/add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnAnnulerLaPhoto = new JButton("Annuler la Photo");
		btnAnnulerLaPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Labe_Image.setIcon(null);
				lb_path_Image.setText(null);				
			}
		});
		btnAnnulerLaPhoto.setIcon(new ImageIcon(AddProducts.class.getResource("/images/cancel.png")));
		btnAnnulerLaPhoto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lb_path_Image = new JLabel("");
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ImagePath=lb_path_Image.getText();
				if (ImagePath!=null)
				{
					Labe_Image.setIcon(Use_Files.ResizeImage_Panel(ImagePath,Image_panel));
				}
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(AddProducts.class.getResource("/images/resize_x32.png")));
		
		JLabel lblAutoResize = new JLabel("Auto resize");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(56)
							.addComponent(Image_panel, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblAutoResize))
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAnnulerLaPhoto, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lb_path_Image, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(lb_path_Image, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(15)
									.addComponent(lblAutoResize)))
							.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
							.addComponent(btnAnnulerLaPhoto, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addComponent(Image_panel, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		Labe_Image = new JLabel("Image");
		Labe_Image.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_Image_panel = new GroupLayout(Image_panel);
		gl_Image_panel.setHorizontalGroup(
			gl_Image_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(Labe_Image, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
		);
		gl_Image_panel.setVerticalGroup(
			gl_Image_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(Labe_Image, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
		);
		Image_panel.setLayout(gl_Image_panel);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
	private static void Remplire_Combobox(ResultSet result , JComboBox combobox)
	{
		try {
			while(result.next()){
				combobox.addItem(result.getString(1));
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	/**
	 * @param prix_achat
	 * @param prix_vent
	 * @return
	 * Remplir automatiquement le champ de texte Boni 
	 */
	private static float Calcule_Boni(String prix_achat ,String prix_vent)
	{
		if(!prix_achat.equals("") && !prix_vent.equals(""))
		{
			float boni=0;
			float prix_Achat=0;
			float prix_Vent=0;
			prix_Achat=Float.parseFloat(prix_achat);
			prix_Vent=Float.parseFloat(prix_vent);
			boni=((prix_Vent/prix_Achat)-1)*100;
			return boni;
		}
		return 0;
	}
	/**
	 * @param prix_achat
	 * @param prix_vent
	 * @return
	 * Remplir automatiquement le champ de texte Boni
	 */
	private static float Calcule_Prix_Vent(String prix_achat ,String boni)
	{
		if(!prix_achat.equals("") && !boni.equals(""))
		{
			float Boni=0;
			float prix_Achat=0;
			float prix_Vent=0;
			prix_Achat=Float.parseFloat(prix_achat);
			Boni=Float.parseFloat(boni);
			prix_Vent=(((prix_Achat*Boni)/100)+prix_Achat);
			return prix_Vent;
		}
		return 0;
	}
	private static void Auto_update_of_Prix_achat()
	{
		tf_Boni1.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente1.getText().toString())));
		tf_Boni2.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente2.getText().toString())));
		tf_Boni3.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente3.getText().toString())));
		tf_Boni4.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente4.getText().toString())));
		tf_Boni5.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente5.getText().toString())));
		tf_Boni6.setText(String.format("%12.2f", Calcule_Boni(tf_Prix_Achat.getText().toString(),tf_Prix_Vente6.getText().toString())));
		}
}
