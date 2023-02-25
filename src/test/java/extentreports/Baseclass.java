package extentreports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;




public class Baseclass    {
	
	public  static WebDriver driver=null;
	public static Logger logg;
	 
  	@BeforeSuite
   
  	  public void openbowser() throws InterruptedException {
  		
  		logg = Logger.getLogger("school registration form");
  		PropertyConfigurator.configure("Log4j.properties");
		
  	WebDriverManager.chromedriver().setup();
  	// install the chrome driver
		 driver=new ChromeDriver();
		 // launch the url
		 driver.manage().window().maximize();
  	
  	
		 
   driver.get("https://facegenie-ams-school.web.app/");
   // check the application to get the error with in 30 seconds 
  
  	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  	  String expexctedtitle="Rai-Test-Bams";
  	  // check the title of the appliation
  	
  	  String actualtitle=driver.getTitle();
  	 
 Assert.assertEquals(actualtitle, expexctedtitle);
 driver.findElement(By.id("email")).sendKeys("testing@gamil.com");
	 logg.info("enter the email address in the email -address text box field");
	Thread.sleep(2000);
	  driver.findElement(By.id("password")).sendKeys("testing@123");
	  logg.info("enter the passwrd in passwprd textbox filed");
	  Thread.sleep(2000);
	 // Actions act=new Actions(driver);
	 // act.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).click();
	
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(2000);
  	  } 
  	@Test(priority=1) 
  	public void check_the_user_deatails() throws InterruptedException {
  		
  		

  		 
  		  String expexctedtitle="testing@gamil.com";
  		  String actualtitle=driver.findElement(By.xpath("//p[text()='testing@gmail.com']")).getText();
  		  Assert.assertEquals(actualtitle, expexctedtitle);
  		  logg.info("check the gmail-address");
  		  } 
  		  
  		  
@AfterSuite
			  public void logout() throws InterruptedException {
				  Thread.sleep(2000);
			  
			 driver.findElement(By.xpath("//span[text()='Log Out']")).click();
			  
			  
			  
			  }

	
	 
		




public String getScreenhot() throws IOException {
	String timeStamp1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	String repName1="screenshot"+timeStamp1+".png";
	String screenshotPath= System.getProperty("user.dir")+"\\Screenshots\\"+ repName1;
	 TakesScreenshot src=(TakesScreenshot)driver;
File	screenshot=src.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenshot, new File(screenshotPath));
	return screenshotPath;
}
	
}

	
	
	



	
		
	
	
 
	
	

	

	

