package com.stock.core.data.dbo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.stock.core.model.Company;

@Transactional
public interface CompanyRepository extends CrudRepository<Company, String> {
	public List<Company> findByCategoriesAndCountries(String category,
			String country);

}
