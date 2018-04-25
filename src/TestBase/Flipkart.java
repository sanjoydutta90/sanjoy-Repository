package TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM.FlipkartHomePage;
import WebDriverUtilities.DriverSetup;

public class Flipkart extends DriverSetup{
	
	FlipkartHomePage obj;
	
	@BeforeTest
	@Parameters({"Browser","URL","UserName","Password"})
	public void setup(String Browser, String URL, String Username, String Password)
	{
		LaunchBrowser(Browser);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		login(Username, Password);
		
		
	}
	
	@Test
	@Parameters({"SearchItem"})
	public void ValidateFlipkart(String Item)
	{
		obj=new FlipkartHomePage(driver);
		obj.SearchItem(Item);
		
		String Added_Item=obj.AddCart();
		
		obj.OpenCart();
		
		Assert.assertEquals(driver.findElement(By.xpath("(//a[@class='_325-ji _3ROAwx'])[1]")).getText(), Added_Item);
		
		
	}

	@AfterTest
	public void TearDown()
	{
		obj.LogOut();
		driver.quit();
	}
}
