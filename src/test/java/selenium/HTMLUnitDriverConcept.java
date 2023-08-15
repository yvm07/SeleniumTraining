//add htmlunitdriver jar file to library


//package selenium;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//
//public class HTMLUnitDriverConcept {
//
//	public static void main(String[] args) throws InterruptedException {
//		
//		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
//		
//		//testing is happening behind the scenes -- no browser is launched
//		// execution of testcases is very fast
//		// performance of script is very fast
//		// not suitable for Actions class - user action - mousemovement, doubleclick, drag&drop
//		// also called GhostDriver/ HeadlessBrowser
//		
////		WebDriver driver = new HtmlUnitDriver(); //-->headless driver
//		
//		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//		System.out.println(driver.getTitle());
//		
//		driver.findElement(By.name("proceed")).click();
//		System.out.println(driver.getTitle());
//		
//		driver.findElement(By.id("login1")).sendKeys("abc@test.com");
//		driver.findElement(By.name("proceed")).click();
//		System.out.println(driver.getTitle());
//		
//		driver.findElement(By.id("password")).sendKeys("abc@test");
//		driver.findElement(By.name("proceed")).click();
//		System.out.println(driver.getTitle());
//		
//	}
//
//}
