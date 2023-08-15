package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationInSelenium {

	static WebElement element;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		element = driver.findElement(By.id("email"));
		sendKeys(element, driver, 3, "yamunamurthy");

		element = driver.findElement(By.id("pass"));
		sendKeys(element, driver, 3, "yamunamurthy");
		
		element = driver.findElement(By.name("login"));
		click(element, driver, 3);

	}
	
	public static void sendKeys(WebElement element, WebDriver driver, int timeOut, String value) {
		
		new WebDriverWait(driver, Duration.ofSeconds(timeOut))
		.until(ExpectedConditions.visibilityOf(element))
		.sendKeys(value);
	}
	
public static void click(WebElement element, WebDriver driver, int timeOut) {
		
		new WebDriverWait(driver, Duration.ofSeconds(timeOut))
		.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}


}
