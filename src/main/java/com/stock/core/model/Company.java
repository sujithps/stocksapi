package com.stock.core.model;

import java.util.List;

public class Company {
	private String companyID;
	private List<String> countries;
	private int budget;
	private String budgetUnit;
	private int bid;
	private String bidUnit;
	private List<String> categories;

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

	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", countries=" + countries
				+ ", budget=" + budget + ", budgetUnit=" + budgetUnit
				+ ", bid=" + bid + ", bidUnit=" + bidUnit + ", categories="
				+ categories + "]";
	}

}