package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtilities {

    public static Select select;

    public BrowserUtilities()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public static void waitForElementToAppear(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void select(WebElement element,String value)
    {
        select = new Select(element);
        select.selectByValue(value);

    }
}
