package selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowSwitch {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement elink = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[1]/a/button"))));
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.LEFT_CONTROL).click(elink).keyUp(Keys.LEFT_CONTROL).build().perform();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String Parent = it.next();
		String Child = it.next();
		System.out.println("Parent ID---> "+Parent);
		System.out.println("Child ID---> "+Child);
		driver.switchTo().window(Child);
		
		driver.findElement(By.id("Form_getForm_FullName")).sendKeys("John Cena");
		driver.findElement(By.id("Form_getForm_Email")).sendKeys("test@test.com");
		Select select = new Select(driver.findElement(By.id("Form_getForm_Country")));
		select.selectByVisibleText("United States");
		driver.findElement(By.id("Form_getForm_Contact")).sendKeys("9988776655");
//		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]")).click();
		driver.findElement(By.id("Form_getForm_action_submitForm")).click();
		
		driver.close();
		driver.switchTo().window(Parent);
		Thread.sleep(3000);
		driver.close();

		
//		List<WebElement> solist = solution.findElements(By.xpath("//div[@class ='secondary-menu']/ul//following-sibling::li"));
//		for(int i=0; i<solist.size(); i++) {
//			System.out.println(solist.get(i).getText());
//		}
		
		
	}
	

}
