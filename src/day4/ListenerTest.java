package day4;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" The name of Test Start");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the test Successd  "+result.getName());
		    
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("the name of the test got FAILED  "+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of test got SKIPPED  "+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("THis test start when any test starts  "+context.getName());
		
	}
	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("This test called when all tests are executed  "+context.getName());
		
	}

}
