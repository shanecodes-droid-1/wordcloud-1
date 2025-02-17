package ie.gmit.dip;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1 MapCreator is a concrete class.
 */
public class MapCreator {

	// ConcurrentHashMap with threads possible
	// Create an instance variable wordMap which is used to store the text frequency
	// table
	// HashMaps can be declared in 0(1) time.
	private static Map<String, Integer> wordMap = new HashMap<>();

	/**
	 * An accessor method to the wordMap
	 * 
	 * @return it returns the Map wordMap.
	 */
	public static Map<String, Integer> getWordMap() {
		return wordMap;
	}

	/**
	 * A setter method for the wordMap
	 * 
	 * @param wordMap takes a map as an input parameter and assigns it to the instance variable wordMap.
	 */
	public static void setWordMap(Map<String, Integer> wordMap) {
		MapCreator.wordMap = wordMap;
	}

	// The big o run time of addToMap is 0(1). 
	/**
	 * Takes a String s as input. It then creates a counter variable called
	 * frequency which is used to calculate the frequency of the parameter string.
	 * An if statement is used to check if the map already contains the string s and
	 * if present it increases the frequency value by one. The String s is then
	 * added to wordMap along with the frequency value generating a frequency table.
	 * The big o run time is 0(1).
	 * 
	 * @param s Takes a String s as an input parameter.
	 * @throws Exception - An instance of RuntimeException is thrown.
	 */
	public static void addToMap(String s) throws Exception {
		int frequency = 1;
		// containsKey is 0(1) for HashMap
		// increase the frequency for every occurrence of the String
		if (wordMap.containsKey(s)) {
			// get is 0(1) for HashMap
			frequency += wordMap.get(s);
		}
		// adds (put) to hashmap in 0(1)
		wordMap.put(s, frequency);
	}
}
