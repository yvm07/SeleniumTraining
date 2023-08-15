//	1)id
//	2)relative xpath
//	3)name
//	4)linkText

package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Smart/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.amazon.in/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26adgrpid%3D58355126069%26ext_vrnc%3Dhi%26hvadid%3D486458706470%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9062055%26hvnetw%3Dg%26hvpone%3D%26hvpos%3D%26hvptwo%3D%26hvqmt%3De%26hvrand%3D1400341601253580588%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2154373%26ref%3Dpd_sl_7hz2t19t5c_e%26tag%3Dgooghydrabk1-21%26ref_%3Dnav_custrec_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

		// --------------1)x.path
//		driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).sendKeys("Tom Peter");
//		driver.findElement(By.xpath("//*[@id=\"ap_phone_number\"]")).sendKeys("7777888822");
//		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("abc@test.com");
//		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("abc@test");

		// driver.findElement(By.id("ap_customer_name")).sendKeys("Tom Peter");
		// //---2)id

		// driver.findElement(By.name("email")).sendKeys("abc@test.com"); //---3)name

		// driver.findElement(By.linkText("Sign in")).click(); //---4)linkText

		// driver.findElement(By.partialLinkText("Create a")).click();  //---5)partialLinkText (not recommended)

		//---6)cssSelector
		
		
		//if id is there === #id
		//if className is there === .class
		// driver.findElement(By.cssSelector("#ap_customer_name")).sendKeys("Harry Potter"); //---6)cssSelector
		
		driver.findElement(By.className("a-button-input")).click(); //---7)className (not recommended)
	}

}
