package Quality;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Student Name: Younes Boutaleb
 * Lab Professor: Dr. James Mwangi
 * Due Date: April 4, 2021
 * Modified: March 31, 2021
 */

/**
* This class extends Employee class and declares salary variable for the Regular employee
* It overrides readInfo and printInfo methods
*@author Younes
*@version 3.0
*@since 1.8
**/

public class Regular extends Employee {
	
	    /** this is the employees's salary */
	    protected double salary;
	
	
		/** this is a no-arg constructor
		 * we need it as we are declaring regular employee objects
		**/
		public Regular() {
		}//end no argument constructor
		
		/** 
	    * this is a parameterized constructor
	    * @param firstName
	    *         this is the employees's first name
	    * @param lastName
	    *         this is the employees's last name
	    * @param email
	    *         this is the employees's email address
	    * @param phoneNumber
	    *         this is the employees's phone number
	    * @param employeeNumber
	    *         this is the employees's identification number
		 * @param salary
		 *        this is the employees's salary
		 */
		public Regular (String firstName, String lastName,String email, long phoneNumber, int employeeNumber, double salary) {
			
			super(firstName, lastName, email, phoneNumber, employeeNumber);
			this.salary = salary;
			
		}//end parameterized constructor
		
		/**
		 * This method calls the super method readInfo and reads the employees's salary
		 * @param input
		 *        this is a Scanner object that will be declared in method main
		 */
		@Override
		public void readInfo(Scanner input) {
					
			super.readInfo(input);
			
			/**this is the loop variable which indicates whether the user entered a valid input**/
		    boolean validInput = true;
		    
		    //****validate salary input
			while(validInput) {
			try {
					
			System.out.print("Enter annual salary: ");
			salary = input.nextDouble()/12;
			
			if(salary>0) {
				validInput = false;
			}//end if 
			else {
				System.out.println("Invalid salary amount.... please try again...");
			    validInput = true;
			}//end else

			}catch(InputMismatchException ex6) {
					System.out.printf("*****Input Mismatch Exception while reading employee's hourly rate and hours worked*****\n", ex6);
				}//end catch
			input.nextLine();	
			}//end while
			
		}//end readInfo
		
		
		/**
		 * This method calls the super method readFile and reads the employees's salary from the employee.txt file
		 * @param input
		 *        this is a Scanner object that will be declared in method main
		 */
		@Override
		public void readFile(Scanner input) {
			
		try {
			super.readFile(input);
			salary= input.nextDouble()/12;
		}catch(InputMismatchException e) {
			System.out.println("Data is damaged");
			input.nextLine();
		}
		}//end readFile
		
			
		/**
		 * This method overrides the super method printInfo and prints the employee's salary 
		 */
		@Override
		public void printInfo() {
			
			super.printInfo();
			System.out.printf("%11.2f|\n", salary);
		}//end printInfo

}//end class
