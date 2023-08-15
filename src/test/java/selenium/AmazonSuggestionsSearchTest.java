package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSuggestionsSearchTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("hp");
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='left-pane-results-container']//div/descendant::div[@role='button']"));
		System.out.println(list.size());	
		
		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getText()); -> this caused: Timed out receiving message from renderer
			if(list.get(i).getText().contains("hp printer")) {
				list.get(i).click();
				break;
			}
		}
			
				
		

	}

}
