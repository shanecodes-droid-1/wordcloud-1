package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

/**
 * 
 * @author Shane McGillycuddy
 * @version 1.0
 * @since Java 15.0.1
 *
 *        ParseableImpl implements the Parseable interface and is a concrete
 *        class
 */
public class ParseableImpl implements Parseable {

	// create a static instance of the scanner class
	private static Scanner scan = new Scanner(System.in);
	// create a TreeSet stopwords which is used to store the String content of the
	// ignore words file
	// when creating the word cloud.
	private static Set<String> stopwords = new TreeSet<>();

	/**
	 * checkParseFormat is implemented from the interface Parseable. First calls the
	 * parseIgnoreWords method to allow the user specify the ignore words file. Then
	 * asks the user for the file or URL to generate the word cloud. The String
	 * input is checked to see if it is a URL by checking the string prefix. A
	 * BufferedReader is then created depending on the user input. The parseToMap
	 * method is then called using the BufferedReader as an input parameter.
	 */
	// https://stackoverflow.com/questions/25237682/how-to-know-whether-a-string-path-is-web-url-or-a-file-based
	// https://examples.javacodegeeks.com/core-java/net/url/read-text-from-url/
	@Override
	public void checkParseFormat() throws Exception {
		parseIgnoreWords();
		System.out.println("Please specify the file or URL to generate the word cloud");
		String userPath = scan.nextLine();
		String checkOrigin = userPath.trim().toLowerCase();
		boolean isURL = checkOrigin.startsWith("http://") || checkOrigin.startsWith("https://");

		if (isURL) {
			try {
				URL url = new URL(userPath);

				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				parseToMap(br);

			} catch (MalformedURLException e) {
				System.out.println("Malformed URL: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("I/O Error: " + e.getMessage());
			}

		} else {
			File f = new File(userPath);
			if (f.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(f));
				parseToMap(br);
			}

		}
	}

	/**
	 * Asks the user to specify a file to use to check which words to ignore when
	 * creating the word cloud. A BufferedReader is used to to read from the file. A
	 * while statement is used to read from the file line by line and add the string
	 * content to the treeset stopwords. An exception may be thrown.
	 * 
	 * @throws Exception - An instance of RuntimeException is thrown.
	 */
	// https://stackoverflow.com/questions/50907840/adding-contents-of-text-files-to-a-hash-set/50908189
	public void parseIgnoreWords() throws Exception {
		System.out.println("Please specify the file which contains a list of words to be ignored");
		String ignoreWords = scan.nextLine();
		File f = new File(ignoreWords);
		if (f.exists()) {

			BufferedReader br = new BufferedReader(new FileReader(f));
			// Print status to user
			System.out.println("The file was successfully read");
			String line = null;

			while ((line = br.readLine()) != null) {

				stopwords.add(line);

			}
			br.close();
		} else {
			// Exception handling for the user input
			throw new Exception("Invalid file name...!");
		}
	}

	/**
	 * Takes a BufferedReader as an input parameter. Then reads through the
	 * BuffereredReader line by line. For every String s in the BufferedReader the
	 * filter() method is called from the Class WordProcessing. The filtered String
	 * is then assigned a new String q. An if statement is used to check if q is in
	 * the stopwords treeset and if the string is blank. If the string contains
	 * content and is not in stopwords the addToMap method is called from the
	 * MapCreator class. The method userSetDisplayWords is then called from the
	 * Class WordProcessing. A List of <Entry<String, Integer>> is then created by
	 * calling the processMW method from the WordProcessing Class which takes the
	 * wordMap that has been created as an input parameter. The drawWC is then
	 * called from the ReallySimpleWC class to generate the word cloud.
	 * 
	 * @param br Takes a BufferedReader as an input parameter. Then reads through the
	 * BuffereredReader line by line.
	 */
	@Override
	public void parseToMap(BufferedReader br) throws Exception {
		String line;

		while ((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			for (String s : words) {
				String q = WordProcessing.filter(s);
				if (!stopwords.contains(q) && !(q.isBlank())) {
					MapCreator.addToMap(q);
				}
			}

		}
		br.close();
		// Calls the userSetDisplayWords to allow the user set the maximum words to
		// display in the word cloud
		WordProcessing.userSetDisplayWords();
		// Create a list l by processing the word map that has been generated.
		// refer to the WordProcessing class for information on the processMW method
		List<Entry<String, Integer>> l = WordProcessing.processMW(MapCreator.getWordMap());
		// Draw the word cloud using the list generated
		ReallySimpleWC.drawWC(l);
	}

}
