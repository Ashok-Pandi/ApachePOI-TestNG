package pavanSirExcelScripts;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadingAndWritingDataOnExcel {
	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream("F:\\TESTING\\Scripts\\TestNG\\src\\pavanSirExcelScripts\\ReadingAndWritingDataOnExcel.java");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sh = wb.getSheetAt(0);
		int row=sh.getLastRowNum();
		int cell = sh.getRow(0).getLastCellNum();
		System.out.println("NO OF ROWS ARE    "+row+"        "+"NO  OF CELLS ARE     "+cell);
	}
	}