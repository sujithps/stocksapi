/**
 * 
 */
package com.stock.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sujith PS
 *
 */
public class TempApplication {
	public static List<Company> getTempListCompanies() {

		List<Company> companies = new ArrayList<>();

		Company company1 = new Company();
		company1.setCompanyID("C1");
		List<String> countries = new ArrayList<>();
		countries.add("US");
		countries.add("FR");

		company1.setCountries(countries);

		company1.setBudget(1);
		company1.setBudgetUnit("$");

		company1.setBid(10);
		company1.setBidUnit("cent");

		List<String> categories = new ArrayList<>();
		categories.add("Automobile");
		categories.add("Finance");

		companies.add(company1);

		return companies;
	}
}
