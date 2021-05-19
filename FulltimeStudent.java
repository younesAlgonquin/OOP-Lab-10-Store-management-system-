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
 * This class inherits students's common information and reads the special properties of Full time students
 * and insert them in the list of students table
 *@author Younes
 *@version 2.0
 *@since 1.8
 **/

public class FulltimeStudent extends Student {
	
	/**this is tuition fees that will be payed by this student**/
	private double tuitionFees;
	
	/**
	 * this is a no-arg constructor
	**/
	public FulltimeStudent () {
		
	}//end no-arg constructor
	
	
	/**
	 * this method reads the special properties of Full time students
	 * @param input
	 *        this is a Scanner object that will be declared in method main
	**/
	@Override
	public void readInfo(Scanner input) throws InputMismatchException {
		
		super.readInfo(input);
		
 		System.out.print("Enter tuition fees: ");
	    tuitionFees = input.nextDouble();

	}//end readInfo
	
	
	/**
	 * this method reads the tuition Fees from the students.txt file
	 * @param input
	 *        this is a Scanner object that will be declared in method main
	 */
	@Override
	public void readFile(Scanner input) throws InputMismatchException {
		
		super.readFile(input);
		
		tuitionFees = input.nextDouble();
		
	}//end readFile
	
	/**
	 * this method inserts the Full time students's special properties in the list of students table
	**/
	@Override
	public void printInfo() {
		
		super.printInfo();
		System.out.printf("%9.2f|", tuitionFees);
	}//end printInfo

}//end class
