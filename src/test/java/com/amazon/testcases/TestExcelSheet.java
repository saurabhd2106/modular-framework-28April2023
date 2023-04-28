package com.amazon.testcases;

import org.testng.annotations.Test;

import utilis.ExcelReader;

public class TestExcelSheet {

	@Test
	public void verifyExcelUtility() throws Exception {

		String currentWorkingDirectory = System.getProperty("user.dir");

		String sheetName = "test data";

		ExcelReader excelReader = new ExcelReader();

		String filename = String.format("%s/testdata/searchProductTestData.xlsx", currentWorkingDirectory);

		excelReader.createWorkbook(filename);

		excelReader.openWorkbook(filename);

		excelReader.createSheet(sheetName);

		excelReader.setCellData(sheetName, 0, 0, "Apple Watch");
		excelReader.setCellData(sheetName, 0, 1, "Electronics");

		excelReader.setCellData(sheetName, 1, 0, "Table");
		excelReader.setCellData(sheetName, 1, 1, "Furniture");

		excelReader.setCellData(sheetName, 2, 0, "Amazon gift Card ");
		excelReader.setCellData(sheetName, 2, 1, "Gift Cards");

		excelReader.saveFile();

		excelReader.closeWorkbook();
	}

	@Test
	public void readTestData() throws Exception {
		String currentWorkingDirectory = System.getProperty("user.dir");

		String sheetName = "test data";

		ExcelReader excelReader = new ExcelReader();

		String filename = String.format("%s/testdata/searchProductTestData.xlsx", currentWorkingDirectory);

		excelReader.openWorkbook(filename);

		System.out.print(excelReader.getCellData(sheetName, 0, 0) + " ");
		System.out.println(excelReader.getCellData(sheetName, 0, 1));
		System.out.print(excelReader.getCellData(sheetName, 1, 0)+ " ");
		System.out.println(excelReader.getCellData(sheetName, 1, 1));
		System.out.print(excelReader.getCellData(sheetName, 2, 0)+ " ");
		System.out.println(excelReader.getCellData(sheetName, 2, 1));
		
		

	}

}
