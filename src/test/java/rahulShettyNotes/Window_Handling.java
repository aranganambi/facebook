package rahulShettyNotes;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handling{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		browserLaunch();
		windowHandling();

	}
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void windowHandling() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.cssSelector("a[href*='windows']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		
		//Switching to child window
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
		
		//Switching to child window
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
		driver.quit();
		
	}

}
