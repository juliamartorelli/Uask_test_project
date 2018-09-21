package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	static WebDriver driver;
	
	public PageObject (WebDriver driver) {
		PageObject.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
