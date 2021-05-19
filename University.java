package University;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
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
 * This class stores the students objects in an array of references. 
 * According to their type it calls the appropriate readInfo and printInfo methods   
 *@author Younes
 *@version 2.0
 *@since 1.8
 **/

public class University {
	
	/** this is the name of the university**/
	private String name;
	/**this is a List of references that stores the Student objects**/
	private ArrayList <Student> students;
	/**this is the option that the user choose from the menu **/
	private int option=0;
	/**this is the type of data input that the user choose from the menu **/
	private int choice=0;
	/**this is a scanner object which will read from a file*/
	private Scanner keyboard;
	
	/**
	 * This is a parameterized constructor which assigns the university's name and the students array size
	 * @param name
	 *        this is the name of the university
	 **/
	public University (String name) {
		
		this.name=name;
		students = new ArrayList<Student>();
	}//end parameterized constructor
	
	
	/**
	 * this method defines the type of Student objects and calls the appropriate read info method
	 * it also display a menu of options and executes the option chosen by the user 
	 * @param input
	 *        this is a Scanner object that will be declared in method main
	 **/
	public void readStudentsDetails(Scanner input) {
		
		for(int i=0; i<=students.size(); i++) {
			
			/**this is the loop variable which indicates whether the user entered a valid input**/
		    boolean validInput = true;
		    
		    //****validate option input
			while(validInput) {
				try {
					
				    //menu of options
					System.out.println("\n   1. Register Students ");
					System.out.println("   2. Display Students ");
					System.out.println("   3. Exit ");
					System.out.print("Enter your choice: ");
					
					
					option = input.nextInt();
					
					if(option ==1 || option == 2 || option == 3) {
					validInput = false;
				    }//end if 
				    else {
					System.out.println("Invalid option.... please try again...");
				    validInput = true;
				    }//end else
					
					}catch(InputMismatchException ex) {
						System.out.printf("Input Mismatch Exception\n", ex);
					}//end catch
					input.nextLine();
			}//end while
			
			switch(option) {
			case 1:
	
			    validInput = true;
			    
			    //****validate option input
				while(validInput) {
					try {
						
					    //menu of input options
						System.out.println("\n   1. Read from file ");
						System.out.println("   2. Read from the user ");
						System.out.print("   Enter your option: ");

						choice = input.nextInt();
						
						if(choice ==1 || choice == 2) {
						validInput = false;
					    }//end if 
					    else {
						System.out.println("Invalid option.... please try again...");
					    validInput = true;
					    }//end else
						
						}catch(InputMismatchException ex) {
							System.out.printf("Input Mismatch Exception\n", ex);
						}//end catch
						input.nextLine();
				}//end while
				
				if (choice ==1) {
					
					try {
					openFile();

					while(keyboard.hasNext()) {
					String letter = keyboard.next();

					if (letter.equals("f")) {
						
						try {
						students.add(new FulltimeStudent());
						students.get(i).readFile(keyboard);
						i++;
						}catch(InputMismatchException ex) {
							students.remove(i);
							System.out.printf("Input Mismatch Exception\n", ex);
							keyboard.nextLine();
						}//end catch
						
					
					}//end if (letter.equals("f"))
					
					else {
						
						try {
						students.add(new ParttimeStudent());
						students.get(i).readFile(keyboard);
						i++;
						}catch(InputMismatchException ex) {
							students.remove(i);
							System.out.printf("Input Mismatch Exception\n", ex);
							keyboard.nextLine();
						}//end catch
						
					}//end else

					}//end while
					
					closeFile();
					
					}catch(NullPointerException p) {
						System.out.println("Scanner Object is null");
					}
					i--;
				}//end if (choice ==1)
				
				
				else {
					
					/**this is the student's type that the user choose from the list **/
					int type =0;
					/**this is the loop variable which indicates whether the user entered a valid input**/
				    validInput=true;
				    
				    //****validate type input
		    	    while (validInput) {
		    		
		    	    try {
		    		System.out.println("\nEnter details of student");
		    		System.out.println("========================");
					System.out.println("   1 - Fulltime student ");
					System.out.println("   2 - Parttime Student\n");
					System.out.print("Enter Student type:  ");
					
		    		type = input.nextInt();
		    		input.nextLine();
		    		
		    		try {
			    		if (type ==1) {
							    	
			 					students.add(new FulltimeStudent());
			 					students.get(i).readInfo(input);
					    	    validInput = false;
			    			 }//end if
			    		
			    		else if (type ==2) {
			    		
						    students.add(new ParttimeStudent());
						    students.get(i).readInfo(input);
				    	    validInput = false;
			    		}//end else if
			    		
						else {
							System.out.println("Invalid type.... please try again...");
						    //validInput = true;
						     }//end else
			    		
			    	    }catch(InputMismatchException ex) {
			    	    	students.remove(i);
			    	    	System.out.printf("*****Input Mismatch Exception*****\n", ex);
			    	    }//end catch
		    		
		    	    }catch(InputMismatchException ex) {
		    	    	System.out.printf("*****Input Mismatch Exception while reading type*****\n", ex);
		    	    }//end catch
		    	    
		    	    input.nextLine();
					}//end while
		    	    
				}//end else
				
			break;
				
			case 2:
				
				if(i==0)
					System.out.println("\nNo students to display....");	
				else {
				printTitle();
				printStudentDetails();
				}
				i--;
			break;
			
			case 3:
				
				System.out.println("\nExiting...Goodbye.... Have a nice day!");
				i=students.size();
		    break;
		    
		    default:
		    	i--;
				
			}//end switch
			}//end for

	        }//end readStudentsDetails
	
	/**
	 * this methods prints information about students in a table
	 */
	private void printStudentDetails() {
		
		for(int i=0; i<students.size(); i++) 
			
			students.get(i).printInfo();
	}//end printStudentDetails
	
	/**
	 * this method prints the list of students title
	 **/
	private void printTitle() {
		
		System.out.printf("\n%s - List of Students\n", name);
		System.out.println("*".repeat(name.length() + 19));
		System.out.printf("%7s|%9s|%18s|%16s|%11s|%5s|%9s|%9s|\n", "Program", "Student#", "Name", "Email", "Phone", "GPA", "Fees", "Credits");
	}//end printTitle
	
	/**
	 * This method opens a file using its  path
	 */
	private void openFile() {
		try {
	keyboard = new Scanner(Paths.get("students.txt"));
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
