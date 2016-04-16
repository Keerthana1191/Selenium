package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrapper {
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileOutputStream fos;

	public void OpenWorkbook(String filepath, String Sheetname) {

		try {
			fis = new FileInputStream(new File(filepath));
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(Sheetname);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Cannot open workbook");
		}

	}

	public int GetNoOfRows() {
		try {
			
			int num = sheet.getLastRowNum();
		} catch (Exception e) {
			System.out.println("Unable to find no of rows");
		}
		return 0;
		

	}

	public String GetCellValue(int rowindex, int columnindex) {
		try {
			XSSFRow row = sheet.getRow(rowindex);
			row.getCell(columnindex).getStringCellValue();
		} catch (Exception e) {
			System.out.println("Unable to get the cell value");
		}
		return null;

	}

	public void WriteData(int rowno, int cellno, String data) {

		try {
			XSSFRow row = sheet.createRow(rowno);
			XSSFCell cell = row.createCell(cellno);
			cell.setCellValue(data);
		} catch (Exception e) {
			System.out.println("Unable to write data");
		}

	}

	public void Save(String filename) {

		try {
			fos = new FileOutputStream(new File(filename));
			wb.write(fos);
			wb.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to save file");
		} catch (IOException e) {
			System.out.println("Unable to save file");
		}

	}

}
