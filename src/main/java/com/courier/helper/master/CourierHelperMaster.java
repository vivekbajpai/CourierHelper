package com.courier.helper.master;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.courier.helper.comparators.NextAvailableVehicleCompator;
import com.courier.helper.comparators.PackageDistanceCompartor;
import com.courier.helper.factory.EstimationFactory;
import com.courier.helper.models.DeliveryTrip;
import com.courier.helper.models.Package;
import com.courier.helper.models.Vehicle;
import com.courier.helper.models.VehiclesInfo;
import com.courier.helper.utils.CourierHelperUtils;

@Component
public class CourierHelperMaster {
	
	Console console = System.console();
	
	@Autowired
	EstimationFactory estimationFactory;
	
	public void startCourerHelperService() {
		System.out.println("Enter 1 for Package cost Estimations.\n"
				         + "      2 for Package Delivery Estimations.");
		String line = console.readLine("Enter Option: ");
		estimationFactory.estimate(line);
		
	}
	
}	