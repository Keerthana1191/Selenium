package Opentaps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrapper {
	public void OpenWorkbook(String filepath, String Sheetname) 
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File(filepath));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(Sheetname);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Cannot open workbook");
		}

		

	}
}
