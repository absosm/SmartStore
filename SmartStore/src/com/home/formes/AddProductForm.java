package com.home.formes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.home.Product;
import com.home.Selling;
import com.home.Session;
import com.home.Use_Files;
import com.home.custom.SellingModel;
import com.home.docfilter.Filter;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class AddProductForm extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * declaration des attributs (SmartStore)
	 */
	private Product product;
	/**
	 * déclaration des attributs (GUI)
	 */
	private JPanel contentPane;
	private JTextField tf_barcode;
	private JTextField tf_name;
	private JTextField tfcount;
	private JTextField tf_actual;
	private static  JTextField tfcost;
	private static JLabel Labe_Image ;
	private static JComboBox<String> cb_family;
	private static JLabel lb_path_Image;
	private static JPanel Image_panel;
	private JTextField tfmin;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTextField tfdelay_exp;
	private JDateChooser expiration;
	private JCheckBox expirate;

	/**
	 * Create the frame.
	 */
	public AddProductForm() {
		
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		/**
		 * creation d'un nouveau instant objet Produit
		 */
		product = new Product();
		
		setTitle("Ajouter Produit");
		setFont(new Font("Tahoma", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_2 = new JButton("Annuler");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/1490388962_DeleteRed.png")));
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				product.add();
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOk.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/database-accept-icon.png")));
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("G\u00E9n\u00E9ral", new ImageIcon(AddProductForm.class.getResource("/images/Download-Folder-icon.png")), panel, null);
		
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
		
		tf_barcode = new JTextField();
		tf_barcode.setEditable(false);
		tf_barcode.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
                product.setBarcode(tf_barcode.getText());
            }
			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tf_barcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_barcode.setColumns(10);
		tf_barcode.setText(generateCode());
		
		tf_name = new JTextField();
		tf_name.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
                product.setName(tf_name.getText());
            }

			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tf_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_name.setColumns(10);
		
		cb_family = new JComboBox<String>();
		cb_family.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					product.setFamily(e.getItem().toString());
				}
			}
		});
		cb_family.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfcount = new JTextField();
		Filter.TextField(tfcount, Filter.NUMBER);
		tfcount.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
                product.setCount(Integer.parseInt(tfcount.getText()));
                tf_actual.setText(product.getActual()+"");
            }
			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tfcount.setText("0");
		tfcount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfcount.setColumns(10);
		
		tf_actual = new JTextField();
		tf_actual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_actual.setEditable(false);
		tf_actual.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!Session.isSetForm(Session.FAMILIES))
					Session.setForm(Session.FAMILIES, new FamiliesForm());
				Session.showForm(Session.FAMILIES);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/add.png")));
		
		JDateChooser tf_store_date = new JDateChooser();
		tf_store_date.setDateFormatString("dd/MM/yyyy");
		tf_store_date.getDateEditor().addPropertyChangeListener( new PropertyChangeListener() {
	        public void propertyChange(PropertyChangeEvent e) {
	            if ("date".equals(e.getPropertyName())) {
	            	
	                product.setStore_date(new java.sql.Date(((java.util.Date)e.getNewValue()).getTime()));
	            }
	        }
		});
		tf_store_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tf_store_date.setDate(new Date());
		tf_store_date.getCalendarButton().setIcon(new ImageIcon(AddProductForm.class.getResource("/images/calendar.png")));
		
		JButton btnNewButton_4 = new JButton("G\u00E9n\u00E9rer");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_barcode.setText(generateCode());
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/refresh.png")));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDsignation)
						.addComponent(lblNewLabel)
						.addComponent(lblFamille)
						.addComponent(lblDateDuStock)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(cb_family, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(tf_store_date, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(tf_barcode, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_4))
						.addComponent(tf_name, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(tf_actual, Alignment.LEADING)
							.addComponent(tfcount, Alignment.LEADING)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_barcode, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_name, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDsignation))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblFamille)
							.addGap(18)
							.addComponent(lblDateDuStock))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cb_family, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tf_store_date, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(tfcount, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_actual, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Plus d'info", new ImageIcon(AddProductForm.class.getResource("/images/Button-Info-icon.png")), panel_1, null);
		
		JLabel lblNewLabel_3 = new JLabel("Prix d'achat");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfcost = new JTextField();
		Filter.TextField(tfcost, Filter.CURRENCY);
		tfcost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfcost.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
				
				if (!tfcost.getText().isEmpty()) {
					product.setCost(Double.parseDouble((tfcost.getText())));
					SellingModel model = (SellingModel)table.getModel();
					model.update();
				}
            }

			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tfcost.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Prix de vente", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 14), new Color(0, 0, 0)));
		((javax.swing.border.TitledBorder) panel_3.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.repaint();
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfcost, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
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
								.addComponent(tfcost, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)))
					.addGap(235))
		);
		
		JToolBar toolBar = new JToolBar();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(243, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new SellingModel());
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellingModel model = (SellingModel)table.getModel();
				int i = model.getRowCount();
				Selling s = new Selling(product);
				s.setCategory("Prix "+(++i));
				s.setPrice(product.getCost());
				model.addRow(s);
			}
		});
		button.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/add.png")));
		toolBar.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					SellingModel model = (SellingModel)table.getModel();
					model.delete(table.getSelectedRow());
				}
			}
		});
		button_1.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/delete.png")));
		toolBar.add(button_1);
		panel_3.setLayout(gl_panel_3);
		
		expirate = new JCheckBox("");
		expirate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (expirate.isSelected()) {
					expiration.setEnabled(true);
					expiration.grabFocus();
					tfdelay_exp.setEnabled(true);
				}
				else {
					expiration.setEnabled(false);
					tfdelay_exp.setEnabled(false);
				}
				
				product.setExpirate(expirate.isSelected());
			}
		});
		expirate.setSelected(false);
		expirate.setHorizontalAlignment(SwingConstants.CENTER);
		expirate.setBounds(12, 54, 77, 28);
		
		JLabel lblDateDePremption = new JLabel("<html>Expir\u00E9 <br>(OUI/NO)</br></html>");
		lblDateDePremption.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateDePremption.setBounds(12, 13, 77, 30);
		lblDateDePremption.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblExpireLe = new JLabel("Date d'expiration");
		lblExpireLe.setBounds(95, 14, 136, 28);
		lblExpireLe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblExpireLe.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblnombreDesJours = new JLabel("<html>Nombre des <br> jours d'alerte</br></html>");
		lblnombreDesJours.setBounds(241, 9, 110, 30);
		lblnombreDesJours.setIcon(new ImageIcon("C:\\Users\\DocteurTnou\\Desktop\\event.png"));
		lblnombreDesJours.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnombreDesJours.setHorizontalAlignment(SwingConstants.LEFT);
		
		tfmin = new JTextField();
		tfmin.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
				product.setMin(Integer.parseInt(tfmin.getText()));
            }
			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		Filter.TextField(tfmin, Filter.NUMBER);
		tfmin.setText("15");
		tfmin.setBounds(12, 132, 77, 28);
		tfmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfmin.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(12, 200, 77, 28);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(12, 263, 178, 25);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setColumns(10);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(95, 132, 140, 28);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox<Object> comboBox_4 = new JComboBox<Object>();
		comboBox_4.setBounds(241, 132, 110, 28);
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox<Object> comboBox_5 = new JComboBox<Object>();
		comboBox_5.setBounds(95, 200, 140, 28);
		comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox<Object> comboBox_6 = new JComboBox<Object>();
		comboBox_6.setBounds(241, 200, 108, 28);
		comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbldpotmagasin = new JLabel("D\u00E9pot Magasin");
		lbldpotmagasin.setBounds(241, 96, 110, 30);
		lbldpotmagasin.setHorizontalAlignment(SwingConstants.LEFT);
		lbldpotmagasin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblunitDemesure = new JLabel("<html>Unit\u00E9 de<br>Mesure</br></html>");
		lblunitDemesure.setBounds(95, 96, 140, 30);
		lblunitDemesure.setHorizontalAlignment(SwingConstants.LEFT);
		lblunitDemesure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblstockmin = new JLabel("Stock Min");
		lblstockmin.setBounds(12, 96, 77, 30);
		lblstockmin.setHorizontalAlignment(SwingConstants.LEFT);
		lblstockmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblColissage = new JLabel("Colissage");
		lblColissage.setBounds(12, 163, 77, 30);
		lblColissage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTva = new JLabel("TVA %");
		lblTva.setBounds(95, 163, 140, 30);
		lblTva.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lbllocalisationrayonnage = new JLabel("<html>Localisation/<br>Rayonnage</br></html>");
		lbllocalisationrayonnage.setBounds(241, 163, 110, 30);
		lbllocalisationrayonnage.setHorizontalAlignment(SwingConstants.LEFT);
		lbllocalisationrayonnage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblLimiteDePrix = new JLabel("Limite de prix de vente");
		lblLimiteDePrix.setBounds(12, 239, 127, 21);
		lblLimiteDePrix.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		expiration = new JDateChooser();
		expiration.addPropertyChangeListener(
		    new PropertyChangeListener() {
		    	
		        public void propertyChange(PropertyChangeEvent e) {
		        	if (product.isExpire())
		        		product.setExpiration(expiration.getDate());
		        }
	    });
		expiration.setBounds(95, 54, 140, 28);
		expiration.setDateFormatString("dd/MM/yyyy");
		expiration.setFont(new Font("Tahoma", Font.BOLD, 14));
		expiration.setDate(new Date());
		expiration.setEnabled(false);
		expiration.getCalendarButton().setIcon(new ImageIcon(AddProductForm.class.getResource("/images/calendar.png")));
		panel_4.setLayout(null);
		panel_4.add(lblColissage);
		panel_4.add(expirate);
		panel_4.add(lblDateDePremption);
		panel_4.add(tfmin);
		panel_4.add(lblstockmin);
		panel_4.add(textField_5);
		panel_4.add(lblunitDemesure);
		panel_4.add(expiration);
		panel_4.add(comboBox_5);
		panel_4.add(comboBox);
		panel_4.add(lblTva);
		panel_4.add(lblExpireLe);
		panel_4.add(lblnombreDesJours);
		panel_4.add(comboBox_6);
		panel_4.add(lbllocalisationrayonnage);
		panel_4.add(comboBox_4);
		panel_4.add(lbldpotmagasin);
		panel_4.add(lblLimiteDePrix);
		panel_4.add(textField_6);
		
		tfdelay_exp = new JTextField();
		tfdelay_exp.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
				product.setCount(Integer.parseInt(tfdelay_exp.getText()));
            }
			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tfdelay_exp.setText("0");
		tfdelay_exp.setEnabled(false);
		Filter.TextField(tfdelay_exp, Filter.NUMBER);
		tfdelay_exp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfdelay_exp.setColumns(10);
		tfdelay_exp.setBounds(241, 54, 110, 28);
		panel_4.add(tfdelay_exp);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Photo Produit", new ImageIcon(AddProductForm.class.getResource("/images/photo-camera-x32.png")), panel_2, null);
		
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
		btnNewButton.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnAnnulerLaPhoto = new JButton("Annuler la Photo");
		btnAnnulerLaPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Labe_Image.setIcon(null);
				lb_path_Image.setText(null);
			}
		});
		btnAnnulerLaPhoto.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/cancel.png")));
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
		btnNewButton_3.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/resize_x32.png")));
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(171)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(160)
					.addComponent(btnNewButton_2))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public String generateCode() {
		int leftLimit = 48; // letter '0'
	    int rightLimit = 57; // letter '9'
	    int targetStringLength = 14;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    return(generatedString);
	}
}
