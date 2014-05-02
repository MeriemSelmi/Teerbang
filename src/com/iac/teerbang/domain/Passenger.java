package com.iac.teerbang.domain;

public class Passenger {

	String name;
	String reservationNumber;
	String seat;
	String classs;
	
	public Passenger() {
		super();
	}
	public Passenger(String name, String reservationNumber, String seat, String classs) {
		this.name = name;
		this.reservationNumber = reservationNumber;
		this.seat = seat;
		this.classs = classs;
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
	
	
	
}
