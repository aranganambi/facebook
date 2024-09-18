package iframes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframes_Example {
	public static WebDriver driver;
	
	
	@Test
	public static void browserLaunch() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://jqueryui.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	
	@Test
	public static void iframe_And_DragDrop() {
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(drag, drop).build().perform();
		System.out.println("Successfully Dropped");
	}

}
