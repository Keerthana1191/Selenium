package Opentaps;

import java.io.IOException;

import org.junit.Test;

public class EditContact extends Wrapper {
	@Test
	public void EditContacts() throws IOException {

		launchApplication("chrome", "http://demo1.opentaps.org/opentaps/control/main");
		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLinkText("CRM/SFA");
		clickByLinkText("Create Contact");
		clickByLinkText("Find Contacts");
		enterTextByXpath("(//input[@name='id'])", "10029");
		clickByXpath("(//button[@class='x-btn-text'])[7]");
		clickByLinkText("10029");
		clickByLinkText("Edit");
		selectByText("addMarketingCampaignForm_marketingCampaignId", "Automobile");
		clickByXpath("(//input[@name='submitButton'])[2])");
		clickByXpath("(//input[@name='submitButton'])[1]");
		closeBrowser();

	}

}
