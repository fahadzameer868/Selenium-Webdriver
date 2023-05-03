package com.ui.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReaderUtil {
	
	public static Object[][] readExcelData(String filepath, String sheetname) throws IOException {
		Workbook workbook = null;

		//Create an object of File class to open xlsx file
		File file = new File(filepath);
		
		//Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(file);
	    
		//Find the file extension by splitting file name in substring  and getting only extension name
	    String fileExtensionName = FilenameUtils.getExtension(filepath);
	    
	    //if the file is xlsx file
	    if(fileExtensionName.equals("xlsx")){
	    	workbook = new XSSFWorkbook(fis); 
	    }
	    //if the file is xls file
	    else if(fileExtensionName.equals("xls")){
	        workbook = new HSSFWorkbook(fis);
	    }
	    
	    //read sheet
	    Sheet sheet = workbook.getSheet(sheetname);
	    
	    //create data object array
	    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    
	    //get the num of rows of the sheet
	    int rowCount = sheet.getLastRowNum();
	 
	    for (int i = 0; i < rowCount; i++) {
	        Row row = sheet.getRow(i+1);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	        	data[i][j] = row.getCell(j).toString();
	        }
	    }
	    
	    return data;
	}

}
