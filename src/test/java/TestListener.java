import browser.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestListener  extends TestListenerAdapter {
    private static final String SRC_FOLDER = "src/screenshots/";
    WebDriver driver;

    public void onTestFailure(ITestResult tr){
        System.out.println("Test failed "+tr.getName());
        driver = Browser.getDriver();
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(SRC_FOLDER+tr.getName()+".png");
        try {
            FileUtils.copyFile(screenShot, destFile);
        } catch (IOException e) {
            System.out.println("Did not get dest ********");
            e.printStackTrace();
        }

    }

}
