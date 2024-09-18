package limiting_Driver;

import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Getting_Total_Links_Lists {
	public static WebDriver driver;
	public static WebElement footerLinks;
	public static WebElement headerLinks;
	public static WebElement columnDriver;
	
	public static void main(String[] args) throws Throwable {
		browserLaunch();
		total_Links_Count();
		header_Links_Count();
		footer_Links_Count();
		first_Column_Links();
		clicking_Links();
		page_Title();
		driver.quit();
	}

	public static void browserLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// Getting Total Links Presents In The Current Page
	public static void total_Links_Count() {
		System.out.println(driver.findElements(By.tagName("a")).size());
	}
	
	// Getting Header Links Presents In The Current Page
	public static void header_Links_Count() {
		headerLinks = driver.findElement(By.xpath("//header[@class='jumbotron text-center header_style']"));
		System.out.println(headerLinks.findElements(By.tagName("a")).size());
	}

	// Getting Footer Links Presents In The Current Page
	public static void footer_Links_Count() {
	    footerLinks = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerLinks.findElements(By.tagName("a")).size());
	}
	
	// Getting First Column Of Footer Links Presents In The Current Page
	public static void first_Column_Links() {
		columnDriver = footerLinks.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
	}
	
	//Clicking All Links 1 By 1
	public static void clicking_Links() throws Throwable {
		for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
			String keys = Keys.chord(Keys.CONTROL , Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(keys);
			Thread.sleep(3000);
		}
	}
	
	//Tacking PageTitle By Window Handling
	public static void page_Title() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
	}
	
	
}
