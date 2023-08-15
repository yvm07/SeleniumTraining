package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonCarousel {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		driver.get("https://www.amazon.in/");
		
		List<WebElement> elist = driver.findElements(By.tagName("a"));
		System.out.println(elist.size());
		
		for(int i=1; i<elist.size();i++) {
			String text = elist.get(i).getText();
			System.out.println(text);
		}
		
	}

}
