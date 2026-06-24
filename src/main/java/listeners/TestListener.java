package listeners;

import java.io.IOException;

import Base.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.ExtentManager;
import Utility.Screenshot;

public class TestListener implements ITestListener {

		ExtentReports extent = ExtentManager.getInstance();

		private static ThreadLocal<ExtentTest> test =new ThreadLocal<>();

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("Execution Started");
	    }

	    @Override
	    public void onTestStart(ITestResult result) {

	    	test.set(extent.createTest(result.getMethod().getMethodName()));
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {

	    	test.get().pass("Test Passed");
	        BaseClass.logger.info(result.getName() + " PASSED");
	    }
	    
	    @Override
	    public void onTestFailure(ITestResult result) {

	        try {
	            String screenshotPath =Screenshot.captureScreenshot(BaseClass.getDriver(),result.getName());

	            ExtentTest extentTest = test.get();

	            if(extentTest != null) {

	                extentTest.fail(result.getThrowable());

	                extentTest.addScreenCaptureFromPath(screenshotPath);
	            }
	        }

	        catch (Exception e) {

	            e.printStackTrace();
	        }

	        BaseClass.logger.error(result.getName() + " FAILED");
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.get().skip("Test Skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
}