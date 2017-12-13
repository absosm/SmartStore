package com.home;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String telephone;
	private int privilege;
	private Date last_login;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getPrivilege() {
		return privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public User() {
		
	}
	
	public void add() {
		
	}
	
	public boolean update() {
		
		boolean b = false;
		
		DataBase database = Session.getDatabase();
				
		try {
			PreparedStatement prepared = (PreparedStatement) database.getConnection()
				.prepareStatement("UPDATE users SET firstname=?, lastname=?, telephone=?, password=? WHERE id=?");
			prepared.setString(1, firstname);
			prepared.setString(2, lastname);
			prepared.setString(3, telephone);
			prepared.setString(4, password);
			prepared.setInt(5, id);
			if (prepared.executeUpdate() > 0) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	public void login() {
		
		DataBase database = Session.getDatabase();
				
		try {
			PreparedStatement prepared = (PreparedStatement) database.getConnection()
				.prepareStatement("UPDATE users SET last_login=NOW() WHERE id=?");
			prepared.setInt(1, id);
			prepared.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void block(boolean b) {
		
	}
	
	public static boolean exist(String username, String password) {
		
		boolean b = false;
		DataBase database = Session.getDatabase();
				
		try {
			PreparedStatement prepared = (PreparedStatement) database.getConnection()
				.prepareStatement("SELECT id FROM users WHERE username=? and password=?");
			prepared.setString(1, username);
			prepared.setString(2, password);
			ResultSet result = prepared.executeQuery();
			if (result.next()) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	public static User get(String username) {
		
		User user = null;
		
		DataBase database = Session.getDatabase();
		
		try {
			PreparedStatement prepared = (PreparedStatement) database.getConnection()
				.prepareStatement("SELECT * FROM users WHERE username=?");
			prepared.setString(1, username);
			ResultSet result = prepared.executeQuery();
			if (result.next()) {
				user = new User();
				user.setId(result.getInt("id"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setFirstname(result.getString("firstname"));
				user.setLastname(result.getString("lastname"));
				user.setTelephone(result.getString("telephone"));
				user.setPrivilege(result.getInt("privilege"));
				user.setLast_login(result.getDate("last_login"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
