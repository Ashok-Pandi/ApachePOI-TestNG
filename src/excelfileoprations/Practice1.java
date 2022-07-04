package excelfileoprations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Practice1 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi= new FileInputStream("F:\\TESTING//Employess.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheetAt(0);
		Row r = sh.getRow(0);
		int rc = sh.getLastRowNum();
		int cc = r.getLastCellNum();
		System.out.println("No of Rows  "+rc+"    "+"No of cells "+cc);
		for (int row = 1; row <= rc; row++) 
		{
		String Employee= wb.getSheetAt(0).getRow(row).getCell(0).getStringCellValue();
		if (wb.getSheetAt(0).getRow(row).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
		int intdata= (int) wb.getSheetAt(0).getRow(row).getCell(1).getNumericCellValue();
		String Salary = String.valueOf(intdata);
		System.out.println(Employee+"-----------"+Salary);
		sh.getRow(row).createCell(2).setCellValue("PASS");
		}
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("F:\\\\TESTING//EmployessResults.xlsx");
				wb.write(fo);
		fo.close();
		wb.close();
	}
	

}
