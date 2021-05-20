package Quality;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

/**
* This class stores the employee objects in an array of references. 
* According to their type it calls the appropriate read and print methods and creates a database of employees
*@author Younes
*@version 3.0
*@since 1.8
**/

public class Store {
	
	/** this is the name of the store**/
	private String name;
	/**this is an List of references that stores the Employee objects**/
	private ArrayList <Employee> employees;
	/**this is the option that the user choose from the menu **/
	private int option=0;
	/**this is a scanner object which will read from a file*/
	private Scanner keyboard;
	
	/**
	 * This is a parameterized constructor which assigns the store's name
	 * We don't need to specify the number of employees in the constructor as we are using an ArrayList
	 * @param name
	 *        this is the name of the store
	 **/
	public Store (String name) {
		
		employees = new ArrayList<Employee>();
		this.name=name;
	}//end parameterized constructor
	
	/**
	 * this method defines the type of Employee objects and calls the appropriate read info method
	 * it also display a menu of options and executes the option chosen by the user 
	 * It has to take a Scanner object as parameter as we need to read the employee's type
	 * The options are declared in this method inside the for loop because we want to display the options menu after iteration
	 * @param input
	 *        this is a Scanner object that will be declared in method main
	 **/
	public void readDetails(Scanner input) {
		
		for(int i=0; i<=employees.size(); i++) {
			

			/**this is the loop variable which indicates whether the user entered a valid input**/
		    boolean validInput = true;
		    
		    //****validate option input
			while(validInput) {
				try {
					
		    //menu of options
			System.out.println("\n   1. Read Employee Details from the user ");
			System.out.println("   2. Read Details from the file ");
			System.out.println("   3. Print Employee Details ");
			System.out.println("   4. Quit ");
			System.out.print("Enter your option: ");
			option = input.nextInt();
			
			if(option ==1 || option == 2 || option == 3 || option == 4) {
				validInput = false;
			}//end if 
			else {
				System.out.println("Invalid option.... please try again...");
			    validInput = true;
			     }//end else
				}catch(InputMismatchException ex3) {
					System.out.printf("*****Input Mismatch Exception while reading option*****\n", ex3);
				}//end catch
				input.nextLine();
			}//end while

		switch(option) {
		case 1:
			
			/**this is the employee's type that the user choose from the list **/
			int type =0;
			/**this is the loop variable which indicates whether the user entered a valid input**/
		    validInput=true;
		    
		    //****validate type input
    	    while (validInput) {
    		
    	    try {
    		System.out.println("\nEnter details of employee " + (i+1) + " :");
			System.out.println("   1. Regular ");
			System.out.println("   2. Contractor\n");
			System.out.print("Enter type of employee:  ");
    		type =input.nextInt();
    		
    		if(type ==1 || type == 2) {
    			validInput = false;
    		}//end if
			else {
				System.out.println("Invalid type.... please try again...");
			    validInput = true;
			     }//end else
    	    }catch(InputMismatchException ex4) {
    	    	System.out.printf("*****Input Mismatch Exception while reading type*****\n", ex4);
    	    }//end catch
    	    input.nextLine();
			}//end while
    	    
		    if (type ==1) {
			employees.add(new Regular());
			employees.get(i).readInfo(input);	
		    }//end if
		
		    else {
		    employees.add(new Contractor());
		    employees.get(i).readInfo(input);	
		    }//end else
	
		break;
		
		case 2:
		try {	
		openFile();

		while(keyboard.hasNext() && option==2) {
		String letter = keyboard.next();
		//Employee e = new Employee();
		if (letter.equals("r")) {
			employees.add(new Regular());
			employees.get(i).readFile(keyboard);
			i++;
		}//end if
		else {
		    employees.add(new Contractor());
		    employees.get(i).readFile(keyboard);
			i++;
		}//end else
		}//end while
		
		closeFile();
		}catch(NullPointerException p) {
			System.out.println("Scanner Object is null");
		}
		
		i--;
		break;
		
		case 3:
			
			printTitle(name);
			printDetails();
			i--;
		break;
		
		case 4:
			
			System.out.println("\nGoodbye... Have a nice day!");
			i=employees.size();
	    break;
	    
	    default:
	    	i--;
			
		}//end switch
		}//end for
			
	}//end readDetails
	
	/**
	 * this methods prints information about employees in a table
	 * We declared it private as it's called locally in readDetails method 
	 */
	private void printDetails() {
		
		for(int i=0; i<employees.size(); i++) 

				employees.get(i).printInfo();
	}//end printStudentDetails 

	/**
	 * this method prints a line using "="
	 * We declared it private as it's called locally in printTitle method 
	**/
	private void printLine() {
		System.out.println("=".repeat(70));
	}//end printLine
	
	/**
	 * this method prints the stor's database title
	 * We declared it private as it's called locally in readDetails method 
	 * @param name
	 *          this is the store name
	 **/
    private void printTitle(String name) {
	    printLine();
		System.out.printf("%s Store Management System\n", name);
		printLine();
		System.out.printf("%9s|%18s|%16s|%11s|%11s|\n", "Emp#", "Name", "Email", "Phone", "Salary");
		printLine();
	}//end printTitle
    
    
    
	/**
	 * This method opens a file using its  path
	 */
	private void openFile() {
		try {
	keyboard = new Scanner(Paths.get("employees.txt"));
	}catch(NoSuchFileException fe) {
	   System.err.println("File not found");
	}catch(IOException ioe){
	   System.err.println("ioe");
    }
			
	}//end openFile
	
	
	/**
	 * This method closes a file
	 */
	private void closeFile() {
		
		if(keyboard!=null)
			keyboard.close();
	}//end closeFile
	
}//end class
