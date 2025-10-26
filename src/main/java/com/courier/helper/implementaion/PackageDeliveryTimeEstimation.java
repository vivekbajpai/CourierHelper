package com.courier.helper.implementaion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.courier.helper.comparators.NextAvailableVehicleCompator;
import com.courier.helper.comparators.PackageDistanceCompartor;
import com.courier.helper.models.DeliveryTrip;
import com.courier.helper.models.Package;
import com.courier.helper.models.PackageGroup;
import com.courier.helper.models.Vehicle;
import com.courier.helper.models.VehiclesInfo;
import com.courier.helper.services.EstimationService;

@Service
@Qualifier("PackageDeliveryTimeEstimation")
public class PackageDeliveryTimeEstimation extends PackageDeliveryCostEstimation implements EstimationService {

	Logger logger = LoggerFactory.getLogger(PackageDeliveryTimeEstimation.class);
	private List<DeliveryTrip> delveryTrips = new ArrayList<>();
	private List<Package> scheduledPackage = new ArrayList<Package>();
	private List<Package> excludedPackage = new ArrayList<Package>();
	private List<Vehicle> nextAvailableVehicle = new ArrayList<>();

	private VehiclesInfo vehiclesInfo;

	@Override
	public void estimate() {
		estimatePackageCostsandDelivertyTime();
		display();

	}

	private void estimatePackageCostsandDelivertyTime() {
		estimatePackageCosts();
		vehiclesInfo = new VehiclesInfo();
		while (true) {
			String line = console
					.readLine("Enter vehicle details as no_of_vehicles max_speed max_carriable_weight e.g 2 70 200: ");
			String[] values = line.split(" ");
			if (values.length == 3) {
				vehiclesInfo.setCount(Integer.parseInt(values[0]));
				vehiclesInfo.setSpeed(Integer.parseInt(values[1]));
				vehiclesInfo.setCapacityWeight(Integer.parseInt(values[2]));
				break;
			}

		}

		setUpAvailbleVehicles(vehiclesInfo.getCount());
		excludeHaveyPackages();
		createDeliveryTrips();
		scheduleDeliveryTrips();
	}

	private void createDeliveryTrips() {
		logger.info("Creating the delivery trips");
		int tripId = 0;
		while (!listPackage.isEmpty()) {
			tripId++;
			Collections.sort(listPackage);			
			DeliveryTrip trip = new DeliveryTrip();
			trip.setTripId("trip_" + tripId);
			List<Package> pkgs1 = new ArrayList<>();
			double capcity = 0;
			for (Package item : listPackage) {

				if (capcity + item.getWeight() < vehiclesInfo.getCapacityWeight()) {
					capcity = capcity + item.getWeight();
					pkgs1.add(item);

				}
			}
			scheduledPackage.addAll(pkgs1);
			listPackage.removeAll(pkgs1);
			trip.setPkgs(pkgs1);
			delveryTrips.add(trip);

		}

	}

	private void setUpAvailbleVehicles(int no_vehicle) {
		logger.info("Configuaring vehicles." + no_vehicle);

		int in = 0;
		while (in < no_vehicle) {
			in++;
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleId("vehicle_" + in);
			vehicle.setNextAvailableAt(0.0);
			nextAvailableVehicle.add(vehicle);
		}

	}

	private void scheduleDeliveryTrips() {
		logger.info("Schedulings Trips.");
		for (DeliveryTrip trip : delveryTrips) {
			Optional<Vehicle> vehicleOpt = nextAvailableVehicle.stream().min(new NextAvailableVehicleCompator());
			Vehicle nextAvailble = vehicleOpt.get();
			trip.setVehicleid(nextAvailble.getVehicleId());
			
			double tripStartTime = nextAvailble.getNextAvailableAt();
			double totalTriptime = calculateTotolTripTime(trip);

			nextAvailble.setNextAvailableAt((tripStartTime + totalTriptime));
			setPackageDelivertTime(trip, tripStartTime);

			trip.setStartTime(tripStartTime);
			trip.setEndTime(tripStartTime + totalTriptime);

		}

	}

	private double calculateTotolTripTime(DeliveryTrip trip) {
		logger.info("Calculating Total Trip time for trip." + trip.getTripId());

		Optional<Package> pkgOpt = trip.getPkgs().stream().max(new PackageDistanceCompartor());
		System.out.println(trip.getPkgs().toString());
		System.out.println(pkgOpt.get().toString());
		double totalTripDistance = pkgOpt.get().getDiatance() * 2;
		double totalTripTime = (totalTripDistance / vehiclesInfo.getSpeed());
		return totalTripTime;

	}

	private void setPackageDelivertTime(DeliveryTrip trip, double tripStartTime) {

		for (Package pkg : trip.getPkgs()) {
			double packageDeliveryTime = (pkg.getDiatance() / vehiclesInfo.getSpeed());
			pkg.setDeliveryTime((tripStartTime + packageDeliveryTime));
		}

	}

	private void excludeHaveyPackages() {
		logger.info("Excluding heavey packages from the trip.");
		List<Package> pkgs1 = new ArrayList<>();
		for (Package item : listPackage) {

			if (item.getWeight() > vehiclesInfo.getCapacityWeight()) {
				pkgs1.add(item);

			}
		}
		excludedPackage.addAll(pkgs1);
		listPackage.removeAll(pkgs1);
	}

	private void display() {
		System.out.println("\nPackage delivery time estimation\n");
		for (Package pkg : scheduledPackage) {
			System.out
					.println(pkg.getId() + " " + pkg.getDiscount() + " " + pkg.getCost() + " " + pkg.getDeliveryTime());
		}
		System.out.println("\nDelivery Trips:\n");
		for (DeliveryTrip trip : delveryTrips) {
			System.out.println(trip.getTripId() + " " + trip.getPkgs().toString() + " " + trip.getVehicleid());
		}
		
		if (excludedPackage.size()>=1) {
			System.out.println("\nPackage excluded from delivery:\n");
			for (Package pkg : excludedPackage) {
				System.out
						.println(pkg.getId());
			}
			
		}
	}
	
	private void deliveryUtil() {
		int Count=0;
		List<PackageGroup> grp = new ArrayList<>();
		Map<String, List<Package>> group = new HashMap<>();
		Map<Integer, List<Package>> group2 = new HashMap<>();
		Map<Integer, List<Package>> group3 = new HashMap<>();
		while (!listPackage.isEmpty()) {
		PackageGroup pg = new PackageGroup();
		List<Package> pkgs = new ArrayList<>();
		for(Package pkg:listPackage) {
			double capcity = 0;
			for (Package item : listPackage) {

				if (capcity + item.getWeight() < vehiclesInfo.getCapacityWeight()) {
					capcity = capcity + item.getWeight();
					pkgs.add(item);

				}
			}
			
		}
		pg.setPkg(pkgs);
		listPackage.removeAll(pkgs);		
	 }
		
		for(String key:group.keySet()) {
			int c= group.get(key).size();
			if(!group2.containsKey(c)) {
				group2.put(c, group.get(key));
			}
			else if(group2.containsKey(c) && !group3.containsKey(c) ) {
				List<Package> temp = group.get(key);
				temp.addAll(group2.get(c));
				group3.put(c, temp);
			}
			
			
		}
		
	}




}
