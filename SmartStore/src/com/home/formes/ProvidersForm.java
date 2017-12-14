/**
 * Cette Classe permet de:
 * Rechercher Fournisseur par Numero
 * Rechercher Fournisseur par nom (et/ou) prenom
 * Ajouter    Fournisseur 
 * Modifier   Fournisseur
 * supprimer  Fournisseur
 */

package com.home.formes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;

import com.home.DataBase;
import com.home.Provider;
import com.home.Session;
import com.home.custom.ProvidersModel;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProvidersForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static JTable table;
	private JTextField textField;
	private JComboBox<Object> comboBox;
	private JButton btnedit;
	private JButton btndelete;

	/**
	 * Create the frame.
	 */
	public ProvidersForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				comboBox.setSelectedIndex(1);
				Load();
			}
		});
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		setTitle("Liste des fournisseurs");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProvidersForm.class.getResource("/images/Search-People-icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1004, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		
		JPanel panel = new JPanel();
		toolBar.add(panel);
		
		JLabel label = new JLabel("Recherche par:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Code", "Nom", "Prenom"}));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(label)
					.addGap(10)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(label))
				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
		);
		panel.setLayout(gl_panel);
		
		JButton btnAjouter = new JButton("Ajouter");
		toolBar.add(btnAjouter);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// pour ajouter un fournisseur
				if (!Session.isSetForm(Session.ADDPROVIDER))
					// creer un instance du class "addProvider"
					Session.setForm(Session.ADDPROVIDER, new AddProviderForm());
			}
		});
		btnAjouter.setIcon(new ImageIcon(ProvidersForm.class.getResource("/images/fournisseur - Copie.png")));
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnedit = new JButton("Modifier");
		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (table.getSelectedRow()>=0) {
					
					ProvidersModel model = (ProvidersModel)table.getModel();
					Provider provider = model.getProvider(table.getSelectedRow());
					
					if (!Session.isSetForm(Session.UPDATEPROVIDER))
						Session.setForm(Session.UPDATEPROVIDER, new UpdateProviderForm(provider));
					Session.showForm(Session.UPDATEPROVIDER);
				}else {
					JOptionPane.showMessageDialog(null, "Selectionez un fournisseur puis click \"Modifier\".");
				}
			}
		});
		btnedit.setEnabled(false);
		btnedit.setIcon(new ImageIcon(ProvidersForm.class.getResource("/images/fournisseur.png")));
		btnedit.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(btnedit);
		
		btndelete = new JButton("Supprimer");
		btndelete.setEnabled(false);
		toolBar.add(btndelete);
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					ProvidersModel model = (ProvidersModel)table.getModel();
					model.delete(table.getSelectedRow());
				}else {
					JOptionPane.showMessageDialog(null, "Selectionez un fournisseur puis click \"Supprimer\".");
				}
			}
		});
		btndelete.setIcon(new ImageIcon(ProvidersForm.class.getResource("/images/Delete_48.png")));
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(toolBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE))
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setRowHeight(32);
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				
				if (table.getSelectedRow()>=0) {
					
					ProvidersModel model = (ProvidersModel)table.getModel();
					Provider c = model.getProvider(table.getSelectedRow());
					if (c != null) {
						btnedit.setEnabled(true);
						btndelete.setEnabled(true);
					} else {
						btnedit.setEnabled(false);
						btndelete.setEnabled(false);
					}
				}
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
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
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void Load() {
		
		DataBase database = Session.getDatabase();
		try {
			ResultSet result = database.getConnection().prepareStatement("SELECT id FROM providers").executeQuery();
			ProvidersModel model = new ProvidersModel();
			while (result.next()) {
				Provider provider = new Provider(result.getInt("id"));
				model.addRow(provider);
			}
			table.setModel(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
