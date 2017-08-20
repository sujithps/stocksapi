package com.stock.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.core.data.dbo.CompanyRepository;
import com.stock.core.services.task.TradeTask;

/**
 * @author Sujith PS
 *
 */
@RestController
@CrossOrigin
@ComponentScan({ "com.stock.core.data.dbo", "com.stock.core.services.task" })
@RequestMapping("/stock")
public class ExchangeService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private TradeTask tradeTask;

	@RequestMapping(path = "/{countryCode}/{category}/{baseBid}", method = RequestMethod.GET)
	public String performTheBestTrade(
			@PathVariable(value = "countryCode") String countryCode,
			@PathVariable(value = "category") String category,
			@PathVariable(value = "baseBid") int baseBid) {

		String tradeResponse = tradeTask
				.doTrade(countryCode, category, baseBid);

		return tradeResponse;
	}

}
