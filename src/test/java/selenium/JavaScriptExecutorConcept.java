package selenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("email")).sendKeys("yamuna murthy");

		driver.findElement(By.id("pass")).sendKeys("yamunamurthy");

		WebElement button = driver.findElement(By.name("login"));
		flash(button, driver);

//		button.click();
		clickElementByJS(button, driver);

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile method
		FileUtils.copyFile(src, new File("C:/Users/Smart/Documents/JSON files/" + timeStamp + ".png"));

		generateAlert(driver, "Check error marked in red");
		driver.switchTo().alert().accept();

//		driver.navigate().refresh();
		refreshBrowserByJS(driver);
		
		System.out.println(getTitleByJS(driver));
		
		System.out.println(getPageInnerText(driver));
		
//		scrollPageDown(driver);
		
		scrollIntoView(driver, driver.findElement(By.xpath("//a[text() = 'Forgotten account?']")));
		
	}

	public static void flash(WebElement element, WebDriver driver) {
		String bgcolor = element.getCssValue("background");
		System.out.println("bgcolor " + bgcolor);
		for (int i = 0; i < 50; i++) {
			changeColor("rgb(242, 231, 24)", element, driver);
			changeColor(bgcolor, element, driver);
		}

	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('style', 'border:3px solid red; background:" + color + "')",
				element);
	}

	public static void generateAlert(WebDriver driver, String message) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}
	
	

}
