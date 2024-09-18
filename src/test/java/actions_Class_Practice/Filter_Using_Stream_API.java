package actions_Class_Practice;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filter_Using_Stream_API {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String childWindow;
	public static String parentWindow;
	
	public static void main(String[] args) throws Throwable {
		browserLaunch();
		windowHandles();
		sorting();
		driver.quit();
	}
	
	public static void browserLaunch() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='cart-header-navlink'])[1]")).click();
	}

	public static void windowHandles() {
		Set<String> windowHandle = driver.getWindowHandles();
		Iterator<String> it = windowHandle.iterator();
		parentWindow = it.next();
		childWindow = it.next();
	}

	public static void sorting() {
		driver.switchTo().window(childWindow);
		driver.findElement(By.id("search-field")).sendKeys("rr");
		
		//Storing all webElements in List
		List<WebElement> originalElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		System.out.println("originalElements: "+originalElements.size());
		
		List<WebElement> filteredElements = originalElements.stream().filter(s->s.getText().contains("rr")).collect(Collectors.toList());
		System.out.println("filteredElements: "+filteredElements.size());
		assertEquals(originalElements, filteredElements);
	}

}
