package com.home;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author DocteurTnou
 *
 */
public class Client {
	private int Id ;
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Famille;
	private int CodePostal;
	private String Wilaya;
	private String Commune;
	private String TelPortable;
	private String TeleFix;
	private String Fax;
	private String NRC;
	private String NART;
	private String NIF;
	private String NIS;
	private String RIB;
	private String ComptBancaire;
	private String Email;
	private String SiteWeb;
	private int ModeTarif;
	private double LimitationCredit ;
	private double Solde_Initial;
	
	/**
	 * @return 
	 * Intrger : ID
	 */
	public Client(){
		
	}
	public int getId()
	{
		return Id;
	}
	public void setId(int id)
	{
		this.Id=id;
	}
	
	/**
	 * @return
	 * String : Nom
	 */
	public String getNom()
	{
		return Nom;
	}
	public void setNom(String nom)
	{
		this.Nom=nom;
	}

	/**
	 * @return
	 * String : Prenom
	 */
	public String getPrenom()
	{
		return Prenom;
	}
	public void setPrenom(String prenom)
	{
		this.Prenom=prenom;
	}	
	/**
	 * @return
	 *String :  Adresse
	 */
	public String getAdresse()
	{
		return Adresse;
	}
	public void setAdresse(String adresse)
	{
		this.Adresse=adresse;
	}
	/**
	 * @return
	 * String : Famille
	 */
	public String getFamille()
	{
		return Famille;
	}
	public void setFamille(String famille)
	{
		this.Famille=famille;
	}
	/**
	 * @return
	 * String : CodePostal
	 */
	public int getCodePostal()
	{
		return CodePostal;
	}
	public void setCodePostal(int codepostal)
	{
		this.CodePostal=codepostal;
	}
	/**
	 * @return
	 * String : Wilaya
	 */
	public String getWilaya()
	{
		return Wilaya;
	}
	public void setWilaya(String wilaya)
	{
		this.Wilaya=wilaya;
	}
	/**
	 * @return
	 * String : Commune
	 */
	public String getCommune()
	{
		return Commune;
	}
	public void setCommune(String commune)
	{
		this.Commune=commune;
	}	
	/**
	 * @return
	 * String : TelPortable
	 */
	public String getTelPortable()
	{
		return TelPortable;
	}
	public void setTelePortable(String telePortable)
	{
		this.TelPortable=telePortable;
	}
	/**
	 * @return
	 * String : TeleFix
	 */
	public String getTeleFix()
	{
		return TeleFix;
	}
	public void setTeleFix(String telefix)
	{
		this.TeleFix=telefix;
	}
	/**
	 * @return
	 * String : Fax
	 */
	public String getFax()
	{
		return Fax;
	}
	public void setFax(String fax)
	{
		this.Fax=fax;
	}

