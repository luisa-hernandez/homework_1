package Homework_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements Serializable{

	private String firstName;
	private String lastName;

	public Student(String username, String password, String firstName, String lastName) {
		super(username, password);
		this.firstName = firstName;
		this.lastName = lastName;
	}

}