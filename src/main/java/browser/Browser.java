package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Browser {

    private static WebDriver driver;

    public static String getProperty(String property) {
        String propertyValue = null;
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/browser.properties");

            Properties properties = new Properties();
            properties.load(inputStream);
           propertyValue = properties.getProperty(property);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }

    public static void setDriver() {
        String driverValue = getProperty("browser");

        if(driverValue.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(driverValue.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
