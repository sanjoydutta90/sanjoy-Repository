package POM;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlipkartHomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By SearchTxtBox=By.xpath("//input[@name='q']");
	By SearchButton=By.xpath("//button[@class='vh79eN']");
	By FirstItem=By.xpath("(//div[@class='_3T_wwx']//div[@class='_3wU53n'])[1]");
	By AddtoCartButton=By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']");
	By CartLink=By.xpath("//a[@class='_3NFO0d _2f5Jjv']");
	By MyAccount=By.xpath("//div[@class='_20yN1P qt4LQw']//span");
	By MyProfile=By.xpath("(//div[@class='_20yN1P qt4LQw']//a)[1]");
	By LogOutButton=By.xpath("(//div[@class='_3NNJZh row']//span)[2]");
	
	
	public FlipkartHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SearchItem(String Item)
	{	
		wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.presenceOfElementLocated(SearchTxtBox));
		driver.navigate().refresh();
		driver.findElement(SearchTxtBox).sendKeys(Item);
		driver.findElement(SearchButton).click();
	}
	
	public String AddCart()
	{
		
		wait.until(ExpectedConditions.presenceOfElementLocated(FirstItem));
		driver.findElement(FirstItem).click();
		
		String ParentWindow=driver.getWindowHandle();
		SwitchToWindow();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='_3eAQiD']")));
		String AddedItem_Title=driver.findElement(By.xpath("//h1[@class='_3eAQiD']")).getText();
		driver.findElement(AddtoCartButton).click();
		driver.close();
		driver.switchTo().window(ParentWindow);
		
		return AddedItem_Title;
	
	}
	
	public void OpenCart()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(CartLink));
		driver.findElement(CartLink).click();
	}
	
	public void LogOut()
	{
		driver.findElement(MyAccount).click();
		driver.findElement(MyProfile).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(LogOutButton));
		driver.findElement(LogOutButton).click();
		
	}
	
	public void SwitchToWindow()
	{
		String ParentWindow=driver.getWindowHandle();
		Set<String> childwindows=driver.getWindowHandles();
		for(String win : childwindows)
		{
			if(!win.equals(ParentWindow))
			{
				driver.switchTo().window(win);
			}
		}
			
	}

}
