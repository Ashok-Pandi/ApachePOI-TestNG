package day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ThirdTestcase 
{
	WebDriver driver;
	@Parameters({"URL3"})
	@Test
	public void Login(String URL)
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.name("Submit")).sendKeys(Keys.ENTER);
	System.out.println(URL);
		String expected="dashboard";
		
		String actual = driver.getCurrentUrl();
		if(actual.contains(expected))
		{
			Reporter.log("Login success",true);
		}
		else
		{
			Reporter.log("Login Fail",true);
		}
		driver.close();
		
	}
	}

