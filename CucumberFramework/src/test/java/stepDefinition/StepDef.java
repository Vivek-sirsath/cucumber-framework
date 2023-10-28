package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class StepDef {
	
	
	public WebDriver driver;
	public LoginPage loginPg;
	

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		loginPg = new LoginPage(driver); // Here we've to pass object of WebDriver
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {  // URL comes from Feature file
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

	@Then("The page title should be {string}")
	public void the_page_title_should_be(String expectedTitle) {
	    String actualTitle = driver.getTitle();
	    
	    if(actualTitle.equals(expectedTitle)) {
	    	Assert.assertTrue(true);  // Test will Pass
	    }
	    else {
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

	@Then("Close browser")
	public void close_browser() {
	    driver.close();
	    driver.quit();
	}
}
