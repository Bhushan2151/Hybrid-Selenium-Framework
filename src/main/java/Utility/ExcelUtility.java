package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] getExcelData(String filePath, String sheetName)
	        throws IOException {

	    FileInputStream fis = new FileInputStream(filePath);

	    Workbook workbook = new XSSFWorkbook(fis);

	    Sheet sheet = workbook.getSheet(sheetName);

	    if(sheet == null) {

	        workbook.close();
	        fis.close();

	        throw new RuntimeException(
	            "Sheet '" + sheetName + "' not found in Excel file");
	    }

	    int rowCount = sheet.getLastRowNum();

	    int colCount = sheet.getRow(0).getLastCellNum();
	    
	    System.out.println("Sheet Found");

	    System.out.println("Rows = " + rowCount);
	    System.out.println("Cols = " + colCount);

	    Object[][] data = new Object[rowCount][colCount];

	    for(int i = 1; i <= rowCount; i++) {

	        Row row = sheet.getRow(i);

	        for(int j = 0; j < colCount; j++) {

	            Cell cell = row.getCell(j);

	            if(cell == null) {
	                data[i - 1][j] = "";
	            }
	            else {
	                data[i - 1][j] = cell.toString();
	            }
	        }
	    }

	    workbook.close();
	    fis.close();

	    return data;
	}
}
