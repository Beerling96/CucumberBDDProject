package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.core.cli.Main;
import PgeObject.AddNewCustomerPage;
import PgeObject.LoginPage;
import PgeObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass{

	@Before("@Sanity")
	public void setup1() {
		
		//initialise read config properties 
		readConfig = new ReadConfig();
		
		
		//initialise logger after creating variable class in step def
		log = LogManager.getLogger("StepDef");
		
		System.out.println("Setup method is executed..");
		
		String browser = readConfig.getBrowser();
		switch(browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;	
		
		default:
			driver = null;
			break;
			
		}
		
		
		log.info("Setup 1 Executed...");
		
	}
		@Before("@regression")
		public void setup2() {
			
			System.out.println("Setup method2 is executed..");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Setup 2 Executed...");
			
	}
	@Given("User opens Chrome Browser")
	public void user_opens_chrome_browser() {
		

		loginPg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		SearchCustPg = new SearchCustomerPage(driver);

		log.info("User launch chrome browser");
		
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("Url opened");
		
	}

	@And("User enter Email {string} and Password as {string}")
	public void user_enter_email_and_password_as(String emailadd, String password) {
		loginPg.enterEmail(emailadd);
		loginPg.enterPassword(password);
		log.info("email address and password entered");
       
	}

	@And("Click on Login")
	public void click_on_login() {
		loginPg.clickOnLoginButton();
		log.info("Clicked on Login");

	}

	////////////LOGIN FEATURE ///////////
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			
			log.info("Test Passed : log in feature page tiltle matched");
			
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed : log in feature page title not matched");
			Assert.assertTrue(false);
		}

	}

	@When("user click on Log out link")
	public void user_click_on_log_out_link() {
		loginPg.clickOnLogut();
		
		log.info("User clicked on log out link");
		
	    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	/*@And("close browser")
	public void close_browser() {
		driver.close();
		log.info("Browser closed");
		
		//driver.quit();

	}*/
	
	
	////////////////////////ADD NEW CUSTOMERS ////////////////
	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    String actualTitle = addNewCustPg.getPageTitle();
	    String expectedTitle = "Dashboard / nopCommerce administration";
	    
	    if(actualTitle.equals(expectedTitle)) {
	    	
	    	log.info("User can view Dashboard test passed");
	    	
	    	Assert.assertTrue(true);
	    } else {
	    	
	    	log.warn("User can view Dashboard test failed");
	    	Assert.assertTrue(false);
	    }
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User click on customer Menu")
	public void user_click_on_customer_menu() {
	    addNewCustPg.clickOnCustomersMenu();
	    
	    log.info("User clicked on customer Menu");
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
	   addNewCustPg.clickOnCustomersMenuItem();
	   
	   log.info("User clicked on customer Menu item");
	    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@And("click on Add new button")
	public void click_on_add_new_button() {
	    addNewCustPg.clickOnAddnew();
	    log.info("User clicked on Add new button");
	    
	}

	@Then("User can view Add New Customer page")
	public void user_can_view_add_new_customer_page() {
	    String actualTitle = addNewCustPg.getPageTitle();
	    String expectedTitle = "Add a new customer / nopCommerce administration";
	    
	    if(actualTitle.equals(expectedTitle)) {
	    	
	    	Assert.assertTrue(true);
	    	log.info("User can view Add New Customer page test passed");
	    	
	    } else {
	    	
	    	Assert.assertTrue(false);
	    	
	    	log.warn("User can view Add New Customer page test failed");
	    }
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
	   // addNewCustPg.enterEmail("bk12@gmail.com");
		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
	    addNewCustPg.enterPassword("test12");
	    addNewCustPg.enterFirstName("Kudaki");
	    addNewCustPg.enterLastName("King");
	    addNewCustPg.enterGender("Male");
	    addNewCustPg.enterDob("6/6/1996");
	    addNewCustPg.enterCompanyName("CodeStudio");
	    addNewCustPg.enterAdminContent("Admin content");
	    addNewCustPg.enterManagerOfVendor("Vendor 1");
	    
	    log.info("Customer information entered");
	}

	@And("Click on Save button")
	public void click_on_save_button() {
	    addNewCustPg.clickOnSave();
	    
	    log.info("Clicked on Save button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
	  
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
	   
	   if(bodyTagText.contains(expectedConfirmationMsg)) {
		  
		   Assert.assertTrue(true);
		   log.info("User can view confirmation message test passed");
		   
	   } else {
		   Assert.assertTrue(false);
		   log.warn("User can view confirmation message test failed"); 
	   }
	}
	
	/////////SEARCH CUSTOMER///////////
	

	@When("enter customer Email")
	public void enter_customer_email() {
	    SearchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
	    log.info("Email address entered");
	}

	@When("Click on search button")
	public void click_on_search_button() {
	    SearchCustPg.clickOnSearchButton();
	    
	    log.info("Clicked on search button");
	    
	    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
	    String expectedEmail = "victoria_victoria@nopCommerce.com";
	    
	   // Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));
	    
	   if(SearchCustPg.searchCustomerByEmail(expectedEmail) ==true) {
		   Assert.assertTrue(true);
		   
		   log.info("User should found Email in the search table test passed");
		   
	   } else {
		  
		   Assert.assertTrue(false);
		   
		   log.warn("User should found Email in the search table test failed");

	   }
	}
//	
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
	        if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	/*@After
	public void teardown(Scenario sc) {
		System.out.println("Teardown method is executed..");
		if(sc.isFailed()==true) {
			
			//screenshot
			String fileWithPath = "C:\\Users\\dell\\eclipse-workspace\\CucumberDemo\\Screenshot\\test1.png";
	        TakesScreenshot scrShot = ((TakesScreenshot)driver);
	        
	        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
	        File DestFile = new File(fileWithPath);
	        
	        try {
				FileUtils.copyFile(srcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}*/
	
	
	/*@After
	public void teardown2() {
		System.out.println("Teardown method2 is executed..");
		driver.quit();
	}*/
	
	
	/*@BeforeStep
	public void beforeStepMethodDemo() {
		System.out.println("This is before step method...");
	}
	
	@AfterStep
	public void afterStepMethodDemo() {
		System.out.println("This is after step method...");
		
	}*/
}
