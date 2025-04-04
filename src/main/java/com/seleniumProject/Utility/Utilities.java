 package com.seleniumProject.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_WAIT_TIME=5;

	public String RandomEmail ()
	{
		String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder emailPrefix = new StringBuilder();

        // Generate a random prefix of length 10
        for (int i = 0; i < 10; i++) {
            emailPrefix.append(characters.charAt(random.nextInt(characters.length())));
        }
        // Define a random domain
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "example.com"};
        String domain = domains[random.nextInt(domains.length)];

        // Combine prefix and domain to form the email
        String randomEmail = emailPrefix + "@" + domain;
        System.out.println("Randomly Generated Email: " + randomEmail);
        return randomEmail;
	}
	public static Object[][] getTestDataFromExcelSheet(String SheetName) {
	    XSSFWorkbook workbook = null;
	    File excelFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\seleniumProject\\TestData\\Book1.xlsx");

	    try {
	        if (!excelFile.exists()) {
	            System.out.println("Excel file not found at " + excelFile.getAbsolutePath());
	            return null;
	        }

	        FileInputStream fisExcel = new FileInputStream(excelFile);
	        workbook = new XSSFWorkbook(fisExcel);
	    } catch (Throwable e) {
	        e.printStackTrace();
	        return null;
	    }

	    XSSFSheet sheet = workbook.getSheet(SheetName);
	    if (sheet == null) {
	        System.out.println("Sheet with the specified name '" + SheetName + "' not found.");
	        return null;
	    }

	    int rows = sheet.getLastRowNum();
	    int cols = sheet.getRow(0).getLastCellNum();

	    Object[][] data = new Object[rows][cols];

	    for (int i = 0; i < rows; i++) {
	        XSSFRow row = sheet.getRow(i + 1);
	        if (row == null) {
	            continue; // Skip if the row is null
	        }

	        for (int j = 0; j < cols; j++) {
	            XSSFCell cell = row.getCell(j);
	            if (cell == null) {
	                data[i][j] = ""; // Handle empty cells
	                continue;
	            }

	            CellType celltype = cell.getCellType();
	            switch (celltype) {
	                case STRING:
	                    data[i][j] = cell.getStringCellValue();
	                    break;
	                case NUMERIC:
	                    data[i][j] = Integer.toString((int) cell.getNumericCellValue());
	                    break;
	                default:
	                    data[i][j] = "";
	            }
	        }
	    }

	    return data;
	}

}
