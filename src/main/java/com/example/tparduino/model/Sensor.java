package com.example.tparduino.model;

public class Sensor {
	private String sensorId;
	private String fecha;

	public Sensor() {
		super();
	}


	public Sensor(String sensorId, String fecha) {
		super();
		this.sensorId = sensorId;
		this.fecha = fecha;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}