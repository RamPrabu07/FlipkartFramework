package datalibrary;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import baseclass.BaseClass;

public class ReadExcel extends BaseClass{
	public static Object[][] readExcelData() throws IOException {
		
		XSSFWorkbook book = new XSSFWorkbook("/FlipKart/exceldata/Book12.xlsx");
		XSSFSheet sheet = book.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
	    String[][] data = new String[lastRowNum][lastCellNum];
	    for (int i = 1; i <=lastRowNum; i++) {
	    	for (int j = 0; j < lastCellNum; j++) {
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
				
				data[i-1][j]=stringCellValue;
			}
	    }
	    book.close();
	    return data;
	    
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	

}
