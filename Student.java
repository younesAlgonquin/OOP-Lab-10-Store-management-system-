package University;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/*
 * Student Name: Younes Boutaleb
 * Lab Professor: Dr. James Mwangi
 * Due Date: April 4, 2021
 * Modified: April 11, 2021
 */
/**
 * This class implements Person interface and . It reads the students properties and marks, calculates GPA 
 * and prints a reports. 
 *@author Younes
 *@version 2.0
 *@since 1.8
 **/

public class Student implements Person {
	
	// I choose to declare the instance variables private as we won't use them in the subclasses
	//we can also declare them protected
	
	/** this is the student's first name **/
	private String firstName;
	/** this is the student's last name **/
	private String lastName;
	/** this is the student's email address **/
	private String emailId;
	/** this is the student's phone number **/
	private long phoneNumber;
	/** this is the student's identification number **/
	private int studentNumber;
	/** this is the program in which the student is enrolled **/
	private String programName;
	/** this is the studendt's Grade Point Average **/
	private double gpa;
	
	/** this is a no-arg constructor
	 * It's an optional declaration. we can omit it, in this case subclass will extend the default constructor
	**/
//	public Student() {
//		
//	}//end no-arg constructor
	

	/**
	 * This method reads the students' common attributes. it also calls the readMarks
	 * @param input
	 *         this is a Scanner object that will be declared in method main
	 **/
	@Override 
	public void readInfo(Scanner input) throws InputMismatchException {
		
		System.out.print("Enter program name: ");
		programName = input.nextLine();
		
   		System.out.print("Enter student number: ");
		studentNumber= input.nextInt();
		input.nextLine();
    	
		System.out.print("Enter first name: ");
		firstName = input.nextLine();
		
		System.out.print("Enter last name: ");
		lastName = input.nextLine();
		
		System.out.print("Enter email Id: ");
		emailId = input.nextLine();
				
   		System.out.print("Enter phone number: ");
		phoneNumber= input.nextLong();
    	
    	readMarks(input);
	}//end readInfo
	
	/**
	 * 
	 * this method is declared private as we only call it inside the class
	 * This methods reads the number of courses and then reads marks of all  
	 * After reading the marks, this method calls calculateGpa().
	 * @param input
	 *         this is a Scanner object that will be declared in method main 
	**/
	private void readMarks (Scanner input) throws InputMismatchException {
		
   		System.out.print("Enter number of courses: ");
   		int numberCourses= input.nextInt();
    	
   		ArrayList <Double> marks = new ArrayList<Double>(numberCourses);
       	
    	for(int i=0; i<numberCourses; i++) {
    		System.out.print("Enter mark " + (i +1) + ": ");
    	    marks.add(input.nextDouble());
    	}//end for
    	
    	calculateGpa(marks);
	}//end readMarks
	
	/**
	 * this method is declared private as we only call it inside the class
	 * this method calculates the student's GPA 
	 * @param marks
	 *            this is an arrayList of doubles that stores the student's marks
	**/
	private void calculateGpa (ArrayList <Double> marks) {
		
		double total=0;
		for(int i=0; i<marks.size(); i++) {

			total += marks.get(i);
		}
		
		gpa = ((total/marks.size())/100)*4;	
	}//end calculateGpa
	
	/**
	 * This method reads the employees's identification number from the students.txt file
	 * @param input
	 *        this is a Scanner object that will be declared in method main
	 */
	@Override
	public void readFile(Scanner input) throws InputMismatchException {
		
		studentNumber= input.nextInt();
		firstName = input.next();
		lastName = input.next();
		emailId = input.next();
		phoneNumber= input.nextLong();
		programName = input.next();
		gpa = input.nextDouble();
		
	}//end readFile
	
	/**
	 * this method prints a table that contains the students's common information
	 **/
	@Override
	public void printInfo() {
		
		System.out.printf("\n%7s|%9d|%18s|%16s|%11d|%5.2f|", programName, studentNumber, firstName + " " + lastName, emailId, phoneNumber, gpa );
	}//end printInfo
	
}//end class
