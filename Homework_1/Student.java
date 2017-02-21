package Homework_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {

	private String firstName;
	private String lastName;

	public Student(String username, String password, String firstName, String lastName) {
		super(username, password);
		this.firstName = firstName;
		this.lastName = lastName;
	}

}