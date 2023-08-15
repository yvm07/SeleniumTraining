//type ="file"  should be present for browse/attachfile/uploadfile buttons
//Alert popup / Javascript popup - Alert API
//File upload popup - sendKeys(file path)
//Browser window popup /Ad popup - windowhandlerAPI
package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleFileAlertPopUp {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/input-type-file/");
		driver.manage().window().maximize();
		
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.id("fileupload")));
//		action.perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(800,800)");
		
		driver.findElement(By.id("fileupload")).sendKeys("C://Users/Smart/Documents/JSON files/store.txt");
		

	}

}
