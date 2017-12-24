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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;

import com.home.DataBase;
import com.home.Provider;
import com.home.Session;
import com.home.custom.ProvidersModel;
import com.home.docfilter.Filter;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ProvidersForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static JTable table;
	private JTextField tffind;
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		toolBar.add(panel);
		
		JLabel label = new JLabel("Recherche par:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox = new JComboBox<Object>();
		comboBox.setBorder(new LineBorder(new Color(30, 144, 255)));
		comboBox.setForeground(Color.BLUE);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tffind.selectAll();
				tffind.grabFocus();
				
				switch (comboBox.getSelectedIndex()) {
				case 0:
					Filter.TextField(tffind, Filter.NUMBER);
					break;
				case 1:
					Filter.TextField(tffind, Filter.UPPERCASE);
					break;
				case 2:
					Filter.TextField(tffind, Filter.FIRSTUPPERCASE);
					break;
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Code", "Nom", "Prenom"}));
		
		tffind = new JTextField();
		tffind.setBorder(new LineBorder(new Color(30, 144, 255)));
		tffind.setForeground(Color.BLUE);
		Filter.TextField(tffind, Filter.NUMBER);
		tffind.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				FindBy(comboBox.getSelectedIndex(), tffind.getText());
			}

			public void changedUpdate(DocumentEvent arg0)  {warn();}
			public void insertUpdate(DocumentEvent arg0)  {warn();}
			public void removeUpdate(DocumentEvent arg0) {warn();}
			
		});
		tffind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(label)
					.addGap(10)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tffind, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(label))
				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				.addComponent(tffind, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
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
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
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
		btnedit.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_1.setOpaque(false);
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
	
	private void FindBy(int FindType, String value) 
	{
		DataBase database= Session.getDatabase();
		String sql_format = "SELECT * FROM providers WHERE %s like ?";
		String field_name = null, SQL = null;
		
		switch (FindType) {
		case 0:
			field_name = "id";
			break;
		case 1:
			field_name = "lastname";
			break;
		case 2:
			field_name = "firstname";
			break;
		}
		
		SQL = String.format(sql_format, field_name);
		
		try {
			PreparedStatement ps = database.getConnection().prepareStatement(SQL);
			ps.setString(1, value+"%");
			ResultSet result = ps.executeQuery();

			ProvidersModel model = new ProvidersModel();
			while (result.next()) {
				Provider provider = new Provider(result.getInt("id"));
				model.addRow(provider);
			}
			table.setModel(model);
			
		} catch (Exception e) {    
			e.printStackTrace();
		}
	}
}
