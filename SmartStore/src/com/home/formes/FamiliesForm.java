package com.home.formes;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import com.home.DataBase;
import com.home.Family;
import com.home.Session;
import com.home.custom.FamiliesModel;

import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class FamiliesForm extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public FamiliesForm() {
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		setTitle("Famille de produit:");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 374);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setIcon(new ImageIcon(FamiliesForm.class.getResource("/images/1490388962_DeleteRed.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Famille de produit", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 14), Color.BLUE));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.BLUE);
		scrollPane.setBorder(new LineBorder(new Color(30, 144, 255)));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOpaque(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(toolBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FamiliesModel model = (FamiliesModel) table.getModel();
				model.addRow(new Family());
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(FamiliesForm.class.getResource("/images/add.png")));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FamiliesModel model = (FamiliesModel)table.getModel();
				model.delete(table.getSelectedRow());
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(FamiliesForm.class.getResource("/images/delete.png")));
		toolBar.add(btnNewButton_4);
		
		toolBar.addSeparator(new Dimension(15, 20));
		
		JLabel lblRecherche = new JLabel("recherche :  ");
		lblRecherche.setForeground(Color.BLUE);
		lblRecherche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(lblRecherche);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(30, 144, 255)));
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			public void warn() {
				
				DataBase database = Session.getDatabase();
				
				try {
					PreparedStatement prepared = database.getConnection().
							prepareStatement("SELECT id FROM families WHERE designation like ?");
					prepared.setString(1, "%"+textField.getText()+"%");
					ResultSet result = prepared.executeQuery();
					FamiliesModel model = new FamiliesModel();
					while (result.next()) {
						Family f = new Family(result.getInt("id"));
						model.addRow(f);
					}
					table.setModel(model);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warn();
			}
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warn();
			}
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warn();
			}
		});
		lblRecherche.setLabelFor(textField);
		toolBar.add(textField);
		
		
		table = new JTable();
		table.setForeground(Color.BLUE);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		setLocationRelativeTo(null);
		
		Load();
	}
	
	public void Load() {
		
		DataBase database = Session.getDatabase();
		try {
			ResultSet result = database.getConnection().prepareStatement("SELECT id FROM families").executeQuery();
			FamiliesModel model = new FamiliesModel();
			while (result.next()) {
				Family f = new Family(result.getInt("id"));
				model.addRow(f);
			}
			table.setModel(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}