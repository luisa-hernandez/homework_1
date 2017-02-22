package Homework_1;

import java.io.Serializable;

public class Student extends User implements Serializable {

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Student() {

	}

	public Student(String password, String firstName, String lastName) {
		super(new String(firstName + lastName), password);
		this.firstName = firstName;
		this.lastName = lastName;
	}

}