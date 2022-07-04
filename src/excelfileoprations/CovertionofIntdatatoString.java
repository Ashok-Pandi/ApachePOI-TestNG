package excelfileoprations;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class CovertionofIntdatatoString {

	public static void main(String[] args)throws Throwable {
		FileInputStream fi = new FileInputStream("F:\\TESTING//Contries.xlsx");
		Workbook wb = new WorkbookFactory().create(fi);
		//Sheet<Shape<S,P>, TextParagraph<S,P,?>>
		Sheet sh= wb.getSheetAt(0);
		Row row = sh.getRow(0);
		int rc=sh.getLastRowNum();
		int cc=row.getLastCellNum();
		System.out.println("No of rows are"+rc+"       "+"No of cells are"+cc);
		for (int r = 1; r <=rc; r++)
		{
			String username = wb.getSheetAt(0).getRow(r).getCell(0).getStringCellValue();
			if(wb.getSheetAt(0).getRow(r).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				int intdata= (int) wb.getSheetAt(0).getRow(r).getCell(1).getNumericCellValue();
				String password = String.valueOf(intdata);
				System.out.println(username+"         "+password);
				sh.getRow(r).createCell(2).setCellValue("Pass");
			}
			}
		fi.close();
		FileOutputStream fo= new FileOutputStream("F:\\\\TESTING//ContriesResults.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}

}
