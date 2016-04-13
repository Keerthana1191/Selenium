package Opentaps;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Wrapper {
	RemoteWebDriver driver;

	public void launchApplication(String browser, String url) {

		try {
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();

			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
		} catch (WebDriverException e) {
			System.out.println("Browser could not be launched");
		}

	}

	public void enterTextById(String id, String value) {
		try {
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("Element could not be found");
		}
	}

	public void enterTextByName(String name, String value) {
		try {
			driver.findElement(By.name(name)).clear();
			driver.findElement(By.name(name)).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("Element could not be found");
		}
	}

	public void enterTextByClassName(String name, String value) {
		try {
			driver.findElement(By.className(name)).clear();
			driver.findElement(By.className(name)).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("Element could not be found");
		}
	}

	public void enterTextByTagName(String name, String value) {
		try {
			driver.findElement(By.tagName(name)).clear();
			driver.findElement(By.tagName(name)).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("Element could not be found");
		}
	}

	public void enterTextByXpath(String xpathExpression, String value) {
		try {
			driver.findElement(By.xpath(xpathExpression)).clear();
			driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("Element could not be found");
		}
	}

	public void clickById(String id) {
		try {
			driver.findElement(By.id(id)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element could not be found");
		}
	}

	public void clickByName(String name) {
		try {
			driver.findElement(By.name(name)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element could not be found");
		}
	}

	public void clickByClassName(String className) {
		try {
			driver.findElement(By.className(className)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element could not be found");
		}
	}

	public void clickByLinkText(String link) {
		try {
			driver.findElement(By.linkText(link)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Link could not be found");
		}
	}

	public void clickByPartialLinkText(String link) {
		try {
			driver.findElement(By.partialLinkText(link)).click();
		} catch (NoSuchElementException e) {
			System.out.println("PartialLink could not be found");
		}
	}

	public void clickByPartialTagName(String name) {
		try {
			driver.findElement(By.tagName(name)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Tagname could not be found");
		}
	}

	public void clickByXpath(String xpathExpression) {
		try {
			driver.findElement(By.xpath(xpathExpression)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Xpath could not be found");
		}
	}

	public void verifyText(String id, String expected) {

		try {
			WebElement content = driver.findElementById(id);
			System.out.println(content.getText().equals(expected));
			System.out.println("Text verified");

		} catch (Exception ex) {
			System.out.println("verification of text could not be done");
		}

	}

	public boolean verifyTitle(String expected) {
		boolean returnValue = false;

		try {
			if (driver.getTitle().equals(expected)) {
				returnValue = true;
				System.out.println("Titles match");
			} else {
				System.out.println("Titles does not match");
			}
		} catch (Exception e) {
			System.out.println("Browser could not verify title");
		}

		return (returnValue);

	}

	public void selectByText(String id, String value) {
		try {
			WebElement element = driver.findElement(By.id(id));
			Select se = new Select(element);
			se.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println("Element could not be found with given index");
		}
	}

	public void getText(String id) {
		try {
			String a = driver.findElementById(id).getText();
			System.out.println(a);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("No such element found");
		}
	}

	public boolean verifyUrl(String expected) {
		boolean returnValue = false;

		try {
			if (driver.getCurrentUrl().equals(expected)) {
				returnValue = true;
				System.out.println("Urls match");
			} else {
				System.out.println("Urls does not match");
			}
		} catch (Exception e) {
			System.out.println("Browser could not verify url");
		}

		return (returnValue);

	}

	public void selectByIndex(String id, int value) {
		try {
			WebElement element = driver.findElement(By.id(id));
			Select se = new Select(element);
			se.selectByIndex(value);
		} catch (Exception e) {
			System.out.println("Element could not be found with given index");
		}
	}

	public void switchToPrimaryWindow() {

		try {
			String primarywindow = driver.getWindowHandle();
			driver.switchTo().window(primarywindow);
		} catch (Exception e) {
			System.out.println("Not able to switch to primary window");
		}
	}

	public void defaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println("Not able to switch to default content");
		}
	}

	public void switchToFirstFrame() {
		try {
			driver.switchTo().frame(0);
			List<WebElement> list = driver.findElementsByTagName("iframe");
			System.out.println(list);
			defaultContent();

		} catch (NoSuchFrameException e) {
			System.out.println("Not able to switch to first frame");
		}
	}

	public void switchToLastWindow() {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String eachwindow : allWindows) {
				driver.switchTo().window(eachwindow);
				System.out.println("Current window handle is " + driver.getWindowHandle());
			}
		} catch (NoSuchWindowException e) {
			System.out.println("No such window");
		}
	}

	public void switchToFrameByElememt() {
		try {
			List<WebElement> fr = driver.findElements(By.tagName("iframe"));
			for (WebElement frameElement : fr) {
				driver.switchTo().frame(frameElement);
				defaultContent();
			}
		} catch (NoSuchFrameException e) {
			System.out.println("No such frame");
		}

	}

	public boolean acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
		} catch (NoAlertPresentException Ex) {
			System.out.println("No alert is found");
			return false;
		}
	}

	public boolean dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			return true;
		} catch (NoAlertPresentException Ex) {
			System.out.println("No alert is found");
			return false;
		}
	}

	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("Browser could not be closed");
		}
	}

	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(" Browser windows could not be closed ");
		}
	}
}
