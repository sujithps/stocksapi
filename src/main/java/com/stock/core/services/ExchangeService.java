package com.stock.core.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sujith PS
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/stock")
public class ExchangeService {

	@RequestMapping(path = "/{countryCode}/{category}/{baseBid}", method = RequestMethod.GET)
	public String performTheBestTrade(
			@PathVariable(value = "countryCode") String countryCode,
			@PathVariable(value = "category") String category,
			@PathVariable(value = "baseBid") String baseBid) {

		return (countryCode + " , " + category + " , " + baseBid);
	}

}
