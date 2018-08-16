package com.home;

import java.io.StringReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class Product {
	
	private int id;							// 1
	private String barcode;					// 2
	private String name;					// 3
	private String family;					// 4
	private String unit;					// 5
	private int count;						// 6
	private int used;						// 7
	private int min;						// 8
	private double cost;					// 9
	private Map<Integer, Selling> selling;	// 10
	private double selling_limit;			// 11
	private double tva;						// 12
	private java.util.Date store_date;		// 13
	private boolean expire;					// 14
	private java.util.Date expiration;		// 15
	private int dely_exp;					// 16
	private boolean packing;				// 17
	private int packing_amount;				// 18
	private String location;				// 19
	private String shelf;					// 20
	private String path_image;				// 21
	
	
	public Product () {
		
		setBarcode("");
		setName("");
		setFamily("");
		setUnit("");
		setCount(0);
		setUsed(0);
		setMin(0);
		setCost(0);
		selling = new HashMap<Integer, Selling>();
		setSelling_limit(0);
		setTva(0);
		setStore_date(new Date());
		setExpirate(false);
		setExpiration(new Date());
		setDely_exp(0);
		setPacking(false);
		setPackingAmount(0);
		setLocation("");
		setShelf("");
		setPath_image("");
	}

	public Product(int id) {
		
		selling = new HashMap<Integer, Selling>();

		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("SELECT * FROM products WHERE id=?");
			prepared.setInt(1, id);
			ResultSet result = prepared.executeQuery();
			if (result.next()) {
				setBarcode(result.getString(2));
				setName(result.getString(3));
				setFamily(result.getString(4));
				setUnit(result.getString(5));
				setCount(result.getInt(6));
				setUsed(result.getInt(7));
				setMin(result.getInt(8));
				setCost(result.getDouble(9));
				String json_selling = result.getString(10);
				JsonReader reader = Json.createReader(new StringReader(json_selling));
				JsonObject obj = reader.readObject();
				for (Entry<String, JsonValue> entry: obj.entrySet()) {
					Selling s = new Selling(this);
					s.setCategory(entry.getKey());
					s.setPrice(Double.parseDouble(entry.getValue().toString()));
					setSelling(s.getId(), s);
				}
				setSelling_limit(result.getDouble(11));
				setTva(result.getDouble(12));
				setStore_date(result.getDate(13));
				setExpirate(result.getBoolean(14));
				setExpiration(result.getDate(15));
				setDely_exp(result.getInt(16));
				setPacking(result.getBoolean(17));
				setPackingAmount(result.getInt(18));
				setLocation(result.getString(19));
				setShelf(result.getString(20));
				setPath_image(result.getString(21));
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
	public String getName() {
		return name;
	}
	public void setName(String designation) {
		this.name = designation;
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
	public java.util.Date getStore_date() {
		return store_date;
	}
	public void setStore_date(java.util.Date store_date) {
		this.store_date = store_date;
	}
	public Selling getSelling(String selling_key) {
		return selling.get(selling_key);
	}
	public void setSelling(int id, Selling s) {
		this.selling.put(id, s);
	}
	public void deleteSelling(int id) {
		this.selling.remove(id);
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public boolean isExpire() {
		return expire;
	}
	public void setExpirate(boolean expire) {
		this.expire = expire;
	}
	public java.util.Date getExpiration() {
		return expiration;
	}
	public void setExpiration(java.util.Date expiration) {
		this.expiration = expiration;
	}
	public int getDely_exp() {
		return dely_exp;
	}
	public void setDely_exp(int dely_exp) {
		this.dely_exp = dely_exp;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
	public boolean isPacking() {
		return packing;
	}
	public void setPacking(boolean packing) {
		this.packing = packing;
	}
	public int getPackingAmount() {
		return packing_amount;
	}
	public void setPackingAmount(int packing_amount) {
		this.packing_amount = packing_amount;
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
		return (count-used);
	}
	
	public boolean add() {
		
		boolean b = false;
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("INSERT INTO products(barcode, name, family, unit, count, "
							+ "used, min, cost, selling, selling_limit, tva, store_date, "
							+ "expire, expiration, delay_exp, packing, packing_amount, location, shelf, path_image) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
							Statement.RETURN_GENERATED_KEYS);
			prepared.setString(1, getBarcode());
			prepared.setString(2, getName());
			prepared.setString(3, getFamily());
			prepared.setString(4, getUnit());
			prepared.setInt(5, getCount());
			prepared.setInt(6, getUsed());
			prepared.setInt(7, getMin());
			prepared.setDouble(8, getCost());
			JsonObjectBuilder sellingObject = Json.createObjectBuilder();
			for (Entry<Integer, Selling> entry: selling.entrySet()) {
				Selling s = entry.getValue();
				sellingObject.add(s.getCategory(), s.getPrice());
			}
			JsonObject obj = sellingObject.build();
			prepared.setString(9, obj.toString());
			prepared.setDouble(10, getSelling_limit());
			prepared.setDouble(11, getTva());
			prepared.setDate(12, new java.sql.Date(getStore_date().getTime()));
			prepared.setBoolean(13, isExpire());
			prepared.setDate(14, new java.sql.Date(getExpiration().getTime()));
			prepared.setInt(15, getDely_exp());
			prepared.setBoolean(16, isPacking());
			prepared.setInt(17, getPackingAmount());
			prepared.setString(18, getLocation());
			prepared.setString(19, getShelf());
			prepared.setString(20, getPath_image());
			
			if (prepared.executeUpdate() > 0) {
				ResultSet result = prepared.getGeneratedKeys();
				result.next();
				setId(result.getInt(1));
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}

	public void update() {
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("UPDATE products SET barcode=?, name=?, family=?, unit=?, "
							+ "count=?, used=?, min=?, cost=?, selling=?, selling_limit=?,"
							+ "tva=?, store_date=?, expire=?, expiration=?, delay_exp=?, packing=?, packing_amount=?, "
							+ "location=?, shelf=?, path_image=? WHERE id=?");
			prepared.setString(1, getBarcode());
			prepared.setString(2, getName());
			prepared.setString(3, getFamily());
			prepared.setString(4, getUnit());
			prepared.setInt(5, getCount());
			prepared.setInt(6, getUsed());
			prepared.setInt(7, getMin());
			prepared.setDouble(8, getCost());
			JsonObjectBuilder sellingObject = Json.createObjectBuilder();
			for (Entry<Integer, Selling> entry: selling.entrySet()) {
				Selling s = entry.getValue();
				sellingObject.add(s.getCategory(), s.getPrice());
			}
			JsonObject obj = sellingObject.build();
			prepared.setString(9, obj.toString());
			prepared.setDouble(10, getSelling_limit());
			prepared.setDouble(11, getTva());
			prepared.setDate(12, new java.sql.Date(getStore_date().getTime()));
			prepared.setBoolean(13, isExpire());
			prepared.setDate(14, new java.sql.Date(getExpiration().getTime()));
			prepared.setInt(15, getDely_exp());
			prepared.setBoolean(16, isPacking());
			prepared.setInt(17, getPackingAmount());
			prepared.setString(18, getLocation());
			prepared.setString(19, getShelf());
			prepared.setString(20, getPath_image());
			prepared.setInt(21, getId());
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
