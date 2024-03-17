package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ErrorLoginPage {

    public ErrorLoginPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "h3[data-test='error']")
    private WebElement message;


    public String errorMessage()
    {
        return message.getText();
    }
}
