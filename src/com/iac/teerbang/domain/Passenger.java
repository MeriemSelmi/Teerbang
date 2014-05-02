package com.iac.teerbang.domain;

import java.util.LinkedList;
import java.util.List;

public class Passenger {

	String name;
	String passport;
	List<Flight> flights;
	
	public Passenger() {
		super();
		flights = new LinkedList<Flight>();
	}

	public Passenger(String name, String passport) {
		super();
		this.name = name;
		this.passport = passport;
		this.flights = new LinkedList<Flight>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void addFlight(Flight flight) {
		flight.setPassenger(this);
		this.flights.add(flight);
	}
	
	
	
	
}
