package Homework_1;

import java.util.Scanner;

public class User {

	private String username;
	private String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean login(String username, String password) {

		if (this.username.compareTo(username) == 0 && this.password.compareTo(password) == 0){
			return true;
		}
		return false;
	}

}
