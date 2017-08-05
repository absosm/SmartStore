package com.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;


public class DataBase {
    
	private int driver;
    private String host;
    private int port;
    private String name;
    private String username;
    private String password;
    private Connection connection;
    private Statement statement;
    
    public static final int MYSQL			= 0;
    public static final int MSSQL			= 1;
    public static final int POSTGRESQL		= 2;
    public static final int ORACLE			= 3;
    
    public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String database) {
		this.name = database;
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

	public DataBase() {
    	/**
    	 * default MySQL server
    	 */
    	this.port = 3306;
    	this.driver = DataBase.MYSQL;
    }
    
    public DataBase(int driver, int port) {
        this.driver = driver;
        this.port = port;
    }
    
    public boolean Connect() {
        
        try {
            
            String url = "";
            
            switch (driver) {
            case DataBase.MYSQL: {
            	Class.forName("com.mysql.jdbc.Driver");
            	url = String.format("jdbc:mysql://%s:%d/%s", host, port, name);
            	break;
            }
            }
            
            Properties prop = new Properties();
            
            prop.put("user", this.username);
            prop.put("password", this.password);
            prop.put("useUnicode", "yes");
            prop.put("characterEncoding", "UTF-8");
            
            connection = DriverManager.getConnection(url, prop);
            
            if (connection != null) {
                statement = connection.createStatement();
                return true;
            }else {
                return false;
            }
        }catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public ResultSet getResult(String sql) {
        try {
            return statement.executeQuery(sql);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

	public Connection getConnection() {
        return this.connection;
    }
    
    public void Disconnect() {
        try {
            connection.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
