package Resources;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public static void setExcel(String path, int sheetnumber) {
		
	try {
			File src = new File(path);
			FileInputStream fis;
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheetnumber);
	} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}
	
	public static String getData(int rowNum, int cellNum) {
		String data = null;
		try{		
			data = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
			
		   }
		catch (Exception e){
			System.out.println("No data!");
		}
		return data;
	}
}
