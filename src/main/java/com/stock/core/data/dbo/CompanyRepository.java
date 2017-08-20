package com.stock.core.data.dbo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.stock.core.model.Company;

public interface CompanyRepository extends CrudRepository<Company, String> {
	public List<Company> findByCountries(String country);

	public List<Company> findByCategories(String category);

	public List<Company> findByBudgetLessThanEqual(int budget);

	public List<Company> findByBudgetGreaterThanEqual(int budget);

	public List<Company> findByBidLessThanEqual(int bid);

	public List<Company> findByBidGreaterThanEqual(int bid);
}
