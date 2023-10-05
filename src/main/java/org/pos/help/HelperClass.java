package org.pos.help;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HelperClass
{
  
	WebDriver driver;
	
	public HelperClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void launchApplicationURL(String url)	
	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	
	 	
	public void navigateToModule(String mName)
	{
       driver.findElement(By.xpath("//span[text()='"+mName+"']")).click();
       String actual = driver.getTitle();
		System.out.println(actual);
		String expected="Women";
		Assert.assertEquals(actual, expected);
        
	}
	

}

	
	

