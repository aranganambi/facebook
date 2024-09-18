package rahulShettyNotes;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll_Down {
	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		browser_Launch();
		auto_Suggestion_DropDown();
		scroll_Down();
	}

	public static void browser_Launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public static void auto_Suggestion_DropDown() throws Throwable {
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
			Thread.sleep(3000);
			WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
			Select s = new Select(dropDown);
			s.selectByValue("option1");
		}
	}

	public static void scroll_Down() {
		JavascriptExecutor ts = (JavascriptExecutor) driver;
		ts.executeScript("window.scrollBy(0,500)");

		List<WebElement> noOfRows = driver.findElements(By.xpath("//fieldset/table/tbody/tr"));
		System.out.println(noOfRows.size());

		List<WebElement> noOfColumns = driver.findElements(By.xpath("//fieldset/table/tbody/tr/th"));
		System.out.println(noOfColumns.size());

		String a = driver.findElement(By.xpath("//fieldset/table/tbody/tr[3]/td[1]")).getText();
		String b = driver.findElement(By.xpath("//fieldset/table/tbody/tr[3]/td[2]")).getText();
		String c = driver.findElement(By.xpath("//fieldset/table/tbody/tr[3]/td[3]")).getText();

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		driver.quit();
	}

}
