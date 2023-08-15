
package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");

		// ----> disable browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications"); // block browser notifications
		options.addArguments("disable-geolocation"); // block location
		options.addArguments("disable-media-stream"); // block mike/camera notifications
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();

		// Thread.sleep(10000);

		Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]"))).build().perform();

		action.moveToElement(driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[1]")))
				.build().perform();

//		--------->>>>  wait() after selenium4
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='Username']")));
//		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("SpiceMax")));

//		Thread.sleep(10000);
		
		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(By.linkText("SpiceMax")));
		firstResult.click();
//		driver.findElement(By.linkText("SpiceMax")).click();

	}

}
