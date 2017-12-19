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
	
	private int city;				// 7
	private int wilaya;				
	 
	private String mobile;			// 8
	private String phone;			// 9
	private String fax;				// 10
	private String mail;			// 11
	private String website;			// 12
	
	private int mode;				// 13
	
	private String bank_account;	// 14
	private double credit;			// 15
	
	private String NRC;				// 16
	private String NART;			// 17
	private String NIF;				// 18
	private String NIS;				// 19
	private String RIB;				// 20
	
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

				String city_code = result.getString(7);
				setWilaya(Integer.parseInt(city_code.substring(0, 2)));
				setCity(Integer.parseInt(city_code.substring(2, 4)));
				
				setMobile(result.getString(8));
				setPhone(result.getString(9));
				setFax(result.getString(10));
				
				setMail(result.getString(11));
				setWebsite(result.getString(12));
				setMode(result.getInt(13));
				setBank_account(result.getString(14));
				setCredit(result.getDouble(15));
				
				setNRC(result.getString(16));
				setNART(result.getString(17));
				setNIF(result.getString(18));
				setNIS(result.getString(19));
				setRIB(result.getString(20));
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
		String selectSQL="INSERT INTO providers(firstname,lastname,address,family,zip,city,"
				+ "mobile,phone,fax,mail,website,mode,bank_account,credit,NRC,NART,"
				+ "NIF,NIS,RIB) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement(selectSQL,Statement.RETURN_GENERATED_KEYS);
			prepared.setString(1 , getFirstname());
			prepared.setString(2 , getLastname());
			prepared.setString(3 , getAddress());
			prepared.setString(4 , getFamily());
			prepared.setString(5 , getZip());
			
			prepared.setString(6 , String.format("%02d%02d", getWilaya(), getCity()));
			
			prepared.setString(7 , getMobile());
			prepared.setString(8 , getPhone());
			prepared.setString(9, getFax());
			prepared.setString(10, getMail());
			prepared.setString(11, getWebsite());
			prepared.setInt   (12, getMode());
			prepared.setString(13, getBank_account());
			prepared.setDouble(14, getCredit());
			prepared.setString(15, getNRC());
			prepared.setString(16, getNART());
			prepared.setString(17, getNIF());
			prepared.setString(18, getNIS());
			prepared.setString(19, getRIB());
			
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
					        		+ "family=?,zip=?,city=?,mobile=?,phone=?,fax=?,mail=?,"
					        		+ "website=?,mode=?,bank_account=?,credit=?,NRC=?,"
					        		+ "NART=?,NIF=?,NIS=?,RIB=? WHERE id=?;");
			
			prepared.setString(1 , getFirstname());
			prepared.setString(2 , getLastname());
			prepared.setString(3 , getAddress());
			prepared.setString(4 , getFamily());
			prepared.setString(5 , getZip());
			prepared.setString(6 , String.format("%02d%02d", getWilaya(), getCity()));
			prepared.setString(7 , getMobile());
			prepared.setString(8 , getPhone());
			prepared.setString(9, getFax());
			prepared.setString(10, getMail());
			prepared.setString(11, getWebsite());
			prepared.setInt   (12, getMode());
			prepared.setString(13, getBank_account());
			prepared.setDouble(14, getCredit());
			prepared.setString(15, getNRC());
			prepared.setString(16, getNART());
			prepared.setString(17, getNIF());
			prepared.setString(18, getNIS());
			prepared.setString(19, getRIB());
			prepared.setInt   (20, getId());
			if (prepared.executeUpdate()>0)
				b = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
}
