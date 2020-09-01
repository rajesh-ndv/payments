package com.Virtusa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Currecncy {

private String country;
	
	public String getCountry() {
		return country;
	}
	
	public Currecncy() {
		
	}

	public Currecncy(String country, Double factor, Integer forexCost) {
		this.country = country;
		this.factor = factor;
		ForexCost = forexCost;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}

	public Integer getForexCost() {
		return ForexCost;
	}

	public void setForexCost(Integer forexCost) {
		ForexCost = forexCost;
	}

	private Double factor;
	
	private Integer ForexCost;
}
