package flightpack;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

/**
 * Main class to run the analysis on flight data.
 */
public class program1 {

    /**
     * Main method to execute the flight data analysis.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // Change this to your relative file path
        String filePath = "/Users/Felsh/OneDrive/Desktop/flights.csv/";

        try {
            // Measure time to read the file
            long timeToReadFile = measureTime(() -> {
				try {
					MyDataReader.readFlights(filePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
            System.out.println("Time to read the file: " + timeToReadFile + " milliseconds");

            // Analyze and print results
            analyzeAndPrintResults(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Measures the time taken by a given task.
     * @param task The task to be measured.
     * @return Time taken in milliseconds.
     */
    private static long measureTime(Task task) {
        Instant start = Instant.now();
        task.execute();
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

    /**
     * Analyzes flight data and prints results for each task.
     * @param filePath Path to the CSV file.
     */
    private static void analyzeAndPrintResults(String filePath) throws IOException {
        Flight[] flights = MyDataReader.readFlights(filePath);

        // Task 4.a
        long timeForTask4a = measureTime(() -> printMaineAirports(flights));
        System.out.println("Time for task 4.a: " + timeForTask4a + " milliseconds");

        // Task 4.b
        long timeForTask4b = measureTime(() -> printMaxPassengers(flights, "PWM"));
        System.out.println("Time for task 4.b: " + timeForTask4b + " milliseconds");

        // Task 4.c
        long timeForTask4c = measureTime(() -> printPercentageNoEmptySeats(flights));
        System.out.println("Time for task 4.c: " + timeForTask4c + " milliseconds");

        // Task 4.d
        long timeForTask4d = measureTime(() -> printAvgPassengers(flights, "PWM", "FL", 2009));
        System.out.println("Time for task 4.d: " + timeForTask4d + " milliseconds");
    }

    /**
     * Prints the names of all airports in the state of Maine.
     * @param flights Array of Flight objects.
     */
    private static void printMaineAirports(Flight[] flights) {
        ArrayList<String> maineAirports = MyAnalyzer.getAirports(flights, "ME");
        System.out.println("Name of all the airports in the state of Maine: " + maineAirports);
    }

    /**
     * Prints the maximum number of passengers coming to a specific airport.
     * @param flights Array of Flight objects.
     * @param airport Airport code.
     */
    private static void printMaxPassengers(Flight[] flights, String airport) {
        int maxPassengers = MyAnalyzer.maxPassengers(flights, airport);
        System.out.println("The maximum number of passengers coming to " + airport + ": " + maxPassengers);
    }

    /**
     * Prints the percentage of flights with no empty seats.
     * @param flights Array of Flight objects.
     */
    private static void printPercentageNoEmptySeats(Flight[] flights) {
        double percentageNoEmptySeats = MyAnalyzer.percentageNoEmptySeats(flights);
        System.out.printf("The percentage of the flights with no empty seats: %.2f%%\n", percentageNoEmptySeats);
    }

    /**
     * Prints the average number of passengers on flights from one airport to a state in a given year.
     * @param flights Array of Flight objects.
     * @param airport Airport code.
     * @param state Destination state.
     * @param year Year of the flights.
     */
    private static void printAvgPassengers(Flight[] flights, String airport, String state, int year) {
        double avgPassengers = MyAnalyzer.avgPassengerFromToState(flights, airport, state, year);
        System.out.printf("The average number of passengers on flights from %s to %s in %d: %.2f\n", airport, state, year, avgPassengers);
    }

    /**
     * Functional interface for tasks that need timing.
     */
    @FunctionalInterface
    private interface Task {
        void execute();
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
