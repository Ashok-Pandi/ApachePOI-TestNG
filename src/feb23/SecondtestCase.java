package feb23;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class SecondtestCase {
	WebDriver driver;
	@BeforeTest
	  public void setup()
	  {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://calc.qedgetech.com/");
		 Reporter.log("Runnig Setup",true);
	  }
	@Test(priority=2)
  public void addtion() 
	{
		driver.findElement(By.xpath("(//input[@id='btn'])[26]")).click();
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("12546");
		driver.findElement(By.xpath("(//input[@id='btn'])[6]")).click();
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("2546");
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		//to capture that value we use getAttribute in TestNG
		String additionres = driver.findElement(By.xpath("(//input[@id='btn'])[1]")).getAttribute("value");
		Reporter.log("Addition Result is  "+additionres,true);
		Reporter.log("Executing Addition",true);
  }
@Test(priority=0)
public void multplication()
{
	driver.findElement(By.xpath("(//input[@id='btn'])[26]")).click();
	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("123");
	driver.findElement(By.xpath("(//input[@id='btn'])[16]")).click();
	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("11");
	driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
	String mulres= driver.findElement(By.xpath("(//input[@id='btn'])[1]")).getAttribute("value");
	Reporter.log("Multiplication result  is  "+mulres,true);
	Reporter.log("Executing Multiplication  ",true);
}
@Test(priority=1,groups= {"Smoke"})
public void division()
{
	driver.findElement(By.xpath("(//input[@id='btn'])[26]")).click();
	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("786");
	driver.findElement(By.xpath("(//input[@id='btn'])[21]")).click();
	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("10");
	driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
	String divisionres =driver.findElement(By.xpath("(//input[@id='btn'])[1]")).getAttribute("value");
	Reporter.log("Division result  is  "+divisionres,true);
	Reporter.log("Executing Division ",true);
}
@Parameters({"URL2"})
@Test(priority=3)
public void substraction(String URL)
{
	System.out.println(URL);
	driver.findElement(By.xpath("(//input[@id='btn'])[26]")).click();
	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("78645");
	driver.findElement(By.xpath("(//input[@id='btn'])[11]")).click();
	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("100");
	driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
	String substractionres =driver.findElement(By.xpath("(//input[@id='btn'])[1]")).getAttribute("value");
	Reporter.log("SubStraction result  is  "+substractionres,true);
	Reporter.log("Executing SubSTraction  ",true);
}
  @AfterTest
  public void teardown()
  {
	 
	  driver.close();
	  Reporter.log("Runnig teardown",true);
  }

}
