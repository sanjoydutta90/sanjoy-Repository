package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartLoginPage {
	
	WebDriver driver;
	By UsernameTxtBox=By.className("_2zrpKA");
	By PasswordTxtBox=By.xpath("//input[@type='password']");
	
	
	public FlipkartLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void loginFlipkart(String UserName, String Password)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		WebElement user=wait.until(ExpectedConditions.visibilityOf(driver.findElement(UsernameTxtBox)));
		user.sendKeys(UserName);
		WebElement Pass=wait.until(ExpectedConditions.visibilityOf(driver.findElement(PasswordTxtBox)));
		Pass.sendKeys(Password);
		
		
		
		/* it is form so no need to find element separately 
		for login button. so I can take any element in that form and use 
		.submit() to submit the form. so i have taken username element 
		again and submit using that*/
		
		driver.findElement(By.className("_2zrpKA")).submit();
		
	}

}
