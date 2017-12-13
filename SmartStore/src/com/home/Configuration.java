package com.home;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Configuration {
	
	private static SAXBuilder saxBuilder;
	private static Document document;
	private static Element root;
	private static Element config_db;
	private static Element config_auth;
	
	public static class database {
		
		public static int driver;
		public static String host;
		public static String name;
		public static String username;
		public static String password;
	}
	
	public static class authentification {
		
		public static String username;
		public static String password;
		public static boolean remember;
	}
	
	public static void initialize() {
		
		saxBuilder = new SAXBuilder();
		config_db=null; config_auth=null;
		
        try {
        	document = saxBuilder.build(new File("./config/main.xml"));
			root = document.getRootElement();
	        config_db = root.getChild("database").clone();
	        config_auth = root.getChild("authentification").clone();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Load() {
		
		database.driver = Integer.parseInt(config_db.getChild("driver").getText());
		database.host = config_db.getChild("host").getText();
		database.name = config_db.getChild("name").getText();
		database.username = config_db.getChild("username").getText();
		database.password = new String(Base64.getDecoder().decode(
				config_db.getChild("password").getText().getBytes()));
		
		authentification.remember = Boolean.parseBoolean(config_auth.getChild("remember").getText());
		
		if (authentification.remember) {
			authentification.username = config_auth.getChild("username").getText();
			authentification.password = new String(Base64.getDecoder().decode(
				config_auth.getChild("password").getText().getBytes()));
		}
	}
	
	public static void save() {
		
		config_db = new Element("database");
		Element element = new Element("driver");
		element.addContent(database.driver+"");
		config_db.addContent(element);
		element = new Element("host");
		element.addContent(database.host);
		config_db.addContent(element);
		element = new Element("name");
		element.addContent(database.name);
		config_db.addContent(element);
		element = new Element("username");
		element.addContent(database.username);
		config_db.addContent(element);
		element = new Element("password");
		element.addContent(database.password);
		config_db.addContent(element);
		
		config_auth = new Element("authentification");
		element = new Element("username");
		element.addContent(authentification.username);
		config_auth.addContent(element);
		element = new Element("password");
		element.addContent(authentification.password);
		config_auth.addContent(element);
		element = new Element("remember");
		element.addContent(authentification.remember+"");
		config_auth.addContent(element);
		
		root = new Element("root");
		root.addContent(config_db);
		root.addContent(config_auth);
		
		Document doc_write = new Document(root);
        try {
        	XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        	sortie.output(doc_write, new FileOutputStream("./config/main.xml"));
        }
        catch (Exception e){
        	e.printStackTrace();
        }
	}
}
