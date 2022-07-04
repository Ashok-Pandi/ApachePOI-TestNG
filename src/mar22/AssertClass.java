package mar22;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AssertClass {
	WebDriver driver ;
	@Test
	public void assertEqulas()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		String expectedTitle  = "Google";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle,"The Is not MATCHING");
		driver.close();
	}
	@Test
	public void assertEqulas1()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gmail.com");
		String expectedTitle  = "Google";
		String actualTitle = driver.getTitle();
		try {
			Assert.assertEquals(actualTitle, expectedTitle,"The Title Is not MATCHING");
		} catch (Throwable e) {
			System.out.println( e.getMessage());
		}
		
		driver.close();
	}
	

}
