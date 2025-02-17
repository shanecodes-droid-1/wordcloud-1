package ie.gmit.dip;

import java.util.*;

/**
 * 
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1 See Menu The Class Menu is a concrete class.
 * 
 */
public class Menu {
	// create an instance variable of the scanner class s
	private Scanner s;
	// create an instance variable keepRunning which is set to true and will be used
	// by the start method to keep the method running until the user quits the
	// application
	private boolean keepRunning = true;
	// Menu contains a reference to the ParseableImpl class this is an example of aggregation
	// as its called from the method start() but is not fully encapsulated.
	ParseableImpl pi = new ParseableImpl();
	
	 //Menu is a constructor for the Menu class which takes no parameters and
	 // creates an instance of Scanner.
	public Menu() {
		s = new Scanner(System.in);
	}

	/**
	 * Calls the method showOptions. A switch statement is used to take the user
	 * input. The user input should be in the range of 1-2 integer values. The
	 * first option in the method will allow the user to parse a file or by calling an
	 * instance of the ParserImpl class and running the checkParseFormat method.  The second
	 * option in the method calls the quitting method. If the user enters anything
	 * but the values within the range a message is printed to the user. If an
	 * exception is generated an error message is printed to the user. 
	 */
	public void start() {
		
		while (keepRunning) {
			// call the method showOptions and then allow the user to input their choice
			// with a switch statement
			showOptions();
			try {
				int choice = Integer.parseInt(s.next());

				switch (choice) {
				case 1 -> pi.checkParseFormat();
				case 2 -> quitting();
				default -> System.out.println("Invalid Entry: Please select a value between [1-2]");
				}
			} catch (Exception e) {
				// print an error message to the user
				System.out.println("Invalid entry: Please try again");
			}
		}
	}

	/**
	 * Prints the menu options to the screen.
	 * Two options are given. Specify a file or URL for word cloud generating or quit.
	 */
	public void showOptions() {
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Word Cloud Generator   V1.0           *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");
		System.out.println("Specify a file or URL to generate a word cloud");
		System.out.println("1) Please specify a file or URL"); 
		System.out.println("2) Quit"); 
		System.out.println("\nSelect Option [1-2]>");

	}
	/**
	 * Sets the loop control variable keepRunnning to false therefore closing the application.
	 */
	public void quitting() {
		System.out.println("Quitting Application");
		keepRunning = false;
	}

}
