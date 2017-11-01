package com.home;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	 * 
	 */
	public Client(){
		setName("");
		setFirst_name("");
		setAddress("");
		setFamily("");
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
		setPricing_Mode(0);
		setLimitation_Credit(0);
		setInitial_Credit(0);		
	}
	
	public Client(int id){
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().prepareStatement("SELECT * FROM client WHERE id=?");
			prepared.setInt(1, id);
			ResultSet result = prepared.executeQuery();
			if (result.next()) {
			setId(id);
			setName(result.getString(2));
			setFirst_name(result.getString(3));
			setAddress(result.getString(4));
			setFamily(result.getString(5));
			setPostal_Code(result.getInt(6));
			setWilaya(result.getString(7));
			setCity(result.getString(8));
			setMobile_Number(result.getString(9));
			setTelphone(result.getString(10));
			setFax(result.getString(11));
			setNRC(result.getString(12));
			setNART(result.getString(13));
			setNIF(result.getString(14));
			setNIS(result.getString(15));
			setRIB(result.getString(16));
			setBank_Account(result.getString(17));
			setEmail(result.getString(18));
			setWebsite(result.getString(19));
			setPricing_Mode(result.getInt(20));
			setLimitation_Credit(result.getDouble(21));
			setInitial_Credit(result.getDouble(22));
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
	 * String : Family
	 */
	public String getFamily()
	{
		return Family;
	}
	public void setFamily(String family)
	{
		this.Family=family;
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
	public boolean setEmail(String email)
	{
		try {
			Pattern pattern = Pattern.compile("^.+@.+\\..+$");//Email validation
			Matcher matcher1 = pattern.matcher(email);// passage de parametre
			if(matcher1.find() ||email.equals("") ){
			this.Email=email;
			return true;
			}
			else
			{
				JOptionPane.showMessageDialog(new JFrame(), "Adresse e-mail incorrecte \t\t \n E-Mail format:   xxxxxx@yyyy.zzz", "ERREUR d'inscription",
				        JOptionPane.ERROR_MESSAGE);
				return false;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
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
	public void setWebsite(String website)
	{
		this.Website=website;
	}
	/**
	 * @return
	 *integer : pricing_mode
	 */
	public int getPricing_Mode()
	{
		return Pricing_Mode;
	}
	public void setPricing_Mode(int pricing_mode)
	{
		this.Pricing_Mode=pricing_mode;
	}
	/**
	 * @return
	 *double : LimitationCredit
	 */
	public double getLimitation_Credit()
	{
		return Limitation_Credit;
	}
	public void setLimitation_Credit(double limitation_credit)
	{
		this.Limitation_Credit=limitation_credit;
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
	public static boolean exist(String name ,String First_name)
	{
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
			prepareStatement("select * from client where Name=? AND First_name =? ");
			prepared.setString(1, name);
			prepared.setString(2, First_name);
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
		String selectSQL="insert into client(Name,First_name,Address,Family,Postal_Code,Wilaya,City,Mobile_Number,Telphone"+
			"Fax,NRC,NART,NIF,NIS,RIB,Bank_Account,Email,Website,Pricing_Mode,"+
			"Limitation_Credit,Initial_Credit)Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().prepareStatement(selectSQL,Statement.RETURN_GENERATED_KEYS);
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
			System.out.println("hello world");
			if(prepared.executeUpdate()>0)
			{	
				ResultSet result = prepared.getGeneratedKeys();
				result.next();
				this.setId(result.getInt(1));				
			}
			else{
				System.out.println("noussaiba Bawala");
			}
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
			prepared.setInt   (22, getId());
			prepared.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
