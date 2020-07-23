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

@SuppressWarnings("unused")
public class Loginstepdefination {

	WebDriver driver;
	
	@Given("^launch the opencart application$")
	public void launchtheapp() 
	{
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	
	}
	
	@Then("^click on account$")
	public void clickaccount() 
			
	{
		driver.findElement(By.xpath("//span[ contains (text(),'My Account')]")).click();
		
	}
	
	@And("^click register$")
	
	public void clickregister() 
			
	{
		driver.findElement(By.xpath("//a[ contains (text(),'Register')]")).click();
	}
	
	
	@Then("^Enter details$") 
	public void enterdetails()
	 
	{
		driver.findElement(By.xpath("//input[ @id ='input-firstname']")).sendKeys("Radha");
		driver.findElement(By.xpath("//input[ @id ='input-lastname']")).sendKeys("surekha");
		driver.findElement(By.xpath("//input[ @id ='input-email']")).sendKeys(randomEmail());
		driver.findElement(By.xpath("//input[ @id ='input-telephone']")).sendKeys("1234123411");
		driver.findElement(By.xpath("//input[ @id ='input-password']")).sendKeys("Qwerty@123");
		driver.findElement(By.xpath("//input[ @id ='input-confirm']")).sendKeys("Qwerty@123");
		WebElement checkbox = driver.findElement(By.xpath("//input[ @type='checkbox']"));
		if (!(checkbox.isSelected()))
			checkbox.click();
		
	}
	
	
	@Then("^click continue$")
	
public void clickcontinue()
	
{
		driver.findElement(By.xpath("//input[ @type='submit']")).click();
	}
	

	@When("^login success validate username$") 
	public void login_success_validate_username()
	
	{
    String titles = driver.getTitle();
    System.out.println(titles);
   Assert.assertEquals("Your Account Has Been Created!", titles);
 
   	
	}
	
	 @Then("^verify Enquiry$")
		public void verify_Enquiry() 
	{
	driver.findElement(By.xpath("//a[  contains (text(),'contact us')]")).click();	
	driver.findElement(By.id("input-enquiry")).sendKeys("ugduegdgedggduieguideudui");
	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();	
	driver.findElement(By.xpath("//a[  contains (text(),'Continue')]")).click();
	}
	 
	 @Then("^click homepagesamsungtab$")
	 public void  click_homepagesamsungtab()
		{
driver.findElement(By.xpath("//div[@class='swiper-pagination slideshow0 swiper-pagination-clickable swiper-pagination-bullets']//span[1]")).click();
driver.findElement(By.xpath("//div[@class='swiper-slide text-center swiper-slide-active']//img[@alt='iPhone 6']")).click();
driver.findElement(By.xpath("//a[contains (text(),'Reviews (0)')]")).click();
		}
	 @When("^provide review$")
	 public void provide_review()  {
		driver.findElement(By.xpath("//input [@id='input-name']")).sendKeys("Radha");
		driver.findElement(By.xpath("//textarea[@id='input-review']")).sendKeys("product is goodheehhehdheudhehduehhhedhhuiehdhedhehdhe");
	WebElement	radio4 = driver.findElement(By.xpath("//input[@value='4']"));
	radio4.click();
	driver.findElement(By.xpath("//button[  contains (text(),'Continue')]")).click();
	 }
	 @Then("^addtowishlist$")
	 public void addtowishlist()
	 {
		driver.findElement(By.xpath("//button[ @data-original-title='Add to Wish List']")).click(); 
		driver.findElement(By.xpath("//div[ @class='alert alert-success alert-dismissible']"));
		driver.findElement(By.xpath("//li//a[contains (text(),'Wish List')]")).click();
	 }
	 
	 @Then("^displayprice$")
	 public void displayprice(){
		 String price = driver.findElement(By.xpath("//div[@class='price']")).getText();
		 System.out.println("The price of samsung tab is"+ price);
	 }
	 @Then("^addandremove item$")
	 public void addandremove_item(){
		 driver.findElement(By.xpath("//td//button[@data-original-title ='Add to Cart']")).click(); 
		 driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		 driver.findElement(By.xpath("//a[@data-original-title='Remove']")).click();
		 driver.findElement(By.xpath("//p[contains(text(),'Your wish list is empty.')]"));
		 driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		 driver.findElement(By.xpath("//li[@class='dropdown']//a[@title='My Account']")).click();
		 driver.findElement(By.xpath("//a[@href='https://demo.opencart.com/index.php?route=account/logout']")).click();
		
	 }
	 
	 private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@examplee.com";
    }
	 
	
	
}
