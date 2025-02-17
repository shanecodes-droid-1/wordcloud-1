package ie.gmit.dip;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1
 * 
 *        WordProcessing is a concrete class.
 *
 */
public class WordProcessing {

	// create an instance variable keepRunning which is set to true and used by
	// userSetDisplayWords to keep the method running until the user inputs a value
	// between 1-30
	private static boolean keepRunning = true;
	// create an instance variable MWDiplay which is used to control the max number
	// of words to display on the word cloud
	private static int MWDisplay;

	/**
	 * Accessor method which returns the instance variable MWDisplay.
	 * 
	 * @return returns the instance variable MWDisplay
	 */
	public static int getMWToDisplay() {
		return MWDisplay;
	}

	/**
	 * Sets the instance variable MWDisplay
	 * 
	 * @param Takes an integer mw as an input parameter and assigns it to the
	 *              instance variable MWDisplay.
	 */
	public static void setMWToDisplay(int mw) {
		MWDisplay = mw;
	}

	/**
	 * A while loop is used to keep the method running until the user inputs a
	 * integer value between 1-30. An if statement is used to check if the user has
	 * input an integer value within the range. This updates the MWDisplay instance
	 * variable if the input is within the range by calling the setMWToDisplay
	 * method An else statement is used to print a message to the user if the input
	 * is not within the range. An exception is thrown if the input is not expected.
	 * 
	 * @throws Exception - An instance of RuntimeException is thrown.
	 */
	// https://stackoverflow.com/questions/59776867/how-to-restrict-the-user-to-enter-number-between-certain-range-in-java
	public static void userSetDisplayWords() throws Exception {
		while (keepRunning) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter value between 1-30 to specify the max words to be displayed");
			int choice = Integer.parseInt(sc.next());
			if (choice <= 30 && choice > 0) {
				setMWToDisplay(choice);
				keepRunning = false;
			} else {
				System.out.println("Invalid Entry: Please select a value between [1-30]");
			}
		}
	}

	/**
	 * Takes a String s as an input parameter. It first converts any characters to
	 * lower case, then removes any whitespace and non-alphabetical characters The
	 * filtered string is assigned to a new string lower and returned.
	 * 
	 * @param s - Takes a String as an input parameter
	 * @return The filtered string is assigned to a new string lower and returned.
	 */
	// https://stackoverflow.com/questions/22512865/how-to-exclude-the-words-that-have-non-alphabetic-characters-from-string
	public static String filter(String s) {
		String lower = s.toLowerCase().trim().replaceAll("[^a-zA-Z]", " ");
		return lower;
	}

	/**
	 * Takes a Map<String, Integer> wm as an input parameter. entrySet() is called
	 * on the map which returns the elements as a new set. A stream is then opened
	 * and the sorted method is called to sort the elements in descending order
	 * based on the value. The limit method is called which takes the instance
	 * variable MWToDisplay by calling its getter method. This sets a limit on the
	 * elements. collect is then called to assign the sorted and limited elements to
	 * a new list called entries which is returned by processMW. It can throw an
	 * exception.
	 * 
	 * @param wm - Takes a Map<String, Integer> as an input parameter.
	 * @return entries - a new list which has been sorted in descending order by
	 *         value and limited based on the instance variable MWDisplay
	 * @throws Exception - An instance of RuntimeException is thrown.
	 */
	// https://stackoverflow.com/questions/17095083/java-how-to-return-top-10-items-based-on-value-in-a-hashmap
	// https://learnonline.gmit.ie/mod/forum/discuss.php?d=33135
	public static List<Entry<String, Integer>> processMW(Map<String, Integer> wm) throws Exception {
		List<Entry<String, Integer>> entries = wm.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(getMWToDisplay())
				.collect(Collectors.toList());
		return entries;
	}

}
