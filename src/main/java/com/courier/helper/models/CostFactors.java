package com.courier.helper.models;

public class CostFactors {
	
	double chargesPerKg;
	double chargesPerKm;
	
	public CostFactors(double chargesPerKg, double chargesPerKm) {
		super();
		this.chargesPerKg = chargesPerKg;
		this.chargesPerKm = chargesPerKm;
	}
	public double getChargesPerKg() {
		return chargesPerKg;
	}
	public void setChargesPerKg(double chargesPerKg) {
		this.chargesPerKg = chargesPerKg;
	}
	public double getChargesPerKm() {
		return chargesPerKm;
	}
	public void setChargesPerKm(double chargesPerKm) {
		this.chargesPerKm = chargesPerKm;
	}
	
}
