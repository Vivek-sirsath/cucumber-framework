package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddNewCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class StepDef extends BaseClass {

	

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		loginPg = new LoginPage(driver); // Here we've to pass object of WebDriver
		addNewCustPg = new AddNewCustomerPage(driver);
		searchCustPg = new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) { // URL comes from Feature file
		driver.get(url);

	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailID, String password) {
		loginPg.enterEmail(emailID);
		loginPg.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPg.clickOnLoginButton();
	}

	@Then("Close browser")
	public void close_browser() {
		driver.close();
	}

	/////////////// Login Feature ///////////////////
	 
	@Then("The page title should be {string}")
	public void the_page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true); // Test will Pass
		} else {
			Assert.assertTrue(false); // Test will Fail
		}
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() {
		loginPg.clickOnLogoutLink();
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
//			log.info("user can view dashboard test passed.");
			Assert.assertTrue(true); // Pass

		} else {
			Assert.assertTrue(false); // Fail
//			log.warn("user can view dashboard test failed.");

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
		 
	}

	@When("User click on Customers option")
	public void user_click_on_customers_option() {
		addNewCustPg.clickOnCustomersOption();
	}

	@When("User clicks on Add New button")
	public void user_clicks_on_add_new_button() {
		addNewCustPg.clickOnAddNewBtn();
	}

	@Then("User can see a form to add new customer page")
	public void user_can_see_a_form_to_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
//			log.info("User can view Add new customer page- passed");

			Assert.assertTrue(true);// pass
		} else {
//			log.info("User can view Add new customer page- failed");

			Assert.assertTrue(false);// fail
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
//		addNewCustPg.enterEmail("vrs19@gmail.com");
		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("Prachi");
		addNewCustPg.enterLastName("Gupta");
		addNewCustPg.enterGender("Female");
		addNewCustPg.enterDob("6/13/1988");
		addNewCustPg.enterCompanyName("CodeStudio");
		addNewCustPg.enterAdminComment("This is Admin content");
		addNewCustPg.selectVendorFromDropdown("Vendor 1");
	}

	@When("Click on save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSaveButton();
	}

	@Then("User can see confirmation message {string}")
	public void user_can_see_confirmation_message(String expectedConfirmationMessage) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(expectedConfirmationMessage)) {
			Assert.assertTrue(true);// pass
//			log.info("User can view confirmation message - passed");

		} else {
//			log.warn("User can view confirmation message - failed");

			Assert.assertTrue(false);// fail

		}

	}

/////////////////////////// Search Customer by Email ///////////////////////////////////////////

	@When("Enter customer email")
	public void enter_customer_email() {
		searchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
//	    log.info("Email address entered");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCustPg.clickOnSearchButton();
//        log.info("Clicked on search button.");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User should found email in search table")
	public void user_should_found_email_in_search_table() {

		String expectedEmail = "victoria_victoria@nopCommerce.com";

//		We can also use Assertion instead of if-else
//		Assert.assertTrue(searchCustPg.searchCustomerByEmail(expectedEmail));

		if (searchCustPg.searchCustomerByEmail(expectedEmail) == true) {
			Assert.assertTrue(true);
//			log.info("User should found Email in the Search table - passed");

		} else {
//			log.info("User should found Email in the Search table - passed");
			Assert.assertTrue(false);

		}
	}
/////////////////////////// Search Customer by Name ///////////////////////////////////////////

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchCustPg.enterFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCustPg.enterLastName("Terces");
	}

	@Then("User should found name in search table")
	public void user_should_found_name_in_search_table() {
		String expectedName = "Victoria Terces";
		
		if(searchCustPg.searchCustomerByName(expectedName) == true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
}
