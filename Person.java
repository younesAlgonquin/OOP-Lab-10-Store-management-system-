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
* This is an abstract class declares common Employee properties and reads their values
* It declares also an abstract method printInfo
*@author Younes
*@version 3.0
*@since 1.8
**/

public abstract class Person {
	/** this is the employees's first name */
	protected String firstName;
	/** this is the employees's last name */
	protected String lastName;
	/** this is the employees's email address */
	protected String email;
	/** this is the employees's phone number */
	protected long phoneNumber;
	
	
	/** this is a no-arg constructor
	 * we need it as we are declaring a parameterized constructor and we need no-arg constructors in the subclasses
	**/
	public Person() {
		
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
	 */
	public Person (String firstName, String lastName,String email, long phoneNumber) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		
	}//end parameterized constructor

	/**
	 * This method reads employee's common properties from the user
	 * @param input
	 *        this is a Scanner object that will be declared in method main
	 */
	public void readInfo(Scanner input) {
		
		System.out.print("Enter first name: ");
		firstName = input.nextLine();
		
		System.out.print("Enter last name: ");
		lastName = input.nextLine();
		
		System.out.print("Enter email: ");
		email = input.nextLine();

		/**this is the loop variable which indicates whether the user entered a valid input**/
	    boolean validInput = true;
	    
	    //****validate employee's phone number input
		while(validInput) {
		try {
				
		System.out.print("Enter phone number: ");
		phoneNumber = input.nextLong();
		
		if(phoneNumber>0) {
			validInput = false;
		}//end if 
		else {
			System.out.println("Invalid phone number.... please try again...");
		    validInput = true;
		     }//end else
		}catch(InputMismatchException ex7) {
				System.out.printf("*****Input Mismatch Exception while reading employee number*****\n", ex7);
			}//end catch
		input.nextLine();
		}//end while
		
	}//end readInfo
		
	/**
	 * This method reads employee's common properties from the file
	 * @param input
	 *        this is a Scanner object that will be declared in method main
	 */
	public void readFile(Scanner input) {
		
		firstName = input.next();
		lastName = input.next();
		email = input.next();
		phoneNumber = input.nextLong();

	}//end readFile
	
	
	/**
	 * This is an abstract method that will be implemented in the subclass
	 */
	public abstract void printInfo();
	
}//end class
