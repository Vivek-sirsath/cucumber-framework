package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCustomerPage {

	public WebDriver ldriver;

	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Find WebElements on Web Page

	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement lnkCustomersDropdown;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement lnkCustomersOption;

	@FindBy(xpath = "//a[@href='/Admin/Customer/Create']")
	WebElement addNewBtn;

	@FindBy(xpath = "//div[@class='card-title']")
	WebElement formTitle; // It should contain text 'Customer info'

	@FindBy(id = "Email")
	WebElement emailField;

	@FindBy(id = "Password")
	WebElement passwordField;

	@FindBy(id = "FirstName")
	WebElement firstNameField;

	@FindBy(id = "LastName")
	WebElement lastNameField;

	@FindBy(id = "Gender_Male")
	WebElement genderMaleRadioBtn;

	@FindBy(id = "Gender_Female")
	WebElement genderFemaleRadioBtn;

	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement dateOfBirth;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyName;

	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement vendorManager;

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement textCommentArea;

	@FindBy(xpath = "//button[@name='save']")
	WebElement saveButton;

	// Identify methods to perform on web elements
	public String getPageTitle() {
		return ldriver.getTitle();
		// Page Title - Dashboard should display
	}

	public void clickOnCustomersDropdownMenu() {
		lnkCustomersDropdown.click();
			
	}

	public void clickOnCustomersOption() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOf(lnkCustomersOption)).click();
		
	}

	public void clickOnAddNewBtn() {
		addNewBtn.click();
	}

	public String addNewCustomerFormVisibility() {
		return formTitle.getText();
	}

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void enterGender(String gender) {
		if (gender.equals("Male")) {
			genderMaleRadioBtn.click();
		} else if (gender.equals("Female")) {
			genderFemaleRadioBtn.click();
		} else// default set Male gender
		{
			genderMaleRadioBtn.click();
		}

	}

	public void enterDob(String dob) {
		dateOfBirth.sendKeys(dob);
	}

	public void enterCompanyName(String coName) {
		companyName.sendKeys(coName);
	}

	public void selectVendorFromDropdown(String value) {
		Select select = new Select(vendorManager);
		select.selectByVisibleText(value);
	}

	public void enterAdminComment(String commnt) {
		textCommentArea.sendKeys(commnt);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

}
