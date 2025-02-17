package ie.gmit.dip;

import java.util.Random;

/**
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1 
 * 	RandomColour is a concrete class which randomly generates
 * 	an element from the enum Colours.
 */
public class RandomColour {

	/**
	 * An array is created from the enum Colours with a size the same as the number of
	 * Colours. An instance variable length is created with the same size as the
	 * Colours array. A random index position is then generated using the Random
	 * method imported from java.util.Random. This generates a random int within the
	 * range of the array size, as the nextInt() method takes length as a parameter.
	 * The method getRandomColour then returns the random int as an index position
	 * for the Colours array.
	 * 
	 * @return returns the random int as an index position for the Colours array.
	 */
	// https://dirask.com/posts/Java-get-random-element-from-enum-VDK8np
	public static Colours getRandomColour() {
		// create an array of colours
		Colours[] random = Colours.values();
		// get the length of the enum Colours
		int length = random.length;
		// generate a random index for the array
		int randomIndex = new Random().nextInt(length);
		// return a random colour value from the array of colours
		return random[randomIndex];
	}
}
