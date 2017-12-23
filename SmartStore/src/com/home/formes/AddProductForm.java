package com.home.formes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
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

import com.home.Family;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	private JTextField tfbarcode;
	private JTextField tfname;
	private JTextField tfcount;
	private JTextField tfactual;
	private static  JTextField tfcost;
	private static JLabel Labe_Image ;
	private static JComboBox<String> cbfamily;
	private static JLabel lb_path_Image;
	private static JPanel Image_panel;
	private JTextField tfmin;
	private JTextField tfselling_limit;
	private JTable table;
	private JTextField tfdelay_exp;
	private JDateChooser expiration;
	private JCheckBox expirate;
	private JComboBox<Object> cbunit;
	private JComboBox<Object> comboBox;
	private JTextField tfpacking_amount;
	private JTextField tftva;
	private JComboBox<Object> comboBox_2;
	private JCheckBox packing;

	/**
	 * Create the frame.
	 */
	public AddProductForm() {
		setBackground(Color.WHITE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				cbfamily.setModel(new DefaultComboBoxModel<String>(Family.load()));
			}
		});
		
		
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_2 = new JButton("Annuler");
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/1490388962_DeleteRed.png")));
		
		JButton btnOk = new JButton("OK");
		btnOk.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				product.add();
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOk.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/database-accept-icon.png")));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
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
		
		tfbarcode = new JTextField();
		tfbarcode.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfbarcode.setForeground(Color.BLUE);
		tfbarcode.setEditable(false);
		tfbarcode.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
                product.setBarcode(tfbarcode.getText());
            }
			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tfbarcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfbarcode.setColumns(10);
		tfbarcode.setText(generateCode());
		
		tfname = new JTextField();
		tfname.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfname.setForeground(Color.BLUE);
		tfname.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
                product.setName(tfname.getText());
            }

			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tfname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfname.setColumns(10);
		
		cbfamily = new JComboBox<String>(Family.load());
		cbfamily.setBorder(new LineBorder(new Color(30, 144, 255)));
		cbfamily.setForeground(Color.BLUE);
		cbfamily.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					product.setFamily(e.getItem().toString());
				}
			}
		});
		cbfamily.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfcount = new JTextField();
		tfcount.setForeground(Color.BLUE);
		tfcount.setBorder(new LineBorder(new Color(30, 144, 255)));
		Filter.TextField(tfcount, Filter.NUMBER);
		tfcount.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
				if (!tfcount.getText().isEmpty()) {
					product.setCount(Integer.parseInt(tfcount.getText()));
					tfactual.setText(product.getActual()+"");
				}
                
            }
			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tfcount.setText("0");
		tfcount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfcount.setColumns(10);
		
		tfactual = new JTextField();
		tfactual.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfactual.setForeground(Color.BLUE);
		tfactual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfactual.setEditable(false);
		tfactual.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!Session.isSetForm(Session.FAMILIES))
					Session.setForm(Session.FAMILIES, new FamiliesForm());
				Session.showForm(Session.FAMILIES);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/add.png")));
		
		JDateChooser tfstore_date = new JDateChooser();
		tfstore_date.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfstore_date.setForeground(Color.BLUE);
		tfstore_date.setDateFormatString("dd/MM/yyyy");
		tfstore_date.getDateEditor().addPropertyChangeListener( new PropertyChangeListener() {
	        public void propertyChange(PropertyChangeEvent e) {
	            if ("date".equals(e.getPropertyName())) {
	            	
	                product.setStore_date(((java.util.Date)e.getNewValue()));
	            }
	        }
		});
		tfstore_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfstore_date.setDate(new Date());
		tfstore_date.getCalendarButton().setIcon(new ImageIcon(AddProductForm.class.getResource("/images/calendar.png")));
		
		JButton btnNewButton_4 = new JButton("G\u00E9n\u00E9rer");
		btnNewButton_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfbarcode.setText(generateCode());
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(AddProductForm.class.getResource("/images/refresh.png")));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(97)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(tfbarcode, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addComponent(lblDsignation)
					.addGap(18)
					.addComponent(tfname, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(138)
					.addComponent(lblFamille)
					.addGap(18)
					.addComponent(cbfamily, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(59)
					.addComponent(lblDateDuStock)
					.addGap(18)
					.addComponent(tfstore_date, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(108)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(tfcount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(102)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(tfactual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(tfbarcode, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(lblDsignation))
						.addComponent(tfname, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblFamille))
						.addComponent(cbfamily, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(lblDateDuStock))
						.addComponent(tfstore_date, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(lblNewLabel_1))
						.addComponent(tfcount, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(lblNewLabel_2))
						.addComponent(tfactual, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLUE);
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Plus d'info", new ImageIcon(AddProductForm.class.getResource("/images/Button-Info-icon.png")), panel_1, null);
		
		JLabel lblNewLabel_3 = new JLabel("Co\u00FBt(DA)");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfcost = new JTextField();
		tfcost.setForeground(Color.BLUE);
		tfcost.setBorder(new LineBorder(new Color(30, 144, 255)));
		Filter.TextField(tfcost, Filter.CURRENCY);
		tfcost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfcost.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
				
				if (!tfcost.getText().isEmpty()) {
					product.setCost(Double.parseDouble((tfcost.getText())));
					SellingModel model = (SellingModel)table.getModel();
					model.update();
					tfselling_limit.setText(tfcost.getText());
				}
            }

			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tfcost.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Prix de vente", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 14), new Color(0, 0, 0)));
		((javax.swing.border.TitledBorder) panel_3.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.repaint();
		
		JLabel lblLimiteDePrix = new JLabel("<html>Prix de vente(limit)</html>");
		lblLimiteDePrix.setForeground(Color.BLUE);
		lblLimiteDePrix.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfselling_limit = new JTextField();
		tfselling_limit.setForeground(Color.BLUE);
		tfselling_limit.setBorder(new LineBorder(new Color(30, 144, 255)));
		Filter.TextField(tfselling_limit, Filter.CURRENCY);
		tfselling_limit.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
				if(!tfselling_limit.getText().isEmpty())
					product.setSelling_limit(Double.parseDouble(tfselling_limit.getText()));
			}

			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tfselling_limit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfselling_limit.setColumns(10);
		
		JLabel lblTva = new JLabel("TVA (%)");
		lblTva.setForeground(Color.BLUE);
		lblTva.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tftva = new JTextField();
		tftva.setForeground(Color.BLUE);
		tftva.setBorder(new LineBorder(new Color(30, 144, 255)));
		tftva.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
				if (!tftva.getText().isEmpty()) {
					double perc = (Double.parseDouble(tftva.getText()))/100;
					product.setTva(perc);
				}
			}

			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		Filter.TextField(tftva, Filter.PERCENTAGE);
		tftva.setText("19");
		tftva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.WHITE);
		
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
		button.setBackground(Color.WHITE);
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
		button_1.setBackground(Color.WHITE);
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
		expirate.setBorder(new LineBorder(new Color(30, 144, 255)));
		expirate.setBackground(Color.WHITE);
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
		
		JLabel lblDateDePremption = new JLabel("<html>Expir\u00E9 <br>(OUI/NO)</br></html>");
		lblDateDePremption.setForeground(Color.BLUE);
		lblDateDePremption.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateDePremption.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblExpireLe = new JLabel("Date d'expiration");
		lblExpireLe.setForeground(Color.BLUE);
		lblExpireLe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblExpireLe.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblnombreDesJours = new JLabel("<html>Nombre des <br> jours d'alerte</br></html>");
		lblnombreDesJours.setForeground(Color.BLUE);
		lblnombreDesJours.setIcon(new ImageIcon("C:\\Users\\DocteurTnou\\Desktop\\event.png"));
		lblnombreDesJours.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnombreDesJours.setHorizontalAlignment(SwingConstants.LEFT);
		
		tfmin = new JTextField();
		tfmin.setForeground(Color.BLUE);
		tfmin.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfmin.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
				if (!tfmin.getText().isEmpty())
					product.setMin(Integer.parseInt(tfmin.getText()));
            }
			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		Filter.TextField(tfmin, Filter.NUMBER);
		tfmin.setText("15");
		tfmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfmin.setColumns(10);
		
		tfpacking_amount = new JTextField();
		tfpacking_amount.setForeground(Color.BLUE);
		tfpacking_amount.setBorder(new LineBorder(new Color(30, 144, 255)));
		Filter.TextField(tfpacking_amount, Filter.NUMBER);
		tfpacking_amount.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
				if (!tfpacking_amount.getText().isEmpty())
					product.setPackingAmount(Integer.parseInt(tfpacking_amount.getText()));
            }
			public void changedUpdate(DocumentEvent arg0) {warn();}
			public void insertUpdate(DocumentEvent arg0) {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
        });
		tfpacking_amount.setEnabled(false);
		tfpacking_amount.setText("12");
		tfpacking_amount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfpacking_amount.setColumns(10);
		
		cbunit = new JComboBox<Object>();
		cbunit.setForeground(Color.BLUE);
		cbunit.setBorder(new LineBorder(new Color(30, 144, 255)));
		cbunit.setModel(new DefaultComboBoxModel<Object>(new String[] {"Metre", "Kg", "g", "Litre"}));
		cbunit.setSelectedIndex(1);
		cbunit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				product.setUnit((String)cbunit.getSelectedItem());
			}
		});
		cbunit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox = new JComboBox<Object>();
		comboBox.setForeground(Color.BLUE);
		comboBox.setBorder(new LineBorder(new Color(30, 144, 255)));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Aucun>"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox_2 = new JComboBox<Object>();
		comboBox_2.setForeground(Color.BLUE);
		comboBox_2.setBorder(new LineBorder(new Color(30, 144, 255)));
		comboBox_2.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Aucun>"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbldpotmagasin = new JLabel("D\u00E9pot /Magasin");
		lbldpotmagasin.setForeground(Color.BLUE);
		lbldpotmagasin.setHorizontalAlignment(SwingConstants.LEFT);
		lbldpotmagasin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblunitDemesure = new JLabel("<html>Unit\u00E9 de<br>Mesure</br></html>");
		lblunitDemesure.setForeground(Color.BLUE);
		lblunitDemesure.setHorizontalAlignment(SwingConstants.LEFT);
		lblunitDemesure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblstockmin = new JLabel("Stock Min");
		lblstockmin.setForeground(Color.BLUE);
		lblstockmin.setHorizontalAlignment(SwingConstants.LEFT);
		lblstockmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblColissage = new JLabel("Colisage(Qtt)");
		lblColissage.setForeground(Color.BLUE);
		lblColissage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lbllocalisationrayonnage = new JLabel("<html>Localisation/<br/>Rayonnage</html>");
		lbllocalisationrayonnage.setForeground(Color.BLUE);
		lbllocalisationrayonnage.setHorizontalAlignment(SwingConstants.LEFT);
		lbllocalisationrayonnage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		expiration = new JDateChooser();
		expiration.setBorder(new LineBorder(new Color(30, 144, 255)));
		expiration.setBackground(Color.WHITE);
		expiration.addPropertyChangeListener(
		    new PropertyChangeListener() {
		    	
		        public void propertyChange(PropertyChangeEvent e) {
		        	if (product.isExpire())
		        		product.setExpiration(expiration.getDate());
		        }
	    });
		expiration.setDateFormatString("dd/MM/yyyy");
		expiration.setFont(new Font("Tahoma", Font.BOLD, 14));
		expiration.setDate(new Date());
		expiration.setEnabled(false);
		expiration.getCalendarButton().setIcon(new ImageIcon(AddProductForm.class.getResource("/images/calendar.png")));
		
		tfdelay_exp = new JTextField();
		tfdelay_exp.setForeground(Color.BLUE);
		tfdelay_exp.setBorder(new LineBorder(new Color(30, 144, 255)));
		tfdelay_exp.setBackground(Color.WHITE);
		tfdelay_exp.getDocument().addDocumentListener(new DocumentListener() {
			
			protected void warn() {
				if (!tfdelay_exp.getText().isEmpty())
					product.setDely_exp(Integer.parseInt(tfdelay_exp.getText()));
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
		
		packing = new JCheckBox("");
		packing.setForeground(Color.BLUE);
		packing.setBackground(Color.WHITE);
		packing.setBorder(new LineBorder(new Color(30, 144, 255)));
		packing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (packing.isSelected())
					tfpacking_amount.setEnabled(true);
				else
					tfpacking_amount.setEnabled(false);
				
				product.setPacking(packing.isSelected());
			}
		});
		packing.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblColisage = new JLabel("Colisage");
		lblColisage.setForeground(Color.BLUE);
		lblColisage.setHorizontalAlignment(SwingConstants.LEFT);
		lblColisage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfcost, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLimiteDePrix, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTva))
							.addGap(4)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(tfselling_limit, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(tftva, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_3))
								.addComponent(tfcost, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLimiteDePrix, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(34)
									.addComponent(lblTva, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(5)
									.addComponent(tfselling_limit, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(5)
									.addComponent(tftva, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
							.addGap(2)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addGap(11))))
		);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblDateDePremption, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblExpireLe, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblnombreDesJours, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(expirate, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(expiration, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(tfdelay_exp, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblstockmin, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblunitDemesure, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lbldpotmagasin, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(tfmin, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(cbunit, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblColisage, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblColissage, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lbllocalisationrayonnage, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(packing, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(tfpacking_amount, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(4)
							.addComponent(lblDateDePremption))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(5)
							.addComponent(lblExpireLe, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblnombreDesJours))
					.addGap(11)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(expirate, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(expiration, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfdelay_exp, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblstockmin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblunitDemesure)
						.addComponent(lbldpotmagasin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(tfmin, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbunit, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblColisage, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColissage, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbllocalisationrayonnage))
					.addGap(7)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(packing, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfpacking_amount, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
		);
		panel_4.setLayout(gl_panel_4);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Photo Produit", new ImageIcon(AddProductForm.class.getResource("/images/photo-camera-x32.png")), panel_2, null);
		
		Image_panel = new JPanel();
		Image_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnNewButton = new JButton("Ajout\u00E9 une Photo");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
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
		btnAnnulerLaPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
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
		btnNewButton_3.setBorder(new LineBorder(new Color(0, 0, 0)));
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
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
