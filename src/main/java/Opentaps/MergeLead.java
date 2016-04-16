package Opentaps;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.Keys;

import framework.ExcelConfig;
import framework.Wrapper;

public class MergeLead extends ExcelConfig {
	String url =""; String BrowserName =""; String Verifytitle=""; 	String UserName ="";
	String Password =""; String CompanyName=""; String firstName=""; String LastName="";
	Double Source=null; Double Marketing_Campaign=null; String Email =""; String Phone ="";
	
	
	@SuppressWarnings("resource")
	public void Create_Lead() throws Throwable
	{
		
		File file = new File("./Data/MergeLead.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet1");
		for(int i=1; i<=sh.getLastRowNum();i++)
		{
		BrowserName= sh.getRow(i).getCell(0).getStringCellValue();
		url=sh.getRow(i).getCell(1).getStringCellValue();
		Verifytitle= sh.getRow(i).getCell(2).getStringCellValue();
		UserName= sh.getRow(i).getCell(3).getStringCellValue();
		Password= sh.getRow(i).getCell(4).getStringCellValue();
		CompanyName= sh.getRow(i).getCell(5).getStringCellValue();
		firstName= sh.getRow(i).getCell(6).getStringCellValue();
		LastName= sh.getRow(i).getCell(7).getStringCellValue();
		Source= sh.getRow(i).getCell(8).getNumericCellValue();
		Marketing_Campaign= sh.getRow(i).getCell(9).getNumericCellValue();
		Email= sh.getRow(i).getCell(10).getStringCellValue();
		Phone= sh.getRow(i).getCell(11).getStringCellValue();
		
		// Testcase starts
		launchApp(BrowserName, url);
		enterText("Id=username", UserName);
		enterText("Id=password", Password);
		click("classname=decorativeSubmit");
		//clicking CRM/SFA link
		clickByXPath("//div[@class='crmsfa']/a/img");
		// Click CreateLead from shotcuts
		clickByXPath("//div[@class='frameSectionBody']/ul/li[1]/a[1]");
		//Enter Company Name
		enterTextById("createLeadForm_companyName", CompanyName);
		//Enter firstName
		enterTextByXPath("//input[@id='createLeadForm_firstName']", firstName);
		//Enter LastName
		enterTextByXPath("//input[@id='createLeadForm_lastName']", LastName);
		
		//Source
		selectValueByIndex("name=dataSourceId", Source.intValue());
		// Marketing_Campaign
		selectValueByIndex("name=marketingCampaignId", Marketing_Campaign.intValue());		
		enterTextById("createLeadForm_primaryEmail", Email);
		enterTextById("createLeadForm_primaryPhoneNumber", Phone);
		clickByXPath("//input[@value='Create Lead']");
		
		}
	}

	@SuppressWarnings("resource")
	
	public void Merge_Lead() throws Throwable
	{
		File file = new File("./Data/MergeLead.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet2");
		for(int i=1; i<=sh.getLastRowNum();i++)
		{
		BrowserName= sh.getRow(i).getCell(0).getStringCellValue();
		url=sh.getRow(i).getCell(1).getStringCellValue();
		Verifytitle= sh.getRow(i).getCell(2).getStringCellValue();
		UserName= sh.getRow(i).getCell(3).getStringCellValue();
		Password= sh.getRow(i).getCell(4).getStringCellValue();
		String FromLead =sh.getRow(i).getCell(5).getStringCellValue();
		String ToLead =sh.getRow(i).getCell(6).getStringCellValue();
		
		// Testcase starts
				launchApp(BrowserName, url);
				enterText("Id=username", UserName);
				enterText("Id=password", Password);
				click("classname=decorativeSubmit");
				//clicking CRM/SFA link
				clickByXPath("//div[@class='crmsfa']/a/img");
				
				// Click CreateLead from shotcuts
				clickByXPath("//div[@class='frameSectionBody']/ul/li[1]/a[1]");
				// Click Merge lead
				clickByXPath("//div[@class='frameSectionBody']/ul/li[4]");
				// from Lead image
				clickByXPath("//div[@class='subSectionBlock']/form/table/tbody/tr[1]/td[2]/a");
				switchToLastWindow();
				//verifyUrl("http://demo1.opentaps.org/crmsfa/control/LookupLeads?id=&parm0=LookupLeads");
				enterTextByXPath("//div[@class='x-form-element'][1]/input[1]", FromLead+Keys.ENTER);
				clickByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
				switchToPrimaryWindow();
				clickByXPath("//div[@class='subSectionBlock']/form/table/tbody/tr[2]/td[2]/a");
				switchToLastWindow();
				enterTextByXPath("//div[@class='x-form-element'][1]/input[1]", ToLead+Keys.ENTER);
				Thread.sleep(500);
				clickByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
				switchToPrimaryWindow();
				clickByXPath("(//a[contains(text(),'Merge')])[2]");
				acceptAlert();
				
		}
	}


}
