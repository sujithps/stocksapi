package com.stock.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.core.data.dbo.CompanyRepository;
import com.stock.core.model.Company;
import com.stock.core.model.TempApplication;

/**
 * 
 * @author Sujith PS
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/company")
public class CompanyResource {

	@Autowired
	private CompanyRepository companyRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Company> companies() {
		return TempApplication.getTempListCompanies();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Company getCompany(@PathVariable(value = "id") int id) {
		return null;
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.PUT,
			RequestMethod.OPTIONS })
	public Company updateCompany(@PathVariable(value = "id") int id,
			@RequestBody Company company) {
		return company;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public Company deleteCompany(@PathVariable(value = "id") int id) {
		return null;
	}

}
