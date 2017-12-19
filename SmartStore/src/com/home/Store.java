package com.home;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Store {
	
	private int id;				// 1
	private String name;		// 2
	private String address;		// 3
	private String zip;			// 4
	private int wilaya;			 
	private int city;			// 5
	private String mobile;		// 6
	private String phone;		// 7
	private String fax;			// 8
	
	public Store() {
		
		setName("");
		setAddress("");
		setZip("");
		setWilaya(0);
		setCity(0);
		setMobile("");
		setPhone("");
		setFax("");
	}
	
	public Store(int id) {
		try {
			
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("SELECT * FROM stores WHERE id=?");
			prepared.setInt(1, id);
			ResultSet result = prepared.executeQuery();
			
			if (result.next()) {
				setId(result.getInt(1));
				setName(result.getString(2));
				setAddress(result.getString(3));
				setZip(result.getString(4));
				
				String city_code = result.getString(5);
				setWilaya(Integer.parseInt(city_code.substring(0, 2)));
				setCity(Integer.parseInt(city_code.substring(2, 4)));
				
				setMobile(result.getString(6));
				setPhone(result.getString(7));
				setFax(result.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public int getWilaya() {
		return wilaya;
	}
	public void setWilaya(int wilaya) {
		this.wilaya = wilaya;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public boolean add()
	{
		boolean b = false;
		String selectSQL="INSERT INTO stores(name,address,zip,city,mobile,"
				+ "phone,fax) VALUES (?,?,?,?,?,?,?);";
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement(selectSQL,Statement.RETURN_GENERATED_KEYS);
			prepared.setString(1 , getName());
			prepared.setString(2 , getAddress());
			prepared.setString(3 , getZip());
			
			prepared.setString   (4 , String.format("%02d%02d", getWilaya(), getCity()));
			
			prepared.setString(5 , getMobile());
			prepared.setString(6 , getPhone());
			prepared.setString(7, getFax());
			
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
	
	public void delete(){
		
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
			prepareStatement("DELETE FROM stores WHERE id=?");
			prepared.setInt(1, getId());
			prepared.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean update()
	{
		boolean b = false;
		
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					        prepareStatement("UPDATE stores SET name=?,address=?,zip=?,city=?,"
					        		+ "mobile=?,phone=?,fax=? WHERE id=?;");
			
			prepared.setString(1 , getName());
			prepared.setString(2 , getAddress());
			prepared.setString(3 , getZip());
			
			prepared.setString   (4 , String.format("%02d%02d", getWilaya(), getCity()));
			
			prepared.setString(5 , getMobile());
			prepared.setString(6 , getPhone());
			prepared.setString(7, getFax());
			prepared.setInt   (8, getId());
			
			if (prepared.executeUpdate()>0)
				b = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
}
