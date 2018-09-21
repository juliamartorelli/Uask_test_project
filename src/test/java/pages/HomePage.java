package pages;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageObject {
	
    @FindBy(linkText="Home")
    private WebElement homeLink;

    public HomePage(WebDriver driver) {
        super(driver);
        //assertTrue(message.isDisplayed());
    }

   /*
    public String getMessage(){
        return message.getText();
    }*/
    
}
