package selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpConcept {

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

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//div[text() = 'Deals']")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(400));
//		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//		
//		Duration d = driver.manage().timeouts().getPageLoadTimeout();
//		System.out.println(d.toSeconds());
//		driver.manage().timeouts().pageLoadTimeout(d);
		
//		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println("parentWindowId---> " + parentWindowId);

		String childWindowId = it.next();
		System.out.println("childWindowId---> " + childWindowId);

		driver.switchTo().window(childWindowId);
		System.out.println("ChildTitle---> " + driver.getTitle());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[3]/a")).click();
		System.out.println("ChildTitle---> " + driver.getTitle());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("ParentTitle---> " + driver.getTitle());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.quit();
		
	}

}
