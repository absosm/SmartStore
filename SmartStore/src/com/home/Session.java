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
	private static JFrame[] Form = new JFrame[10];
	/**
	 * declaration des constants identificateurs relatifs des forms
	 */
	public static final int AUTHENTIFICATION		= 0;
	public static final int MAIN					= 1;
	public static final int PROFILE					= 2;
	public static final int FAMILLE					= 3;
	
	public static void start() {
		
		user.login();
		register = true;
		Form[MAIN] = new MainForm();
		Form[MAIN].setVisible(true);
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
		
		for (int i=1; i<4; i++) {
			
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

	public static void setForm(int id, JFrame form) {
		
		if (Form[id] == null)
			Form[id] = form;
	}
	
	public static void showForm(int id) {
		
		if (Form[id] != null)
			Form[id].setVisible(true);
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
