package pages;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id = "txtUsername") private WebElement userName;
    WebDriver driver = Browser.getDriver();

    public void openHomePage() {
        driver.navigate().to(Browser.getProperty("url"));
    }

    public void logIn(){

    }

}
