package com.home;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Product {
	
	private int id;
	private String barcode;
	private String designation;
	private String family;
	private String mesure_unit;
	private int amount;
	private int used;
	private int min;
	private double cost;
	private double selling1;
	private double selling2;
	private double selling3;
	private double selling_limit;
	private double tva;
	private Date store_date;
	private Date expiration;
	private int packing;
	private String location;
	private String shelf;
	private String path_image;
	
	
	public Product () {
		
		setBarcode("");
		setDesignation("");
		setFamily("");
		setMesure_unit("");
		setAmount(0);
		setUsed(0);
		setMin(0);
		setCost(0);
		setSelling1(0);
		setSelling2(0);
		setSelling3(0);
		setSelling_limit(0);
		setTva(0);
		setStore_date(Date.valueOf(LocalDate.now()));
		setExpiration(Date.valueOf(LocalDate.now()));
		setPacking(0);
		setLocation("");
		setShelf("");
		setPath_image("");
	}

	public Product(int id) {
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("SELECT * FROM products WHERE id=?");
			prepared.setInt(1, id);
			ResultSet result = prepared.executeQuery();
			if (result.next()) {
				setBarcode(result.getString(1));
				setDesignation(result.getString(2));
				setFamily(result.getString(3));
				setMesure_unit(result.getString(4));
				setAmount(result.getInt(5));
				setUsed(result.getInt(6));
				setMin(result.getInt(7));
				setCost(result.getDouble(8));
				setSelling1(result.getDouble(9));
				setSelling2(result.getDouble(10));
				setSelling3(result.getDouble(11));
				setSelling_limit(result.getDouble(12));
				setTva(result.getDouble(13));
				setStore_date(result.getDate(14));
				setExpiration(result.getDate(15));
				setPacking(result.getInt(16));
				setLocation(result.getString(17));
				setShelf(result.getString(18));
				setPath_image(result.getString(19));
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
	public double getSelling_limit() {
		return selling_limit;
	}
	public void setSelling_limit(double selling_limit) {
		this.selling_limit = selling_limit;
	}
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
	}
	public int getPacking() {
		return packing;
	}
	public void setPacking(int packing) {
		this.packing = packing;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public int getActual() {
		return (amount-used);
	}
	
	public void add() {
				
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("INSERT INTO products(barcode, designation, family, mesure_unit, amount, "
							+ "used, min, cost, selling1, selling2, selling3, selling_limit, tva, store_date, "
							+ "expiration, packing, location, shelf, path_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, "
							+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			prepared.setString(1, getBarcode());
			prepared.setString(2, getDesignation());
			prepared.setString(3, getFamily());
			prepared.setString(4, getMesure_unit());
			prepared.setInt(5, getAmount());
			prepared.setInt(6, getUsed());
			prepared.setInt(7, getMin());
			prepared.setDouble(8, getCost());
			prepared.setDouble(9, getSelling1());
			prepared.setDouble(10, getSelling2());
			prepared.setDouble(11, getSelling3());
			prepared.setDouble(12, getSelling_limit());
			prepared.setDouble(13, getTva());
			prepared.setDate(14, getStore_date());
			prepared.setDate(15, getExpiration());
			prepared.setInt(16, getPacking());
			prepared.setString(17, getLocation());
			prepared.setString(18, getShelf());
			prepared.setString(19, getPath_image());
			
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
					prepareStatement("UPDATE products SET barcode=?, designation=?, family=?, mesure_unit=?, "
							+ "amount=?, used=?, min=?, cost=?, selling1=?, selling2=?, selling3=?, selling_limit=?,"
							+ "tva=?, store_date=?, expiration=?, packing=?, location=?, shelf=?, path_image=?"
							+ " WHERE id=?");
			prepared.setString(1, getBarcode());
			prepared.setString(2, getDesignation());
			prepared.setString(3, getFamily());
			prepared.setString(4, getMesure_unit());
			prepared.setInt(5, getAmount());
			prepared.setInt(6, getUsed());
			prepared.setInt(7, getMin());
			prepared.setDouble(8, getCost());
			prepared.setDouble(9, getSelling1());
			prepared.setDouble(10, getSelling2());
			prepared.setDouble(11, getSelling3());
			prepared.setDouble(12, getSelling_limit());
			prepared.setDouble(13, getTva());
			prepared.setDate(14, getStore_date());
			prepared.setDate(15, getExpiration());
			prepared.setInt(16, getPacking());
			prepared.setString(17, getLocation());
			prepared.setString(18, getShelf());
			prepared.setString(19, getPath_image());
			prepared.setInt(20, getId());
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
