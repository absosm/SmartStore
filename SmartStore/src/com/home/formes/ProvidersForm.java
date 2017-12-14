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
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.home.Session;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.JComboBox;

public class ProvidersForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static JTable table;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ProvidersForm() {
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		setTitle("Recherche");
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
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		
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
				new AddProviderForm();                // creer un instance du class "AddFournisseur_form"   
			}                                    		  // pour ajouter un Fournisseur 
		});
		btnAjouter.setIcon(new ImageIcon(ProvidersForm.class.getResource("/images/fournisseur - Copie.png")));
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton button = new JButton("Modifier");
		button.setIcon(new ImageIcon(ProvidersForm.class.getResource("/images/fournisseur.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(button);
		
		JButton btnSupprimer = new JButton("Supprimer");
		toolBar.add(btnSupprimer);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					List<String> list = new ArrayList<String>();
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					int a=table.getSelectedRow();
					list.add(tableModel.getValueAt(a, 0).toString()); // passer les informations de Fournisseur
					list.add(tableModel.getValueAt(a, 1).toString());
					list.add(tableModel.getValueAt(a, 2).toString());
					list.add(tableModel.getValueAt(a, 7).toString());
					//new Sup_Fournisseur_Form(list);                             // lancer une fenêtre pour valider la suppression
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(new JFrame(),e1.getMessage()+"\n Sélectionnez l'élément pour supprimer ","ERREUR",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnSupprimer.setIcon(new ImageIcon(ProvidersForm.class.getResource("/images/Delete_48.png")));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		
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
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				if(event.getClickCount()>=2)
				{
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					int a=table.getSelectedRow();
					Object num = tableModel.getValueAt(a, 0);
					if(num!=null){
					new UpdateProviderForm(Integer.valueOf(num.toString()));
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
}
