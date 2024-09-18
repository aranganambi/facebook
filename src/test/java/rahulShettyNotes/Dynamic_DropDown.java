package rahulShettyNotes;

import java.awt.Dimension;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_DropDown {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException{
		fromAndTo();
		dateSelection();
		passengers();
		currency();
		autoSuggesion();
		uiChecking();
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		driver.quit();
		
	}
	
	public static void fromAndTo() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		System.out.println("Edit field successfully clicked");
		driver.findElement(By.xpath("//*[text()=' Chennai (MAA)']")).click();
		System.out.println("From: Chennai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //*[text()=' Kochi (COK)']")).click();
		System.out.println("To: Kochi");
	}

	public static void dateSelection() {
		driver.findElement(By.xpath("(//*[text()='25'])[1]")).click();
	}
	
	public static void passengers() throws InterruptedException {
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i=0; i<=5; i++){
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		Thread.sleep(2000);
		int j = 0;
		while (j<4) {
			driver.findElement(By.id("hrefIncChd")).click();
			j++;
		}
		Thread.sleep(2000);
//		for (int k = 0; k < 3; k++) {
//			driver.findElement(By.id("hrefIncInf")).click();
//		}
//		Thread.sleep(2000);
		driver.findElement(By.id("btnclosepaxoption")).click();
	}
	
	public static void currency() throws InterruptedException {
		WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Thread.sleep(2000);
		Select s = new Select(currency);
		s.selectByVisibleText("USD");
	}
	
	public static void autoSuggesion() throws InterruptedException {
		driver.findElement(By.id("autosuggest")).sendKeys("unit");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("United Kingdom (UK)")) {
				option.click();
				break;
			}
			String str = driver.findElement(By.id("autosuggest")).getText();
			Thread.sleep(1000);
			System.out.println(str);
			
		}
	}
	public static void uiChecking() {
		System.out.println(driver.findElement(By.cssSelector(".picker-second")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		if (driver.findElement(By.cssSelector(".picker-second")).getAttribute("style").contains("0.5")) {
			System.out.println("Its enabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("Disabled");
			Assert.assertFalse(true);
		}
	}
}
