package com.home;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Product {
	
	private int id;
	private String designation;
	private String family;
	private String barcode;
	private double cost;
	private Date store_date;
	private double selling1;
	private double selling2;
	private double selling3;
	private int amount;
	private int used;
	private int min;
	private Date expiration;
	private String mesure_unit;
	private String path_image;

	public Product () {
		
		setDesignation("");
		setFamily("");
		setBarcode("");
		setCost(0);
		setStore_date(Date.valueOf(LocalDate.now()));
		setSelling1(0);
		setSelling2(0);
		setSelling3(0);
		setAmount(0);
		setUsed(0);
		setMin(0);
		setExpiration(Date.valueOf(LocalDate.now()));
		setMesure_unit("");
	}
	
	public Product(int id) {
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("SELECT * FROM products WHERE id=?");
			prepared.setInt(1, id);
			ResultSet result = prepared.executeQuery();
			if (result.next()) {
				setId(result.getInt(1));
				setDesignation(result.getString(2));
				setFamily(result.getString(3));
				setBarcode(result.getString(4));
				setCost(result.getDouble(5));
				setStore_date(result.getDate(6));
				setSelling1(result.getDouble(7));
				setSelling2(result.getDouble(8));
				setSelling3(result.getDouble(9));
				setAmount(result.getInt(10));
				setUsed(result.getInt(11));
				setMin(result.getInt(12));
				setExpiration(result.getDate(13));
				setMesure_unit(result.getString(14));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Date getStore_date() {
		return store_date;
	}
	public void setStore_date(Date store_date) {
		this.store_date = store_date;
	}
	public double getSelling1() {
		return selling1;
	}
	public void setSelling1(double selling1) {
		this.selling1 = selling1;
	}
	public double getSelling2() {
		return selling2;
	}
	public void setSelling2(double selling2) {
		this.selling2 = selling2;
	}
	public double getSelling3() {
		return selling3;
	}
	public void setSelling3(double selling3) {
		this.selling3 = selling3;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public String getMesure_unit() {
		return mesure_unit;
	}
	public void setMesure_unit(String mesure_unit) {
		this.mesure_unit = mesure_unit;
	}
	public String getPath_image() {
		return path_image;
	}
	public void setPath_image(String path_image) {
		this.path_image = path_image;
	}
	
	public void add() {
				
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("INSERT INTO products(designation, family, barcode, cost, store_date"
							+ "selling1, selling2, selling3, amount, used, min, expiration, mesure_unit) "
							+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			prepared.setString(1, getDesignation());
			prepared.setString(2, getFamily());
			prepared.setString(3, getBarcode());
			prepared.setDouble(4, getCost());
			prepared.setDate(5, getStore_date());
			prepared.setDouble(6, getSelling1());
			prepared.setDouble(7, getSelling2());
			prepared.setDouble(8, getSelling3());
			prepared.setInt(9, getAmount());
			prepared.setInt(10, getUsed());
			prepared.setInt(11, getMin());
			prepared.setDate(12, getExpiration());
			prepared.setString(13, getMesure_unit());
			if (prepared.executeUpdate() > 0) {
				ResultSet result = prepared.getGeneratedKeys();
				result.next();
				setId(result.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update() {
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("UPDATE products SET designation=?, family=?, barcode=?, cost=?, store_date=?,"
							+ "selling1=?, selling2=?, selling3=?, amount=?, used=?, min=?, expiration=?"
							+ ", mesure_unit=? WHERE id=?");
			prepared.setString(1, getDesignation());
			prepared.setString(2, getFamily());
			prepared.setString(3, getBarcode());
			prepared.setDouble(4, getCost());
			prepared.setDate(5, getStore_date());
			prepared.setDouble(6, getSelling1());
			prepared.setDouble(7, getSelling2());
			prepared.setDouble(8, getSelling3());
			prepared.setInt(9, getAmount());
			prepared.setInt(10, getUsed());
			prepared.setInt(11, getMin());
			prepared.setDate(12, getExpiration());
			prepared.setString(13, getMesure_unit());
			prepared.setInt(14, getId());
			prepared.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete() {
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("DELETE FROM products WHERE id=?");
			prepared.setInt(1, getId());
			prepared.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
