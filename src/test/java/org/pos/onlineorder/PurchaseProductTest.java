package org.pos.onlineorder;

import org.pos.onlineorder.PurchaseProductTest;
import org.pos.page.PurchaseProductPage;
import org.testng.annotations.Test;
import org.pos.base.TestBaseClass;
import org.pos.help.HelperClass;

public class PurchaseProductTest extends TestBaseClass 
{
			
		  
	
	@Test
	public void validatePurchaseProduct() throws InterruptedException
	   {		   
		    HelperClass helper = new HelperClass(driver);				   
			helper.launchApplicationURL(prop.getProperty("userurl"));					
			helper.navigateToModule(prop.getProperty("moduleName"));
			
			PurchaseProductPage page=new PurchaseProductPage(driver);
			page.selectProduct(prop.getProperty("productName"));			
			page.shippingDetails(prop.getProperty("eMail"),prop.getProperty("firstName"),prop.getProperty("lastName"),prop.getProperty("address"),prop.getProperty("cityName"),prop.getProperty("stateName"),prop.getProperty("zipCode"),prop.getProperty("phoneNumber"));
			
			
	   }	   
	  	   

	

}
