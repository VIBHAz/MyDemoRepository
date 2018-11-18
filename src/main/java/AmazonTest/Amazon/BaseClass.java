package AmazonTest.Amazon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import TestUtil.TestUtil;

public class BaseClass
{
      
	public static WebDriver driver;
	public static Properties prop;
	
	
	public BaseClass(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Vibha\\eclipse-workspace\\Amazon\\src\\main\\java\\Config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
						driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			          driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
}
		
	
	
	

