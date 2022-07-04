package day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Firstclass {
	
	WebDriver driver;
	@BeforeMethod
	  public void setup() throws Throwable
	{
		//System.setProperty("webdriver.chrome.driver", "F:\\TESTING/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.manage().deleteAllCookies();
		//Thread.sleep(3000);
		driver.get("http://primusbank.qedgetech.com/");
		driver.findElement(By.name("txtuId")).sendKeys("Admin");
		driver.findElement(By.name("txtPword")).sendKeys("Admin");
		driver.findElement(By.name("login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Runnig Setup",true);
	  }

  @Test(dataProvider="getmethod")
  public void branches(String username,String password)
  {
     System.out.println(username);
     System.out.println(password);
	  driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/a[1]/img[1]")).click();
	  Reporter.log("Executing Branches Testcase",true); 
  }
  @Parameters({"URL1","URL"})
  @Test
  
  public void role(String URL1, String URL)
  {
	
	  driver.findElement(By.xpath("//a[@href='Admin_Roles_details.aspx']//img")).click();
	  Reporter.log("Executing Roles testcase",true);
	  System.out.println("URL1 is "+ URL1);
	  System.out.println("URL is  "+URL);
  }
 
  @AfterMethod
  public void teardown()
  {
	  driver.close();
	  Reporter.log("Runnig teardown",true);
	 
  }
  @DataProvider
  public Object[][] getmethod()
  {
	  Object[][] data = new Object[2][2];
	  data[0][0]= "USERname";
	  data[0][1]= "password";
	  data[1][0]= "USERNAME1";
	  data[1][1]="password1";
	  
	return data;
	  
  }
}
