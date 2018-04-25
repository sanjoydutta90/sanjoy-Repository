package WebDriverUtilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import POM.FlipkartLoginPage;

public class DriverSetup {
	
	public WebDriver driver;
	
	public void LaunchBrowser(String Browser)
	{
		if (Browser.equalsIgnoreCase("firefox"))
		{
			LaunchFirefox();
			
		}
		else
			LaunchChrome();
	}
	
	public void LaunchFirefox()
	{
		//I Need to know what machine (Windows or MAC)
				String os =System.getProperty("os.name").toLowerCase();
				
				if(os.contains("mac"))
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/ExeFiles/geckodriver-Mac");
				else
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\ExeFiles\\geckpdriver-Win32");
				
				driver=new FirefoxDriver();
			
	}
	public void LaunchChrome()
	{
		//I Need to know what machine (Windows or MAC)
				String os =System.getProperty("os.name").toLowerCase();
				
				if(os.contains("mac"))
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/ExeFiles/chromedriver-Mac");
				else
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ExeFiles\\chromedriver-Win32");
				
				driver=new ChromeDriver();
		
	}
	
	public void login(String Username,String Password)
	{
		FlipkartLoginPage obj=new FlipkartLoginPage(driver);
		obj.loginFlipkart(Username, Password);
	}
	
	

}
