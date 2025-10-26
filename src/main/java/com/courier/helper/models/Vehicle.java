package com.courier.helper.models;

public class Vehicle {
	
	private String vehicleId;
	private double nextAvailableAt;
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Double getNextAvailableAt() {
		return nextAvailableAt;
	}
	public void setNextAvailableAt(double nextAvailableAt) {
		this.nextAvailableAt = nextAvailableAt;
	}
	@Override
	public String toString() {
		return "NextAvailableVehicle [" + vehicleId + ", nextAvailableAt=" + nextAvailableAt + "]";
	}	

}
