package com.stock.core.services.task;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.core.data.dbo.CompanyRepository;
import com.stock.core.model.Company;
import com.stock.core.util.CurrencyConvertionUtil;

/**
 * @author Sujith PS
 *
 */
@Component
public class TradeTask {

	@Autowired
	private CompanyRepository companyRepository;

	private final Logger logger = LogManager.getLogger(this.getClass());

	public String doTrade(String countryCode, String category, int baseBid) {

		List<Company> companies = getBaseTargetCompanies(countryCode, category);

		if (companies == null || companies.isEmpty()) {
			if (logger.isErrorEnabled()) {

				logger.error("{C1, Failed},{C2,Failed},{C3,Failed}");

				/*
				 * logger.error(companies.stream() .map(c -> "{" +
				 * c.getCompanyID() + ", Failed}")
				 * .collect(Collectors.joining(",")));
				 */
			}

			return "No Companies Passed from Targeting";
		}

		companies = filterCompaniesWithEnoughBudget(companies);

		if (companies == null || companies.isEmpty()) {
			if (logger.isErrorEnabled()) {
				logger.error("{C1, Failed},{C2,Failed},{C3,Failed}");
			}

			return "No Companies Passed from Budget";
		}

		companies = filterCompaniesHavingAtleastBaseBid(companies, baseBid);

		if (companies == null || companies.isEmpty()) {
			if (logger.isErrorEnabled()) {
				logger.error("{C1, Failed},{C2,Failed},{C3,Failed}");
			}

			return "No Companies Passed from BaseBid check";
		}

		String result = findBestCompanyToBid(companies, countryCode, category,
				baseBid);

		return result;
	}

	private List<Company> getBaseTargetCompanies(String countryCode,
			String category) {

		return companyRepository.findByCategoriesAndCountries(category,
				countryCode);
	}

	private List<Company> filterCompaniesWithEnoughBudget(
			List<Company> companies) {
		return companies
				.stream()
				.filter(company -> CurrencyConvertionUtil.convert(company) >= company
						.getBid()).collect(Collectors.toList());
	}

	private List<Company> filterCompaniesHavingAtleastBaseBid(
			List<Company> companies, int baseBid) {

		return companies
				.stream()
				.filter(company -> company.getBid() > baseBid
						&& CurrencyConvertionUtil.convert(company) >= baseBid)
				.collect(Collectors.toList());
	}

	private String findBestCompanyToBid(List<Company> companies,
			String countryCode, String category, int baseBid) {
		Company company = companies.stream()
				.max((c1, c2) -> c2.getBid() - c1.getBid()).get();

		return updateCompanyBudget(company, countryCode, category, baseBid);

	}

	private synchronized String updateCompanyBudget(Company company,
			String countryCode, String category, int baseBid) {
		int convertedBugdget = CurrencyConvertionUtil.convert(company);

		company.setBudget(convertedBugdget - baseBid);
		company.setBudgetUnit(company.getBidUnit());

		try {
			companyRepository.save(company);

		} catch (Exception e) {
			// Do the process again from starting for the conflict
			return doTrade(countryCode, category, baseBid);
		}

		if (logger.isInfoEnabled()) {
			logger.info("Winner = " + company.getCompanyID());
		}

		return company.getCompanyID();
	}
}
