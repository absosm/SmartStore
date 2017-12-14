package com.home;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Provider {
	
	private int id ;				// 1
	private String firstname;		// 2
	private String lastname;		// 3
	private String address;			// 4
	private String family;			// 5
	private String zip;				// 6
	private int wilaya;				// 7
	private int city;				// 8
	 
	private String mobile;			// 9
	private String phone;			// 10
	private String fax;				// 11
	private String mail;			// 12
	private String website;			// 13
	
	private int mode;				// 14
	
	private String bank_account;	// 15
	private double credit;			// 16
	
	private String NRC;				// 17
	private String NART;			// 18
	private String NIF;				// 19
	private String NIS;				// 20
	private String RIB;				// 21
	
	/**
	 * 
	 */
	public Provider(){
		
		setFirstname("");
		setLastname("");
		setAddress("");
		setFamily("");
		setZip("");
		setWilaya(0);
		setCity(0);
		setMobile("");
		setPhone("");
		setFax("");
		setNRC("");
		setNART("");
		setNIF("");
		setNIS("");
		setRIB("");
		setBank_account("");
		setMail("");
		setWebsite("");
		setMode(0);
		setCredit(0);		
	}
	
	public Provider(int id){
		
		try {
			
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("SELECT * FROM providers WHERE id=?");
			prepared.setInt(1, id);
			ResultSet result = prepared.executeQuery();
			
			if (result.next()) {
				setId(result.getInt(1));
				setFirstname(result.getString(2));
				setLastname(result.getString(3));
				setAddress(result.getString(4));
				setFamily(result.getString(5));
				setZip(result.getString(6));
				setWilaya(result.getInt(7));
				setCity(result.getInt(8));
				setMobile(result.getString(9));
				setPhone(result.getString(10));
				setFax(result.getString(11));
				
				setMail(result.getString(12));
				setWebsite(result.getString(13));
				setMode(result.getInt(14));
				setBank_account(result.getString(15));
				setCredit(result.getDouble(16));
				
				setNRC(result.getString(17));
				setNART(result.getString(18));
				setNIF(result.getString(19));
				setNIS(result.getString(20));
				setRIB(result.getString(21));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
				
	}
	/**
	 * @param id
	 */
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id=id;
	}
	
	/**
	 * @return
	 * String : name
	 */
	public String getFirstname()
	{
		return firstname;
	}
	public void setFirstname(String name)
	{
		this.firstname=name;
	}

	/**
	 * @return
	 * String : First_name
	 */
	public String getLastname()
	{
		return lastname;
	}
	public void setLastname(String first_name)
	{
		this.lastname=first_name;
	}	
	/**
	 * @return
	 *String :  Address
	 */
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	/**
	 * @return
	 * String : Family
	 */
	public String getFamily()
	{
		return family;
	}
	public void setFamily(String family)
	{
		this.family=family;
	}
	/**
	 * @return
	 * String : Postal_Code
	 */
	public String getZip()
	{
		return zip;
	}
	public void setZip(String zip)
	{
		this.zip=zip;
	}
	/**
	 * @return
	 * String : Wilaya
	 */
	public int getWilaya()
	{
		return wilaya;
	}
	public void setWilaya(int wilaya)
	{
		this.wilaya=wilaya;
	}
	/**
	 * @return
	 * String : City
	 */
	public int getCity()
	{
		return city;
	}
	public void setCity(int city)
	{
		this.city=city;
	}	
	/**
	 * @return
	 * String : mobile_number
	 */
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile_number)
	{
		this.mobile=mobile_number;
	}
	/**
	 * @return
	 * String : Telephone
	 */
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	/**
	 * @return
	 * String : Fax
	 */
	public String getFax()
	{
		return fax;
	}
	public void setFax(String fax)
	{
		this.fax=fax;
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
	public String getBank_account()
	{
		return bank_account;
	}
	public void setBank_account(String comptBancaire)
	{
		this.bank_account=comptBancaire;
	}
	/**
	 * @return
	 *String : Email
	 */
	public String getMail()
	{
		return mail;
	}
	public void setMail(String mail)
	{
		this.mail = mail;		
	}
	/**
	 * @return
	 *String : SiteWeb
	 */
	public String getWebsite()
	{
		return website;
	}
	public void setWebsite(String website)
	{
		this.website=website;
	}
	/**
	 * @return
	 *integer : pricing_mode
	 */
	public int getMode()
	{
		return mode;
	}
	public void setMode(int pricing_mode)
	{
		this.mode=pricing_mode;
	}
	/**
	 * @return
	 *double : initial_credit
	 */
	public double getCredit()
	{
		return credit;
	}
	public void setCredit(double initial_credit)
	{
		this.credit=initial_credit;
	}
	
	
	/**
	 * @param nom
	 * @param prenom
	 * @return
	 * (true/false) recherche par nom et prénom
	 */
	public static boolean exist(String firstname ,String lastname)
	{
		boolean b = false;
		
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
			prepareStatement("SELECT * FROM providers WHERE (Name=? AND First_name =?)");
			prepared.setString(1, firstname);
			prepared.setString(2, lastname);
			ResultSet result=prepared.executeQuery();
			if (result.next())
				b = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b ;
	}
	/**
	 * @param id
	 * @return
	 * (true/false) recherche par Id
	 */
	public static boolean exist(int id)
	{
		boolean b = false;
		
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("select * from providers where id=?;");
			prepared.setInt(1,id);			
			ResultSet result = prepared.executeQuery();
			if (result.next())
				b = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	/**
	 * 
	 */
	public boolean add()
	{
		boolean b = false;
		String selectSQL="INSERT INTO providers(firstname,lastname,address,family,zip,wilaya,city,"
				+ "mobile,phone,fax,mail,website,mode,bank_account,credit,NRC,NART,"
				+ "NIF,NIS,RIB) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement(selectSQL,Statement.RETURN_GENERATED_KEYS);
			prepared.setString(1 , getFirstname());
			prepared.setString(2 , getLastname());
			prepared.setString(3 , getAddress());
			prepared.setString(4 , getFamily());
			prepared.setString(5 , getZip());
			prepared.setInt   (6 , getWilaya());
			prepared.setInt   (7 , getCity());
			prepared.setString(8 , getMobile());
			prepared.setString(9 , getPhone());
			prepared.setString(10, getFax());
			prepared.setString(11, getMail());
			prepared.setString(12, getWebsite());
			prepared.setInt   (13, getMode());
			prepared.setString(14, getBank_account());
			prepared.setDouble(15, getCredit());
			prepared.setString(16, getNRC());
			prepared.setString(17, getNART());
			prepared.setString(18, getNIF());
			prepared.setString(19, getNIS());
			prepared.setString(20, getRIB());
			
			prepared.executeUpdate();
			ResultSet result = prepared.getGeneratedKeys();
			if (result.next()) {
				this.setId(result.getInt(1));
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	/**
	 * @return 
	 * void delete Client
	 */
	public void delete(){
		
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
			prepareStatement("DELETE FROM providers WHERE id=?");
			prepared.setInt(1, getId());
			prepared.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * @param id
	 * @return
	 * void delete Client
	 */

	public static void delete(int id){
		
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
			prepareStatement("DELETE FROM providers WHERE id=?");
			prepared.setInt(1,id);
			prepared.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * Update Client information
	 */
	public boolean update()
	{
		boolean b = false;
		
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					        prepareStatement("UPDATE providers SET firstname=?,lastname=?,address=?,"
					        		+ "family=?,zip=?,wilaya=?,city=?,mobile=?,phone=?,fax=?,mail=?,"
					        		+ "website=?,mode=?,bank_account=?,credit=?,NRC=?,"
					        		+ "NART=?,NIF=?,NIS=?,RIB=? WHERE id=?;");
			
			prepared.setString(1 , getFirstname());
			prepared.setString(2 , getLastname());
			prepared.setString(3 , getAddress());
			prepared.setString(4 , getFamily());
			prepared.setString(5 , getZip());
			prepared.setInt(6 , getWilaya());
			prepared.setInt(7 , getCity());
			prepared.setString(8 , getMobile());
			prepared.setString(9 , getPhone());
			prepared.setString(10, getFax());
			prepared.setString(11, getMail());
			prepared.setString(12, getWebsite());
			prepared.setInt   (13, getMode());
			prepared.setString(14, getBank_account());
			prepared.setDouble(15, getCredit());
			prepared.setString(16, getNRC());
			prepared.setString(17, getNART());
			prepared.setString(18, getNIF());
			prepared.setString(19, getNIS());
			prepared.setString(20, getRIB());
			prepared.setInt   (21, getId());
			if (prepared.executeUpdate()>0)
				b = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
}
