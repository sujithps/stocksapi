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

		company1.setCategories(categories);

		companies.add(company1);

		Company company2 = new Company();
		company2.setCompanyID("C2");
		List<String> countries2 = new ArrayList<>();
		countries2.add("IN");
		countries2.add("US");

		company2.setCountries(countries2);

		company2.setBudget(2);
		company2.setBudgetUnit("$");

		company2.setBid(30);
		company2.setBidUnit("cent");

		List<String> categories2 = new ArrayList<>();
		categories2.add("Finance");
		categories2.add("IT");

		company2.setCategories(categories2);

		companies.add(company2);

		Company company3 = new Company();
		company3.setCompanyID("C3");
		List<String> countries3 = new ArrayList<>();
		countries3.add("US");
		countries3.add("RU");

		company3.setCountries(countries3);

		company3.setBudget(3);
		company3.setBudgetUnit("$");

		company3.setBid(5);
		company3.setBidUnit("cent");

		List<String> categories3 = new ArrayList<>();
		categories3.add("IT");
		categories3.add("Automobile");

		company3.setCategories(categories3);

		companies.add(company3);

		return companies;
	}
}
