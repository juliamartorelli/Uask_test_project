package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.HomePage;

public class LoginSteps {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	@Before("@login")
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\martinsj\\eclipse-workspace\\UAsk_Test_Project\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://admin-dev.askfield.com/");
		loginPage = new LoginPage(driver);
	}
	
	@After("@login")
    public void close() {
        driver.quit();
    }

	@Given("^User is on Sign In page$")
	public void loginPage() throws Throwable{
        assertTrue(driver.getCurrentUrl().equals("http://admin-dev.askfield.com/#/login"));
    }

	@When("^User enter a valid email and password$")
	public void enterEmailAndPassword() throws Throwable{
    	Thread.sleep(200);
    	loginPage.insertEmail("pedrojeunon@gmail.com");
        loginPage.insertPass("123456");
        homePage = loginPage.login();
    }

	@Then("^User can see the home page$")
    public void successLogin() throws Throwable{
		loginPage.login();
        //assertEquals("Signed in successfully.", homePage.getMessage());
    }
	/*
	@When("^User enter a invalid email and password$")
	public void enterInvalidEmail() throws Throwable{
		Thread.sleep(200);
    	loginPage.insertEmail("invalidEmail@email.com");
        loginPage.insertPass("123456");
        //fazer para senha
	}
	
	@Then("^User cant login and an error message is displaying$")
    public void unsuccessLogin() throws Throwable{
		loginPage.login();
        assertEquals("User not found.", loginPage.getMessageInvalidEmail());
    }*/
	
	
}
