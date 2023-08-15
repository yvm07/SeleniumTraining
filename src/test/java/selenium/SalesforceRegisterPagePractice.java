

package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SalesforceRegisterPagePractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("UserFirstName")).sendKeys("John");
		driver.findElement(By.name("UserLastName")).sendKeys("Cena");
		driver.findElement(By.name("UserEmail")).sendKeys("abc@test.com");
		
		Select selectJobTitle = new Select(driver.findElement(By.name("UserTitle")));
		selectJobTitle.selectByVisibleText("Student / Job Seeker / Personal Interest");
		
		driver.findElement(By.name("CompanyName")).sendKeys("TechMahindra");
		
		Select selectEmployees = new Select(driver.findElement(By.name("CompanyEmployees")));
		selectEmployees.selectByVisibleText("2001+ employees");
		
		driver.findElement(By.name("UserPhone")).sendKeys("9762652588");
		
		Select selectCountry = new Select(driver.findElement(By.name("CompanyCountry")));
		selectCountry.selectByVisibleText("United States");
		
		Select selectState = new Select(driver.findElement(By.name("CompanyState")));
		selectState.selectByVisibleText("California");
		
		driver.findElement(By.className("checkbox-ui")).click();
		

		
	}

}
