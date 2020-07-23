package StepDefination;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
@SuppressWarnings("unused")
public class Productcomparision {
	WebDriver driver;

	@And("^click Login$")
	
	public void clicklogin() 
			
	{
		driver.findElement(By.xpath("//aside[@id='column-right']//a[1]")).click();
	
		//WebElement loginbtn = driver.findElement(By.xpath("//div[@class='list-group']//a[@href='https://demo.opencart.com/index.php?route=account/login']"));
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", loginbtn);
	}
	
	@Then("^Enter details login$")
	
	public void Enter_details_login()
	{
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("fgrg@rgheuieuif.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Qwerty123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	@Then("^searchandsort$")
	public void searchandsort()
	{
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("apple");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		//driver.findElement(By.xpath("//select[@name='category_id']")).click();
		Select dropdown = new Select (driver.findElement(By.xpath("//select[@name='category_id']")));
		dropdown.selectByValue("//option[@value='28']");
		driver.findElement(By.xpath("//input[@id='button-search']")).click();
		driver.findElement(By.xpath("//a[contains (text(),'Phones & PDAs')]")).click();
		Select sortbtn=new Select (driver.findElement(By.xpath("//select[@id='input-sort']")));
		sortbtn.selectByVisibleText("Price (Low > High)");
	}
	@Then("^compare$")
	public void compare()
	{
		driver.findElement(By.cssSelector("#content > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2) > button:nth-of-type(3) > i")).click();
		driver.findElement(By.cssSelector("#content > div:nth-child(3) > div:nth-child(1) > div > div:nth-child(2) > div.button-group > button:nth-child(3) > i")).click();
		driver.findElement(By.xpath("//*[contains(text(),' Success: You have added ')]"));
		driver.findElement(By.xpath("//*[contains(text(),'Product Compare (0)')]")).click();
	}
	@Then("^addtocart$")
	public void addtocart()
	{
		driver.findElement(By.xpath("//*[@id='content']/table/tbody[2]/tr/td[3]/input")).click();
		driver.findElement(By.xpath("//span[@id='cart-total']")).click();
		driver.findElement(By.xpath("//a[@href='https://demo.opencart.com/index.php?route=checkout/checkout']/strong")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
	}
	@Then("^orderhistory$")
	public void orderhistory()
	{
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li//a[contains(text(),'Order History')]")).click();
		
		
		
	}
	
	@Then("^logout$")
	public void logout()
	{
		driver.findElement(By.xpath("//ul//li//a[contains(text(),'Logout')]")).click();
		driver.close();
	}
	
	
	
	
}

