package com.home;

import java.util.List;

import javax.swing.JFrame;

import com.home.formes.MainForm;

public class Session {
	
	/**
	 * déclaration les variables globales du session
	 */
	private static DataBase database;
	private static User user;
	private static boolean register = false;
	/**
	 * déclaration les attributes formes de l'application
	 */
	private static JFrame[] Form = new JFrame[11];
	/**
	 * declaration des constants identificateurs relatifs des forms
	 */
	public static final int AUTHENTIFICATION		= 0;
	public static final int MAIN					= 1;
	public static final int CONFIGURATION			= 2;
	public static final int PROFILE					= 3;
	public static final int FAMILIES				= 4;
	public static final int PRODUCTS				= 5;
	public static final int ADDPRODUCT				= 6;
	public static final int CLIENTS					= 7;
	public static final int PROVIDERS				= 8;
	
	public static final int ADDCLIENT				= 9;
	
	public static final int UPDATECLIENT			= 10;
	
	public static void start() {
		
		user.login();
		register = true;
		if (!isSetForm(MAIN))
			setForm(MAIN, new MainForm());
		showForm(MAIN);
	}
	
	public static boolean isRegister() {
		return register;
	}

	public static void Disconnect() {
		
		/**
		 * tuer les variables globales et fermer tous les forms 	
		 */
		if (database != null) database.Disconnect();
		database = null;
		user = null;
		
		for (int i=1; i<Form.length; i++) {
			
			if (Form[i] != null) {
				Form[i].dispose();
				Form[i] = null;
			}
		}
		
		Form[AUTHENTIFICATION].setVisible(true);
		register = false;
	}
	
	public static JFrame getForm(int id) {
		return Form[id];
	}

	public static void setForm(int id, JFrame form) 
	{
		Form[id] = form;
		Form[id].setLocationRelativeTo(null);
	}
	
	public static boolean isSetForm(int id) {
		boolean b = false;
		if (Form[id] != null) 
			b = true;
		return b;
	}
	
	public static void showForm(int id) {
		
		if (Form[id] != null)
			Form[id].setVisible(true);
	}
	
	public static void removeForm(int id) {
		Form[id] = null;
	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		
		if (user != null)
			Session.user = user;
	}

	public static DataBase getDatabase() {
		return database;
	}

	public static void setDatabase(DataBase database) {
		Session.database = database;
	} 
}
