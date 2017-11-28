/**
 * Cette Classe permet de:
 * Rechercher Client par Numero
 * Rechercher Client par nom (et/ou) prenom
 * Ajouter    Client 
 * Modifier   Client
 * supprimer  Client
 */
package com.home.formes;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.home.DataBase;
import com.home.Session;
import com.home.formes.AddClientForm.*;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ClientsForm extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static Connection connecet=null;
	private JTextField tffind;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ClientsForm frame = new ClientsForm();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientsForm() {
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		setTitle("Recherche");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientsForm.class.getResource("/images/Search-People-icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 984, 59);
		contentPane.add(toolBar);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// pour ajouter un client
				if (!Session.isSetForm(Session.ADDCLIENT))
					// creer un instance du class "addClient"
					Session.setForm(Session.ADDCLIENT, new AddClientForm());
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ClientsForm.class.getResource("/images/employeeIcon.png")));
		toolBar.add(btnNewButton_1);
		
		JButton button = new JButton("Supprimer");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setIcon(new ImageIcon(ClientsForm.class.getResource("/images/Delete_48.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(button);

		toolBar.addSeparator(new Dimension(15, 48));
		
		JPanel panel = new JPanel();
		toolBar.add(panel);
		
		JLabel lblRecherchePar = new JLabel("Recherche par:");
		lblRecherchePar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Code", "Nom", "Prenom"}));
		
		tffind = new JTextField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRecherchePar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tffind, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRecherchePar))
						.addComponent(tffind, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("");
		toolBar.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon(ClientsForm.class.getResource("/images/Search-icon.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 70, 964, 479);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				if(event.getClickCount()>=2)
				{
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					int a=table.getSelectedRow();
					Object num = tableModel.getValueAt(a, 0);
					if(num!=null){
					new UpdateClientForm(Integer.valueOf(num.toString()));
					}
				}
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00B0Client", "Nom", "Prenom", "Telephone", "Adresse", "Wilaya", "Commune", "Solde"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FindBy(comboBox.getSelectedIndex(), tffind.getText());
			}
		});
	}
	/************************************************************************************************/
	
	
	/**
	 * @param result
	 * methode pour l'affichage des resultates des recherche client
	 */
	private void FindBy(int FindType, String value) 
	{
		DataBase database= Session.getDatabase();
		String sql_format = "SELECT * FROM Client WHERE %s=?";
		String field_name = null, SQL = null;
		
		switch (FindType) {
		case 0:
			field_name = "id";
			break;
		case 1:
			field_name = "firstname";
			break;
		case 2:
			field_name = "lastname";
			break;
		}
		
		SQL = String.format(sql_format, field_name);
		
		try {
			PreparedStatement ps = database.getConnection().prepareStatement(SQL);
			ps.setString(1, value);
			ResultSet result = ps.executeQuery();
		
			DefaultTableModel model = (DefaultTableModel) table.getModel(); 
			model.setNumRows(0);
					
			while(result.next())  
			{
				model.addRow(
					new Object[]{
					result.getString("id"),result.getString("firstname"),
					result.getString("lastname"),result.getString("mobile"),
					result.getString("address"),result.getString("wilaya"),
					result.getString("city"),result.getString("solde")
				});
			}
			table.setModel(model);
		} catch (Exception e) {    
			e.printStackTrace();
		}
	}
}
