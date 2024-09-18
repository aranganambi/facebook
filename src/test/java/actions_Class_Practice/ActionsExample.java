package actions_Class_Practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyAgreementSpi.ECVKO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsExample {
	private static final int VK_C = 0;
	private static final int VK_V = 0;
	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		browserLaunch();
		actions();
	}

	public static void browserLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(); 
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void actions() throws Throwable {
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		a.moveToElement(move).build().perform();
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().sendKeys("aranganambi").build().perform();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).getText();
		System.out.println(text);
		System.out.println(driver.findElement(By.id("twotabsearchtextbox")).getText());
		
		driver.quit();
	}
	
	

}
