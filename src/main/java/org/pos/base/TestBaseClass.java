package org.pos.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass
{
    protected WebDriver driver;
    protected Properties prop;
    
    @BeforeTest
    public void loadProperties() throws IOException 
    {
    	String absolutePath=System.getProperty("user.dir")+"/config/retail.properties";
    	File file = new File(absolutePath);
    	FileInputStream fis = new FileInputStream(file);
    	prop = new Properties();
		prop.load(fis);
    }
	
   
   @BeforeClass
	public void instantiateDriver() throws IOException
	{

		
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
	}

	
}
