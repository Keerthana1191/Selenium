package Opentaps;

import java.io.IOException;

import org.junit.Test;

public class MergeContact extends Wrapper{
	@Test
	public void EditContacts() throws IOException {

		launchApplication("chrome", "http://demo1.opentaps.org/opentaps/control/main");
		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLinkText("CRM/SFA");
		clickByLinkText("Create Contact");
		clickByLinkText("Merge Contacts");
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToPrimaryWindow();
		enterTextByXpath("//input[@name='id']", "10032");
		
}
}