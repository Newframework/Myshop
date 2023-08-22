package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testbase.Baseclass;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		
		String timestamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
		
		repName="Test-Report-"+timestamp+".html";
		
		sparkreporter = new ExtentSparkReporter(".\\report\\"+repName);
		
		sparkreporter.config().setDocumentTitle("Myshop Automation Report");
		sparkreporter.config().setReportName("My shop Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("Application", "Myshop");
		extent.setSystemInfo("Modul", "Admin");
		extent.setSystemInfo("sub modul", "Customers");
		extent.setSystemInfo("Operating system", System.getProperty("os.mane"));
		extent.setSystemInfo("User Name", System.getProperty("user.mane"));
		extent.setSystemInfo("Environment", "QA");
	
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		
		test.log(Status.PASS, "Test Passed");
	}
	
	
	public void onTestFailure(ITestResult result)
	{
		
		test=extent.createTest(result.getName());
		
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		try
		{
				String imgpath=new Baseclass().captureScreen(result.getName());
			
		    test.addScreenCaptureFromPath(imgpath);	
		
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	
	}
		
		
		

		public void onTestSkipped(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP,"testSkipped");
			test.log(Status.SKIP,result.getThrowable().getMessage());
			
		}
		
		
		public void onFinish(ITestContext testContext)
		{
			extent.flush();
		}
		
		
		
	
}
