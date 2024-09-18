package actions_Class_Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handle_Practice {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		browserLaunch();
		windowHandle();
	}
	
	public static void browserLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(); 
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void windowHandle() {
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		//Switching back to parent window
		driver.switchTo().window(childWindow);
		String text = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		System.out.println(text);
		String[] splited = text.split(" ");
		String emailID = splited[4];
		System.out.println(splited[4]);
		
		//Switching back to parent window
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(emailID);
		System.out.println(driver.findElement(By.cssSelector("p.text-center.text-white")).getText());
		String text2 = driver.findElement(By.cssSelector("p.text-center.text-white")).getText();
		String[] splited1 = text2.split(" ");
		System.out.println(splited1[6]);
		String[] finalSplit = splited1[6].split("g");
		System.out.println(finalSplit[0]+"g");
		driver.findElement(By.id("password")).sendKeys(finalSplit[0]+"g");
		
	}

}
