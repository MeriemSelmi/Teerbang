package com.iac.teerbang.manager;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import android.text.format.Time;

import com.iac.teerbang.domain.Flight;
import com.iac.teerbang.domain.Passenger;

public class FlightManager {

	List<Flight> fligths;
	Flight currentFlight;
	Passenger passenger;
	
	public FlightManager() {
		super();
		fligths = new LinkedList<Flight>();
		
		Time departureTime = new Time(); departureTime.set(0, 30, 19, 5, 5, 2014);
		Time arrivalTime = new Time(); arrivalTime.set(0, 30, 23, 5, 5, 2014);
		Time checkinStart = new Time(); checkinStart.set(0, 15, 17, 5, 5, 2014);
		Time checkinEnd = new Time(); checkinEnd.set(0, 0, 18, 5, 5, 2014);
		Flight flight1 = new Flight("1000AB1", "Airbus A330", "1000TN", "Tunis Carthage", "Dublin Airport", departureTime, arrivalTime, "64B", "First Class", "Tunisair", checkinStart, checkinEnd, "Gate A");
		
		departureTime.set(0, 30, 8, 5, 5, 2014);
		arrivalTime.set(0, 30, 18, 5, 5, 2014);
		checkinStart.set(0, 6, 17, 5, 5, 2014);
		checkinEnd.set(0, 0, 7, 5, 5, 2014);
		Flight flight2 = new Flight("2000AB2","Airbus A330", "2000TN", "Tunis Carthage", "Sao Paolo Airport", departureTime, arrivalTime, "68B", "First Class", "Syphax Airlines", checkinStart, checkinEnd, "Gate B");
		
		passenger = new Passenger("Bedis Tlili", "421337ABC12");
		passenger.addFlight(flight1); passenger.addFlight(flight2);
		
		fligths.add(flight1); fligths.add(flight2);
	}
	
	public Flight getFlightByPassenger(String passport, String flightNumber) throws Exception{
		for (Flight flight : fligths) {
			System.out.println(flightNumber + " " + flight.getNumber());
			if(flight.getNumber().equals(flightNumber)){
				if(flight.getPassenger().getPassport().equals(passport)){
					currentFlight = flight;
					return flight;
				}else{
					throw new Exception("No such passport number");
				}
			}
		}
		throw new Exception("No such flight number");
		
	}
	
	public String getSeatByPassenger(String passport, String flightNumber){
		return currentFlight.getSeat();
	}
}
