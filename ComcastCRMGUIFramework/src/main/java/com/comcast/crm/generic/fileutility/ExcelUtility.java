package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rowNum, int cellNum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./testScriptData/VTigerTestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 String exceldata = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();	
		return exceldata; 
	}
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./testScriptData/VTigerTestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		return rowCount;	
	}
	public void setDataIntoExcel(String sheetName,int rowNum, int cellNum,String data) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./testScriptData/VTigerTestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Cell block = wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
//		block.setCellType(CellType.STRING);
		block.setCellValue(data);
		
		
		FileOutputStream fos=new FileOutputStream("./testScriptData/VTigerTestScript.xlsx");
		wb.write(fos);
		wb.close();
		

		
	}
}
