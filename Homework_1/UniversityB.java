package Homework_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UniversityB {

	/*
	 * Instance Variables
	 */
	ArrayList<Course> courseList;

	public UniversityB() {

	}

	private void createCourseList() {
		// TODO Auto-generated method stub
		// ("/Users/LuisaHernandez/Documents/MyUniversityCourses.csv");
		File myFile = new File("/Users/Zorro/Documents/MyUniversityCourses.csv");

		// creating scanner
		Scanner input;
		try {
			input = new Scanner(myFile);
			// creating new array
			ArrayList<Course> courseList = new ArrayList<Course>();
			// this should skip first horizontal line of document
			input.nextLine();
			// reading lines
			while (input.hasNextLine()) {
				String lineData = input.nextLine();
				// splitting by commas (excel feature)
				String[] data = lineData.split(",");
				Course myCourse = new Course(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
						data[5], Integer.parseInt(data[6]), data[7]);
				// adds data to courseList
				courseList.add(myCourse);

				// this is for testing and printing out what is contained in
				// myCourse
				// myCourse.print();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void adminBlock() {
		System.out.println("You are in the admin block");
		// admin stuff goes here

		// sign in
	}
	
	

	private void studentBlock() {
		// student stuff goes here
		System.out.println("You are in the student block");

		// sign in
		
		
	}

	public static void main(String[] args) {
		// do all our stuff here
		UniversityB ub = new UniversityB();

		// create course list
		ub.createCourseList();

		// student or admin?
		Scanner in = new Scanner(System.in);
		System.out.println("Speak ye, student or admin?");
		String status = in.nextLine();

		if (status.compareTo("admin") == 0) {
			// go to admin block
			ub.adminBlock();
		} else if (status.compareTo("student") == 0) {
			// go to student block
			ub.studentBlock();
		} else {
			System.out.println("You must enter admin or student.");
		}

	}

}
