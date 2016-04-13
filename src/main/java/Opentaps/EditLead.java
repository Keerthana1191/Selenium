package Opentaps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class EditLead extends Wrapper {
	@Test
	public void FindLeads() throws IOException {
		FileInputStream fis = new FileInputStream(new File("./data/CreateLead.xlsx"));

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row = sheet.getRow(4);

		FileInputStream fi = new FileInputStream(new File("./data/EditLead.xlsx"));

		XSSFWorkbook wb1 = new XSSFWorkbook(fi);

		XSSFSheet sheet1 = wb1.getSheetAt(0);


		for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
			XSSFRow row1 = sheet1.getRow(i);
			String k = row1.getCell(1).getStringCellValue();
			launchApplication(k, "http://demo1.opentaps.org/opentaps/control/main");
			enterTextById("username", "DemoSalesManager");
			enterTextById("password", "crmsfa");
			clickByClassName("decorativeSubmit");
			clickByLinkText("CRM/SFA");
			clickByLinkText("Create Lead");
			clickByLinkText("Find Leads");

			String a = row.getCell(1).getStringCellValue();

			enterTextByXpath("(//input[@name='firstName'])[3] ", a); //find lead by 1st name
			clickByXpath("(//button[@class='x-btn-text'])[7]"); // find lead
			clickByLinkText("10179"); // click the link by lead id
			verifyTitle("View Lead | opentaps CRM"); // verify the title
			clickByLinkText("Edit"); 

			String x = row1.getCell(2).getStringCellValue();
			selectByText("addDataSourceForm_dataSourceId", x);
			clickByXpath("(//input[@name='submitButton'])[2]"); // to add
			String y = row1.getCell(3).getStringCellValue();
			selectByText("addMarketingCampaignForm_marketingCampaignId", y);
			clickByXpath("(//input[@name='submitButton'])[3]"); // to add marketing campaign
			clickByXpath("(//input[@name='submitButton'])[1]"); // to update the leads
			System.out.println("Source data");
			verifyText("viewLead_dataSources_sp", x);
			System.out.println("Marketing Campaign data");
			verifyText("viewLead_marketingCampaigns_sp", y);
			closeBrowser();
		}
	}
}
