package com.home;

import java.sql.Date;
import java.sql.PreparedStatement;
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
	private String RIP;
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
	public String getRIP()
	{
		return RIP;
	}
	public void setRIP(String rip)
	{
		this.RIP=rip;
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
	public boolean format_Email(String email)
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
	public Client(){
		this.getId();
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
	public void delete(int id ){
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
	public void update()
	{
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("UPDATE products SET designation=?, family=?, barcode=?, cost=?, "
							+ "selling1=?, selling2=?, selling3=?, amount=?, used=?, min=?, expiration=?"
							+ ", mesure_unit=? WHERE id=?");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
