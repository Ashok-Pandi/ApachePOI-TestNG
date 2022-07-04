package day4;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(day4.ListenerTest.class)
public class Testcase 
{
	WebDriver driver =  new FirefoxDriver();
	@Test
	public void Login()
	{
		driver.manage().deleteAllCookies();
		
		driver.get("https://demo.guru99.com/V4/index.php");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr392666");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("vUqepym");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();	
     	driver.close();
	}
	@Test
	public void TesttoFail()
		{
		System.out.println("this test is to fail");
		Assert.assertTrue(false);
		
		}     

}

