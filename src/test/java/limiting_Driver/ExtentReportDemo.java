package limiting_Driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {

	public static ExtentReports extents;
	public static WebDriver driver;
	
	public static ExtentReports extendReport(){
		String path = System.getProperty("user.dir")+"\\Reports\\html.index";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Naukri Automation");
		reporter.config().setDocumentTitle("Naukri");
		
		
		extents = new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("Tester Name", "Mr.Aranganambi");
		return extents;
		
	}
		
}
