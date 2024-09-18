package baseClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static WebDriver driver;
	public static String url;
	public static String firstName;
	public static String lastName;
	public static String email;
	public static String userName;
	public static String password;

	
	public static void properties() {

		try {
			FileInputStream stream = new FileInputStream("config.properties");
			Properties prop = new Properties();
			prop.load(stream);

			url = prop.getProperty("URL");
			firstName = prop.getProperty("FirstName");
			lastName = prop.getProperty("Lastname");
			email = prop.getProperty("email");
			userName = prop.getProperty("UserName");
			password = prop.getProperty("Password");

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}

	}

	// browser_Launch_Chrome
	public static  WebDriver browser_Launch_Chrome() {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Launched Successfully");
			return driver;
			
			
		

	}
	
	public static WebDriver browser_Launch_Edge() {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		return driver;
	

}

	// browser_Launch_Firefox
	public static void browser_Launch_Firefox() {
		try {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox Launched Successfully");
		} catch (Exception e) {
			System.out.println("Firefox Launched Fail");
		}

	}

	// browser_Launch_EdgeDriver
	public static void browser_Launch_InternetExplorer() {
		try {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("EdgeDriver Launched Successfully");
		} catch (Exception e) {
			System.out.println("EdgeDriver Launched Fail");
		}

	}

	// get_url
	public static void get_Url(WebDriver driver , String link) {
		driver.get(link);
	}

	// Maximize
	public static void maximize() {
		driver.manage().window().maximize();
	}

	// FullScreen
	public static void fullScreen() {
		driver.manage().window().fullscreen();
	}

	// Set_Size
	public static void set_Size(int a, int b) {
		Dimension d = new Dimension(a, b);
		driver.manage().window().setSize(d);
	}

	// sendkeys
	public static void input_Value(WebElement name, String username) {
		name.sendKeys(username);
	}

	// sendkeys 2
	public static void input_Value_2(String locator, String username) {
		driver.findElement(By.id(locator)).sendKeys(username);

	}

	// click
	public static void clicks(WebElement clickin) {
		clickin.click();
	}

	public static void clicks_2(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	// move_element
	public static void Movein(WebElement move) {
		Actions act = new Actions(driver);
		act.moveToElement(move).build().perform();
	}

	// context
	public static void context(WebElement user) {
		Actions act = new Actions(driver);
		act.contextClick(user).build().perform();
	}

	// double_Click
	public static void doubl(WebElement user) {
		Actions act = new Actions(driver);
		act.doubleClick(user).build().perform();
	}

	// robot
	public static void robot() throws Throwable {
		Robot r = new Robot();
	}

	// robot_Down
	public static void robot_Down() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
	}

	// robot_Up
	public static void robot_UP() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
	}

	// robot_Enter
	public static void robot_Enter() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}

	// robot_Keyrelease_Down
	public static void robot_Down_keyrelease() throws Throwable {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_DOWN);

	}

	// robot_Keyrelease_Up
	public static void robot_Up_Keyrelease() throws Throwable {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_UP);
	}

	// robot_TAB
	public static void robot_Tab() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
	}

	// for_loop
	public static void looping(WebElement loops) {
		for (int i = 0; i < 3; i++) {
			loops.click();
		}
	}

	// drop_down
	public static void drop(WebElement dropdown, String value) {
		Select s = new Select(dropdown);
		s.selectByValue(value);
	}

	// drop_down
	public static void drop1(WebElement dropdown, int value) {
		Select s = new Select(dropdown);
		s.selectByIndex(value);
		
	}

	// scroll_up
	public static void scroll_Up() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,-600)", " ");
	}

	// scroll_down
	public static void scroll_Down() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)", " ");
	}

	// screen_shot
	public static String screenshot(String location, WebDriver driver) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File from = ts.getScreenshotAs(OutputType.FILE);
		File to = new File(System.getProperty("user.dir") + "//Reports//" + location + ".png");
		FileUtils.copyFile(from, to);
		return System.getProperty("user.dir") + "//Reports//" + location + ".png";
	}

	public static void get_Partial_ScreenShot(String location, WebElement object) throws Throwable {
		File from = object.getScreenshotAs(OutputType.FILE);
		File to = new File(location);
		FileUtils.copyFile(from, to);

	}

	public static void screenShot1(String location) throws Throwable {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(location));

	}

	// implicitly wait
	public static void waitimp(int duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}

	// explicit wait
	public static void waitexp(String locator, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	}

	// quit
	
	public static void quit() {
		driver.quit();
	}

	// close
	private void close() {
		driver.close();
	}

	// navigate
	public static void transfer(String url) {
		driver.navigate().to(url);
	}

	// navigation_forward
	public static void forward() {
		driver.navigate().forward();
	}

	// backward
	public static void backward() {
		driver.navigate().back();
	}

	// refresh
	public static void refresh() {
		driver.navigate().refresh();
	}

	// get
	public static void title() {
		driver.getTitle();
	}

	// thread
	public static void thread(int duration) throws Throwable {
		Thread.sleep(duration);
	}

	// alert_accept
	public static void alert_Accept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	// alert_dismiss
	public static void alert_Dismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	// alert_Keys
	public static void alert_Keys(String keys) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(keys);
		al.accept();
	}

	// get_text
	public static void text() {
		driver.getTitle();
	}

	// Clear
	public static void clear(WebElement element) {
		element.clear();
	}
}
