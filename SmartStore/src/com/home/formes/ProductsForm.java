package com.home.formes;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.home.DataBase;
import com.home.Product;
import com.home.Session;
import com.home.custom.ProductsModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;

public class ProductsForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JComboBox<Object> comboBox_2;

	/**
	 * Create the frame.
	 */
	public ProductsForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				comboBox_2.setSelectedIndex(1);
				Load();
			}
		});
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		setTitle("List des produit");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 872, 555);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ProductsForm.class.getResource("/images/cancel.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(577, Short.MAX_VALUE)
					.addComponent(btnNewButton_1))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnNewButton_1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOpaque(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setOpaque(false);
		toolBar_1.setRollover(true);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(toolBar_1, GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setOpaque(false);
		btnNewButton.setIcon(new ImageIcon(ProductsForm.class.getResource("/images/print.png")));
		toolBar_1.add(btnNewButton);
		
		toolBar_1.addSeparator(new Dimension(15, 20));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setSize(new Dimension(50, 20));
		toolBar_1.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setBounds(465, 0, 270, 22);
		panel_2.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(409, 3, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		comboBox_2 = new JComboBox<Object>();
		comboBox_2.setModel(new DefaultComboBoxModel<Object>(new String[] {"id", "family", "name"}));
		comboBox_2.setBounds(66, 0, 333, 22);
		panel_2.add(comboBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 3, 46, 14);
		panel_2.add(lblNewLabel_2);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setRowHeight(32);
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				
				if (table.getSelectedRow()>=0) {
					
					ProductsModel model = (ProductsModel)table.getModel();
					Product c = model.getProduct(table.getSelectedRow());
					if (c != null) {
						//btnedit.setEnabled(true);
					//	btndelete.setEnabled(true);
					} else {
					//	btnedit.setEnabled(false);
						//btndelete.setEnabled(false);
					}
				}
				
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("");
		button.setOpaque(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!Session.isSetForm(Session.ADDPRODUCT))
					Session.setForm(Session.ADDPRODUCT, new AddProductForm());
				Session.showForm(Session.ADDPRODUCT);
			}
		});
		button.setIcon(new ImageIcon(ProductsForm.class.getResource("/images/add.png")));
		toolBar.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setOpaque(false);
		button_1.setIcon(new ImageIcon(ProductsForm.class.getResource("/images/edit.png")));
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setOpaque(false);
		button_2.setIcon(new ImageIcon(ProductsForm.class.getResource("/images/remove.png")));
		toolBar.add(button_2);
		
		toolBar.addSeparator(new Dimension(15, 20));
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		toolBar.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(477, 4, 46, 14);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(533, 0, 225, 22);
		panel_3.setLayout(null);
		panel_3.add(lblNewLabel);
		panel_3.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Recherche :");
		lblNewLabel_3.setBounds(0, 4, 65, 14);
		panel_3.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				FindBy(comboBox_2.getSelectedIndex(),textField.getText());
			}

			public void changedUpdate(DocumentEvent arg0)  {warn();}
			public void insertUpdate(DocumentEvent arg0)  {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
			
		});
		textField.setBounds(64, 1, 403, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		setLocationRelativeTo(null);
	}
	/**
	 * @param result
	 * methode pour l'affichage des resultates des recherche client
	 */
	private void FindBy(int FindType, String value) 
	{
		DataBase database= Session.getDatabase();
		String sql_format = "SELECT * FROM products WHERE %s like ?";
		String field_name = null, SQL = null;
		switch (FindType) {
		case 0:
			field_name = "id";
			break;
		case 1:
			field_name = "family";
			break;
		case 2:
			field_name = "name";
			break;
		}
		
		SQL = String.format(sql_format, field_name);
		
		try {
			PreparedStatement ps = database.getConnection().prepareStatement(SQL);
			ps.setString(1, value+"%");
			ResultSet result = ps.executeQuery();
			ProductsModel model = new ProductsModel();
			while (result.next()) {
				Product product = new Product(result.getInt("id"));
				
				model.addRow(product);
			}
			table.setModel(model);
			
		} catch (Exception e) {    
			e.printStackTrace();
		}
	}
	public void Load() {
		
		DataBase database = Session.getDatabase();
		try {
			ResultSet result = database.getConnection().prepareStatement("SELECT id FROM products").executeQuery();
		ProductsModel model = new ProductsModel();
			while (result.next()) {
				Product product = new Product(result.getInt("id"));
			
				model.addRow(product);
			}
			table.setModel(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
