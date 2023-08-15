//Implicit wait--- is always applied globally--- is available for all the webelements
//dynamic in nature
//it can be changed anywhere and at any time in code
//it is applied to the Driver


package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWaitConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().getImplicitWaitTimeout();
		driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().timeouts().getScriptTimeout();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		--------->>>>  wait() after selenium4
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120,1));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='Username']")));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Welcome']")));

//----->For Fluent Wait
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//		        .withTimeout(Duration.ofSeconds(30))
//		        .pollingEvery(Duration.ofSeconds(5))
//		        .ignoring(NoSuchElementException.class);
	}

}
