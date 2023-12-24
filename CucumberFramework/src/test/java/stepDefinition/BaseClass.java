package stepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.AddNewCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;
import utilities.ReadConfig;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomerPage addNewCustPg;
	public SearchCustomerPage searchCustPg;
	public static Logger log;
	public ReadConfig readConfig;
	
	public String generateEmailId() {
		return (RandomStringUtils.randomAlphabetic(5));
	}

}
