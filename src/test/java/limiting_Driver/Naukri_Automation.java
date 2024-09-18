package limiting_Driver;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Naukri_Automation {
	public static WebDriver driver;
	public static WebElement companyList;
	
	public static void main(String[] args) throws Throwable {
		browser_Launch();
		naukri_Login();
		search_Job();
		limiting_Driver();
		clicking_Links();
		page_Title();
	}
	
	public static void browser_Launch() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.naukri.com/nlogin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public static void naukri_Login() {
		driver.findElement(By.id("usernameField")).sendKeys("aranganambi.ezhumalai@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Eras@7871044138");
		driver.findElement(By.xpath("(//*[text()='Login'])[3]")).click();
	}
	
	public static void search_Job() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span.nI-gNb-sb__placeholder")).click();
		driver.findElement(By.xpath("(//input[@class='suggestor-input '])[1]")).
		sendKeys("automation testing, automation test engineer, selenium webdriver, qa automation, qa testing,");
		WebElement experiece = driver.findElement(By.id("experienceDD"));
		experiece.click();
		for (int i=0; i<=3;i++) {
			Thread.sleep(1000);
			String keys = Keys.chord(Keys.CONTROL , Keys.DOWN);	
		}
		Keys.chord(Keys.CONTROL , Keys.ENTER);
		
		driver.findElement(By.xpath("(//input[@class='suggestor-input '])[2]")).sendKeys("chennai, bangalore, coimbatore,");
		driver.findElement(By.xpath("//*[text()='Search']")).click();
		
	}
	
	public static void limiting_Driver() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[@class='ni-icon-unchecked'])[3]")).click();
		Thread.sleep(1000);
		companyList = driver.findElement(By.xpath("//body/div[1]/div/main/div/div[2]/div[2]/div"));
		System.out.println(companyList.findElements(By.tagName("a")).size());
		
//		JavascriptExecutor ts = (JavascriptExecutor) driver;
//		ts.executeScript("window.scrollBy(0,1500)");
	}
	
	public static void clicking_Links() throws Throwable {
		for (int i = 0; i < companyList.findElements(By.tagName("a")).size(); i++) {
			Thread.sleep(1000);
			String keys = Keys.chord(Keys.CONTROL , Keys.ENTER);
			Thread.sleep(1000);
			companyList.findElements(By.tagName("a")).get(i).sendKeys(keys);
			Thread.sleep(1000);
			//i=i+3;
	}
	}
	
	public static void page_Title() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
}
	
}