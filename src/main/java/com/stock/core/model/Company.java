package com.stock.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Company {

	@Id
	private String companyID;

	@ElementCollection(targetClass = String.class)
	private List<String> countries = new ArrayList<String>();

	private int budget;
	private String budgetUnit;
	private int bid;
	private String bidUnit;

	@Version
	private Integer version;

	@ElementCollection(targetClass = String.class)
	private List<String> categories = new ArrayList<String>();

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getBudgetUnit() {
		return budgetUnit;
	}

	public void setBudgetUnit(String budgetUnit) {
		this.budgetUnit = budgetUnit;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBidUnit() {
		return bidUnit;
	}

	public void setBidUnit(String bidUnit) {
		this.bidUnit = bidUnit;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return String
				.format("Company [companyID=%s, budget=%s, budgetUnit=%s, bid=%s, bidUnit=%s]",
						companyID, budget, budgetUnit, bid, bidUnit);
	}

}