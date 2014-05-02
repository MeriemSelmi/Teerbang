package com.iac.teerbang.domain;

import java.util.LinkedList;
import java.util.List;

public class Passenger {

	String name;
	String reservationNumber;
	List<Flight> flights;
	
	public Passenger() {
		super();
		flights = new LinkedList<Flight>();
	}

	public Passenger(String name, String reservationNumber) {
		super();
		this.name = name;
		this.reservationNumber = reservationNumber;
		this.flights = new LinkedList<Flight>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void addFlight(Flight flight) {
		flight.setPassenger(this);
		this.flights.add(flight);
	}
	
	
	
	
}
