package rahulShettyNotes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusCodeChecking {
	public static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		SoftAssert a = new SoftAssert();

		for (int i = 0; i < links.size(); i++) {
			String url = links.get(i).getAttribute("href");
			String linkName = links.get(i).getText();
			HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode = connection.getResponseCode();
			
			System.out.println(linkName+": "+responseCode);
			
			a.assertEquals(responseCode<200, "The link with text: " + links.get(i).getText() + " is broken with code: " + responseCode);
			
		}
	}
}
