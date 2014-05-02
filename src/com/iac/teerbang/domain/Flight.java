package com.iac.teerbang.domain;

import java.util.LinkedList;
import java.util.List;

import android.text.format.Time;

public class Flight {

	String number;
	String departureAirport;
	String arrivalAirport;
	Time departureTime;
	Time arrivalTime;
	String checkinAgency;
	Time checkinStart;
	Time checkinEnd;
	String gate;
	String plane;
	List<Passenger> passengers;
	
	public Flight() {
		super();
	}
	
	public Flight(String number, String departureAirport,
			String arrivalAirport, Time departureTime, Time arrivalTime,
			String checkinAgency, Time checkinStart, Time checkinEnd,
			String gate, String plane) {
		super();
		this.number = number;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.checkinAgency = checkinAgency;
		this.checkinStart = checkinStart;
		this.checkinEnd = checkinEnd;
		this.gate = gate;
		this.plane = plane;
		this.passengers = new LinkedList<Passenger>();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getCheckinAgency() {
		return checkinAgency;
	}

	public void setCheckinAgency(String checkinAgency) {
		this.checkinAgency = checkinAgency;
	}

	public Time getCheckinStart() {
		return checkinStart;
	}

	public void setCheckinStart(Time checkinStart) {
		this.checkinStart = checkinStart;
	}

	public Time getCheckinEnd() {
		return checkinEnd;
	}

	public void setCheckinEnd(Time checkinEnd) {
		this.checkinEnd = checkinEnd;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public void addPassenger(Passenger passenger){
		passengers.add(passenger);
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}
	
	
	
}
