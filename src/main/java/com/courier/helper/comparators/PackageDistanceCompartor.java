package com.courier.helper.comparators;

import java.util.Comparator;

import com.courier.helper.models.Package;

public class PackageDistanceCompartor implements Comparator<Package> {

	@Override
	public int compare(Package pkg1, Package pkg2) {
		
		return pkg1.getDiatance().compareTo(pkg2.getDiatance());
	}

}
