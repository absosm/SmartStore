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

import com.home.formes.AddClients_Form.*;

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

public class Liste_des_Clients_Form extends JFrame {

	private JPanel contentPane;
	private static JTextField Nom_client;
	private static JTextField Prenom_client;
	private static JTextField Num_Client;
	private static JTable table;
	private static Connection connecet=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Liste_des_Clients_Form frame = new Liste_des_Clients_Form();
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
	public Liste_des_Clients_Form() {
		setTitle("Recherche");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Liste_des_Clients_Form.class.getResource("/images_Resource/Search-People-icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 599);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 136, 964, 414);
		contentPane.add(scrollPane);
		
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
					new Modifier_Clients_Form(Integer.valueOf(num.toString()));
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
		
		Nom_client = new JTextField();
		Nom_client.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent arg0) {
				try {
					affichage_table(AddClients_Form.info_search_Client(Nom_client.getText(),Prenom_client.getText())); // recherche intelligent
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(),e.getMessage()+"\n erreur de recherche à partir le Nom","ERREUR",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		Nom_client.setBounds(61, 70, 151, 47);
		contentPane.add(Nom_client);
		Nom_client.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(21, 81, 46, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);		
		Prenom_client = new JTextField();
		Prenom_client.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent arg0) {
				try {
					affichage_table(AddClients_Form.info_search_Client(Nom_client.getText(),Prenom_client.getText()));// #hhhh recherche intelligent

				} catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(),e.getMessage()+"\n erreur de recherche à partir le PréNom","ERREUR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Prenom_client.setBounds(281, 70, 157, 47);
		Prenom_client.setColumns(10);
		contentPane.add(Prenom_client);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(219, 81, 59, 23);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPrenom);
		
		Num_Client = new JTextField();
		Num_Client.setBounds(508, 70, 104, 47);
		Num_Client.setColumns(10);
		contentPane.add(Num_Client);
		
		JLabel lblNclient = new JLabel("N°Client");
		lblNclient.setBounds(448, 80, 62, 23);
		lblNclient.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNclient);
		
		JButton btnNewButton = new JButton("Recherche");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon(Liste_des_Clients_Form.class.getResource("/images_Resource/Search-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(!Num_Client.getText().equals("")){
					affichage_table(AddClients_Form.ID_search_Client(Integer.parseInt(Num_Client.getText())));   // recherche avec ID et 
					}   																						// et afficher le résultat dans une table
					}
				catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(),e.getMessage()+"\n erreur de recherche à partir le Numéro ID,","ERREUR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(634, 70, 157, 47);
		contentPane.add(btnNewButton);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddClients_Form();                // creer un instance du class "addClient"   
			}                                    // pour ajouter un client 
		});
		btnAjouter.setIcon(new ImageIcon(Liste_des_Clients_Form.class.getResource("/images_Resource/employeeIcon.png")));
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjouter.setBounds(61, 2, 153, 57);
		contentPane.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					List<String> list = new ArrayList<String>();
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					int a=table.getSelectedRow();
					list.add(tableModel.getValueAt(a, 0).toString()); // passer les informations de Client
					list.add(tableModel.getValueAt(a, 1).toString());
					list.add(tableModel.getValueAt(a, 2).toString());
					list.add(tableModel.getValueAt(a, 7).toString());
					new Sup_Client_Form(list);                             // lancer une fenêtre pour valider la suppression
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(new JFrame(),e1.getMessage()+"\n Sélectionnez l'élément pour supprimer ","ERREUR",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnSupprimer.setIcon(new ImageIcon(Liste_des_Clients_Form.class.getResource("/images_Resource/Delete_48.png")));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSupprimer.setBounds(281, 2, 157, 57);
		contentPane.add(btnSupprimer);
	}
	/************************************************************************************************/
	
	
	/**
	 * @param result
	 * methode pour l'affichage des resultates des recherche client
	 */
	private static void affichage_table(ResultSet result) 
	{            										 
		try {
			DefaultTableModel tableModel=(DefaultTableModel) table.getModel(); 
			tableModel.setNumRows(0);
					
			while(result.next())  
			{
				tableModel.addRow(
					new Object[]{result.getString("id"),result.getString("Nom"),
					result.getString("Prenom"),result.getString("TelPortable"),
					result.getString("Adresse"),result.getString("wilaya"),
					result.getString("Commune"),result.getString("Solde_Initial")
					});
			}
		
			
		} catch (Exception e) {    
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
			
		}
		
		
	}
}
