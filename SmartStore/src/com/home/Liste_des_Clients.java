package com.home;


import com.home.AddClients.*;
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

public class Liste_des_Clients extends JFrame {

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
					Liste_des_Clients frame = new Liste_des_Clients();
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
	public Liste_des_Clients() {
		setTitle("Recherche");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Liste_des_Clients.class.getResource("/images_Resource/Search-People-icon.png")));
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
					Modifier_Clients F1 = new Modifier_Clients(Integer.valueOf(tableModel.getValueAt(a, 0).toString()));
					
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
				affichage_table(Sql_search_Client_Optimal()); // recherche intelligent
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
				affichage_table(Sql_search_Client_Optimal());	// recherche intelligent
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
		btnNewButton.setIcon(new ImageIcon(Liste_des_Clients.class.getResource("/images_Resource/Search-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				affichage_table(Sql_search_Client());       // recherche normal
			}
		});
		btnNewButton.setBounds(634, 70, 157, 47);
		contentPane.add(btnNewButton);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddClients();                // creer un instance du class "addClient"   
			}                                    // pour ajouter un client 
		});
		btnAjouter.setIcon(new ImageIcon(Liste_des_Clients.class.getResource("/images_Resource/employeeIcon.png")));
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
					list.add(tableModel.getValueAt(a, 0).toString());
					list.add(tableModel.getValueAt(a, 1).toString());
					list.add(tableModel.getValueAt(a, 2).toString());
					list.add(tableModel.getValueAt(a, 7).toString());
					
					new sup_Client(list);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(new JFrame(),e1.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnSupprimer.setIcon(new ImageIcon(Liste_des_Clients.class.getResource("/images_Resource/Delete_48.png")));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSupprimer.setBounds(281, 2, 157, 57);
		contentPane.add(btnSupprimer);
	}
	/************************************************************************************************/
	private static ResultSet Sql_search_Client()//cette methode faire une recherche d'une client
	{
		                // a base de numero ou nom/prenom
		Statement stm=null;
		ResultSet result=null;
		String SqlQury=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");     
			connecet=DriverManager.getConnection("jdbc:mysql://localhost/gestcom?useUnicode=yes&characterEncoding=UTF-8","root","");			
			stm=connecet.createStatement();
			if(!Num_Client.getText().equals("")) // dans le case de recherche avec numero Client
			{                                       
				SqlQury="select * from Client where id='"+Num_Client.getText()+"';";
			}
			else                            // dans le case de recherche avec le nom et prenom
			{
				SqlQury="select * from Client where Nom LIKE '"+Nom_client.getText()+"%' AND Prenom LIKE '"+Prenom_client.getText()+"%';";
				
			}
			result=stm.executeQuery(SqlQury); // execution de requete 
	        
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
			
		}		
		
		return result; // la methode returner le resultate pour l'affichge
	}
	
	/********************************************************************************************/
	private static ResultSet Sql_search_Client_Optimal()//cette methode faire une recherche d'une client
	{
		                // a base de numero ou nom/prenom avec les reactions du clavier
		Statement stm=null;
		ResultSet result=null;
		String SqlQury=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");     
			connecet=DriverManager.getConnection("jdbc:mysql://localhost/gestcom?useUnicode=yes&characterEncoding=UTF-8","root","");			
			stm=connecet.createStatement();
			if(!Num_Client.getText().equals("")) // dans le case de recherche avec numero Client
			{                                       
				SqlQury="select * from Client where id='"+Num_Client.getText()+"';";
			}
			else                            // dans le case de recherche avec le nom et prenom
			{
				SqlQury="select * from Client where Nom LIKE '"+Nom_client.getText()+"%' AND Prenom LIKE '"+Prenom_client.getText()+"%';";
				
			}
			result=stm.executeQuery(SqlQury); // execution de requete 
	        
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
		}		
		return result; // la methode returner le resultate pour l'affichge
	}
	/************************************************************************************************/
	
	private static void affichage_table(ResultSet result) //methode pour l'affichage des resultates
	{            										  // des recherche client 
		try {
			DefaultTableModel tableModel=(DefaultTableModel) table.getModel(); // instance de table d'affichge
			tableModel.setNumRows(0);
					
			while(result.next())     // afficher les information du resultat de requete  
			{
				tableModel.addRow(
					new Object[]{result.getString("id"),result.getString("Nom"),
					result.getString("Prenom"),result.getString("TelPortable"),
					result.getString("Adresse"),result.getString("wilaya"),
					result.getString("Commune"),result.getString("Solde_Initial")
					});
			}
			connecet.close();
			
		} catch (Exception e) {    // dans le cas d'erreur lancer une fenetre d'alert
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
		}
		
		
	}
}
