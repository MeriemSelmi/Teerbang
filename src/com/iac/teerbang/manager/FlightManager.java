package com.iac.teerbang.manager;

import java.util.Currency;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import android.text.format.Time;

import com.iac.teerbang.domain.Flight;
import com.iac.teerbang.domain.Passenger;

public class FlightManager {

	List<Flight> fligths;
	Flight currentFlight ; 
	
	public FlightManager() {
		super();
		fligths = new LinkedList<Flight>();
		
		Time departureTime = new Time(); departureTime.set(0, 30, 19, 5, 5, 2014);
		Time arrivalTime = new Time(); arrivalTime.set(0, 30, 23, 5, 5, 2014);
		Time checkinStart = new Time(); checkinStart.set(0, 15, 17, 5, 5, 2014);
		Time checkinEnd = new Time(); checkinEnd.set(0, 0, 18, 5, 5, 2014);

		Flight flight = new Flight("1000AB1", "Tunis Carthage", "Dublin Airport", departureTime, arrivalTime, "Tunisair", checkinStart, checkinEnd, "Gate A", "Airbus A330");
		Passenger passenger = new Passenger("Bedis Tlili", "res01", "4A", "First Class");
		flight.addPassenger(passenger);
		fligths.add(flight);
		
		departureTime.set(0, 30, 8, 5, 5, 2014);
		arrivalTime.set(0, 30, 18, 5, 5, 2014);
		checkinStart.set(0, 6, 17, 5, 5, 2014);
		checkinEnd.set(0, 0, 7, 5, 5, 2014);
	
		flight = new Flight("2000AB2", "Tunis Carthage", "Sao Paolo Airport", departureTime, arrivalTime, "Syphax Airlines", checkinStart, checkinEnd, "Gate B", "Airbus A330");
		passenger = new Passenger("Khoubeib Selmi", "res02", "2B", "Business Class");
		flight.addPassenger(passenger);
		fligths.add(flight);
	}
	
	public Flight getFlightByPassenger(String reservationNumber, String flightNumber) throws Exception{
		for (Flight flight : fligths) {
			if(flight.getNumber().equals(flightNumber)){
				for (Passenger passenger : flight.getPassengers()) {
					if(passenger.getReservationNumber().equals(reservationNumber)){
						currentFlight = flight;
						return flight;
					}
				}
				throw new Exception("No such reservation number");
				}
			}
		throw new Exception("No such flight number");
		
	}
	
	public Passenger getPassengerByReservation(String reservationNumber) throws Exception{
		for (Flight flight : fligths) {
				for (Passenger passenger : flight.getPassengers()) {
					if(passenger.getReservationNumber().equals(reservationNumber)){
						return passenger;
					}
				}
			}
		throw new Exception("No such reservation number");
	}
	
	public String getSeatByReservation(String reservationNumber) throws Exception{
		Passenger passenger = getPassengerByReservation(reservationNumber);
		return passenger.getSeat();
	}
}
