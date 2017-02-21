package Homework_1;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentB extends UserB{
	//create a constructor
	public StudentB(){	
	}
	
	public void enrolledCourse (ArrayList<Course> cl){
		
	}
	
	public void nonfullCourse (ArrayList<Course> cl){
		//looping through the array list
		for(int i=0; i<cl.size(); i++){
			//if the number of existing students is less than max students, the course is not full
			if(cl.get(i).Current_Students < cl.get(i).Maximum_Students){
				System.out.println("The course " + cl.get(i).Course_Name + " is not full.");
			}
		}
	}
	
	public void registerCourse (ArrayList<Course> cl){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the course ID: ");
		String courseId = sc.nextLine();
		
		System.out.println("Enter the course section number: ");
		int courseNumber = sc.nextInt();
		
		System.out.println("Enter first name: ");
		String firstName = sc.nextLine();
		
		System.out.println("Enter last name: ");
		String lastName = sc.nextLine();
		
		for(int i=0; i<cl.size(); i++){
			if (courseId == cl.get(i).Course_Id && courseNumber == cl.get(i).Course_Section_Number){
				cl.get(i).List_Of_Names.add(firstName + lastName);
				//also update the number of current students
			}	
		}
	}
	
	public void viewCourse (ArrayList<Course> cl){
		for(int i=0; i<cl.size(); i++){
			System.out.println("The course name is: " + cl.get(i).Course_Name);
			System.out.println("The course ID is: " + cl.get(i).Course_Id);
			System.out.println("The number of students in the course is:  " + cl.get(i).Current_Students);
			System.out.println("The maximum number of students that can be enrolled in this class is: " + cl.get(i).Maximum_Students);
			}
		}
	
	public void withdrawCourse (ArrayList<Course> cl){		//create scanner
		Scanner sc = new Scanner(System.in);
		//asking admin to enter course ID
		System.out.println("Enter course ID: ");
		
		//asking admin to enter course name
		System.out.println("Enter course section number: ");
		int course = sc.nextInt();
		
		System.out.println("Enter first name: ");
		String firstName = sc.nextLine();
		
		System.out.println("Enter last name: ");
		String lastName = sc.nextLine();
		
		
		String courseID = sc.nextLine();
		//loop through the array list
		for(int i=0; i<cl.size(); i++){
			//if the input matches a course name and course ID, then delete the course
			if (course == cl.get(i).Course_Section_Number && courseID == cl.get(i).Course_Id){
				cl.get(i).List_Of_Names.remove(firstName + lastName);
			}
		}
	}

//	boolean userExists = false;
//	while(!userExists){
//		Scanner input = new Scanner(System.in);
//		System.out.println("Type in your username: ");
//		String username = input.nextLine();
//		for (i=0; i<studentList.get(i)).username.equals(username)){
//			userExists = true;
//			break;
//		}
//
//}		
//	boolean passwordExists = false;
//	while(!passwordExists){
//		Scanner input = new Scanner(System.in);
//		System.out.println("Type in your password: ");
//		String username = input.nextLine();
//		for (i=0; i<passwordList.get(i)).password.equals(password)){
//			passwordExists = true;
//			break;
//		}
//
//}
//}
}