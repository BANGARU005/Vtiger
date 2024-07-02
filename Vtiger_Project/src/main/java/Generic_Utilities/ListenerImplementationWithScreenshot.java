package Generic_Utilities;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationWithScreenshot implements ITestListener 
{

	 ExtentReports report;
	 ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		test=report.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("<--------I am Listening----------->");
		 
		String screenShot=null;
		
		try {
			screenShot = WebDriver_utility.takeScreenShot(BaseClass.sDriver, result.getMethod().getMethodName());
						} catch (Throwable e) {
							
							e.printStackTrace();
						}
				
					test.addScreenCaptureFromPath(screenShot);
				
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNumber();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+ranNum);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Testing");
		spark.config().setReportName("Bangaru");
		
		report=new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("executed by", "Bangaru");
		report.setSystemInfo("reviewed by", "Reaya");
	}

	@Override
	public void onFinish(ITestContext context) {
			
		report.flush();
	}
	
	
	

}
