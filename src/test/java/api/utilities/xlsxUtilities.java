package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class xlsxUtilities {

	XSSFWorkbook workbook ;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileInputStream fip;
	String filePath;
	
	
	public xlsxUtilities(String filePath){
		
		this.filePath = filePath;
	}
	
	
	
	
	public int getRowCount (String sheetName) throws IOException{
		
		fip = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fip);
		sheet = workbook.getSheet(sheetName);
		
		int rwCount  = sheet.getLastRowNum();
		
		workbook.close();
		fip.close();
		
		return rwCount;
		
	}
	
	public int getCellCount (String sheetName, int rowNum) throws IOException{
		
		fip = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fip);
		sheet = workbook.getSheet(sheetName);
		
		row  = sheet.getRow(rowNum);
		int clNum = row.getLastCellNum();
		
		workbook.close();
		fip.close();
		
		return clNum;
		
	}
	
	public String getCellData (String sheetName, int rowNum, int cellNum) throws IOException{
		
		fip = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fip);
		sheet = workbook.getSheet(sheetName);
		
		row  = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		
		
		DataFormatter df = new DataFormatter ();
		
		String data = df.formatCellValue(cell); // Returns the formatted value of a cell as a String regardless of the cell type.
		
		workbook.close();
		fip.close();
		
		return data;
		
	}
	
	
	
}
