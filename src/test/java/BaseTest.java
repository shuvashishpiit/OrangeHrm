import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static browser.Browser.getProperty;
@Listeners (value = TestListener.class)
public class BaseTest {

    WebDriver driver ;

   @Test
    public void setUp(){
       Browser.setDriver();
       driver = Browser.getDriver();
       driver.navigate().to(Browser.getProperty("url"));
       Assert.assertEquals(4,5);
    }
}
