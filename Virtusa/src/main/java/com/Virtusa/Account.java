package com.Virtusa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private Integer AccountId;
	private String Country;
	private int Amt;
	public Integer getAccountId() {
		return AccountId;
	}
	public void setAccountId(Integer accountId) {
		AccountId = accountId;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getAmt() {
		return Amt;
	}
	public void setAmt(int amt) {
		Amt = amt;
	}	
	
}
