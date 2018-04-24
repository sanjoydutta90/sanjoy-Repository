package TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM.GoogleSearchPage;
import WebDriverUtilities.DriverSetup;

public class GoogleSearch extends DriverSetup{
	
	
	
	
	@BeforeTest
	@Parameters({"Browser"})
	public void Setup(String Browser)
	{	
		LaunchBrowser(Browser);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	@Parameters({"InputData","Browser"})
	public void ValidateGoogleSearch(String InputData,String Browser)
	{
		int flag=0;
		GoogleSearchPage obj=new GoogleSearchPage(driver);
		obj.EnterSearchKey(InputData);
		
		List<WebElement> urls=obj.getListResult();
	
		if(urls.get(0).getText().equals("https://www.payjo.co/"))
		{
			System.out.println("Payjo is appears ​first ​in ​a ​Google ​search of "+Browser+" Browser");
			flag=1;
		}
		else
		{
			for(WebElement e: urls)
			{
				if(e.getText().equals("https://www.payjo.co/"))
				{
					System.out.println("Payjo is appears ​"+(urls.indexOf(e)+1)+" ​position in ​a ​Google ​search of "+Browser+" Browser");
					flag=1;
				}
				
			}
			
		}
		
		if(flag==0)
		{
			System.out.println("Payjo not found in a Google Search of "+Browser+" Browser");
		}
		
		
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
