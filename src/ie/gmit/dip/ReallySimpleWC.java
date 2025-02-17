package ie.gmit.dip;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.List;
import java.util.Map.Entry;

/**
 * 
 * 
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1
 *
 *        ReallySimpleWC is a concrete class.
 */
public class ReallySimpleWC {

	// create a method which takes a list as a parameter
	// it throws an exception if the image can't be written to
	/**
	 * Takes a list of <String, Integer> as an input parameter. Creates a
	 * BufferedImage with set dimensions. An instance of the graphics class is then
	 * created and applied to the image created by BufferedImage. Two instance
	 * variable for the x and y coordinates are assigned. A for each loop is used to
	 * iterate through the List. A font is assigned by using the getRandomFont
	 * method from the RandomFont class. A colour is assigned by using the
	 * getRandomColour method from the RandomColour class. The font and colour are
	 * then set using the Graphics class. The drawString method is then called which
	 * takes a string, x and y coordinates. The String is accessed from the list
	 * using the iterator from the for each loop. The x and y are taken from the
	 * instance variables. The x and y variables are then increased to prevent the
	 * strings overlap as the loop is iterated. The graphics class is then disposed
	 * to release system resources. The image is then written as a png file and
	 * saved as image. An IO exception may be thrown.
	 * 
	 * @param k - Takes a list of <String, Integer> as an input parameter.
	 * @throws Exception - An instance of IOException is thrown.
	 */
	public static void drawWC(List<Entry<String, Integer>> k) throws IOException {

		BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = image.getGraphics();
		int x = 60;
		int y = 60;
		for (Entry<String, Integer> i : k) {
			Font font = RandomFont.getRandomFont().getFt();
			Color colour = RandomColour.getRandomColour().getColour();

			graphics.setFont(font);
			graphics.setColor(colour);
			graphics.drawString(i.getKey(), x, y);
			x += 60;
			y += 60;

		}
		graphics.dispose();
		ImageIO.write(image, "png", new File("image.png"));
		System.out.println("Word Cloud Generated Succesfully");

	}
}
