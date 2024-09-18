package limiting_Driver;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClass.Base_Class;

	public class Listeners extends Base_Class implements ITestListener{
		ExtentTest test;
		//Thread safe
		ThreadLocal<ExtentTest> extentTest = new ThreadLocal <ExtentTest>();
		
		
		ExtentReports extent = ExtentReportDemo.extendReport();
		@Override
		public void onTestStart(ITestResult result) {
			System.out.println("Test paaased");
			test = extent.createTest(result.getMethod().getMethodName());
			extentTest.set(test);
		}
		
		private ThreadLocal ThreadLocal() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			extentTest.get().log(Status.PASS, "Test Passed");
			System.out.println("Test paaased");
		}
		
		@Override
		public void onTestFailure(ITestResult result) {
			System.out.println("Test failed");
			extentTest.get().fail(result.getThrowable());
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			String filePath = null;
			try {
				 filePath = screenshot(result.getMethod().getMethodName(), driver);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
			
			
			
		}
		
		@Override
		public void onTestSkipped(ITestResult result) {
			
		}
		
		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			
		}
		
		@Override
		public void onFinish(ITestContext context) {
			extent.flush();
		}
		
	}

