package Selenium_New_Features;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.Base_Class;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Invoking_Multiple_Windows extends Base_Class {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement emailField;
	public static WebElement nameField;

	public static void main(String[] args) throws Throwable {
		browserLaunch();
		invoking_Multiple_Windows();
		get_Partial_ScreenShot("C:\\Users\\Home\\eclipse-workspace\\FaceBooks\\Screenshot", nameField);
	}

	public static void browserLaunch() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void invoking_Multiple_Windows() throws Throwable {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parent_Window = it.next();
		String child_Window = it.next();
		String child_Window_2 = it.next();

		driver.switchTo().window(child_Window);
		driver.get("https://rahulshettyacademy.com/");
		String name = driver.findElement(By.xpath("//div/div[1]/div[2]/div/h2")).getText();
		driver.close();

		driver.switchTo().window(child_Window_2);
		driver.get("https://vetriias.com/");
		Thread.sleep(3000);
		String email = driver.findElement(By.xpath("//*[text()='enquiry@vetriias.com']")).getText();
		driver.close();

		driver.switchTo().window(parent_Window);
		Thread.sleep(5000);
		nameField = driver.findElement(By.name("name"));
		nameField.sendKeys(name);
		emailField = driver.findElement(By.name("email"));
		emailField.sendKeys(email);
		
		// Height & Width of the element
		System.out.println(nameField.getRect().getDimension().getHeight());
		System.out.println(nameField.getRect().getDimension().getWidth());

		// Partial Screenshot
		File file = nameField.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));

	}

}
