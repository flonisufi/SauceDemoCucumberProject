package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class LoginPage {

    public LoginPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart;


    public void setCredentials(String userN,String pass)
    {
        username.sendKeys(userN);
        password.sendKeys(pass);

    }

    public void login()
    {
        loginBtn.click();
    }

    public WebElement addtoCart()
    {
        BrowserUtilities.waitForElementToAppear(addToCart);
        return addToCart;
    }



}
