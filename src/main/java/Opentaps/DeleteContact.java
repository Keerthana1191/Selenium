package Opentaps;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.Alert;

public class DeleteContact extends Wrapper {
	@Test
	public void EditContacts() throws IOException {

		launchApplication("chrome", "http://demo1.opentaps.org/opentaps/control/main");
		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLinkText("CRM/SFA");
		clickByLinkText("Create Contact");
		clickByLinkText("Find Contacts");
		enterTextByXpath("(//input[@name='id'])", "10030");
		clickByXpath("(//button[@class='x-btn-text'])[7]");
		clickByLinkText("10030");
		clickByLinkText("Deactivate Contact");
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
}
