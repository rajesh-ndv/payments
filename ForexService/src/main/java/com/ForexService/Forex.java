package com.ForexService;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Forex {

	@Id
	private String country;
	
	public String getCountry() {
		return country;
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
