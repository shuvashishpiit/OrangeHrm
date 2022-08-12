import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static browser.Browser.getProperty;

public class BaseTest {

    WebDriver driver;

   @Test
    public void setUp(){
       driver = Browser.getDriver();
        driver.navigate().to(getProperty("url"));
    }
}
