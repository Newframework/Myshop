package Testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	 public static WebDriver driver;
	 
	 public Logger logger;
	 
	 public ResourceBundle rb;
	 
	 @BeforeClass(groups= {"sanity","regression"})
	 @Parameters("browser")
	public void setup(String br)
	{
		 
		 rb=ResourceBundle.getBundle("config");
		 
		 logger=LogManager.getLogger(this.getClass());
		 
		 
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		
		if(br.equals("chrome")){
			driver = new ChromeDriver();
		}
		
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		
		else
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(rb.getString("appUrl"));
		driver.manage().window().maximize();
		
		
	}
	 
	 
	 public String RandomString()
	 {
		String name= RandomStringUtils.randomAlphabetic(4);
		return name;
	 }
	 
	
	 public String Randomnumber()
	 {
		String name= RandomStringUtils.randomNumeric(4);
		return name;
	 }
	 
	 public String Randomalphanumber()
	 {
		String name= RandomStringUtils.randomAlphabetic(4);
		String name1= RandomStringUtils.randomNumeric(4);
		
		return name+name1;
	 }
	 
	 
	 
	 public static String captureScreen(String tname) throws IOException
	 {
		// String timestamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
		 TakesScreenshot ts= (TakesScreenshot) driver;
		 
		 File src= ts.getScreenshotAs(OutputType.FILE);
		 
		 //File des = new File("H:\\java\\Myshop\\screenshot"  + "_" + timestamp +".png");
		 
		 String des = (".\\screenshot\\" + tname + "_" + ".png");
		 
		 //String des1= des.getAbsolutePath();
				try {
					 FileUtils.copyFile(src,new File(des));
				}
				catch(Exception e)
				{
					e.getMessage();
				}
		 
		 return des;
				 
			 
	 }
	 
	 
	 
	 
	 
	 
	 
	 @AfterClass(groups= {"sanity","regression"})
	 public void teardown()
	 {
		 driver.quit();
	 }


	/*public static String captureScreen(String name) throws IOException 
	{
		File srcscreenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destpath= System.getProperty("user.dir")+"\\screenshot\\"+name+".png";
		
		try
		{
			FileHandler.copy(srcscreenshot,new File(destpath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return destpath;
	}*/


	}
	
	
	
	
	
	
	
	
	
	
	
	

