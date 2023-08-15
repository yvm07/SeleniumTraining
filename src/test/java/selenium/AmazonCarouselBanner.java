package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonCarouselBanner {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
//	    System.setProperty("webdriver.firefox.driver", "C:/Users/Smart/Downloads/geckodriver-v0.33.0-win32/geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.linkText("See all deals"))).perform();
//		

//		JavascriptExecutor js =(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.linkText("See all deals")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(1000,1000)");

//		WebElement element = driver.findElement(By.linkText("See all deals"));
//		int x = element.getLocation().getX();
//		int y = element.getLocation().getY();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(" + x + "," + y + ")");

//		String carousel = "//li[@class = 'feed-carousel-card _deals-shoveler-v2_style_dealCard__1HqkZ _deals-shoveler-v2_style_dealCardMinHeight__3YZz0']";
//		String clickB = "//div[@class = 'a-section a-spacing-none a-spacing-top-small feed-carousel first-carousel']/a[2]";
//		//1
//		List items1 = driver.findElements(By.xpath(carousel));
//		String name1;
//		ArrayList<String> list1 = new ArrayList<String>();
//		ArrayList<String> finalList = new ArrayList<String>();
//		
//		for(int i=1; i<=items1.size(); i++) {
//			name1 = driver.findElement(By.xpath(carousel+"["+i+"]")).getText();
//			list1.add(name1);
//		}
//		finalList.addAll(list1);
//		driver.findElement(By.xpath(clickB)).click();
//		
//		//2
//		List items2 = driver.findElements(By.xpath(carousel));
//		String name2;
//		ArrayList<String> list2 = new ArrayList<String>();
//		
//		
//		for(int i=1; i<=items2.size(); i++) {
//			name2 = driver.findElement(By.xpath(carousel+"["+i+"]")).getText();
//			list2.add(name2);
//		}
//		finalList.addAll(list2);
//		driver.findElement(By.xpath(clickB)).click();
//		
//		//3
//		List items3 = driver.findElements(By.xpath(carousel));
//		String name3;
//		ArrayList<String> list3 = new ArrayList<String>();
//		
//		
//		for(int i=1; i<=items3.size(); i++) {
//			name3 = driver.findElement(By.xpath(carousel+"["+i+"]")).getText();
//			list2.add(name3);
//		}
//		finalList.addAll(list3);
//		
//		for(int c=0; c<finalList.size(); c++) {
//			System.out.println(finalList);
//		}
		
//		String listItem = "//li[starts-with(@data-csa-c-item-id, 'amzn1.deal.')]";
//		String button = "//a[@class= 'a-link-normal feed-carousel-control feed-right' and @style ='display: inline;']";
//		
//		List<WebElement> itemList = driver.findElements(By.xpath(listItem));
//		System.out.println(itemList.size());
//
//		for (int i = 0; i < itemList.size(); i++) {
//			if(itemList.get(i).isDisplayed()) {
//				String name = itemList.get(i).getText();
//				System.out.println(name);
//				System.out.println("==========================");
//			}else {
//				driver.findElement(By.xpath(button)).click();
//				Thread.sleep(3000);
//			}
//			
//		}
	
		String listItem = "//div[@class = 'a-section feed-carousel-viewport']//ul/descendant::li[@data-csa-c-owner='DealsX']";
		String nextButton = "//a[@aria-label='Carousel next slide' and @style='display: inline;']//descendant::span[@class='gw-icon feed-arrow']";
		
		List<WebElement> itemList = driver.findElements(By.xpath(listItem));
		System.out.println(itemList.size());
		
		for(WebElement el:itemList) {
			if(el.isDisplayed()) {
				System.out.println(el.getText());
				System.out.println("==================================");
			}else {
				new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(nextButton))).click();
			}
			
		}
		
		driver.close();
		
		
		
		
	}

}
