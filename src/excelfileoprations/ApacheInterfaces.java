/*
1. How to convert Higher version of Excel file to lower version
 Ans:- To convert .xlsx ti .xls we need to change it in Excel file.
2.  How to use Interfaces in Excel File Operations
 */


package excelfileoprations;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ApacheInterfaces {

	public static void main(String[] args)throws Throwable {
	//2.
		FileInputStream fi = new FileInputStream("F:\\TESTING//Dummy.xls");
		Workbook wb= WorkbookFactory.create(fi);
		Sheet sh = wb.getSheetAt(0);
		Row r= sh.getRow(0);
		int rc = sh.getLastRowNum();
		int cc = r.getLastCellNum();
		System.out.println("No of rows are-----"+rc+"         "+"No of Cells/columns are------"+cc);
		for (int rows = 1; rows <= rc; rows++) 
		{
		String username= sh.getRow(rows).getCell(0).getStringCellValue();
		String paassword=sh.getRow(rows).getCell(1).getStringCellValue();
		System.out.println(username+"           "+paassword);
		sh.getRow(rows).createCell(2).setCellValue("pass");		
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("F:\\TESTING//LowerDummyResults.xls");
		wb.write(fo);
		fo.close();
		wb.close();
	}

}
