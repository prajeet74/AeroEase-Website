package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class FlightModel {
	private String flightID;
	private String aircraft;
	private String price;
	private LocalDate date;
	private String departureTime;
	private String arrivalTime;
	private String origin;
	private String destination;
	private String availableSeat;

	public FlightModel() {

	}

	public FlightModel(String flightID, String aircraft, String price, LocalDate date, String departureTime,
			String arrivalTime, String origin, String destination, String availableSeat) {
		super();
		this.flightID = flightID;
		this.aircraft = aircraft;
		this.price = price;
		this.date = date;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.origin = origin;
		this.destination = destination;
		this.availableSeat = availableSeat;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public String getAircraft() {
		return aircraft;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(String availableSeat) {
		this.availableSeat = availableSeat;
	}

	}