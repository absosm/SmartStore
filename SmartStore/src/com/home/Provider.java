package com.home;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Provider {
	private  int Id;
	private  String Name;
	private  String First_name;
	private  String Address;
	private  int Postal_Code;
	private  String Wilaya;
	private  String City;
	private  String Mobile_Number;
	private  String Telphone;
	private  String Fax;
	private  String NRC;
	private  String NART;
	private  String NIF;
	private  String NIS;
	private  String RIB;
	private  String Bank_Account;
	private  String Email;
	private  String Website;
	private  double Initial_Credit;
	
 public Provider() {	
		setName("");
		setFirst_name("");
		setAddress("");		
		setPostal_Code(0);
		setWilaya("");
		setCity("");
		setMobile_Number("");
		setTelphone("");
		setFax("");
		setNRC("");
		setNART("");
		setNIF("");
		setNIS("");
		setRIB("");
		setBank_Account("");
		setEmail("");
		setWebsite("");		
		setInitial_Credit(0);		
	}
 
 public Provider(int id){
	 try {
			PreparedStatement prepared = Session.getDatabase().getConnection().prepareStatement("SELECT * FROM provider WHERE id=?");
			prepared.setInt(1, id);
			ResultSet result = prepared.executeQuery();
			if (result.next()) {	
			setId(id);
			setName(result.getString(1));
			setFirst_name(result.getString(2));
			setAddress(result.getString(3));
			setPostal_Code(result.getInt(4));
			setWilaya(result.getString(5));
			setCity(result.getString(6));
			setMobile_Number(result.getString(7));
			setTelphone(result.getString(8));
			setFax(result.getString(9));
			setNRC(result.getString(10));
			setNART(result.getString(11));
			setNIF(result.getString(12));
			setNIS(result.getString(13));
			setRIB(result.getString(14));
			setBank_Account(result.getString(15));
			setEmail(result.getString(16));
			setWebsite(result.getString(17));
			setInitial_Credit(result.getDouble(18));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	 
 }
	/**
	 * @param id
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
	 * String : name
	 */
	public String getName()
	{
		return Name;
	}
	public void setName(String name)
	{
		this.Name=name;
	}

	/**
	 * @return
	 * String : First_name
	 */
	public String getFirst_name()
	{
		return First_name;
	}
	public void setFirst_name(String first_name)
	{
		this.First_name=first_name;
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
	 * String : Postal_Code
	 */
	public int getPostal_Code()
	{
		return Postal_Code;
	}
	public void setPostal_Code(int postal_code)
	{
		this.Postal_Code=postal_code;
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
	 * String : City
	 */
	public String getCity()
	{
		return City;
	}
	public void setCity(String city)
	{
		this.City=city;
	}	
	/**
	 * @return
	 * String : mobile_number
	 */
	public String getMobile_Number()
	{
		return Mobile_Number;
	}
	public void setMobile_Number(String mobile_number)
	{
		this.Mobile_Number=mobile_number;
	}
	/**
	 * @return
	 * String : Telephone
	 */
	public String getTelphone()
	{
		return Telphone;
	}
	public void setTelphone(String phone)
	{
		this.Telphone=phone;
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
	 * @return
	 *String : SiteWeb
	 */
	public String getWebsite()
	{
		return Website;
	}
	public void setWebsite(String website)
	{
		this.Website=website;
	}
	

	/**
	 * @return
	 *double : initial_credit
	 */
	public double getInitial_Credit()
	{
		return Initial_Credit;
	}
	public void setInitial_Credit(double initial_credit)
	{
		this.Initial_Credit=initial_credit;
	}
	
	/**
	 * @param nom
	 * @param prenom
	 * @return
	 * (true/false) recherche par nom et prénom
	 */
	public static boolean exist(String name ,String first_name)
	{
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("select * from provider where Name=? AND First_name =? ");
			prepared.setString(1, name);
			prepared.setString(2, first_name);
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
			PreparedStatement prepared = Session.getDatabase().getConnection().prepareStatement("select * from provider where id=?;");
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
	public void  add(){
		String selectSQL="insert into provider (Name,First_name,Address,Postal_Code,Wilaya,City,Mobile_Number,Telphone"+
			"Fax,NRC,NART,NIF,NIS,RIB,Bank_Account,Email,Website,Initial_Credit)Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement(selectSQL,Statement.RETURN_GENERATED_KEYS);
			prepared.setString(1 , getName());
			prepared.setString(2 , getFirst_name());
			prepared.setString(3 , getAddress());
			prepared.setInt   (4 , getPostal_Code());
			prepared.setString(5 , getWilaya());
			prepared.setString(6 , getCity());
			prepared.setString(7 , getMobile_Number());
			prepared.setString(8 , getTelphone());
			prepared.setString(9, getFax());
			prepared.setString(10, getNRC());
			prepared.setString(11, getNART());
			prepared.setString(12, getNIF());
			prepared.setString(13, getNIS());
			prepared.setString(14, getRIB());
			prepared.setString(15, getBank_Account());
			prepared.setString(16, getEmail());
			prepared.setString(17, getWebsite());
			prepared.setDouble(18, getInitial_Credit());
			if(prepared.executeUpdate()>0){
				ResultSet result = prepared.getGeneratedKeys();
				result.next();
				setId(result.getInt(1));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	/**
	 * void delete provider
	 */
	public void delete(){
		try {
				PreparedStatement prepared = Session.getDatabase().getConnection().
				prepareStatement("DELETE FROM provider WHERE id=?");
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
	 * void delete provider
	 */

	public static void delete(int id ){
		try {
				PreparedStatement prepared = Session.getDatabase().getConnection().
				prepareStatement("DELETE FROM provider WHERE id=?");
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
					prepareStatement("UPDATE client SET Name=? ,First_name=? ,Address=? ,Postal_Code=? ,Wilaya=?"
							+ ",City=? ,Mobile_Number=? ,Telphone=? ,Fax=? ,NRC=? ,NART=? ,NIF=? ,NIS=? ,RIB=? ,Bank_Account=?"
							+ ",Email=? ,Website=?  ,Initial_Credit=? WHERE id=?;");
			prepared.setString(1 , getName());
			prepared.setString(2 , getFirst_name());
			prepared.setString(3 , getAddress());
			prepared.setInt   (4 , getPostal_Code());
			prepared.setString(5 , getWilaya());
			prepared.setString(6 , getCity());
			prepared.setString(7 , getMobile_Number());
			prepared.setString(8 , getTelphone());
			prepared.setString(9, getFax());
			prepared.setString(10, getNRC());
			prepared.setString(11, getNART());
			prepared.setString(12, getNIF());
			prepared.setString(13, getNIS());
			prepared.setString(14, getRIB());
			prepared.setString(15, getBank_Account());
			prepared.setString(16, getEmail());
			prepared.setString(17, getWebsite());
			prepared.setDouble(18, getInitial_Credit());
			prepared.setInt(19, getId());
			prepared.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	


}
