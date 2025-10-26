package com.courier.helper.models;

public class OffersCriterea {
	
	private String name;
	private double minDistance;
	private double maxDistance;
	private double minWeight;
	private double maxWeight;
	private double discount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMinDistance() {
		return minDistance;
	}
	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}
	public double getMaxDistance() {
		return maxDistance;
	}
	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}
	public double getMinWeight() {
		return minWeight;
	}
	public void setMinWeight(double minWeight) {
		this.minWeight = minWeight;
	}
	public double getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}	

	
}
