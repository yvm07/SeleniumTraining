package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Google") ) {
			System.out.println("Correct title");
		}else {
			System.out.println("Incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		if(driver.getCurrentUrl().equals("https://www.google.com/") ) {
			System.out.println("Correct URL");
		}else {
			System.out.println("Incorrect URL");
		}
		
		//System.out.println(driver.getPageSource());
		
		driver.close();
	}
}
