package com.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;


public class DataBase {
    
	/**
	 * déclaration les attributs class "DATABASE"
	 */
	private int driver;							// identificateur de base de donnée choisi exp: 0 = MYSQL
    private String host;						// hôte ou le serveur de base de donnée exp: "localhost"
    private int port;							// le port associe de base de donnée choisi exp: MySQL = 3306
    private String name;						// le nom de la base de donnée
    private String username;					// Utilisateur de base de donnée exp. "root"
    private String password;					// Mot de passe de base de donnée
    private Connection connection;				// la liaison que permet de faire tous les opération de base de donné
    private Statement statement;				// gérer les rquêtes
    
    /**
     * déclaration constants identification des moteur de bases des données
     */
    
    public static final int MYSQL			= 0;
    public static final int MSSQL			= 1;
    public static final int POSTGRESQL		= 2;
    public static final int ORACLE			= 3;
    
    /**
     * déclaration des méthode get-set associe des attribut
     */
    
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
	
	/**
	 * constructeur de class "DATABASE"
	 */
	public DataBase() {
    	/**
    	 * default MySQL server
    	 */
    	this.port = 3306;				// port par défault de MySQL server
    	this.driver = DataBase.MYSQL;	// identifier le moteur
    }
    
    public DataBase(int driver, int port) {
        this.driver = driver;
        this.port = port;
    }
    
    /**
     * Connexion au base de donnée return true si le réussi false si non
     * @return
     */
    public boolean Connect() {
        
        try {
            
            String url = "";
            
            /**
             * importer les class jdbc selon l'identification de chque base de donnée
             */
            switch (driver) {
            case DataBase.MYSQL: {
            	Class.forName("com.mysql.jdbc.Driver");
            	url = String.format("jdbc:mysql://%s:%d/%s", host, port, name);
            	break;
            }
            }
            
            /**
             * affecter les renseignement de connexion dedans un class "PROPERTIES"
             */
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
    
    /**
     * retourn le resultat selon le requête qui vous avez saisie dans paramètre sql
     * @param sql
     * @return
     */
    public ResultSet getResult(String sql) {
        try {
            return statement.executeQuery(sql);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    /**
     * retourn la laiason
     * @return
     */
	public Connection getConnection() {
        return this.connection;
    }
	
	/**
	 * déconnexion la laiason    
	 */
    public void Disconnect() {
        try {
            connection.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
