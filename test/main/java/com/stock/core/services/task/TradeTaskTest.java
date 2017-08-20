/**
 * 
 */
package com.stock.core.services.task;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stock.core.data.dbo.CompanyRepository;
import com.stock.core.model.Company;
import com.stock.core.model.TempApplication;

/**
 * @author Sujith PS
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeTaskTest {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private TradeTask task;

	@Before
	public void init() {
		companyRepository.deleteAll();

		List<Company> list = TempApplication.getTempListCompanies();
		for (Company company : list) {
			companyRepository.save(company);
		}
	}

	/**
	 * Test method for
	 * {@link com.stock.core.services.task.TradeTask#doTrade(java.lang.String, java.lang.String, int)}
	 * .
	 */
	@Test
	public void testDoTrade() {
		// MultiThread test
		IntStream.range(0, 100).parallel().forEach(value -> {
			String res = task.doTrade("US", "Finance", 5);

			System.out.println(res + " @" + value);
		});

		System.out.println("------------------");
		for (Company company : companyRepository.findAll()) {
			System.out.println(company);
		}

		Assert.assertEquals(5, companyRepository.findOne("C1").getBudget());
	}

}
