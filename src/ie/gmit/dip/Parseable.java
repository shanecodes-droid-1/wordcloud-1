package ie.gmit.dip;

import java.io.BufferedReader;

/**
 * 
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1 Parseable is an interface
 */
public interface Parseable {

	/**
	 * An abstract method that throws an exception
	 * 
	 * @throws Exception - An instance of RuntimeException is thrown.
	 */
	public abstract void checkParseFormat() throws Exception;

	/**
	 * An abstract method that takes a BufferedReader as an input parameter. It
	 * throws an exception.
	 * 
	 * @param br - a BufferedReader used to parse the content.
	 * @throws Exception - An instance of RuntimeException is thrown.
	 */
	public abstract void parseToMap(BufferedReader br) throws Exception;

}
