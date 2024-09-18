package rahulShettyNotes;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Miscellaneous {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		browser_Launch();
		screenShot();
	}

	public static void browser_Launch() {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}
	
	public static void screenShot() throws IOException {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Users\\Home\\Pictures\\Saved Pictures\\snap1.png"));
	}
	
	
}
