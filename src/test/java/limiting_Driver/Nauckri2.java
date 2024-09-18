package limiting_Driver;
import java.io.File;
import java.util.Arrays;
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
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nauckri2 {
	public static WebDriver driver;
	public static WebElement companyList;
	public static String[] keyWords;

	@Test
	public static void naukriTest() throws Throwable {
		browser_Launch();
		naukri_Login();
		search_Job();
		limiting_Driver();
		clicking_Links();
		
		for (int i = 0; i <= 1; i++) {
			windowHandles();
			clickNext();
			limiting_Driver();
			clicking_Links();
		}
		page_Title();
	}

	public static void browser_Launch() {
		driver = new ChromeDriver();
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
		driver.findElement(By.xpath("(//input[@class='suggestor-input '])[1]")).sendKeys(
				"Functional Testing, Manual Testing, automation testing, automation test engineer, selenium webdriver, qa automation, qa testing,");
		WebElement experiece = driver.findElement(By.id("experienceDD"));
		experiece.click();
		driver.findElement(By.xpath("//*[text()='4 years']")).click();
		driver.findElement(By.xpath("(//input[@class='suggestor-input '])[2]"))
				.sendKeys("chennai, coimbatore,bengaluru,");
		driver.findElement(By.xpath("//*[text()='Search']")).click();

		// wfo
		 driver.findElement(By.xpath("//*[text()='Work from office']")).click();
		 Thread.sleep(2000);
		// hybrid
		driver.findElement(By.xpath("//*[text()='Hybrid']")).click();
		Thread.sleep(2000);
		// remote
		driver.findElement(By.xpath("//*[text()='Remote']")).click();
		Thread.sleep(2000);
		//Temp. WFH due to covid
		//driver.findElement(By.xpath("//*[text()='Temp. WFH due to covid']")).click();
	}

	public static void limiting_Driver() throws InterruptedException {
		Thread.sleep(1000);

		companyList = driver.findElement(By.xpath("//body/div[1]/div/main/div/div[2]/div[2]/div"));
		System.out.println(companyList.findElements(By.xpath("//main/div/div[2]/div[2]/div/div/div/div[1]/a")).size());

	}

	public static void clicking_Links() throws Throwable {

		List<WebElement> companyLinks = companyList
				.findElements(By.xpath("//main/div/div[2]/div[2]/div/div/div/div[1]/a"));
		for (int i = 0; i < companyLinks.size(); i++) {
			Thread.sleep(1000);
			String keys = Keys.chord(Keys.CONTROL, Keys.ENTER);
			companyLinks.get(i).sendKeys(keys);
			Thread.sleep(1000);

		}
	}

	public static void windowHandles() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		driver.switchTo().window(parent);
	}

	public static void clickNext() throws Throwable {
					driver.findElement(By.xpath("//*[text()='Next']")).click();
			Thread.sleep(3000);
		
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
