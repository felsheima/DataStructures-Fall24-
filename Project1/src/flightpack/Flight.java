package flightpack;

import java.time.LocalDateTime;

/**
 * Represents a flight with details such as origin, destination, passengers, seats, distance, and flight date.
 */

public class Flight {

	private Airport origin;
	private Airport destination;
	private int passengers;
	private int seats;
	private int distance; 
	private LocalDateTime flightDate;
	
	 /**
     * Constructs a Flight object with the specified details.
     *
     * @param originName       The name of the origin airport
     * @param originCity       The city of the origin airport
     * @param originState      The state of the origin airport
     * @param destinationName  The name of the destination airport
     * @param destinationCity  The city of the destination airport
     * @param destinationState The state of the destination airport
     * @param passengers       The number of passengers on the flight
     * @param seats            The number of seats available on the flight
     * @param distance         The distance of the flight in miles
     * @param flightDate       The date and time of the flight
     */
	
	public Flight(String originName, String originCity, String originState, String destinationName, String destinationCity, String destinationState, int passengers,
			int seats, int distance, LocalDateTime flightDate) {
		
		this.origin = new Airport(originName, originCity, originState);
		this.destination = new Airport(destinationName, destinationCity, destinationState);
		this.passengers = passengers;
		this.seats = seats;
		this.distance = distance;
		this.flightDate = flightDate;
	}
    /**
     * Gets the airport where the flight originates.
     *
     * @return The origin airport
     */
	public Airport getOrigin() {
		return origin;
	}
    /**
     * Sets the airport where the flight originates.
     *
     * @param origin The new origin airport
     */
	public void setOrigin(Airport origin) {
		this.origin = origin;
	}
    /**
     * Gets the airport where the flight arrives.
     *
     * @return The destination airport
     */
    public Airport getDestination() {
        return destination;
    }

    /**
     * Sets the airport where the flight arrives.
     *
     * @param destination The new destination airport
     */
    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    /**
     * Gets the number of passengers on the flight.
     *
     * @return The number of passengers
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Sets the number of passengers on the flight.
     *
     * @param passengers The new number of passengers
     */
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    /**
     * Gets the number of seats available on the flight.
     *
     * @return The number of seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Sets the number of seats available on the flight.
     *
     * @param seats The new number of seats
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * Gets the distance of the flight in miles.
     *
     * @return The distance of the flight
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Sets the distance of the flight in miles.
     *
     * @param distance The new distance of the flight
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Gets the date and time of the flight.
     *
     * @return The flight date and time
     */
    public LocalDateTime getFlightDate() {
        return flightDate;
    }

    /**
     * Sets the date and time of the flight.
     *
     * @param flightDate The new flight date and time
     */
    public void setFlightDate(LocalDateTime flightDate) {
        this.flightDate = flightDate;
    }

    /**
     * Returns a string representation of the Flight object.
     *
     * @return A string in the format "Flight Airport Origin: [origin], Airport Destination: [destination], Passengers: [passengers], Seats: [seats], Distance: [distance], FlightDate: [flightDate]"
     */
	@Override 
	public String toString() {
		return "Flight Airport Origin: " + origin + " Airport Destination: " + destination + "Passengers: " + passengers + "Seats: " + seats + "Distance: " + distance + "FlightDate: " + flightDate;
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
