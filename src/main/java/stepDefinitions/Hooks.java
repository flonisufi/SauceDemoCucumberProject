package stepDefinitions;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    public Hooks()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @Before
    public void setup()
    {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @AfterAll
    public static void afterAll()
    {
        Driver.getDriver().quit();
    }

    @AfterStep
    public void Screenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed())
        {
            File sourcPath = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcPath);
            scenario.attach(fileContent,"image/png","image");

        }

    }
}
