package com.courier.helper.models;

import java.util.ArrayList;
import java.util.List;

public class DeliveryTrip {
	String tripId;
	String vehicleid;
	List<Package> pkgs = new ArrayList<>();
	double startTime;
	double endTime;
	
	
	public String getTripId() {
		return tripId;
	}
	public void setTripId(String tripId) {
		this.tripId = tripId;
	}
	public String getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}
	public List<Package> getPkgs() {
		return pkgs;
	}
	public void setPkgs(List<Package> pkgs) {
		this.pkgs.addAll(pkgs);
		
	}
	public double getStartTime() {
		return startTime;
	}
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	public double getEndTime() {
		return endTime;
	}
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
	

}
