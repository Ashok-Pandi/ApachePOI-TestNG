/*
 1. How to Count no of rows and columns in a Dummy.xlsx file.
 2. How to print Specific row cell data
 3. How to print All rows and columns in a file
 4.How to Write data in Dummy File
 5. How to write Previous(Dummy) Workbook data into new(DummyResults) file. 
 */
 





package excelfileoprations;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingandWritingExcelfileData {

	public static void main(String[] args)throws Throwable {
		FileInputStream fi = new FileInputStream("F:\\TESTING//Dummy.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sh = wb.getSheet("Sheet1");
		XSSFRow row = sh.getRow(0);
		int rc =sh.getLastRowNum();
		int cc = row.getLastCellNum();
	//1.
		System.out.println("No of rows are  in dummy File:::::"+ rc +"           "+    "No of Colums in File:::::"+cc);
		String username = sh.getRow(10).getCell(0).getStringCellValue();
		String password = sh.getRow(10).getCell(1).getStringCellValue();
//2. 
		System.out.println(username+"       "+password);
//3.
		for (int r = 1; r <=rc; r++)
		{
			String uname = sh.getRow(r).getCell(0).getStringCellValue();
			String pword = sh.getRow(r).getCell(1).getStringCellValue();	
			System.out.println(uname+ "            "+pword);
//4. 
			sh.getRow(r).createCell(2).setCellValue("Pass");
		}
		fi.close();
//5. 
		FileOutputStream fo = new FileOutputStream("F:\\TESTING//HigherDummyResults.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}

}
