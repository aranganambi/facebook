package rahulShettyNotes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop_Down_Practice {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		//DropdownByIndex
		WebElement dropdown = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select  s = new Select(dropdown); 
		s.selectByIndex(3);
		System.out.println(s.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		//DropdownByVisibleText
		s.selectByVisibleText("AED");
		System.out.println(s.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		//DropDownByValue
		s.selectByValue("INR");
		System.out.println(s.getFirstSelectedOption().getText());
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
		
		

	}

}
