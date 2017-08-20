package com.stock.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.core.data.dbo.CompanyRepository;
import com.stock.core.model.Company;
import com.stock.core.model.TempApplication;

/**
 * @author Sujith PS
 *
 */
@RestController
@CrossOrigin
@ComponentScan({ "com.stock.core.data.dbo" })
@RequestMapping("/stock")
public class ExchangeService {

	@Autowired
	private CompanyRepository companyRepository;

	@RequestMapping(path = "/{countryCode}/{category}/{baseBid}", method = RequestMethod.GET)
	public String performTheBestTrade(
			@PathVariable(value = "countryCode") String countryCode,
			@PathVariable(value = "category") String category,
			@PathVariable(value = "baseBid") String baseBid) {

		for (Company company : TempApplication.getTempListCompanies()) {
			companyRepository.save(company);
		}

		for (Company company : companyRepository.findAll()) {
			System.out.println(company);
		}
		
		System.out.println("---------------");

		System.out.println(companyRepository.findByCountries("US"));

		return (countryCode + " , " + category + " , " + baseBid);
	}

}
