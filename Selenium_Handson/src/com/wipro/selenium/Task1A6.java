package com.wipro.selenium;
import java.util.List;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

//Please Automate Rental Car Block https://demoqa.com/controlgroup

@SuppressWarnings("unused")
public class Task1A6 extends Base{
	 @Test(groups= {"mandatory","Assignment1"})
	 public void test6() throws IOException {
		 Task1A6 ob = new Task1A6() ;
		 Properties obj = ob.ReadObjectRepo();
		 WebDriver driver = ob.driver();
		 driver.get("https://demoqa.com/controlgroup/");
		 driver.manage().window().maximize();
		 Reporter.log("Browser is launched now");
		// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    //horizontal rental car
		    WebElement ct=driver.findElement(By.id(obj.getProperty("cartype")));
		    ct.click();
		    List<WebElement> l=driver.findElements(By.xpath(obj.getProperty("selectcartype")));
		    for(WebElement e:l)
		    {
		        if(e.getText().equalsIgnoreCase("SUV"))
		            e.click();
		    }
		    Assert.assertTrue(ct.getText().equalsIgnoreCase("SUV"), "SUV is  selected");	   
		    
		    WebElement standardcheck=driver.findElement(By.xpath(obj.getProperty("standardcar1")));
		    if(!(standardcheck.isSelected()))
		        standardcheck.click();
		    
		    //checking the insurance checkbox
		    WebElement insurancecheck=driver.findElement(By.xpath(obj.getProperty("insurance1")));
		    if(!(insurancecheck.isSelected()))
		        insurancecheck.click();
		    
		    driver.findElement(By.id(obj.getProperty("horizentalspinner"))).sendKeys("2");
		    driver.findElement(By.xpath(obj.getProperty("horizentalbuynow"))).click();
		    
		    //vertical rental car
		    WebElement ct2=driver.findElement(By.id(obj.getProperty("cartype2")));
		    ct2.click();
		    List<WebElement> l2=driver.findElements(By.xpath(obj.getProperty("selectcartype2")));
		    for(WebElement e:l2)
		    {
		        if(e.getText().equalsIgnoreCase("Luxury"))
		            e.click();
		    }
		        
			Assert.assertTrue(ct2.getText().equalsIgnoreCase("Luxury"), "Luxury is selected");
		    
		    WebElement automaticcheck1=driver.findElement(By.xpath(obj.getProperty("automaticcar2")));
		    if(!(automaticcheck1.isSelected()))
		        automaticcheck1.click();
		    
		    //checking the insurance checkbox
		    WebElement insurancecheck1=driver.findElement(By.xpath(obj.getProperty("insurance2")));
		    if(!(insurancecheck1.isSelected()))
		        insurancecheck1.click();
		    
		    driver.findElement(By.id(obj.getProperty("verticalspinner"))).sendKeys("3");
		    driver.findElement(By.xpath(obj.getProperty("verticalbuynow"))).click();
		    Reporter.log("Test6 completed");
		    driver.close();
		    }

				 
	 }

