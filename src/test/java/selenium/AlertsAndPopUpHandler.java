package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsAndPopUpHandler {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert(); 
		System.out.println(alert.getText()); //first alert
		alert.accept(); //click on OK button
		//alert.dismiss(); //dismisses the alert
		
		driver.findElement(By.id("login1")).sendKeys("abc@test.com");
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText()); //second alert
		alert.accept();
		
		driver.findElement(By.id("password")).sendKeys("abc@test");
		driver.findElement(By.name("proceed")).click();
		
		
		
	}

}
