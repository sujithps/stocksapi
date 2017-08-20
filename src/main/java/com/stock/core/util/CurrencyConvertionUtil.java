package com.stock.core.util;

import com.stock.core.model.Company;

/**
 * A UTIL class for just converting $ to cents .
 * 
 * @author Sujith PS
 *
 */
public class CurrencyConvertionUtil {
	public static int convert(String sourceCurrency, int sourceAmount,
			String targetCurrency) {
		if (sourceCurrency.equals("$") && targetCurrency.equals("cent")) {
			return sourceAmount * 100;
		}

		return sourceAmount;
	}

	public static int convert(Company company) {
		return convert(company.getBudgetUnit(), company.getBudget(),
				company.getBidUnit());
	}
}
