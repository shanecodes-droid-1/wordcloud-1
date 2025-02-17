package ie.gmit.dip;
/**
 * 
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1
 * 
 * Runner is used to execute the program in the main method.
 *
 */
public class Runner {
	
	/**
	 * 
	 * @param args 
	 * @throws Exception - An instance of RuntimeException is thrown.
	 */
	public static void main(String[] args) throws Exception {
		//create an instance of the menu and initiate it.
		Menu m = new Menu();
		m.start();
	}
	

}
