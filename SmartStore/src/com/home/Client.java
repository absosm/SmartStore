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
	private String Name;
	private String First_name;
	private String Address;
	private String Family;
	private int Postal_Code;
	private String Wilaya;
	private String City;
	private String Mobile_Number;
	private String Telphone;
	private String Fax;
	private String NRC;
	private String NART;
	private String NIF;
	private String NIS;
	private String RIB;
	private String Bank_Account;
	private String Email;
	private String Website;
	private int Pricing_Mode;
	private double Limitation_Credit ;
	private double Initial_Credit;
	
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
	public String getName()
	{
		return Name;
	}
	public void setName(String nom)
	{
		this.Name=nom;
	}

	/**
	 * @return
	 * String : Prenom
	 */
	public String getFirst_name()
	{
		return First_name;
	}
	public void setFirst_name(String prenom)
	{
		this.First_name=prenom;
	}	
	/**
	 * @return
	 *String :  Address
	 */
	public String getAddress()
	{
		return Address;
	}
	public void setAddress(String address)
	{
		this.Address=address;
	}
	/**
	 * @return
	 * String : Family
	 */
	public String getFamily()
	{
		return Family;
	}
	public void setFamily(String famille)
	{
		this.Family=famille;
	}
	/**
	 * @return
	 * String : CodePostal
	 */
	public int getPostal_Code()
	{
		return Postal_Code;
	}
	public void setPostal_Code(int codepostal)
	{
		this.Postal_Code=codepostal;
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
	public String getCity()
	{
		return City;
	}
	public void setCity(String commune)
	{
		this.City=commune;
	}	
	/**
	 * @return
	 * String : TelPortable
	 */
	public String getMobile_Number()
	{
		return Mobile_Number;
	}
	public void setTelePortable(String telePortable)
	{
		this.Mobile_Number=telePortable;
	}
	/**
	 * @return
	 * String : TeleFix
	 */
	public String getTelphone()
	{
		return Telphone;
	}
	public void setTelphone(String telefix)
	{
		this.Telphone=telefix;
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
	public String getBank_Account()
	{
		return Bank_Account;
	}
	public void setBank_Account(String comptBancaire)
	{
		this.Bank_Account=comptBancaire;
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
	public String getWebsite()
	{
		return Website;
	}
	public void setWebsite(String siteweb)
	{
		this.Website=siteweb;
	}
	/**
	 * @return
	 *integer : ModeTarif
	 */
	public int getPricing_Mode()
	{
		return Pricing_Mode;
	}
	public void setPricing_Mode(int modetarif)
	{
		this.Pricing_Mode=modetarif;
	}
	/**
	 * @return
	 *double : LimitationCredit
	 */
	public double getLimitation_Credit()
	{
		return Limitation_Credit;
	}
	public void setLimitation_Credit(double limitationcredit)
	{
		this.Limitation_Credit=limitationcredit;
	}
	/**
	 * @return
	 *double : Solde_Initial
	 */
	public double getInitial_Credit()
	{
		return Initial_Credit;
	}
	public void setInitial_Credit(double solde_initial)
	{
		this.Initial_Credit=solde_initial;
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
			prepared.setString(1 , getName());
			prepared.setString(2 , getFirst_name());
			prepared.setString(3 , getAddress());
			prepared.setString(4 , getFamily());
			prepared.setInt   (5 , getPostal_Code());
			prepared.setString(6 , getWilaya());
			prepared.setString(7 , getCity());
			prepared.setString(8 , getMobile_Number());
			prepared.setString(9 , getTelphone());
			prepared.setString(10, getFax());
			prepared.setString(11, getNRC());
			prepared.setString(12, getNART());
			prepared.setString(13, getNIF());
			prepared.setString(14, getNIS());
			prepared.setString(15, getRIB());
			prepared.setString(16, getBank_Account());
			prepared.setString(17, getEmail());
			prepared.setString(18, getWebsite());
			prepared.setInt   (19, getPricing_Mode());
			prepared.setDouble(20, getLimitation_Credit());
			prepared.setDouble(21, getInitial_Credit());
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
					prepareStatement("UPDATE client SET Name=? ,First_name=? ,Address=? ,Family=? ,Postal_Code=? ,Wilaya=?"
							+ ",City=? ,Mobile_Number=? ,Telphone=? ,Fax=? ,NRC=? ,NART=? ,NIF=? ,NIS=? ,RIB=? ,Bank_Account=?"
							+ ",Email=? ,Website=? ,Pricing_Mode=? ,Limitation_Credit=? ,Initial_Credit=? WHERE id=?;");
			prepared.setString(1 , getName());
			prepared.setString(2 , getFirst_name());
			prepared.setString(3 , getAddress());
			prepared.setString(4 , getFamily());
			prepared.setInt   (5 , getPostal_Code());
			prepared.setString(6 , getWilaya());
			prepared.setString(7 , getCity());
			prepared.setString(8 , getMobile_Number());
			prepared.setString(9 , getTelphone());
			prepared.setString(10, getFax());
			prepared.setString(11, getNRC());
			prepared.setString(12, getNART());
			prepared.setString(13, getNIF());
			prepared.setString(14, getNIS());
			prepared.setString(15, getRIB());
			prepared.setString(16, getBank_Account());
			prepared.setString(17, getEmail());
			prepared.setString(18, getWebsite());
			prepared.setInt   (19, getPricing_Mode());
			prepared.setDouble(20, getLimitation_Credit());
			prepared.setDouble(21, getInitial_Credit());
			prepared.setInt(22, getId());
			prepared.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
