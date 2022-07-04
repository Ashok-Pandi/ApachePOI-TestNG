package extentreports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReports {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver102.exe");
		driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	@BeforeTest  //I am generating reports for only single time thats why i am using beforetest.
	public void generateReports()
	{
		//define path of html reports
		report= new ExtentReports("./Reports/Demo.html");
	}
	@Test
	public void testPass()
	{

		test = report.startTest("My Test PASS");
		test.assignAuthor("Ashok");
		test.assignCategory("Functional");
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equalsIgnoreCase(actualTitle))
		{
			test.log(LogStatus.PASS, "Title is MACHING   "+expectedTitle+"        "+actualTitle);
		}
		else
		{
			test.log(LogStatus.FAIL, "Title is Not MATCHING  "+expectedTitle+"         "+actualTitle);
		}
	}
	@Test
	public void testFail()
	{
		test = report.startTest("My test FAIL");
		test.assignAuthor("Ashok");
		test.assignCategory("Funcctional");
		String expectedTitle= "Gmail";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equalsIgnoreCase(actualTitle))
		{
			test.log(LogStatus.PASS, "Title is MATCHING"+expectedTitle+"      "+actualTitle);
		}
		else
		{
			test.log(LogStatus.FAIL, "Title is Not MATCHING"+expectedTitle+"         "+actualTitle);

		}

	}
	@AfterMethod
	public void closeReports()
	{
		report.flush();
		report.endTest(test);
		driver.close();
	}


}
