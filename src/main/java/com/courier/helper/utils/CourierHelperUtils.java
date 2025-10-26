package com.courier.helper.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.courier.helper.implementaion.CourierWaitDistanceCost;
import com.courier.helper.master.CourierHelperMaster;
import com.courier.helper.models.CostFactors;
import com.courier.helper.models.OffersCriterea;
import com.courier.helper.models.Package;
import com.courier.helper.services.CostCalculator;

@Component
public class CourierHelperUtils {
	
	@Autowired
	ApplicationProperties applicationProperties;	
	
	CostCalculator  costCalculator;
	CostFactors costFactors;
	
	final String RATE_PER_KG="ratePerKg";
	final String RATE_PER_KM="ratePerKm";
	final public String OFFERS_FILE="offersCSVFile";
	Logger logger = LoggerFactory.getLogger(CourierHelperUtils.class);
	
	
	Map<String, OffersCriterea> offerMap = new HashMap<String, OffersCriterea>();
	
	
  public void loadOffersFromCSV(String csvPath){
		
	 // logger.info("Loading offers from: "+ csvPath);
	  
		try(BufferedReader br = new BufferedReader(new FileReader(csvPath))){
			String line;			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				OffersCriterea offerCriteria = new OffersCriterea();
				offerCriteria.setName(values[0]);
				offerCriteria.setDiscount(validateDoubleValue(values[1]));
				offerCriteria.setMinDistance(validateDoubleValue(values[2]));
				offerCriteria.setMaxDistance(validateDoubleValue(values[3]));
				offerCriteria.setMinWeight(validateDoubleValue(values[4]));
				offerCriteria.setMaxWeight(validateDoubleValue(values[5]));
				offerMap.put(values[0], offerCriteria);
				
			}
			
			
		}catch(NumberFormatException ex) {
			logger.error("File format is not coorect, Please check the file "+csvPath + ex.getMessage());
			ex.printStackTrace();
		}
		catch(IOException ex) {
			logger.error(ex.getMessage());						
			ex.printStackTrace();
			
		}	
		
	}
	
	public  CostFactors getCostPerunit() {
		// logger.info("Collecting cost factors details");
		if(costFactors == null) {
			double ratePerKg = Double.parseDouble(applicationProperties.getValue(RATE_PER_KG));
			double ratePerKm = Double.parseDouble(applicationProperties.getValue(RATE_PER_KM));
			costFactors = new CostFactors(ratePerKg, ratePerKm);
			
		}	
		
		return costFactors;
		
	}
	
	private int calcuateOfferedDiscount(Package pkg) {
	 // logger.info("Discount Calculation for Package"+pkg.getId());
		int discount=0;
		OffersCriterea offerItem = offerMap.get(pkg.getOffer());
		
		if (offerItem == null)
			 return discount;
		if ((offerItem.getMaxDistance()<offerItem.getMinDistance()) && (pkg.getDiatance()>offerItem.getMinDistance()))
		{
			if((checkOfferWeight(offerItem,pkg)))			{
				
				discount = (int) offerItem.getDiscount();
			}
		}
		if((pkg.getDiatance()>= offerItem.getMinDistance()) && (pkg.getDiatance()<= offerItem.getMaxDistance()))	
		
		{
			if((checkOfferWeight(offerItem,pkg)))
			{
				discount = (int) offerItem.getDiscount();				
			}
		}	
		
		return discount;
		
	}
	
	private boolean checkOfferWeight(OffersCriterea offerItem, Package pkg) {
		
		if((pkg.getWeight() >= offerItem.getMinWeight()) && ((pkg.getWeight() <= offerItem.getMaxWeight())))
		{
			System.out.println("checkOfferWeight");
			return true;
			}
		
		return false;	
		
	}
	
	public String getValue(String key) {
		return applicationProperties.getValue(key);
	}
	
	private double validateDoubleValue(String value) {
		if (value.trim().length()==0)
			return 0;
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			logger.error("Please Validate the OFFERS CSV File. " +e.getMessage());			
			throw new NumberFormatException();			
		}
		
	}
	
	public void setPackageDiscountAndCost(Double baseCost,Package pkg) {
		if( costFactors == null)
			getCostPerunit();
		    costCalculator = new CourierWaitDistanceCost(baseCost, pkg.getWeight(),costFactors.getChargesPerKg(),pkg.getDiatance(),costFactors.getChargesPerKm(),calcuateOfferedDiscount(pkg));
		    pkg.setDiscount(costCalculator.calculateDiscount());
		    pkg.setCost(costCalculator.calculateTotalCost());
	}
	

	
}
