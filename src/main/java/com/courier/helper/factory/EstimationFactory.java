package com.courier.helper.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.courier.helper.services.EstimationService;

@Component
public class EstimationFactory {

	EstimationService packageDeliveryTimeEstimation;
	EstimationService packageDeliveryCostEstimation;

	@Autowired
	public EstimationFactory(
			@Qualifier("PackageDeliveryTimeEstimation") EstimationService packageDeliveryTimeEstimation,
			@Qualifier("PackageDeliveryCostEstimation") EstimationService packageDeliveryCostEstimation) {
		this.packageDeliveryCostEstimation = packageDeliveryCostEstimation;
		this.packageDeliveryTimeEstimation = packageDeliveryTimeEstimation;
	}

	public void estimate(String opt) {
		switch (opt) {
		case "1":
			System.out.println();
			packageDeliveryCostEstimation.estimate();
			break;

		case "2":
			packageDeliveryTimeEstimation.estimate();
			break;
		}

	}

}
