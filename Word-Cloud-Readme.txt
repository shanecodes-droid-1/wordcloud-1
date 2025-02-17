This project is to build a word cloud generator.
The project is a command line driven application which allows the user to specify a file path or URL and generate a word cloud based on the text content.

The enum Colours contains a selection of colors from the color api.

The class RandomColour generates a random colour from the enum Colours.
It does this by creating an array of colours from the enum Colours and then randomly generating an index position to select a colour. 

The enum FontFormat contains a series of fonts with random characteristics.

The class RandomFont generates a random font from the enum FontFormat.

The class MapCreator contains an HashMap wordMap which is used to store a frequency table of the string integer key value pair.
HashMap was used as it allows 0(1) access to add key value pairs and check for key values. Its method to create the wordMap runs in 0(1) time.

The Menu Class is a concrete class. It has an agrregation relationship with the class ParseImpl as it has a instance variable of ParseImpl which is called from the method start().
The menu class uses a switch statement with loop control variable to keep the application running until the user quits.

Parseable is an interface which contains two method checkParseFormat and parseToMap. These are abstract methods and are therefore not implemented within the interface.

ParseableImpl implements the interface Parseable. It has a dependency relationship with the WordProcessing, MapCreator and ReallySimpleWC Classes as all three are called from methods.

References for checkParseFormat()
https://stackoverflow.com/questions/25237682/how-to-know-whether-a-string-path-is-web-url-or-a-file-based
https://examples.javacodegeeks.com/core-java/net/url/read-text-from-url/
The method checkParseFormat() is implemented. It check whether the user input is a URL and if not assumes it is a File.
The BufferedReader is used and varies depending on the user input. It then calls parseToMap by inputting the BufferedReader as an input parameter.

Reference for parseIgnoreWords()
https://stackoverflow.com/questions/50907840/adding-contents-of-text-files-to-a-hash-set/50908189
parseIgnoreWords() asks the user for an ignore words file, reads from the file and adds the content to the treeset stopwords.

parseToMap takes a BufferedReader as an input parameter. It reads through the BufferedReader line by line and assigns to a string s.
This is then filtered using the filter method from the WordProcessing class and assinged to a new string. A check is then perofrmed against the stopwords treeset and for any blank content.
The string is then added to the wordMap creating a frequncy table for the string content. A method userSetDisplayWords from the WordProcessing class is called to allow the user specify the max words to display. 
A new list is then created using the processMW method from the WordProcessing class which limits the wordMap size and sorts in descending order by the frequeny value.
A word cloud is then generated by calling the drawWC method from the ReallySimpleWC class.

ReallySimpleWC is a concrete class. 
The method drawWC takes a list <String,Integer> as an input parameter. Two instance variables are assigned values for the x and y coordinates. 
A for each loop us used to iterate through the list and create a random font and colour from the two enums by calling the getRandomFont and getRandomColour from the RnadomFont and Random Colour classes.
They are then set using the graphics class and drawString is called to draw the String value from the list in the x and y coordinate. x and y are then increased so that as the loop iterated through the strings do not overlap on the image.
The graphics are then disposed to release the system resources and the image is written as a png file. 

WordProcessing is a concrete class.
userSetDisplayWord() is used to set an instance varibale which controls the maximum number of words displayed by the word cloud.
It takes the user input to set the value but uses an if statement to check if the user input is within a specified range.
A while loop is used to keep the method running until the user selectes a value within the range.

filter() takes a String s as an input parameter and converts it to lowercase, elimnates whitespace and removes non-alphabeitcal characters.
A new String lower is assinged to the filtered String and returned by the method.

processMW() takes a Map<String, Integer> wm as an input parameter. It first accesses the elements by calling entrySet() it then opens a stream and sorts the elements in descending order based on the value. 
A limit is placed on the elements based on the instance variable MWToDisplay which is accessed from a getter method. 
The collect method is then used to assign the sorted limited elements to a list called entries which is returned by the method processMW.

Runner is used to execute the program in the main method.






