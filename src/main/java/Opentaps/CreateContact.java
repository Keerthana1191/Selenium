package Opentaps;

import java.io.IOException;

import org.junit.Test;

public class CreateContact extends Wrapper {
	@Test
	public void CreateContacts() throws IOException {
		launchApplication("chrome", "http://demo1.opentaps.org/opentaps/control/main");
		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLinkText("CRM/SFA");
		clickByLinkText("Create Contact");
		enterTextById("firstNameField", "Keerthana");
		enterTextById("lastNameField", "C");
		clickByClassName("smallSubmit");
		getText("viewContact_fullName_sp");
		closeBrowser();
	}
}
