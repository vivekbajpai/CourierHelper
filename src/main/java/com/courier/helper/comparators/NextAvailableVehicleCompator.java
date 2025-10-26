package com.courier.helper.comparators;

import java.util.Comparator;

import com.courier.helper.models.Vehicle;

public class NextAvailableVehicleCompator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle vehicle1, Vehicle vehicle2) {
		
		return vehicle1.getNextAvailableAt().compareTo(vehicle2.getNextAvailableAt());
	}

}
