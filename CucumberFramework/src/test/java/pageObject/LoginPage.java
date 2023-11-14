package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	// Identify Web Elements
	
	@FindBy(id = "Email")
	WebElement emailField;
	
	@FindBy(id = "Password")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@class = 'button-1 login-button']")
	WebElement loginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logoutLink;
	
	
	
	// Perform action on web elements
	public void enterEmail(String emailAddress) {
		emailField.clear();
		emailField.sendKeys(emailAddress);
	}
	
	public void enterPassword(String pwd) {
		passwordField.clear();
		passwordField.sendKeys(pwd);
	}
	
	public void clickOnLoginButton() {
		loginBtn.click();
	}
	
	public void clickOnLogoutLink() {
		logoutLink.click();
	}
}
