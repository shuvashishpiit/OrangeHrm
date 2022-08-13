import browser.Browser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestListener  extends TestListenerAdapter {
    private static final String SRC_FOLDER = "src\\screenshots\\";
    WebDriver driver = Browser.getDriver();

    public void onTestFailure(ITestResult tr){
        System.out.println("Test failed "+tr.getTestName());
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(screenShot.toPath(), new File(SRC_FOLDER, tr.getTestName()+".png").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
