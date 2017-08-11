package com.home;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Famille {
	
	private int id;
	private String designation;
	private String note;
	private int count;
	
	public Famille() {
		
		setDesignation("(vide)");
		setNote("(vide)");
		setCount(0);
		
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("INSERT INTO families(designation, note, count) VALUES (?,?,?)", 
							Statement.RETURN_GENERATED_KEYS);
			prepared.setString(1, getDesignation());
			prepared.setString(2, getNote());
			prepared.setInt(3, getCount());
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
	
	public Famille(int id) {
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("SELECT * FROM families WHERE id=?");
			prepared.setInt(1, id);
			ResultSet result = prepared.executeQuery();
			if (result.next()) {
				setId(result.getInt("id"));
				setDesignation(result.getString("designation"));
				setNote(result.getString("note"));
				setCount(result.getInt("count"));
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void add() {
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("INSERT INTO families(designation, note, count) "
							+ "VALUES(?, ?, ?)");
			prepared.setString(1, getDesignation());
			prepared.setString(2, getNote());
			prepared.setInt(3, getCount());
			prepared.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean update() {
		boolean b = false;
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("UPDATE families SET designation=?, note=?, count=? WHERE id=?");
			prepared.setString(1, getDesignation());
			prepared.setString(2, getNote());
			prepared.setInt(3, getCount());
			prepared.setInt(4, getId());
			if (prepared.executeUpdate()>0)
				b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	public void delete() {

		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("DELETE FROM families WHERE id=?");
			prepared.setInt(1, getId());
			prepared.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Famille get(int id) {
		
		Famille famille = new Famille();
		try {
			PreparedStatement prepared = Session.getDatabase().getConnection().
					prepareStatement("SELECT * FROM families WHERE id=?");
			prepared.setInt(1, id);
			ResultSet result = prepared.executeQuery();
			if (result.next()) {
				famille.setId(result.getInt("id"));
				famille.setDesignation(result.getString("designation"));
				famille.setNote(result.getString("note"));
				famille.setCount(result.getInt("count"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			famille = null;
			e.printStackTrace();
		}
		
		return famille;
	}
}
