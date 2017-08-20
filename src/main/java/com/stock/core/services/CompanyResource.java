package com.stock.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public Iterable<Company> companies() {
		return companyRepository.findAll();
	}

	@RequestMapping(path = "createSample", method = RequestMethod.GET)
	public List<Company> createSampleData() {
		companyRepository.deleteAll();

		List<Company> list = TempApplication.getTempListCompanies();
		for (Company company : list) {
			companyRepository.save(company);
		}
		return list;
	}

}
