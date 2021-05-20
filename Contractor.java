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
* This class extends Employee class and declares hourly rate and number of hours worked variables and calculates the salary of a contractor employee
* It overrides readInfo and printInfo methods
*@author Younes
*@version 3.0
*@since 1.8
**/

public class Contractor extends Employee {
	
	/** this is the employees's hourly rate */
    protected double hourlyRate;
    /** this is the number of hours worked */
    protected double numHours;
	
	/** this is a no-arg constructor
	* we need it as we are declaring contractor employee objects
	**/
	public Contractor() {
		
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
	* @param hourlyRate
	* @param numHours
	*/
	public Contractor (String firstName, String lastName,String email, long phoneNumber, int employeeNumber, double hourlyRate, double numHours) {
		
		super(firstName, lastName, email, phoneNumber, employeeNumber);
		this.hourlyRate = hourlyRate;
		this.numHours = numHours;
		
	}//end parameterized constructor
	
	/**
	 * This method calls the super method readInfo and reads the employees's hourly Rate & number of hours worked
	 * @param input
	 *        this is a Scanner object that will be declared in method main
	 */
	@Override
	public void readInfo(Scanner input) {
				
		super.readInfo(input);
		
		/**this is the loop variable which indicates whether the user entered a valid input**/
	    boolean validInput = true;
	    
	    //****validate hourly rate and hours worked inputs
		while(validInput) {
		try {
				
		System.out.print("Enter hourly rate: ");
		hourlyRate = input.nextDouble();
		
		System.out.print("Enter number of hours worked: ");
		numHours = input.nextDouble();

		if(hourlyRate>0 && numHours>=0) {
			validInput = false;
		}//end if 
		else {
			System.out.println("Invalid hourly rate and number of hours worked inputs.... please try again...");
		    validInput = true;
		}//end else

		}catch(InputMismatchException ex5) {
				System.out.printf("*****Input Mismatch Exception while reading employee's hourly rate and number of hours worked*****\n", ex5);
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
		hourlyRate= input.nextDouble();
		numHours= input.nextDouble();
		
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
		System.out.printf("%11.2f|\n", hourlyRate*numHours);
	}//end printInfo

}//end class
