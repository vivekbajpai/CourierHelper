package com.courier.helper.implementaion;

import com.courier.helper.services.CostCalculator;


public class CourierWaitDistanceCost implements CostCalculator {
	
	double baseCoost;
	double weight;
	double ratePerKg;
	double distance;
	double ratePerKm;
	int discountRate;
	double discount;
	double deliveryCost;
	
	public CourierWaitDistanceCost(double baseCoost, double weight, double ratePerKg, double distance, double ratePerKm,
			int discountRate) {
		super();
		this.baseCoost = baseCoost;
		this.weight = weight;
		this.ratePerKg = ratePerKg;
		this.distance = distance;
		this.ratePerKm = ratePerKm;
		this.discountRate = discountRate;
	}	
	
	@Override
	public double calculateTotalCost() {
		
		return (deliveryCost-discount);
	}

	@Override
	public double calculateDiscount() {	
		
		deliveryCost=(baseCoost+(weight*ratePerKg)+(distance*ratePerKm));
		if(discountRate >0) {						
			discount = deliveryCost*(discountRate*0.01);			
		}
		
	 return discount;
		
	}

}
