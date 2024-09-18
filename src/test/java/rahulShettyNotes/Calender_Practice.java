package rahulShettyNotes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender_Practice {
	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		browser_Launch();
		month_Selection();
	}
	public static void browser_Launch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public static void month_Selection() throws Throwable {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='form_fields[travel_comp_date]']")).click();
		
		boolean month = driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("May");
		
		while (!month) {
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}
	}

}
