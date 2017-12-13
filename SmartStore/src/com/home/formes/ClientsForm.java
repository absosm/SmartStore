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

import com.home.Client;
import com.home.DataBase;
import com.home.Family;
import com.home.Session;
import com.home.custom.ClientsModel;
import com.home.custom.FamiliesModel;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientsForm extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField tffind;
	private JComboBox comboBox;
	private JButton btndelete;
	private JButton btnEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientsForm frame = new ClientsForm();
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				Load();
			}
		});
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		setTitle("Recherche");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientsForm.class.getResource("/images/Search-People-icon.png")));
		setBounds(100, 100, 1008, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		
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
		
		btndelete = new JButton("Supprimer");
		btndelete.setEnabled(false);
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientsModel model = (ClientsModel)table.getModel();
				model.delete(table.getSelectedRow());
			}
		});
		
		btnEdit = new JButton("Modifier");
		btnEdit.setIcon(new ImageIcon(ClientsForm.class.getResource("/images/if_user_profile_edit_103781.png")));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ClientsModel model = (ClientsModel)table.getModel();
				Client client = model.getClient(table.getSelectedRow());
				
				if (!Session.isSetForm(Session.UPDATECLIENT))
					Session.setForm(Session.UPDATECLIENT, new UpdateClientForm(client));
				Session.showForm(Session.UPDATECLIENT);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setEnabled(false);
		toolBar.add(btnEdit);
		btndelete.setIcon(new ImageIcon(ClientsForm.class.getResource("/images/Delete_48.png")));
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(btndelete);

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setRowHeight(32);
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				
				if (table.getSelectedRow()>=0) {
					
					ClientsModel model = (ClientsModel)table.getModel();
					Client c = model.getClient(table.getSelectedRow());
					if (c != null) {
						btnEdit.setEnabled(true);
						btndelete.setEnabled(true);
					} else {
						btnEdit.setEnabled(false);
						btndelete.setEnabled(false);
					}
				}
				
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		ClientsModel model = new ClientsModel();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, Boolean.FALSE, null},
			},
			new String[] {
				"N\u00B0Client", "Nom", "Prenom", "Telephone", "Adresse", "Wilaya", "Commune", "Solde"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, String.class, Object.class, Integer.class, Boolean.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
					.addGap(1))
		);
		contentPane.setLayout(gl_contentPane);
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
		String sql_format = "SELECT * FROM clients WHERE %s=?";
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

			ClientsModel model = new ClientsModel();
			while (result.next()) {
				Client client = new Client(result.getInt("id"));
				model.addRow(client);
			}
			table.setModel(model);
			
		} catch (Exception e) {    
			e.printStackTrace();
		}
	}
	
	
	public void Load() {
		
		DataBase database = Session.getDatabase();
		try {
			ResultSet result = database.getConnection().prepareStatement("SELECT id FROM clients").executeQuery();
			ClientsModel model = new ClientsModel();
			while (result.next()) {
				Client client = new Client(result.getInt("id"));
				model.addRow(client);
			}
			table.setModel(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
