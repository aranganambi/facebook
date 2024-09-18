package rahulShettyNotes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import baseClass.Base_Class;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions extends Base_Class {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		checkBox();
		passengers();
	}
	
	public static void checkBox() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		//waitimp();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		System.out.println("Asserstion was passed");
	}
	
	public static void passengers() throws InterruptedException {
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i=1; i<4; i++){
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		try {
			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText(), "4 Adult");
		} catch (Exception e) {
			System.out.println("Actual result not matching with Expected result");
		}
		
	}
}
