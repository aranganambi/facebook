package rahulShettyNotes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.Base_Class;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop_Down extends Base_Class{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		//Feeding username and password in the URL itself
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

}
}