package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.HomePage;

public class LoginPage extends PageObject {
	
	@FindBy(id="email")
	private WebElement userEmail;
	
	@FindBy(id="password")
	private WebElement userPassword;
	
	@FindBy(xpath="//input[@mat-select-trigger]")
	private WebElement countryList;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement message;
	
	public LoginPage(WebDriver drive) {
		super(drive);//in PageObject
		assertTrue(userEmail.isDisplayed());		
	}
	
	public void insertEmail(String email) {
		this.userEmail.clear();
		this.userEmail.sendKeys(email);
	}
	
	public void insertPass(String password) {
		this.userPassword.clear();
		this.userPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		this.loginButton.click();
	}

	public HomePage login() {
		loginButton.click();
		return new HomePage(driver);
	}
	
	public String getMessageInvalidEmail() {
		return message.getText();
	}
}
