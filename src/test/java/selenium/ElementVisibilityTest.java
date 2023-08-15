//isDisplayed applies to all webelements
//isEnabled applies to buttons(active or not)
//isSelected applies to checkbox, radio buttons, dropdown


package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementVisibilityTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		boolean b1 = driver.findElement(By.id("SubscriptionAgreement")).isDisplayed();
		boolean b2 = driver.findElement(By.id("SubscriptionAgreement")).isEnabled();
		boolean b3 = driver.findElement(By.id("SubscriptionAgreement")).isSelected();
		System.out.println("b1-->" +b1);
		System.out.println("b2-->" +b2);
		System.out.println("b3-->" +b3);
		
		if(b1&b2) {
			if(!b3) {
				new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("SubscriptionAgreement"))));
				driver.findElement(By.xpath("//div[@class = 'checkbox-ui']")).click();	
			}
			driver.findElement(By.name("start my free trial")).click();
		}
		
	}

}
