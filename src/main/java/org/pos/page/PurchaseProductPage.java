package org.pos.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PurchaseProductPage 
{

    WebDriver driver;	
	
	public PurchaseProductPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void selectProduct(String pName) throws InterruptedException
	{
		
							
		driver.findElement(By.xpath("//a[text()='"+pName+"']")).click();		
					
		driver.findElement(By.xpath("(//div[@id='option-label-size-143-item-168'])[1]")).click();
		driver.findElement(By.xpath("(//div[@id='option-label-color-93-item-49'])[1]")).click();			
		driver.findElement(By.xpath("(//span[text()='Add to Cart'])[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[@id='option-label-size-143-item-168'])[3]")).click();
		driver.findElement(By.xpath("(//div[@id='option-label-color-93-item-49'])[2]")).click();			
		driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[@id='option-label-size-143-item-168'])[4]")).click();
		driver.findElement(By.xpath("(//div[@id='option-label-color-93-item-49'])[3]")).click();			
		driver.findElement(By.xpath("(//span[text()='Add to Cart'])[4]")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);			
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'My Cart')]/ancestor::a"));
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		ele.click();
		Thread.sleep(4000);				
       	       
       driver.findElement(By.id("top-cart-btn-checkout")).click();
       Thread.sleep(2000);
	 
       	       
       			
	}
	
	public void shippingDetails(String eAdd, String fName, String lName, String sAdd, String city, String state, String zCode, String pNum) throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Email Address')]/preceding::input[@id='customer-email']")));
		email.sendKeys(eAdd);
	  
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement firstn = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='input-text' and @name='firstname']")));
		firstn.sendKeys(fName);	   
	   
	   driver.findElement(By.xpath("//input[@class='input-text' and @name='lastname']")).sendKeys(lName);
	   driver.findElement(By.xpath("//input[@class='input-text' and @name='street[0]']")).sendKeys(sAdd);		  
	   driver.findElement(By.xpath("//input[@class='input-text' and @name='city']")).sendKeys(city);
	  
	   WebElement dropdown = driver.findElement(By.xpath("//select[@class='select' and @name='region_id']"));
	   Select sel = new Select(dropdown);
	   sel.selectByVisibleText(state);		
		  
	   driver.findElement(By.xpath("//input[@class='input-text' and @name='postcode']")).sendKeys(zCode);
	  	    	  
	   driver.findElement(By.xpath("//input[@class='input-text' and @name='telephone']")).sendKeys(pNum);
	   driver.findElement(By.xpath("//input[@class='radio' and @name='ko_unique_2']")).click();
	   driver.findElement(By.xpath("//span[text()='Next']")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//span[text()='Place Order']")).click();
	  
	    String actual = driver.getTitle();
		System.out.println(actual);
		String expected="Checkout";
		Assert.assertEquals(actual, expected);
	  
	  
	}


	

}
