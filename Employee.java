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
* This class extends Person class and declares the employee number variable
* It overrides readInfo and printInfo methods
*@author Younes
*@version 3.0
*@since 1.8
**/

public class Employee extends Person {
	
//	Method Store.redDetails(); needs to take a Scanner object as a parameter to be able to read the employee type
//	We need to print the options inside the for loop of Method Store.redDetails(); as we need to display them after each iteration.
//	The Methods Store.printTitle(); Store.printLine(); and Store.printDetails will be called locally inside Method Store.redDetails(); then we have to declare them private. 
//	In fact the instructions require that the program should allow the user to print the employees’ details after each iteration

	
	/** this is the employees's identification number */
	protected int employeeNumber;
	
	/** this is a no-arg constructor
	 * we need it, as we are declaring a parameterized constructor and we need no-arg constructors in the subclasses
	**/
	
	public Employee() {	
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
	 */
	public Employee (String firstName, String lastName,String email, long phoneNumber, int employeeNumber) {
			
			super(firstName, lastName, email, phoneNumber);
			this.employeeNumber = employeeNumber;
			
		}//end parameterized constructor
	
	/**
	 * This method calls the super method readInfo  and reads the employees's identification number
	 * @param input
	 *        this is a Scanner object that will be declared in method main
	 */
	@Override
	public void readInfo(Scanner input) {
				
		/**this is the loop variable which indicates whether the user entered a valid input**/
	    boolean validInput = true;
	    
	    //****validate employee number input
		while(validInput) {
			try {
				
		System.out.print("Enter Employee Number: ");
		employeeNumber = input.nextInt();
		
		if(employeeNumber>0) {
			validInput = false;
		}//end if 
		else {
			System.out.println("Invalid employee number.... please try again...");
		    validInput = true;
		     }//end else
			}catch(InputMismatchException ex7) {
				System.out.printf("*****Input Mismatch Exception while reading employee number*****\n", ex7);
			}//end catch
			input.nextLine();
		}//end while	
			
		super.readInfo(input);
			
		}//end readInfo
	

	/**
	 * This method calls the super method readFile  and reads the employees's identification number from the employee.txt file
	 * @param input
	 *        this is a Scanner object that will be declared in method main
	 */
	@Override
	public void readFile(Scanner input) {
		
		employeeNumber= input.nextInt();
		super.readFile(input);
	}//end readFile
	
	
	/**
	 * This method overrides the super method printInfo and prints the employee's properties 
	 */
	@Override
	public void printInfo() {
			
			System.out.printf("%9d|%18s|%16s|%11d|", employeeNumber, firstName + " " + lastName, email, phoneNumber);
		}//end printInfo

}//end class
