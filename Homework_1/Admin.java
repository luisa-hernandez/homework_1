package Homework_1;
import java.awt.Choice;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class Admin extends User{
	//create a constructor
	public Admin(String username, String password){	
		super(username, password);
	}
	
	//add a course method
	public void addCourse (ArrayList<Course> cl){	
		//ask user to enter new course name
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter course name: ");
		String courseName = cs.nextLine();
		
		//ask user to enter new course ID
		System.out.println("Enter course ID: ");
		String courseId = cs.nextLine();
		
		//ask user to enter new maximum number of students
		System.out.println("Enter Maximum Number of Students: ");
		int maxStudents = cs.nextInt();
		
		//ask user to enter new current number of students
		System.out.println("Enter Current Number of Students: ");
		int currentStudents = cs.nextInt();
		
		//ask user to enter new course instructor
		System.out.println("Enter course Instructor: ");
		String courseInstructor = cs.nextLine();
		
		//ask user to enter new course section
		System.out.println("Enter course Section: ");
		int courseSection = cs.nextInt();
		
		//ask user to enter new course location
		System.out.println("Enter course Location: ");
		String courseLocation = cs.nextLine();
		
		//create new objects of class Course
		Course c = new Course(courseName, courseId, maxStudents, currentStudents, courseInstructor, courseSection, courseLocation);
		
		//add these objects to the class list
		cl.add(c);
	}
	
	//delete a course method
	public void deleteCourse (ArrayList<Course> cl){
		//create scanner
		Scanner sc = new Scanner(System.in);
		//asking admin to enter course ID
		System.out.println("Enter course ID: ");
		
		//asking admin to enter course name
		System.out.println("Enter course section number: ");
		int course = sc.nextInt();
		
		String courseID = sc.nextLine();
		//loop through the array list
		for(int i=0; i<cl.size(); i++){
			//if the input matches a course name and course ID, then delete the course
			if (course == cl.get(i).Course_Section_Number && courseID == cl.get(i).Course_Id){
				cl.remove(i);
			}
		}
	}
	
	//edit a course method
	public void editCourse(ArrayList<Course> cl) {
		Scanner sc = new Scanner(System.in);
		//ask the user to enter which course they want to edit
		System.out.println("Which course do you want to edit (by course ID)?  ");
		String courseId = sc.nextLine();
		
		//asking admin to enter course name
		System.out.println("Enter course section number: ");
		int course = sc.nextInt();
		
		
		//looping through the array list
		for(int i=0; i<cl.size(); i++){
			//if the course ID user input matches an existing ID, display which course information they would like to edit
			if (courseId == cl.get(i).Course_Id && course == cl.get(i).Course_Section_Number){
				System.out.println("Which field do you want to change? ");
				System.out.println("Course Name: \n1");
				System.out.println("Course ID \n2");
				System.out.println("Maximum Students \n3");
				System.out.println("Current Students \n4");
				System.out.println("List of Names \n5");
				System.out.println("Course Instructor \n6");
				System.out.println("Course Section Number \n7");
				System.out.println("Course Location \n8");
				
				//create a new scanner
				Scanner new_sc = new Scanner(System.in);
				int choice = new_sc.nextInt();
				
				switch (choice){
					case 1: System.out.println("Enter a new course name: ");
					cl.get(i).Course_Name = sc.nextLine();
					
					case 2: System.out.println("Enter a new course ID: ");
					cl.get(i).Course_Id = sc.nextLine();
					
					case 3: System.out.println("Enter a new maximum number of students: ");
					cl.get(i).Maximum_Students = sc.nextInt();
					
					case 4: System.out.println("Enter a new current number of students: ");
					cl.get(i).Current_Students = sc.nextInt();
					
					case 5: System.out.println("Enter a new name of a student: ");
					String firstName = sc.nextLine();
//					cl.get(i).List_Of_Names.add(firstName);
					
					case 6: System.out.println("Enter a new course instructor: ");
					cl.get(i).Course_Instructor = sc.nextLine();
					
					case 7: System.out.println("Enter a new course section number: ");
					cl.get(i).Course_Section_Number = sc.nextInt();
					
					case 8: System.out.println("Enter a new course location: ");
					cl.get(i).Course_Location = sc.nextLine();
				}
			}
		}
	}
	
	public void displayCourse(ArrayList<Course> cl) {
		Scanner sc = new Scanner(System.in);
		//ask the user to enter a course ID
		System.out.println("Enter course Id: ");
		String courseId = sc.nextLine();
		//looping through the array list
		for(int i=0; i<cl.size(); i++){
			//if the course ID user input matches an existing ID, display the course information
			if (courseId == cl.get(i).Course_Id){
				System.out.println("Course Name: " + cl.get(i).Course_Name);
				System.out.println("Course ID: " + cl.get(i).Course_Id);
				System.out.println("Maximum Students: " + cl.get(i).Maximum_Students);
				System.out.println("Current Students: " + cl.get(i).Current_Students);
//				System.out.println("List of Names: " + cl.get(i).List_Of_Names);
				System.out.println("Course Instructor: " + cl.get(i).Course_Instructor);
				System.out.println("Course Section Number: " + cl.get(i).Course_Section_Number);
				System.out.println("Course Location: " + cl.get(i).Course_Location);
			}
		}
	}
	
	public void registerStudent(ArrayList<Course> cl) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the course ID: ");
		String courseId = sc.nextLine();
		
		System.out.println("Enter first name: ");
		String firstName = sc.nextLine();
		
		System.out.println("Enter last name: ");
		String lastName = sc.nextLine();
		
		for(int i=0; i<cl.size(); i++){
			if (courseId == cl.get(i).Course_Id){
//				cl.get(i).List_Of_Names.add(firstName + lastName);
				//also update the number of current students
			}	
		}
	}
	
	//view all courses method
	public void viewCourses(ArrayList<Course> cl) {
		for(int i=0; i<cl.size(); i++){
			System.out.println("The course name is: " + cl.get(i).Course_Name);
			System.out.println("The course ID is: " + cl.get(i).Course_Id);
			System.out.println("The number of students in the course is:  " + cl.get(i).Current_Students);
			System.out.println("The maximum number of students that can be enrolled in this class is: " + cl.get(i).Maximum_Students);
			}
		}
	
	//view all courses that are full method
	public void viewFullCourses(ArrayList<Course> cl) {
		//looping through the array list
		for(int i=0; i<cl.size(); i++){
			//if the number of existing students matches max students, the course is full
			if(cl.get(i).Current_Students == cl.get(i).Maximum_Students){
				System.out.println("The course " + cl.get(i).Course_Name + " is full.");
			}
		}
	}
	
	public void writeCourses(ArrayList<Course> cl) {
		BufferedWriter myFile;
		try {
			//write to a new file with the same path
			myFile = new BufferedWriter(new FileWriter("/Users/LuisaHernandez/Documents/FullMyUniversityCourses/cvs"));
			//looping through the array list
			for(int i=0; i<cl.size(); i++){
				//if the number of existing students matches max students, the course is full & then write to new file
				if(cl.get(i).Current_Students == cl.get(i).Maximum_Students){
					myFile.write(cl.get(i).Course_Name + cl.get(i).Course_Id);
				}
			}	
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public void registeredStudents(ArrayList<Course> cl) {	
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the course ID: ");
		String courseId = sc.nextLine();
		//looping through the array list
		for(int i=0; i<cl.size(); i++){
			if (courseId == cl.get(i).Course_Id) {
//				for(int j=0; i< cl.get(i).List_Of_Names.size(); j++){
//					System.out.println(cl.get(i).List_Of_Names.get(j));
//				}
			}
		}
	}
	
//	public void studentCourses(ArrayList<Course> cl) {
//		Scanner sc= new Scanner(System.in);
//		//ask the user to enter a student's first name
//		System.out.println("Enter student's first name: ");
//		String firstName = sc.nextLine();
//		
//		Scanner s_c= new Scanner(System.in);
//		//ask the user to enter a student's last name
//		System.out.println("Enter student's last name: ");
//		String lastName = s_c.nextLine();
//	
//		//looping through the array list
//		System.out.println("The following are courses that a student is in: ");
//			for(int i=0; i<cl.size(); i++){
//				for(int j=0; i<cl.get(i).List_Of_Names.size(); j++){
//					//if the first name and last name match up, display the course information
//					if (firstName == cl.get(i).firstName && lastName ==cl.get(i).lastName){
//						System.out.println(cl.get(i).Course_Name);
//					}
//				}
//			}
//		}
	
//	public void sortCourses(ArrayList<Course> courseList){
//		Collections.sort(courseList);
//	}
	
	public void reports(ArrayList<Course> courseList) {
		char choice = 'a';
		while(choice != 'q'){
			System.out.println("View all courses:\tv ");
			System.out.println("View all FULL courses:\tf ");
			System.out.println("Write to a file of full courses:\tw ");
			System.out.println("View names of students being registered:\ts ");
			System.out.println("View courses that student is registered in:\tc ");
			System.out.println("View sorted courses:\ta ");
			Scanner sc = new Scanner(System.in);
			choice = sc.next().charAt(0);
			switch (choice){
//				case 'a': sortCourses(courseList);
//					break;
//				case 'c': studentCourses(courseList);
//					break;
				case 'f': viewFullCourses(courseList);
					break;
				case 's': registeredStudents(courseList);
					break;
				case 'v': viewCourses(courseList);
					break;
				case 'w': writeCourses(courseList);
					break;
			}
		}
	}
	


}
