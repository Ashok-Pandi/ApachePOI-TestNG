package excelfileoprations;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apace1 {

	public static void main(String[] args) throws Throwable {
		String excelpath= "F:\\TESTING\\Scripts\\TestNG\\datafiles\\Contries.xlsx";
		FileInputStream fi = new FileInputStream(excelpath);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sh = wb.getSheet("Sheet1");
		XSSFRow row = sh.getRow(0);
		int rc = sh.getLastRowNum();
		int cc = row.getLastCellNum();
		System.out.print("No of Rows are    "+rc+"      "+"NO of cell in first Row    "+cc);
		fi.close();
		wb.close();
	}

}
