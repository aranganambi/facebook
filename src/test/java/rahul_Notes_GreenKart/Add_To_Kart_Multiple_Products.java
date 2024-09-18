package rahul_Notes_GreenKart;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.Base_Class;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_To_Kart_Multiple_Products extends Base_Class{
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@Test
	public static void products_Ordering() throws Throwable {
		browser_Launch_Edge();
		//browserLaunch();
		get_Url(driver, "https://rahulshettyacademy.com/seleniumPractise/");
		//waitimp(10);
		
		//explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		product_Selecting();
		checkOut();
		address();
	}
	
	public static void browserLaunch() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//browser_Launch_Chrome();
		
		//driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		
	}
	public static void product_Selecting() throws Throwable {
		
		
		String[] itemNeeded = { "Brocolli", "Cauliflower", "Cucumber","Beetroot","Mushroom","Musk Melon","Almonds","Walnuts" };
		
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// Here converting the array to arrayList for easy search operations
			// After converting check whether required items present or not in the looping
			List<String> itemNeededList = Arrays.asList(itemNeeded);
			if (itemNeededList.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
			}
			if (j == itemNeeded.length) {
				
				break;
			}
		}
		System.out.println("Products Added Successfully");
	}
	public static void checkOut() throws Throwable {
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		String promoCode = driver.findElement(By.cssSelector("input.promoCode")).getText();
		System.out.println(promoCode);
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));		
		String promoCodeValidation = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		System.out.println("Promo_Code_Status: "+promoCodeValidation);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}
	public static void address() throws Throwable {
		WebElement dropDown = driver.findElement(By.xpath("//select[@style='width: 200px;']"));
		Select s = new Select(dropDown);
		s.selectByVisibleText("India");
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File from = ts.getScreenshotAs(OutputType.FILE);
		File to = new File("C:\\Users\\Home\\eclipse-workspace\\FaceBooks\\Screenshot\\OrderComfirmation.png");
		FileUtils.copyFile(from, to);
		System.out.println("Order Has Comfirmed Successfully");
		driver.quit();
	}
	

}
