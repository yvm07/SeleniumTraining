package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomXPath {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

//		WebElement element = driver.findElement(By.xpath("//h2[@class='a-color-base as-title-block-left']"));
		WebElement element = driver.findElement(By.xpath(
				"//div[@class = 'a-section a-spacing-none a-spacing-top-small feed-carousel first-carousel']/a[2]"));

		Actions action = new Actions(driver);
		action.scrollToElement(element).build().perform();

		// str--> unordered carousel list
		String str = "//ul[@class = 'a-unordered-list a-nostyle a-horizontal feed-carousel-shelf _deals-shoveler-v2_style_list__pjYuB']";
		// str1 --> click button xpath
		String str1 = "//div[@class = 'a-section a-spacing-none a-spacing-top-small feed-carousel first-carousel']/a[2]";
		// Str2--->ordered carousel list
		String str2 = "//li[@class = 'feed-carousel-card _deals-shoveler-v2_style_dealCard__1HqkZ _deals-shoveler-v2_style_dealCardMinHeight__3YZz0']";

		List<WebElement> list = driver.findElements(By.xpath(str1));

		System.out.println(list.size());

		ArrayList<WebElement> finallist = new ArrayList<WebElement>();
		List<WebElement> result = driver.findElements(By.xpath(str2));
		int i = result.size();
		System.out.println(i);

	//	finallist.addAll(result);
		for (int c = 0; c < result.size(); c++) {
			System.out.println(result.get(c).getText());

		}
//--->iteration		
		WebElement firstResult1 = new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(str1)));

		firstResult1.click();
		List<WebElement> result1 = driver.findElements(By.xpath(str2));
//		finallist.addAll(result1);
		for (int c = 0; c < result1.size(); c++) {
			System.out.println(result1.get(c).getText());

		}
//---->iteration		
		WebElement firstResult2 = new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(str1)));

		firstResult2.click();
		List<WebElement> result2 = driver.findElements(By.xpath(str2));
//		finallist.addAll(result);

//		System.out.println(finallist.size());
		for (int c = 0; c < result2.size(); c++) {
			System.out.println(result2.get(c).getText());

		}
	}

}
