package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/Smart/Downloads/geckodriver-v0.33.0-win32/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver1 = new ChromeDriver();
		//WebDriver driver2 = new EdgeDriver();
		driver.get("http://www.google.com");

	}

}
//"C:\Users\Smart\Downloads\geckodriver-v0.33.0-win32\geckodriver.exe"