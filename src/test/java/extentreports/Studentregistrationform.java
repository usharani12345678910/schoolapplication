package extentreports;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Studentregistrationform extends Baseclass  {

	@Test(priority=2)
	public void Studentdataformregistration() throws InterruptedException {
		
 	
 		 
 		
 		  //click on manage student
 		  driver.findElement(By.xpath("//span[contains(text(),'Manage Student')]")).click();
 		  //clcik on add student form
 		  driver.findElement(By.xpath("//p[contains(text(),'Add student using Form')]")).click();
 		  //click on admission number :enter the data as per the student information
 		  //admission number:1234
 		 driver.findElement(By.xpath("//input[@name='admissionNo']")).sendKeys("1234");
 		 //click on admission status drop down
 		 WebElement a=driver.findElement(By.xpath("(//div[@class='MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl  css-j5qxp9'])[12]//div"));
 		
 		 Select dd=new Select(a);
 		 
 		 Thread.sleep(20000);
 		 
 		 dd.selectByVisibleText("studying");
 		 
 		 Thread.sleep(20000);
 		 
 		 List<WebElement> c=dd.getOptions();
 		int s=c.size();
 		 System.out.println(s);
 		 for(int i=0;i<s;i++)
 		{
 			WebElement e=c.get(i);
 			String te=e.getText();
 			System.out.println(te);
 			
 		}
 		//confirm add student form
 		 
 		driver.findElement(By.xpath("//p[text()='Confirm Add student Details']")).click();
 		  

 				
 			
}
}

