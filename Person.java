package University;

import java.util.Scanner;

/*
 * Student Name: Younes Boutaleb
 * Lab Professor: Dr. James Mwangi
 * Due Date: April 4, 2021
 * Modified: April 11, 2021
 */
/**
 * This is an interface that will be implemented by class Student. it declares three abstract methods
 *@author Younes
 *@version 2.0
 *@since 1.8
 **/

public interface Person {

	/**
	 * @param input
	 *         this is a Scanner object that will be declared in method main
	 */
	public void readInfo(Scanner input);
	/**
	 * this is an abstract class which will be implemented in subclasses to read students details from the user
	 * @param input
	 *         this is a Scanner object that will be declared in method main
	 */
	public void readFile(Scanner input);
	
	/**
	 * this is an abstract class which will be implemented in subclasses to display students details
	 */
	public void printInfo();
	
}//end interface
