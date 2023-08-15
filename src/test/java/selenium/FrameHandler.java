package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandler {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html_iframe.asp");
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(250,250)");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/iframe")));
		System.out.println(driver.getTitle());
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("javascript:window.scrollBy(500,500)");
		
//		driver.findElement(By.linkText("Study our free HTML Tutorial »")).click();
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/p[7]/a"));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/p[7]/a")).click();
		

	}

}
