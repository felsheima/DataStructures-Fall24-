package flightpack;

import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This class provides methods to read and parse flight data from a CSV file.
 */

public class MyDataReader {
	
	//Define the DateTimeFormatter to parse the date-time format used in the CSV file
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH");	

	 /**
     * Reads flight data from a CSV file and returns an array of Flight objects.
     *
     * @param filePath The path to the CSV file.
     * @return An array of Flight objects read from the file.
     * @throws IOException If an error occurs while reading the file.
     */
	
	 public static Flight[] readFlights(String filePath) throws IOException {
		 // Initialize BufferedReader to read the file
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            // Assuming there are 3M records; initialize array with that size
	            Flight[] flights = new Flight[3000000];
	            String line;
	            int index = 0;

	            // Skip header line
	            br.readLine();
	            
	            // Read each line from the file
	            while ((line = br.readLine()) != null) {
	                try {
	                	// Parse the flight data from the line
	                    Flight flight = parseFlight(line);
	                    // Store the flight object in the array
	                    flights[index++] = flight;
	                } catch (IllegalArgumentException e) {
	                    // Log or handle invalid lines here
	                }
	            }
	         // Return the array of Flight objects
	            return flights;
	        }
	    }
	 
/**
* Parses a line of text to create a Flight object.
*
* @param inputLine The line of text representing flight data.
* @return A Flight object created from the data in the input line.
* @throws IllegalArgumentException If the input line does not have the expected number of fields.
*/
	 
	private static Flight parseFlight(String inputLine) {
		//Split the input lines by commas 
	    String[] items = inputLine.split(",");
	    // Ensure that the line has the correct number of fields
	    if (items.length < 10) {
		    throw new IllegalArgumentException("Input line must have 10 fields.");
	}
	//process each item 
	    String originName = items[0];
	    String originCity = items[1];
	    String originState = items[2];
	    String destinationName = items[3];
	    String destinationCity = items[4];
		String destinationState = items[5];
		int passengers = Integer.parseInt(items[6]);
		int seats = Integer.parseInt(items[7]);
		int distance = Integer.parseInt(items[8]);
		LocalDateTime flightDate = dateConvert(items[9]);
		
		
	
		// Create and return a new Flight object using the extracted data
		return new Flight (originName, originCity, originState, destinationName, destinationCity, destinationState, passengers, seats, distance, flightDate);
	}
	
/**
* Converts a string representation of a date-time to a LocalDateTime object.
*
* @param dateTimeString The string representation of the date-time.
* @return The LocalDateTime object corresponding to the input string.
*/
	
	public static LocalDateTime dateConvert(String dateTimeString) {
		//convert the string to LocalDateTime using the formatter 
		return LocalDateTime.parse(dateTimeString, formatter);
	}
	
}
/**
 * @References
 * Lee, Alex. “Java: Read a CSV File into an Array #49.” YouTube, YouTube, www.youtube.com/watch?v=-Aud0cDh-J8. Accessed 17 Sept. 2024. 
 * Gupta, L. (14 September, 2022). Parse and Read a CSV File in Java. HowToDoInJava. https://howtodoinjava.com/java/io/parse-csv-files-in-java/
 *Geeksforgeeks. (28 June, 2022). Reading a CSV file in java using OpenCSV. geeksforgeeks. https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
 *Geeksforgeeks. (02 Sep, 2024). Arrays in Java. geeksforgeeks. https://www.geeksforgeeks.org/arrays-in-java/
 *W3Schools. (n.d.). Java Constructors. W3Schools. https://www.w3schools.com/java/java_constructors.asp
 * 
 */
