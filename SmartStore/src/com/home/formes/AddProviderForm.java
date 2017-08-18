/**
 * Cette Classe permet de:
 * afficher une formulaire pour ajouter un Fournisseur
 */
package com.home.formes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import com.home.DataBase;
import com.home.Session;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;


public class AddProviderForm extends JFrame {

	private static JPanel contentPane;
	private static JTextField tfnom;
	private static JTextField tfprenom;
	private static JTextField tfadresse;
	private static JTextField tfcodepostal;
	private static JTextField tftelportabl;
	private static JTextField tftelfix;
	private static JTextField tffax;
	private static JTextField tfnrc;
	private static JTextField tfnif;
	private static JTextField tfcomptebancaire;
	private static JTextField tfemail;
	private static JTextField tfnart;
	private static JTextField tfnis;
	private static JTextField tfrib;
	private static JTextField tfsiteweb;
	private static JTextField tfsolde;
	private static JComboBox tfwilaya;
	private static JComboBox tfcommune;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AddProviderForm frame = new AddProviderForm();
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddProviderForm() {
		
		if (!Session.isRegister()) {
			JOptionPane.showMessageDialog(null, "la session est déconnecté.");
			Runtime.getRuntime().exit(0);
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddProviderForm.class.getResource("/images/fournisseur - Copie.png")));
		setFont(new Font("Tahoma", Font.BOLD, 14));
		setTitle("Ajouter Fournisseur");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(0, 0, 674, 342);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();   
		//panel.setBackground(Color.LIGHT_GRAY);
		panel.setToolTipText("");
		tabbedPane.addTab("Général", new ImageIcon(this.getClass().getResource("/images/Download-Folder-icon.png")), panel, "Des informations générales");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPrenom = new JLabel("Prénom ");
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrenom.setBounds(321, 11, 63, 14);
		panel.add(lblPrenom);
		
		tfnom = new JTextField();
		tfnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfnom.setBounds(69, 8, 242, 30);
		panel.add(tfnom);
		tfnom.setColumns(10);
		
		tfprenom = new JTextField();
		tfprenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfprenom.setColumns(10);
		tfprenom.setBounds(399, 8, 232, 30);
		panel.add(tfprenom);
		
		JLabel lblAdresse = new JLabel("Adresse ");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdresse.setBounds(10, 58, 63, 14);
		panel.add(lblAdresse);
		
		tfadresse = new JTextField();
		tfadresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfadresse.setColumns(10);
		tfadresse.setBounds(69, 52, 562, 30);
		panel.add(tfadresse);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCode.setBounds(10, 93, 46, 14);
		panel.add(lblCode);
		
		JLabel lblPostal = new JLabel("Postal");
		lblPostal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPostal.setBounds(10, 107, 46, 14);
		panel.add(lblPostal);
		
