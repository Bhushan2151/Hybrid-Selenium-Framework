package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import Base.BaseClass;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	private int count = 0;

    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
    	
    	System.out.println("Retry Method Called");

        if(count < maxRetryCount) {

            count++;

            BaseClass.logger.warn(
                    "Retrying Test : "
                    + result.getName()
                    + " Attempt : "
                    + count);

            return true;
        }

        return false;
    }

}
