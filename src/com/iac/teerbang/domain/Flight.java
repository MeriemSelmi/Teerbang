package com.iac.teerbang.domain;

import android.text.format.Time;

public class Flight {

	Passenger passenger;
	String number;
	String plane;
	String reservationNumber;
	String departureAirport;
	String arrivalAirport;
	Time departureTime;
	Time arrivalTime;
	String seat;
	String classs;
	String checkinAgency;
	Time checkinStart;
	Time checkinEnd;
	String gate;
	
	public Flight() {
		super();
	}
	
	public Flight(String number, String plane, String reservationNumber,
			String departureAirport, String arrivalAirport, Time departureTime,
			Time arrivalTime, String seat, String classs, String checkinAgency,
			Time checkinStart, Time checkinEnd, String gate) {
		super();
		this.number = number;
		this.plane = plane;
		this.reservationNumber = reservationNumber;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seat = seat;
		this.classs = classs;
		this.checkinAgency = checkinAgency;
		this.checkinStart = checkinStart;
		this.checkinEnd = checkinEnd;
		this.gate = gate;
	}

	
	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
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

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
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

	public void setCheckinEnd(Time chekinEnd) {
		this.checkinEnd = chekinEnd;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}
	
	
}