		tfcodepostal = new JTextField();
		tfcodepostal.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(!(Character.isDigit(c))||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE||
						tfcodepostal.getText().length()>=5)
				{
					getToolkit().beep();
					evt.consume();
					
				}
			}
		});
		tfcodepostal.setText("0");
		tfcodepostal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfcodepostal.setBounds(69, 93, 63, 30);
		panel.add(tfcodepostal);
		tfcodepostal.setColumns(10);
		
		JLabel lblWilaya = new JLabel("Wilaya");
		lblWilaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWilaya.setBounds(142, 93, 46, 22);
		panel.add(lblWilaya);
		
		tfwilaya = new JComboBox();
		tfwilaya.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfwilaya.setModel(new DefaultComboBoxModel(new String[] {"", "ADRAR\t", "AIN DEFLA\t", "AIN TEMOUCHENT\t", "AL TARF\t", "ALGER\t", "ANNABA\t", "B.B.ARRERIDJ\t", "BATNA\t", "BECHAR\t", "BEJAIA\t", "BISKRA\t", "BLIDA\t", "BOUIRA\t", "BOUMERDES\t", "CHLEF\t", "CONSTANTINE\t", "DJELFA\t", "EL BAYADH\t", "EL OUED\t", "GHARDAIA\t", "GUELMA\t", "ILLIZI\t", "JIJEL\t", "KHENCHELA\t", "LAGHOUAT\t", "MASCARA\t", "MEDEA\t", "MILA\t", "MOSTAGANEM\t", "M’SILA\t", "NAAMA\t", "ORAN\t", "OUARGLA\t", "OUM ELBOUAGHI\t", "RELIZANE\t", "SAIDA\t", "SETIF\t", "SIDI BEL ABBES\t", "SKIKDA\t", "SOUKAHRAS\t", "TAMANGHASSET\t", "TEBESSA\t", "TIARET\t", "TINDOUF\t", "TIPAZA\t", "TISSEMSILT\t", "TIZI.OUZOU\t", "TLEMCEN"}));
		tfwilaya.setSelectedIndex(0);
		tfwilaya.setBounds(191, 92, 178, 29);
		panel.add(tfwilaya);
		
		JLabel lblCommune = new JLabel("Commune");
		lblCommune.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCommune.setBounds(383, 98, 71, 21);
		panel.add(lblCommune);
		
		tfcommune = new JComboBox();
		tfcommune.setModel(new DefaultComboBoxModel(new String[] {""}));
		tfcommune.setSelectedIndex(0);
		tfcommune.setEditable(true);
		tfcommune.setBounds(465, 92, 165, 29);
		panel.add(tfcommune);
		
		JLabel lblTel = new JLabel("Tél");
		lblTel.setIcon(new ImageIcon(this.getClass().getResource("/images/Mobile-icon.png")));
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTel.setBounds(7, 132, 56, 32);
		panel.add(lblTel);
		
		JLabel lblTl = new JLabel("Tél");
		lblTl.setIcon(new ImageIcon(this.getClass().getResource("/images/phone-icon.png")));
		lblTl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTl.setBounds(8, 175, 56, 32);
		panel.add(lblTl);
		
		JLabel lblFax = new JLabel("Fax");
		lblFax.setIcon(new ImageIcon(this.getClass().getResource("/images/Fax-icon.png")));
		lblFax.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFax.setBounds(7, 222, 60, 32);
		panel.add(lblFax);
		
		tftelportabl = new JTextField();
		tftelportabl.addKeyListener(new KeyAdapter() {
		
			public void keyTyped(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(!(Character.isDigit(c))||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE||
						tftelportabl.getText().length()>=10)
				{
					getToolkit().beep();
					evt.consume();
					
				}
			}
		});
		tftelportabl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tftelportabl.setColumns(10);
		tftelportabl.setBounds(69, 138, 326, 30);
		panel.add(tftelportabl);
		
		tftelfix = new JTextField();
		tftelfix.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c))||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE||
						tftelfix.getText().length()>=9)
				{
					getToolkit().beep();
					e.consume();
					
				}
			}
		});
		tftelfix.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tftelfix.setColumns(10);
		tftelfix.setBounds(69, 185, 326, 30);
		panel.add(tftelfix);
		
		tffax = new JTextField();
		tffax.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c))||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE||
						tffax.getText().length()>=9)
				{
					getToolkit().beep();
					e.consume();
					
				}
			}
		});
		tffax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tffax.setColumns(10);
		tffax.setBounds(69, 227, 326, 30);
		panel.add(tffax);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Plus_Information", new ImageIcon(this.getClass().getResource("/images/Button-Info-icon.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblN = new JLabel("N° R C");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblN.setBounds(10, 28, 46, 14);
		panel_1.add(lblN);
		
		JLabel lblNIF = new JLabel("N° I F");
		lblNIF.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNIF.setBounds(10, 90, 46, 14);
		panel_1.add(lblNIF);
		
		JLabel lblCompte = new JLabel("Compte");
		lblCompte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompte.setBounds(38, 129, 55, 26);
		panel_1.add(lblCompte);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setIcon(new ImageIcon(this.getClass().getResource("/images/email-2-icon (1).png")));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 195, 64, 24);
		panel_1.add(lblEmail);
		
		JLabel lblBanq = new JLabel("Bancaire");
		lblBanq.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBanq.setBounds(38, 149, 59, 26);
		panel_1.add(lblBanq);
		
		tfnrc = new JTextField();
		tfnrc.setForeground(new Color(0, 102, 204));
		tfnrc.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnrc.setBounds(103, 24, 237, 30);
		panel_1.add(tfnrc);
		tfnrc.setColumns(10);
		
		tfnif = new JTextField();
		tfnif.setForeground(new Color(0, 102, 204));
		tfnif.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnif.setColumns(10);
		tfnif.setBounds(103, 84, 237, 30);
		panel_1.add(tfnif);
		
		tfcomptebancaire = new JTextField();
		tfcomptebancaire.setForeground(new Color(0, 102, 204));
		tfcomptebancaire.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfcomptebancaire.setColumns(10);
		tfcomptebancaire.setBounds(103, 136, 237, 30);
		panel_1.add(tfcomptebancaire);
		
		tfemail = new JTextField();
		tfemail.setForeground(new Color(0, 102, 204));
		tfemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfemail.setColumns(10);
		tfemail.setBounds(103, 193, 237, 30);
		panel_1.add(tfemail);
		
		JLabel lblNArt = new JLabel("N° Art");
		lblNArt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNArt.setBounds(358, 25, 46, 14);
		panel_1.add(lblNArt);
		
		JLabel lblNIS = new JLabel("N° I S");
		lblNIS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNIS.setBounds(358, 90, 46, 14);
		panel_1.add(lblNIS);
		
		JLabel lblRIP = new JLabel("R I B");
		lblRIP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRIP.setBounds(358, 136, 55, 26);
		panel_1.add(lblRIP);
		
		JLabel lblSiteWeb = new JLabel("Site Web");
		lblSiteWeb.setIcon(new ImageIcon(this.getClass().getResource("/images/HTTP-icon (1).png")));
		lblSiteWeb.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSiteWeb.setBounds(337, 191, 97, 32);
		panel_1.add(lblSiteWeb);
		
		tfnart = new JTextField();
		tfnart.setForeground(new Color(0, 102, 204));
		tfnart.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnart.setColumns(10);
		tfnart.setBounds(431, 22, 237, 30);
		panel_1.add(tfnart);
		
		tfnis = new JTextField();
		tfnis.setForeground(new Color(0, 102, 204));
		tfnis.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfnis.setColumns(10);
		tfnis.setBounds(431, 82, 237, 30);
		panel_1.add(tfnis);
		
		tfrib = new JTextField();
		tfrib.setForeground(new Color(0, 102, 204));
		tfrib.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfrib.setColumns(10);
		tfrib.setBounds(431, 134, 237, 30);
		panel_1.add(tfrib);
		
		tfsiteweb = new JTextField();
		tfsiteweb.setForeground(new Color(0, 102, 204));
		tfsiteweb.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfsiteweb.setColumns(10);
		tfsiteweb.setBounds(431, 191, 237, 30);
		panel_1.add(tfsiteweb);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/images/Money-icon (1).png")));
		lblNewLabel_1.setBounds(3, 135, 32, 32);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblSoldeInitiale = new JLabel("Solde Initial :");
		lblSoldeInitiale.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoldeInitiale.setBounds(164, 240, 90, 17);
		panel_1.add(lblSoldeInitiale);
		
		tfsolde = new JTextField();
		tfsolde.setText("0");
		tfsolde.setForeground(new Color(0, 102, 204));
		tfsolde.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfsolde.setColumns(10);
		tfsolde.setBounds(264, 234, 237, 30);
		panel_1.add(tfsolde);
		
		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajouter_fournisseur();
			}
		});
		btnOk.setForeground(new Color(0, 255, 102));
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setIcon(new ImageIcon(AddProviderForm.class.getResource("/images/database-accept-icon.png")));
		btnOk.setBounds(128, 350, 77, 33);
		contentPane.add(btnOk);
		
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAnnuler.setForeground(new Color(255, 51, 51));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnnuler.setIcon(new ImageIcon(AddProviderForm.class.getResource("/images/Misc-Delete-Database-icon.png")));
		btnAnnuler.setBounds(507, 350, 113, 33);
		contentPane.add(btnAnnuler);
	}
