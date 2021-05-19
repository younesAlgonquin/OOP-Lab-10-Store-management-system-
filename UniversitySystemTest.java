package University;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Student Name: Younes Boutaleb
 * Lab Professor: Dr. James Mwangi
 * Due Date: April 4, 2021
 * Modified: April 11, 2021
 */
/**
 * This class declare implements main method to test the program 
 *@author Younes
 *@version 2.0
 *@since 1.8
 **/
public class UniversitySystemTest {

	/**
	 * the main method tests the program by asking user to enter the name of University and the number of students
	 * it executes readStudentsDetails, printTitle, printStudentDetails methods using a university object
	 * @param args
	 */
	public static void main(String[] args) {


		/**this is a Scanner object**/
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the name of University: ");
		String name = input.nextLine();
		
		/**this is the number of students**/
		int number= 0;
		/**this is the loop variable which indicates whether the user entered a valid input**/
		boolean validInput=true;
		
		//****validate number input
				while(validInput) {
				try {
			    System.out.print("How many students do you have? ");
			    number = input.nextInt();
			    if (number > 0) {
			    validInput=false;
			    }
			    else { 
			    	System.out.println("Invalid input ...... ");
			    	validInput=true;}
		    	}catch(InputMismatchException ex1) {
		    		System.out.printf("Input Mismatch Exception\n", ex1);	    		
		    	}
				input.nextLine();
			    }//end while

		University c1 = new University(name);
		c1.readStudentsDetails(input);
		input.close();	
	}//end main method
}//end class
