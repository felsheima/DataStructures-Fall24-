package flightpack;
/**
 * Represents an airport with its name, city, and state.
 */
public class Airport {

	private String airport_name;
	private String airport_city;
	private String airport_state;
	
	 /**
     * Constructs an Airport object with the specified name, city, and state.
     *
     * @param name  The name of the airport
     * @param city  The city where the airport is located
     * @param state The state where the airport is located
     */
	
	public Airport(String name, String city,String state) {
		airport_name = name;
		airport_city = city; 
		airport_state = state;
	}

    /**
     * Gets the state where the airport is located.
     *
     * @return The state of the airport
     */
	public String getAirport_state() {
		return airport_state;
	}
    /**
     * Sets the state where the airport is located.
     *
     * @param airport_state The new state of the airport
     */
	public void setAirport_state(String airport_state) {
		this.airport_state = airport_state;
	}
    /**
     * Gets the city where the airport is located.
     *
     * @return The city of the airport
     */
	public String getAirport_city() {
		return airport_city;
	}
    /**
     * Sets the city where the airport is located.
     *
     * @param airport_city The new city of the airport
     */
	public void setAirport_city(String airport_city) {
		this.airport_city = airport_city;
	}
    /**
     * Gets the name of the airport.
     *
     * @return The name of the airport
     */
	public String getAirport_name() {
		return airport_name;
	}
    /**
     * Sets the name of the airport.
     *
     * @param airport_name The new name of the airport
     */
	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}
    /**
     * Returns a string representation of the Airport object.
     *
     * @return A string in the format "Airport Name: [name], City: [city], State: [state]"
     */
	@Override
	public String toString() {
		return "Airport Name: " + airport_name + ", City: " + airport_city + ", State: " + airport_state;
	}
	

	}