////////////////////////////////////////////////les méthodes/////////////////////////////////////////////////////////////
/**
* @param ID
* @return 
* cette methode faire une recherche d'un Fournisseur a base de identificateur 
* la methode returner le resultate pour l'affichge
*/
public static ResultSet ID_search_fourniseur(int ID)//
				
{
DataBase database= Session.getDatabase();
String SqlQury="select * from fournisseurs where id="+ID+";";		
return database.getResult(SqlQury); 
}

/********************************************************************************************/
/**
* @param nom
* @param prenom
* @return
* cette methode faire une recherche d'un fourniseur a base de numero ou nom/prenom 
* la methode returner le resultate pour l'affichge
*/
public static ResultSet info_search_fourniseur(String nom, String prenom)
{
							
DataBase database=Session.getDatabase();
String SqlQury="select * from fournisseurs where Nom LIKE '"+nom+"%' AND Prenom LIKE '"+prenom+"%';";		
return database.getResult(SqlQury); 
}
/************************************************************************************************/
/**
 * cette methode ajouter un Fournisseur
 */
private static void Ajouter_fournisseur() {

	ResultSet resultSet=null;								
	try {
		Pattern pattern = Pattern.compile("^.+@.+\\..+$");//Email validation
		Matcher matcher1 = pattern.matcher(tfemail.getText());// passage de parametre
		if(matcher1.find() || tfemail.getText().equals("") ){
			DataBase database = Session.getDatabase();
			String selectSQL=null;
			PreparedStatement prepared=null;
		try {
			selectSQL="select * from fournisseurs where Nom=? AND Prenom =?";
			prepared = (PreparedStatement) database.getConnection()
				.prepareStatement(selectSQL);
			prepared.setString(1, tfnom.getText());
			prepared.setString(2, tfprenom.getText());
			resultSet=prepared.executeQuery();
			resultSet.last();
			
		} catch (SQLException g) {
			// TODO Auto-generated catch block
			g.printStackTrace();
		}
		if(resultSet.getRow() !=0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "le fournisseur déjà existe", "ERREUR de connection",
			        JOptionPane.ERROR_MESSAGE);
			
		}
		else
		{
			try {
				selectSQL="insert into fournisseurs(Nom,Prenom,Adresse,CodePostal,wilaya,Commune,TelPortable,TeleFix,"+
						"Fax,NRC,NART,NIF,NIS,RIB,ComptBancaire,Email,SiteWeb,Solde_Initial)Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
						prepared=(PreparedStatement) database.getConnection().prepareStatement(selectSQL);
						prepared.setString(1,  tfnom.getText());
						prepared.setString(2,  tfprenom.getText());
						prepared.setString(3,  tfadresse.getText());
						prepared.setInt(4,     Integer.parseInt(tfcodepostal.getText()));
						prepared.setString(5,  tfwilaya.getSelectedItem().toString());
						prepared.setString(6,  tfcommune.getSelectedItem().toString());
						prepared.setString(7,  tftelportabl.getText());
						prepared.setString(8,  tftelfix.getText());
						prepared.setString(9, tffax.getText());
						prepared.setString(10, tfnrc.getText());
						prepared.setString(11, tfnart.getText());
						prepared.setString(12, tfnif.getText());
						prepared.setString(13, tfnis.getText());
						prepared.setString(14, tfrib.getText());
						prepared.setString(15, tfcomptebancaire.getText());
						prepared.setString(16, tfemail.getText());
						prepared.setString(17, tfsiteweb.getText());
						prepared.setDouble(18, Double.parseDouble(tfsolde.getText()));
						prepared.executeUpdate();
					
						JOptionPane.showMessageDialog(new JFrame(), "Inscription Success", "Information d'inscription",
						        JOptionPane.INFORMATION_MESSAGE);
						tfadresse.setText(null);tfcodepostal.setText("0");tfcomptebancaire.setText(null);
						tfemail.setText(null);tffax.setText(null);tfnart.setText(null);
						tfnif.setText(null);tfnis.setText(null);tfnom.setText(null);tfnrc.setText(null);tfprenom.setText(null);
						tfrib.setText(null);tfsiteweb.setText(null);tftelfix.setText(null);tftelportabl.setText(null);tfsolde.setText("0");
					
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(new JFrame(), "erreur de type donnees", "ERREUR d'inscription",
				        JOptionPane.ERROR_MESSAGE);
			}
		
		}
	}
		else
		{
			JOptionPane.showMessageDialog(new JFrame(), "Adresse e-mail incorrecte \t\t \n E-Mail format:   xxxxxx@yyyy.zzz", "ERREUR d'inscription",
			        JOptionPane.ERROR_MESSAGE);
			
		}
						
	} catch (Exception ex) {
		JOptionPane.showMessageDialog(new JFrame(), ex, "ERREUR de connection",
		        JOptionPane.ERROR_MESSAGE);					
	}
	
}
}
