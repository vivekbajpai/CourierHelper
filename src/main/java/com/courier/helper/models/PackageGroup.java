package com.courier.helper.models;

import java.util.List;

public class PackageGroup {
	
	List<Package> pkg;
	int packageCount;
	int totalwait;
	
	public List<Package> getPkg() {
		return pkg;
	}
	public void setPkg(List<Package> pkg) {
		this.pkg = pkg;
	}
	public int getPackageCount() {
		return packageCount;
	}
	public void setPackageCount(int packageCount) {
		this.packageCount = packageCount;
	}
	public int getTotalwait() {
		return totalwait;
	}
	public void setTotalwait(int totalwait) {
		this.totalwait = totalwait;
	}
	
	

}
