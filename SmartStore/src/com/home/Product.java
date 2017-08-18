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
	private double selling1;
	private double selling2;
	private double selling3;
	private int amount;
	private int used;
	private int min;
	private Date expiration;
	private String mesure_unit;
	
	public Product () {
		
		setDesignation("");
		setFamily("");
		setBarcode("");
		setCost(0);
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
				setSelling1(result.getDouble(6));
				setSelling2(result.getDouble(7));
				setSelling3(result.getDouble(8));
				setAmount(result.getInt(9));
				setUsed(result.getInt(10));
				setMin(result.getInt(11));
				setExpiration(result.getDate(12));
				setMesure_unit(result.getString(13));
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
	
	public void add() {
				
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("INSERT INTO products(designation, family, barcode, cost, "
							+ "selling1, selling2, selling3, amount, used, min, expiration, mesure_unit) "
							+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			prepared.setString(1, getDesignation());
			prepared.setString(2, getFamily());
			prepared.setString(3, getBarcode());
			prepared.setDouble(4, getCost());
			prepared.setDouble(5, getSelling1());
			prepared.setDouble(6, getSelling2());
			prepared.setDouble(7, getSelling3());
			prepared.setInt(8, getAmount());
			prepared.setInt(9, getUsed());
			prepared.setInt(10, getMin());
			prepared.setDate(11, getExpiration());
			prepared.setString(12, getMesure_unit());
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
					prepareStatement("UPDATE products SET designation=?, family=?, barcode=?, cost=?, "
							+ "selling1=?, selling2=?, selling3=?, amount=?, used=?, min=?, expiration=?"
							+ ", mesure_unit=? WHERE id=?");
			prepared.setString(1, getDesignation());
			prepared.setString(2, getFamily());
			prepared.setString(3, getBarcode());
			prepared.setDouble(4, getCost());
			prepared.setDouble(5, getSelling1());
			prepared.setDouble(6, getSelling2());
			prepared.setDouble(7, getSelling3());
			prepared.setInt(8, getAmount());
			prepared.setInt(9, getUsed());
			prepared.setInt(10, getMin());
			prepared.setDate(11, getExpiration());
			prepared.setString(12, getMesure_unit());
			prepared.setInt(13, getId());
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
