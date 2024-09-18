package rahulShettyNotes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nested_Frames {
	public static WebDriver driver;

	public static void main(String[] args) {
		browserLaunch();
		nestedFrames();
	}

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static void nestedFrames() {
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		System.out.println(driver.findElements(By.tagName("frameset")).size());
		driver.switchTo().frame(0);
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("content")).getText());
		driver.quit();
	}

}
