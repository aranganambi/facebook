package rahul_Notes_GreenKart;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable_Checking_SortedOrNot_Using_Streams {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String childWindow;
	public static String parentWindow;

	@Test
	public static void webTable_Checking() throws Throwable {
		browserLaunch();
		windowHandles();
		sorting();
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
		driver.findElement(By.xpath("//table/thead/tr/th[1]")).click();

		// Cpature all webelements into list
		List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

		// Get all texts from the elements and store into new list
		List<String> originalText = elements.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println(originalText);

		// Make the originalText in sorted order
		List<String> sortedText = originalText.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedText);

		// compare the originalText and sortedText
		Assert.assertEquals(originalText, sortedText);

		// To get particular veggie price
		List<String> price;
		do {
			List<WebElement> elements_Page_Wise = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
			price = elements_Page_Wise.stream().filter(s -> s.getText().contains("Wheat")).map(s -> veggiePrice(s))
					.collect(Collectors.toList());
			System.out.println(price);

			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	public static String veggiePrice(WebElement s) {
		
		String price1 = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return price1;
	
		

	}

}
