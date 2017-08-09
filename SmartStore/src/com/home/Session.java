package com.home;

import javax.swing.JFrame;

public class Session {
	
	/**
	 * déclaration les variables globales du session
	 */
	private static DataBase database;	
	private static User user;
	/**
	 * déclaration les attributes formes de l'application
	 */
	private static MainForm mainForm;
	private static ProfileForm profileForm;
	private static JFrame authentificationForm;
	
	public static void start() {
		mainForm = new MainForm();
		mainForm.setVisible(true);
		user.login();
	}

	public static void Disconnect() {
		
		/**
		 * tuer les variables globales et fermer tous les forms 	
		 */
		if (database != null) database.Disconnect();
		database = null;
		user = null;
		
		if (profileForm != null) profileForm.dispose();
		profileForm = null;
		if (mainForm != null) mainForm.dispose();
		mainForm = null;
		
		authentificationForm.setVisible(true);
	}
	
	public static JFrame getAuthentificationForm() {
		return authentificationForm;
	}

	public static void setAuthentificationForm(JFrame authentification) {
		
		if (Session.authentificationForm == null)
			Session.authentificationForm = authentification;
	}
	
	public static ProfileForm getProfileForm() {
		return profileForm;
	}

	public static void setProfileForm(ProfileForm profileForm) {
		
		if (Session.profileForm == null)
			Session.profileForm = profileForm;
	}
	
	public static void showProfileForm() {
		
		if (profileForm != null)
			profileForm.setVisible(true);
	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		
		if (user != null)
			Session.user = user;
	}

	public static MainForm getMainForm() {
		return mainForm;
	}

	public static void setMainForm(MainForm mainForm) {
		Session.mainForm = mainForm;
	}

	public static DataBase getDatabase() {
		return database;
	}

	public static void setDatabase(DataBase database) {
		Session.database = database;
	} 
}
