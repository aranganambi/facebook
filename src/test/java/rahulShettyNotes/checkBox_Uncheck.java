package rahulShettyNotes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkBox_Uncheck {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
     checkBox_Check();
     checkBox_Uncheck();
	}
	
	public static void checkBox_Check() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected();
		}
	
	public static void checkBox_Uncheck() {
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected();
		}
	
	public static void countOfCheckBoxes() {
		driver.findElements(By.xpath("//input[@type='checkbox']")).size();

	}

	}

	


