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
* This class declare implements main method and test the entire program 
* it also throws exceptions when a invalid input is entered
*@author Younes
*@version 3.0
*@since 1.8
**/
public class Lab9 {

	/**
	 * the main method tests the program by asking the user to enter the Store's name and the number of employees
	 * it declares a Scanner object and executes readDetails methods using a Store object
	 * @param args
	 */
	public static void main(String[] args) {


		/**this is a Scanner object**/
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name of the store: ");
		String name = input.nextLine();
		
		/**this is the number of employees**/
		int number = 0;
		/**this is the loop variable which indicates whether the user entered a valid input**/
		boolean validInput=true;
		
		//****validate number input
		while(validInput) {
		try {
	    System.out.print("How many employees do you have? ");
	    number= input.nextInt();
	    if (number!=0) {
	    validInput=false;
	    }
	    else 
	    	validInput=true;
    	}catch(InputMismatchException ex1) {
    		System.out.printf("*****Input Mismatch Exception while reading number of employees*****\n", ex1);	    		
    	}catch(NegativeArraySizeException ex2) {
    		System.out.printf("*****Negative ArraySize Exception while reading number of employees*****\n", ex2);	    		
    	}
		input.nextLine();
	    }//end while
	    Store s1 = new Store(name);
	    s1.readDetails(input);
		input.close();
		
	}//end main method
	}//end class


