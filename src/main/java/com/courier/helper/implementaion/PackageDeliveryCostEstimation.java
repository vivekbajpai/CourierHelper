package com.courier.helper.implementaion;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.courier.helper.models.Package;
import com.courier.helper.services.EstimationService;
import com.courier.helper.utils.CourierHelperUtils;

/***
 * 
 */

@Component
@Qualifier("PackageDeliveryCostEstimation")
public class PackageDeliveryCostEstimation implements EstimationService {

	Logger logger = LoggerFactory.getLogger(PackageDeliveryCostEstimation.class);

	@Autowired
	CourierHelperUtils courierHelperUtils;

	Console console = System.console();
	double basePrice;
	int packageCount;

	protected List<Package> listPackage = new ArrayList<>();

	@Override
	public void estimate() {
		
		estimatePackageCosts();
		diplayPackageCost();

	}

	protected void estimatePackageCosts() {
		courierHelperUtils.loadOffersFromCSV(courierHelperUtils.getValue(courierHelperUtils.OFFERS_FILE));
		try {
			while (true) {
				String line = console.readLine("Enter Base Price and Package Count e.g. 100 3: ");
				String[] values = line.split(" ");
				if (values.length == 2) {
					basePrice = Double.parseDouble(values[0]);
					packageCount = Integer.parseInt(values[1]);
					break;
				}
			}

		} catch (NumberFormatException e) {
			logger.error("Please enter base price as double and package as interger");

		}

		int count = 0;
		while (count < packageCount) {
			Package pkg = new Package();
			System.out.println("Enter Details for Package Item: " + (count + 1));
			while (true) {
				String line = console
						.readLine("Enter Package details as pkg_Id weight distance offer_code e.g PKG1 10 20 OFR001: ");
				String[] values = line.split(" ");
				if (values.length == 4) {
					pkg.setId(values[0]);
					pkg.setWeight(Double.parseDouble(values[1]));
					pkg.setDiatance(Double.parseDouble(values[2]));
					pkg.setOffer(values[3]);
					courierHelperUtils.setPackageDiscountAndCost(basePrice, pkg);
					break;
				}

			}
			listPackage.add(pkg);
			count++;
		}

	}
	
	private void diplayPackageCost() {
		
		System.out.println("Package Cost Estimations");
		for(Package pkg: listPackage) {
			System.out.println(pkg.getId()+" "+pkg.getDiscount()+" "+pkg.getCost());
		}
	}

}
