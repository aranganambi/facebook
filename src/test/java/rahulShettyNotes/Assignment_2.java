package rahulShettyNotes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@class='form-control ng-untouched ng-pristine ng-invalid'])[1]")).sendKeys("Aranganambi");
		driver.findElement(By.name("email")).sendKeys("aranganambi.elumalai@gmail.com");
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("Test@12345");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
		Select g = new Select(gender);
		g.selectByIndex(0);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("20-05-1996");
		driver.findElement(By.className("btn btn-success")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.className("alert alert-success alert-dismissible")).getText());

	}

}
