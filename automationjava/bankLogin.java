package Stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bankLogin {
	
	WebDriver driver = null;
	
	@Given("valid url ACME login page")
	public void valid_url_acme_login_page() {
		
		String userPath = System.getProperty("userdir");
		System.out.println(userPath);
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		//driver.get("https://demo.applitools.com/");
		driver.navigate().to("https://demo.applitools.com");
		
		System.out.println("ACME bank Login page loaded successfully .....");
		
		System.out.println("\n\n");

	}

	@And("user is on ACME login page")
	public void user_is_on_acme_login_page() {
		System.out.println("ACME bank login page loaded successfully with....");		
		// verify page content = "Login Form"  & page title = "ACME Demo App by Applitools"
		driver.getPageSource().contains("Login Form");
		System.out.println("Contains Login form : "+driver.getPageSource().contains(""));
		String Title = driver.getTitle();
		System.out.println("Contains Page title as : "+Title);

		System.out.println("\n\n");
	}

	@When("user enters userid and password")
	public void user_enters_userid_and_password() {
		
		driver.findElement(By.id("username")).sendKeys("bevinzen");
		driver.findElement(By.id("password")).sendKeys("monkey34");
		
		System.out.println("user can able enters valid userid and password");
		
		System.out.println("\n\n");
	}

	@And("click sign in button")
	public void click_sign_in_button() {
		driver.findElement(By.id("log-in")).click();
		System.out.println("click sign in button ....");
		
		System.out.println("\n\n");
	}

	@Then("user is navigated to ACME home page")
	public void user_is_navigated_to_acme_home_page() {
		System.out.println("Home page loaded successfully with user details....");
		
		String expectedTitle = "ACME demo app";
		String expectedKeyword1 = "Jack Gomez";
		String actualTitle = driver.getTitle();
		
		System.out.println(driver.getTitle());
		System.out.println("Customer name availabe : "+ driver.getPageSource().contains("Jack Gomez"));
		
		driver.getPageSource().contains(expectedKeyword1);
		
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Home Page loaded successfully");
        } else {
            System.out.println("Home Page loading failed...");
        }
        
        if(driver.getPageSource().contains(expectedKeyword1)) {
        	System.out.println("User details : "+expectedKeyword1);
        	
        }else {
        	System.out.println("User details was not loaded successfully ");
        }
        
	}

	
	

}
