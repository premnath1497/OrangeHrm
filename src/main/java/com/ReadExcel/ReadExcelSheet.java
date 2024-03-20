package com.ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelSheet {
     
	
		public static String readExcelsheet(String sheetName,int rowIndex,int ColumnIndex) throws EncryptedDocumentException, IOException {
			String data=null;
	    try {
	    // Location Of Your Excel Sheet
		File file=new File("C:\\Users\\1\\Desktop\\ExcelSheetData\\GroupDiscusssion.xlsx");
		// Read Data From Excel Sheet
		FileInputStream fis=new FileInputStream(file);
		// Open Workbook for Reading Data From Excel Shhet
		Workbook wb=WorkbookFactory.create(fis);
		// Sheet name we have Read
		Sheet sh=wb.getSheet(sheetName);
		// Row name I have to pass
		Row r=sh.getRow(rowIndex);
		// coloumn name I have to Pass
		Cell c=r.getCell(ColumnIndex);
		// get the data from cell
		data=c.toString();
		
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return data;
		}
		
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		String user=readExcelsheet("LoginPageData",1,1);
		System.out.println(user);
	}
	
}
