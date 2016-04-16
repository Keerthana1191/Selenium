package Opentaps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.thoughtworks.selenium.webdriven.commands.GetSelectOptions;

public class ERail extends ExcelWrapper {
	@Test
	public void ERailapp() throws InterruptedException, FileNotFoundException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://erail.in/");
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("ms", Keys.TAB);
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("tpj", Keys.TAB);
		Thread.sleep(10000);
		WebElement table = driver.findElementByClassName("DataTable TrainList");
		List<WebElement> row = table.findElements(By.tagName("tr"));
		List<WebElement> cell = table.findElements(By.tagName("tr"));
		System.out.println(row.size());
		System.out.println(cell.size());
		for(int i=1;i<=row.size();i++)
		{
			
		}
		
		
		
	
	

	}
}
