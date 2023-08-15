//Data Driven Framework using properties file

package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertiesFile {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/Smart/eclipse-workspace/SeleniumTraining/config.properties");
		prop.load(ip);

		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));

		String url = prop.getProperty("URL");
		System.out.println(url);

		String browser = prop.getProperty("browser");
		System.out.println(browser);

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:/Users/Smart/Downloads/Firefox Installer.exe");
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();

		driver.findElement(By.id(prop.getProperty("name_locator"))).sendKeys(prop.getProperty("name"));

		driver.findElement(By.id(prop.getProperty("mobile_locator"))).sendKeys(prop.getProperty("mobile"));

		driver.findElement(By.id(prop.getProperty("submit_locator"))).click();

	}

}
