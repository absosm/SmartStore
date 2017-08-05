package com.home;

public class Session {

	private static DataBase database;
	private static MainForm mainForm;
	private static ProfileForm profileForm;
	
	public static ProfileForm getProfileForm() {
		return profileForm;
	}

	public static void setProfileForm(ProfileForm profileForm) {
		Session.profileForm = profileForm;
	}
	
	public static void showProfileForm() {
		profileForm.setVisible(true);
	}

	private static User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Session.user = user;
	}

	public static MainForm getMainForm() {
		return mainForm;
	}
	
	public static void showMainForm() {
		mainForm.setVisible(true);
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
