package com.Entity;

public class Flights {
	private int id;
	private String flightNo;
	private String depart;
	private String arrive;
	private String plane;
	private String pilotFname;
	private String pilotLname;
	public Flights(int id, String flightNo, String depart, String arrive, String plane, String pilotFname, String pilotLname) {
		this.id = id;
		this.flightNo	= flightNo;
		this.depart 	= depart;
		this.arrive		= arrive;
		this.plane 		= plane;
		this.pilotFname = pilotFname;
		this.pilotLname = pilotLname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	
	public String getPilotFname() {
		return pilotFname;
	}
	public void setPilotFname(String pilotFname) {
		this.pilotFname = pilotFname;
	}
	public String getPilotLname() {
		return pilotLname;
	}
	public void setPilotLname(String pilotLname) {
		this.pilotLname = pilotLname;
	}
	public String getPlane() {
		return plane;
	}
	public void setPlane(String plane) {
		this.plane = plane;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
}
