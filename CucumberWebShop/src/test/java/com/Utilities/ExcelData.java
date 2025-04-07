
package com.Utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {


	public static Map<String, String> getAddressDetails(String filePath, String sheetName) {
	    Map<String, String> data = new HashMap<>();
	    DataFormatter formatter = new DataFormatter();
	    
	    try (FileInputStream fis = new FileInputStream(filePath);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
	        
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file");
	        }

	        // getting header
	        XSSFRow headerRow = sheet.getRow(0);
	        // getting datas in rows
	        XSSFRow dataRow = sheet.getRow(1);
	        
	        if (headerRow == null || dataRow == null) {
	            throw new RuntimeException("Header row or data row not found in sheet");
	        }

	        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
	            String header = formatter.formatCellValue(headerRow.getCell(i));
	            String value = formatter.formatCellValue(dataRow.getCell(i));
	            if (value == null || value.isEmpty()) {
	                value = "N/A"; // Provide a default value if the cell is empty
	            }
	            data.put(header, value);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return data;
		}
}
