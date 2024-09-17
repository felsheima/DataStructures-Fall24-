package flightpack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Analyzes flight data.
 */
public class MyAnalyzer {

    /**
     * Gets the names of all unique airports in the specified state.
     *
     * @param flights Array of Flight objects.
     * @param state The state to filter airports by.
     * @return A list of unique airport names in the state.
     */
    public static ArrayList<String> getAirports(Flight[] flights, String stateAbbreviation) {
    	// Use a Set to store unique airport names
        Set<String> airportNames = new HashSet<>();
        
        // Iterate through all flights
        for (Flight flight : flights) {
            if (flight != null) {
            	// Check if the origin or destination airport is in the specified state
            	String originState = flight.getOrigin().getAirport_state();
                String destinationState = flight.getDestination().getAirport_state();
                
                // Add unique airport names to the set
                if (originState.equalsIgnoreCase(stateAbbreviation)) {
                    airportNames.add(flight.getOrigin().getAirport_name());
                }
                if (destinationState.equalsIgnoreCase(stateAbbreviation)) {
                    airportNames.add(flight.getDestination().getAirport_name());
                }
            }
        }
        // Convert the set to an ArrayList and return
        return new ArrayList<>(airportNames);
    }
    /**
     * Gets the maximum number of passengers for flights arriving at a specific airport.
     *
     * @param flights Array of Flight objects.
     * @param airport The airport code to filter flights by.
     * @return The maximum number of passengers on a flight to the specified airport.
     */
    public static int maxPassengers(Flight[] flights, String airport) {
        int maxPassengers = 0;
        
        // Iterate through all flights
        for (Flight flight : flights) {
            if (flight != null && flight.getDestination().getAirport_name().equalsIgnoreCase(airport)) {
            	// Update maxPassengers if current flight has more passengers
                if (flight.getPassengers() > maxPassengers) {
                    maxPassengers = flight.getPassengers();
                }
            }
        }
        return maxPassengers;
    }

    /**
     * Calculates the percentage of flights with no empty seats.
     *
     * @param flights Array of Flight objects.
     * @return The percentage of flights with no empty seats.
     */
    public static double percentageNoEmptySeats(Flight[] flights) {
        int totalFlights = 0;
        int flightsNoEmptySeats = 0;

        for (Flight flight : flights) {
            if (flight != null) {
                totalFlights++;
                // Count flights with no empty seats
                if (flight.getPassengers() == flight.getSeats()) {
                    flightsNoEmptySeats++;
                }
            }
        }
        // Return percentage of flights with no empty seats
        return totalFlights == 0 ? 0 : (100.0 * flightsNoEmptySeats / totalFlights);
    }
    
    /**
     * Calculates the average number of passengers on flights from a specific airport to a state in a given year.
     *
     * @param flights Array of Flight objects.
     * @param airport The airport code to filter flights from.
     * @param state The destination state to filter flights to.
     * @param year The year to filter flights by.
     * @return The average number of passengers on flights from the specified airport to the specified state in the given year.
     */
    public static double avgPassengerFromToState(Flight[] flights, String airport, String state, int year) {
    	int totalPassengers = 0;
    	int count = 0;
    
    	for (Flight flight : flights) {
    		if (flight != null && flight.getOrigin().getAirport_name().equalsIgnoreCase(airport)
    				&& flight.getDestination().getAirport_state().equalsIgnoreCase(state)
    				&& flight.getFlightDate().getYear() == year) {
    			
    			// Accumulate total passengers and count flights
    			totalPassengers += flight.getPassengers();
    			count++;
        }
    }
    	//Return average number of passengers
    	return count == 0 ? 0 : (double) totalPassengers / count;
}
}

