package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddNewCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;
import utilities.ReadConfig;

public class StepDef extends BaseClass {

	@Before // Scenario Hook
	public void setup() {
		
		// Initialize Properties class object created in base class
		readConfig = new ReadConfig();	
		
		// Create a String variable to read the browser value from properties file
		String browser = readConfig.getBrowser();
		
		// Launch browser
		switch(browser.toLowerCase()) 
		{		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
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
			
		// Initialize the Logger class object
		log = LogManager.getLogger("StepDef");
		
		System.out.println("Setup method executed");
		log.info("Setup method executed");
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

//		WebDriverManager.chromedriver().setup();	

		loginPg = new LoginPage(driver); // Here we've to pass object of WebDriver
		addNewCustPg = new AddNewCustomerPage(driver);
		searchCustPg = new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) { // URL comes from Feature file
		driver.get(url);
		log.info("Url opened");

	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailID, String password) {
		loginPg.enterEmail(emailID);
		loginPg.enterPassword(password);
		log.info("Entered email and password");
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPg.clickOnLoginButton();
		log.info("Clicked n login button");
	}

	@Then("Close browser")
	public void close_browser() {
		driver.close();
		log.info("Closed the browser");
	}

	/////////////// Login Feature ///////////////////

	@Then("The page title should be {string}")
	public void the_page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true); // Test will Pass
			log.warn("Login Fearure: Page title matched");
		} else {
			Assert.assertTrue(false); // Test will Fail
			log.warn("Login Fearure: Page title not matched");
		}
		log.info("Page title verified");
	}
	
	

	@When("User click on logout link")
	public void user_click_on_logout_link() {
		loginPg.clickOnLogoutLink();
		log.info("Clicked on logout link");
	}

	@Then("The page should be {string}")
	public void the_page_should_be(String string) {

	}

	/////////// Add New Customer feature //////////////////

	@Then("User can see dashboard")
	public void user_can_see_dashboard() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {

			Assert.assertTrue(true); // Pass
			log.info("User can see dashboard test - passed.");

		} else {
			Assert.assertTrue(false); // Fail
			log.warn("User can see dashboard test - failed.");

		}
	}

	@When("User click on Customers dropdown")
	public void user_click_on_customers_dropdown() {
		addNewCustPg.clickOnCustomersDropdownMenu();

		// Accurate way to handle exception message in Try-Catch block
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated block
			System.out.println("Error message is:- " + e.getMessage());
		}
		log.info("Clicked on Customers dropdown menu");
	}

	@When("User click on Customers option")
	public void user_click_on_customers_option() {
		addNewCustPg.clickOnCustomersOption();
		log.info("Clicked on Customers option");
	}

	@When("User clicks on Add New button")
	public void user_clicks_on_add_new_button() {
		addNewCustPg.clickOnAddNewBtn();
		log.info("Clicked on Add New button");
	}

	@Then("User can see a form to add new customer page")
	public void user_can_see_a_form_to_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			log.info("User can see Add new customer page - passed");

			Assert.assertTrue(true);// pass
		} else {
			log.info("User can see Add new customer page - failed");

			Assert.assertTrue(false);// fail
		}
		log.info("Add new Customer page test verified");
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
//		addNewCustPg.enterEmail("vrs19@gmail.com");
		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
//		generateEmailId() method is called from Base Class
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("Prachi");
		addNewCustPg.enterLastName("Gupta");
		addNewCustPg.enterGender("Female");
		addNewCustPg.enterDob("6/13/1988");
		addNewCustPg.enterCompanyName("CodeStudio");
		addNewCustPg.enterAdminComment("This is Admin content");
		addNewCustPg.selectVendorFromDropdown("Vendor 1");
		
		log.info("Entered customer info");
	}

	@When("Click on save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSaveButton();
		log.info("Clicked on save button");
	}

	@Then("User can see confirmation message {string}")
	public void user_can_see_confirmation_message(String expectedConfirmationMessage) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(expectedConfirmationMessage)) {
			Assert.assertTrue(true);// pass
			log.info("User can view confirmation message - passed");

		} else {
			log.warn("User can view confirmation message - failed");

			Assert.assertTrue(false);// fail

		}

	}

/////////////////////////// Search Customer by Email ///////////////////////////////////////////

	@When("Enter customer email")
	public void enter_customer_email() {
		searchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
	    log.info("Email address entered");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCustPg.clickOnSearchButton();
        log.info("Clicked on search button.");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Error message: " + e.getMessage());
		}
	}

	@Then("User should found email in search table")
	public void user_should_found_email_in_search_table() {

		String expectedEmail = "victoria_victoria@nopCommerce.com";

//		We can also use Assertion instead of if-else
//		Assert.assertTrue(searchCustPg.searchCustomerByEmail(expectedEmail));

		if (searchCustPg.searchCustomerByEmail(expectedEmail) == true) {
			Assert.assertTrue(true);
			log.info("User should found Email in the Search table - Passed");
			
		} else {	
			
			Assert.assertTrue(false);
			log.info("User should found Email in the Search table - Failed");
		}
	}
/////////////////////////// Search Customer by Name ///////////////////////////////////////////

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchCustPg.enterFirstName("Victoria");
		log.info("First name entered");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCustPg.enterLastName("Terces");
		log.info("Last name entered");
	}

	@Then("User should found name in search table")
	public void user_should_found_name_in_search_table() {
		String expectedName = "Victoria Terces";

		if (searchCustPg.searchCustomerByName(expectedName) == true) {
			Assert.assertTrue(true);
			log.info("User should found name in search table - Passed");
		} else {
			Assert.assertTrue(false);
			log.info("User should found name in search table - Failed");
		}
	}

	@After // Scenario Hook
	public void tearDown(Scenario sc) {
		
	
		if (sc.isFailed() == true) {
//			String screenshotPath = "C:\\Users\\Admin\\git\\cucumber-framework\\CucumberFramework\\screenshots\\failedScreenshot.png";
			String screenshotPath = ".\\screenshots\\failedScreenshot.png";

			// Convert WebDriver object to take screenshot and Capture screenshot in srcFile
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Move captured file to destination by creating object of File and pass filePath as Parameter
			File destFile = new File(screenshotPath);
			
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error message at copying screenshot file is: "+ e.getMessage());
			}
		}
		log.info("Screenshot captured");
		
		driver.quit();
		System.out.println("Teardown method executed...");
		log.info("Teardown method executed");
	}
}
