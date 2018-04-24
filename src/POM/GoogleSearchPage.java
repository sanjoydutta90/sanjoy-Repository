package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class GoogleSearchPage {
	
	WebDriver driver;
	By SearchTextBox= By.id("lst-ib");
	By UrlList=By.xpath("//div[@class='g']//cite");
	
	
	public GoogleSearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void EnterSearchKey(String Searchkey)
	{	
		WebElement query = driver.findElement(SearchTextBox);
        query.sendKeys(Searchkey);
        query.sendKeys(Keys.ENTER);
	}
	
	public List<WebElement> getListResult()
	{
		List<WebElement> Urls=driver.findElements(UrlList);
		return Urls;
	}
	

}