	/**
	 * @return
	 * String : NRC
	 */
	public String getNRC()
	{
		return NRC;
	}
	public void setNRC(String nrc)
	{
		this.NRC=nrc;
	}	
	/**
	 * @return
	 * String : NART
	 */
	public String getNART()
	{
		return NART;
	}
	public void setNART(String nart)
	{
		this.NART=nart;
	}
	/**
	 * @return
	 *String : NIF
	 */
	public String getNIF()
	{
		return NIF;
	}
	public void setNIF(String nif)
	{
		this.NIF=nif;
	}
	/**
	 * @return
	 *String : NIS
	 */
	public String getNIS()
	{
		return NIS;
	}
	public void setNIS(String nis)
	{
		this.NIS=nis;
	}
	/**
	 * @return
	 *String : RIP
	 */
	public String getRIB()
	{
		return RIB;
	}
	public void setRIB(String rib)
	{
		this.RIB=rib;
	}
	/**
	 * @return
	 *String : ComptBancaire
	 */
	public String getComptBancaire()
	{
		return ComptBancaire;
	}
	public void setComptBancaire(String comptBancaire)
	{
		this.ComptBancaire=comptBancaire;
	}
	/**
	 * @return
	 *String : Email
	 */
	public String getEmail()
	{
		return Email;
	}
	public void setEmail(String email)
	{
		this.Email=email;
	}
	/**
	 * @param email
	 * @return
	 * (true/false) test format email
	 */
	public static boolean format_Email(String email)
	{  
		try {
		Pattern pattern = Pattern.compile("^.+@.+\\..+$");//Email validation
		Matcher matcher = pattern.matcher(email);// passage de parametre	
		return matcher.find();
		} 
		catch (Exception e) {
		// TODO: handle exception
			}
		return false;
		
	}
	/**
	 * @return
	 *String : SiteWeb
	 */
	public String getSiteWeb()
	{
		return SiteWeb;
	}
	public void setSiteWeb(String siteweb)
	{
		this.SiteWeb=siteweb;
	}
	/**
	 * @return
	 *integer : ModeTarif
	 */
	public int getModeTarif()
	{
		return ModeTarif;
	}
	public void setModeTarif(int modetarif)
	{
		this.ModeTarif=modetarif;
	}
	/**
	 * @return
	 *double : LimitationCredit
	 */
	public double getLimitationCredit()
	{
		return LimitationCredit;
	}
	public void setLimitationCredit(double limitationcredit)
	{
		this.LimitationCredit=limitationcredit;
	}
	/**
	 * @return
	 *double : Solde_Initial
	 */
	public double getSolde_Initial()
	{
		return Solde_Initial;
	}
	public void setSolde_Initial(double solde_initial)
	{
		this.Solde_Initial=solde_initial;
	}
	
	
	/**
	 * @param nom
	 * @param prenom
	 * @return
	 * (true/false) recherche par nom et prénom
	 */
	public static boolean exist(String nom,String prenom)
	{
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("select * from client where Nom=? AND Prenom =? ");
			prepared.setString(1, nom);
			prepared.setString(2, prenom);
			ResultSet resultSet=prepared.executeQuery();
			resultSet.last();
			if (resultSet.getRow()!=0)
			{
				return true;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false ;	
		
	}
	/**
	 * @param id
	 * @return
	 * (true/false) recherche par Id
	 */
	public static boolean exist(int id)
	{
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().prepareStatement("select * from client where id=?;");
			prepared.setInt(1,id);			
			ResultSet resultSet=prepared.executeQuery();
			resultSet.last();
			if (resultSet.getRow()!=0)
			{
				return true;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 */
	public void add()
	{
		String selectSQL="insert into client(Nom,Prenom,Adresse,Famille,CodePostal,wilaya,Commune,TelPortable,TeleFix,"+
				"Fax,NRC,NART,NIF,NIS,RIB,ComptBancaire,Email,SiteWeb,ModeTarif,"+
						"LimitationCredit,Solde_Initial)Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement(selectSQL);
			prepared.setString(1 , getNom());
			prepared.setString(2 , getPrenom());
			prepared.setString(3 , getAdresse());
			prepared.setString(4 , getFamille());
			prepared.setInt   (5 , getCodePostal());
			prepared.setString(6 , getWilaya());
			prepared.setString(7 , getCommune());
			prepared.setString(8 , getTelPortable());
			prepared.setString(9 , getTeleFix());
			prepared.setString(10, getFax());
			prepared.setString(11, getNRC());
			prepared.setString(12, getNART());
			prepared.setString(13, getNIF());
			prepared.setString(14, getNIS());
			prepared.setString(15, getRIB());
			prepared.setString(16, getComptBancaire());
			prepared.setString(17, getEmail());
			prepared.setString(18, getSiteWeb());
			prepared.setInt   (19, getModeTarif());
			prepared.setDouble(20, getLimitationCredit());
			prepared.setDouble(21, getSolde_Initial());
			prepared.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return
	 * void delete Client
	 */
	public void delete(){
		try {
				PreparedStatement prepared = Session.getDatabase().getConnection().
				prepareStatement("DELETE FROM client WHERE id=?");
				prepared.setInt(1, getId());
				prepared.executeUpdate();
			}
		catch (Exception e) {
			// TODO: handle exception
		}
		}
	/**
	 * @param id
	 * @return
	 * void delete Client
	 */

	public static void delete(int id ){
		try {
				PreparedStatement prepared = Session.getDatabase().getConnection().
				prepareStatement("DELETE FROM client WHERE id=?");
				prepared.setInt(1,id);
				prepared.executeUpdate();
			}
		catch (Exception e) {
			// TODO: handle exception
		}
		}
	/**
	 * Update Client information
	 */
	public void update()
	{
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("UPDATE client SET Nom=? ,Prenom=? ,Adresse=? ,Famille=? ,CodePostal=? ,wilaya=?"
							+ ",Commune=? ,TelPortable=? ,TeleFix=? ,Fax=? ,NRC=? ,NART=? ,NIF=? ,NIS=? ,RIB=? ,ComptBancaire=?"
							+ ",Email=? ,SiteWeb=? ,ModeTarif=? ,LimitationCredit=? ,Solde_Initial=? WHERE id=?;");
			prepared.setString(1 , getNom());
			prepared.setString(2 , getPrenom());
			prepared.setString(3 , getAdresse());
			prepared.setString(4 , getFamille());
			prepared.setInt   (5 , getCodePostal());
			prepared.setString(6 , getWilaya());
			prepared.setString(7 , getCommune());
			prepared.setString(8 , getTelPortable());
			prepared.setString(9 , getTeleFix());
			prepared.setString(10, getFax());
			prepared.setString(11, getNRC());
			prepared.setString(12, getNART());
			prepared.setString(13, getNIF());
			prepared.setString(14, getNIS());
			prepared.setString(15, getRIB());
			prepared.setString(16, getComptBancaire());
			prepared.setString(17, getEmail());
			prepared.setString(18, getSiteWeb());
			prepared.setInt   (19, getModeTarif());
			prepared.setDouble(20, getLimitationCredit());
			prepared.setDouble(21, getSolde_Initial());
			prepared.setInt(22, getId());
			prepared.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
