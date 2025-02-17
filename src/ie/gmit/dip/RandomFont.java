package ie.gmit.dip;

import java.util.*;

/**
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1 
 * RandomFont is a concrete class which randomly generates a
 * font from the enum FontFormat
 * 
 */
public class RandomFont {

	/**
	 * An array from the enum FontFormat is created with a size the same as the
	 * number of Fonts. An instance variable length is created with the same size as
	 * the Fonts array. A random index position is then generated using the Random
	 * method imported from java.util.Random. This generates a random int within the
	 * range of the array size, as the nextInt() method takes length as a parameter.
	 * The method getRandomFont then returns the random int as an index position for
	 * the FontFormat array.
	 * 
	 * @return returns the random int as an index position for
	 * the FontFormat array.
	 */
	// https://dirask.com/posts/Java-get-random-element-from-enum-VDK8np
	public static FontFormat getRandomFont() {
		// create an array of fonts
		FontFormat[] values = FontFormat.values();
		// get the length of the enum FontFormat
		int length = values.length;
		// generate a random index for the array
		int randIndex = new Random().nextInt(length);
		// return a random font value from the array of font formats
		return values[randIndex];
	}

}
