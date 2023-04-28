package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.utils.TestDataProvider;

public class SearchProductTest extends BaseTest {

	
	@Test(dataProvider = "getSearchProductTestDataFromExcel", dataProviderClass = TestDataProvider.class, groups = "Sanity")
	public void VerifySearchProduct(String product, String category) throws Exception {
		
		reportUtils.createTestCase("TC-011 # Verify Search Product #" + product + " #"+ category);


		
		reportUtils.addLogs("info", "test data - " + product + " "+ category);

		searchProduct.searchProduct(product, category);
		

		reportUtils.addLogs("info", "Search Product Executed" );


		String productInfo = searchProduct.getProductInfo();

		System.out.println(productInfo);
		
		reportUtils.addLogs("info", "First Product Info - " + productInfo );
		
		//Assert.assertEquals(productInfo, "APPLE WATCH 2021");


	}

}
