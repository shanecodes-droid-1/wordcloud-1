package ie.gmit.dip;

import java.awt.Color;

/**
 * 
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1 
 * Colours is an enum which acts as a container for colors from the Color api.
 */

public enum Colours {
	// Create a number of colours with random characteristics
	COLOUR_1 (Color.black),
	COLOUR_2 (Color.blue),
	COLOUR_3 (Color.cyan),
	COLOUR_4 (Color.darkGray),
	COLOUR_5 (Color.gray),
	COLOUR_6 (Color.green),
	COLOUR_7 (Color.lightGray),
	COLOUR_8 (Color.magenta),
	COLOUR_9 (Color.orange),
	COLOUR_10 (Color.pink),
	COLOUR_11 (Color.red),
	COLOUR_12 (Color.white),
	COLOUR_13 (Color.yellow);
	
	//create an instance variable colour
	private Color colour;

	
	 // Colours is the constructor which takes a Color and assigns it to the instance variable colour.
	private Colours(Color colour) {
		this.colour = colour;
	}

	/**
	 * getColour is an accessor method which returns the instance variable colour.
	 * @return returns the instance variable colour.
	 */
	public Color getColour() {
		return colour;
	}
	/**
	 * setColour sets the instance variable colour based on the color input as a parameter.
	 * @param Takes a Color as an instance parameter assigns it to the instance variable colour.
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}

}
