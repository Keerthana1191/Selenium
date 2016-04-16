package Opentaps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class CreateLead extends Wrapper {
	@Test
	public void CreateLeads() throws IOException {
		launchApplication("chrome", "http://demo1.opentaps.org/opentaps/control/main");
		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLinkText("CRM/SFA");
		clickByLinkText("Create Lead");

		FileInputStream fis = new FileInputStream(new File("./data/CreateLead.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);

		String s = row.getCell(0).getStringCellValue();
		String a = row.getCell(1).getStringCellValue();
		String b = row.getCell(2).getStringCellValue();
		String c = row.getCell(3).getStringCellValue();
		String d = row.getCell(4).getStringCellValue();
		String e = row.getCell(5).getStringCellValue();
		String f = row.getCell(6).getStringCellValue();
		enterTextById("createLeadForm_companyName", s);
		enterTextById("createLeadForm_firstName", a);
		enterTextById("createLeadForm_lastName", b);
		selectByText("createLeadForm_dataSourceId", c);
		selectByText("createLeadForm_marketingCampaignId", d);
		enterTextById("createLeadForm_primaryEmail", e);
		enterTextById("createLeadForm_primaryPhoneNumber", f);
		clickByName("submitButton");

		getText("viewLead_companyName_sp");
	}
}
