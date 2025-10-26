package com.courier.helper.models;

public class Package implements Comparable<Package>{
	
	private String id;
	private double weight;
	private double diatance;
	private String offer;
	private double cost;
	private double discount;
	private double deliveryTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Double getDiatance() {
		return diatance;
	}
	public void setDiatance(double diatance) {
		this.diatance = diatance;
	}
	
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
	public double getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(double deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	@Override
	public String toString() {
		return "Package [id=" + id + ", weight=" + weight + ", diatance=" + diatance + ", offer=" + offer + ", cost="
				+ cost + ", discount=" + discount + ", deliveryTime=" + deliveryTime + "]";
	}
	@Override
	public int compareTo(Package pkg) {
		Double o1= this.getWeight();
		Double o2=pkg.getWeight();
		return o1.compareTo(o1);
	}
	
	

}
