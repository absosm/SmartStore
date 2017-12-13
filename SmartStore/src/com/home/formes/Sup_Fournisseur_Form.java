package com.home.formes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.home.DataBase;
import com.home.Session;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;



public class Sup_Fournisseur_Form extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Sup_Fournisseur_Form frame = new Sup_Fournisseur_Form(new ArrayList<String>());
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
	public Sup_Fournisseur_Form(final List<String> list) {
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sup_Fournisseur_Form.class.getResource("/images/Delete_48.png")));
		setTitle("Supprimer_Fournisseur");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Si vous \u00EAtes s\u00FBr de supprimer le Fournisseur s\u00E9lectionnez<font color=\"#00ff00\"> Oui </font>\r\n<br>\r\nmais si vous ne voulez pas supprimer s\u00E9lectionnez <font color=\"#ff0000\">Annuler</font></html>");
		lblNewLabel.setIcon(new ImageIcon(Sup_Fournisseur_Form.class.getResource("/images/stamp.png")));
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 11, 506, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Num");
		lblNewLabel_1.setFont(new Font("Simplified Arabic", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(39, 82, 84, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("..");
		label.setFont(new Font("Simplified Arabic", Font.PLAIN, 14));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(171, 82, 271, 24);
		contentPane.add(label);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setFont(new Font("Simplified Arabic", Font.BOLD, 14));
		lblNom.setBounds(39, 117, 84, 24);
		contentPane.add(lblNom);
		
		JLabel label_2 = new JLabel("..");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Simplified Arabic", Font.PLAIN, 14));
		label_2.setBounds(171, 117, 271, 24);
		contentPane.add(label_2);
		
		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrnom.setFont(new Font("Simplified Arabic", Font.BOLD, 14));
		lblPrnom.setBounds(39, 152, 84, 24);
		contentPane.add(lblPrnom);
		
		JLabel label_4 = new JLabel("..");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Simplified Arabic", Font.PLAIN, 14));
		label_4.setBounds(171, 152, 271, 24);
		contentPane.add(label_4);
		
		JLabel lblSold = new JLabel("Solde");
		lblSold.setHorizontalAlignment(SwingConstants.LEFT);
		lblSold.setFont(new Font("Simplified Arabic", Font.BOLD, 14));
		lblSold.setBounds(39, 187, 84, 24);
		contentPane.add(lblSold);
		
		JLabel label_6 = new JLabel("..");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Simplified Arabic", Font.PLAIN, 14));
		label_6.setBounds(171, 187, 271, 24);
		contentPane.add(label_6);
		
		JButton btnNewButton = new JButton("<html><font color=\"#00ff00\"> Oui </font></html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DataBase database=Session.getDatabase();
					String SQLquery="DELETE FROM fournisseurs WHERE id ="+list.get(0)+";";
					database.getResult_Update(SQLquery);
					JOptionPane.showMessageDialog(new JFrame(),"Suppression réussie","Succès",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Sup_Fournisseur_Form.class.getResource("/images/user-red-delete.png")));
		btnNewButton.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		btnNewButton.setBounds(349, 238, 97, 41);
		contentPane.add(btnNewButton);
		
		JButton btnOui = new JButton("<html><font color=\"#ff0000\"> Annuler</font></html>");
		btnOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOui.setIcon(new ImageIcon(Sup_Fournisseur_Form.class.getResource("/images/1490388962_DeleteRed.png")));
		btnOui.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		btnOui.setBounds(39, 238, 123, 41);
		contentPane.add(btnOui);
		label.setText(list.get(0));
		label_2.setText(list.get(2));
		label_4.setText(list.get(1));
		label_6.setText(list.get(3));
		
	}
}
