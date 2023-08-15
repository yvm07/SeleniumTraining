//ExplicitWait
//1) no explicit keyword or method
//2) available with WebDriverWait with some ExpectedConditions
//3) specific to element
//4) dynamic in nature
//5) never use implicit and explicit wait together
//6) selenium webdriver will wait for the element first because of IMPLICIT wait and then
//   EXPLICIT wait will be applied, hence total sync wait will be increased for each element


package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.amazon.in/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement element = driver.findElement(By.xpath("//span[text()= 'Prime Early Deals | Smartwatches starting at ₹899']"));
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		System.out.println(driver.findElement(By.xpath("//span[text()= 'Prime Early Deals | Smartwatches starting at ₹899']")).isDisplayed());

				
//		WebElement locator = driver.findElement(By.xpath("//*[@id=\"XUuyxBaYkel-Sh0ZBzyC9A\"]/a/img"));
//		clickOn(driver, locator, 10);
	}

	public static void clickOn(WebDriver driver, WebElement locator, long timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		System.out.println("inside clickon");
		locator.click();
	}

}
