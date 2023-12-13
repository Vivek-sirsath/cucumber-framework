package stepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObject.AddNewCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomerPage addNewCustPg;
	public SearchCustomerPage searchCustPg;
	
	public String generateEmailId() {
		return (RandomStringUtils.randomAlphabetic(5));
	}

}
