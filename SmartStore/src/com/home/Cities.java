package com.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class Cities {
	
	public static Vector LoadWilaya() {
		
		Vector vector = new Vector();
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:data/cities.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT name_fr FROM cities WHERE codeseq like '%01' ORDER BY codeseq ASC;");
			int i=0;
			while(rs.next()) {
				i++;
				vector.addElement(String.format("%02d", i)+" - "+rs.getString("name_fr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vector;
	}
	
	public static Vector LoadCities(int code_wilaya) {
		
		Vector vector = new Vector();
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:data/cities.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(String.format("SELECT name_fr FROM cities WHERE "
					+ "codewilaya='%02d' ORDER BY codeseq ASC", code_wilaya));
			
			int i=0;
			while(rs.next()) {
				i++;
				vector.addElement(String.format("%02d", i)+" - "+rs.getString("name_fr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vector;
	}
	
	public static String getWilaya(int codewilaya) {
		
		String s = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:data/cities.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(String.format("SELECT name_fr FROM cities WHERE "
					+ "codewilaya='%02d' ORDER BY codeseq ASC", codewilaya));
			if(rs.next()) {
				s = rs.getString("name_fr");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static String getCity(int codewilaya, int codeCity) {
		
		String s = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:data/cities.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(String.format("SELECT name_fr FROM cities WHERE "
					+ "codeseq='%02d%02d' ORDER BY codeseq ASC", codewilaya, codeCity));
			if(rs.next()) {
				s = rs.getString("name_fr");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
