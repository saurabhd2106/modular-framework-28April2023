package com.amazon.utils;

import org.testng.annotations.DataProvider;

import utilis.ExcelReader;

public class TestDataProvider {
	
	
	@DataProvider
	public Object[][] getSearchProductTestData(){
		
		Object[][] data = new Object[3][2];
		
		
		data[0][0] = "apple watch";
		data[0][1] = "Electronics";
		
		
		data[1][0] = "Table";
		data[1][1] = "Furniture";
		
		data[2][0] = "Amazon gift Card";
		data[2][1] = "Gift Cards";
		
		return data;
	}
	
	@DataProvider
	public Object[][] getSearchProductTestDataFromExcel() throws Exception{
		
		ExcelReader excelReader = new ExcelReader();
		
		String fileName = String.format("%s/testdata/searchProductTestData.xlsx", System.getProperty("user.dir"));
		
		String sheetName = "test data";
		
		excelReader.openWorkbook(fileName);
		
		int rowCount = excelReader.getRowCount(sheetName);
		
		int cellCount = excelReader.getCellCountFromRow(sheetName, 0);
		
		Object[][] data = new Object[rowCount + 1][cellCount];
		
		for(int row=0; row <=rowCount; row++) {
			for(int cell=0; cell <cellCount; cell++) {
				
				data[row][cell] = excelReader.getCellData(sheetName, row, cell);
				
			}
		}
		
		
		return data;
	}

}
