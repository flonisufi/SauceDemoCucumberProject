package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class LogoutPage {

    public LogoutPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutBtn;

    @FindBy(id = "login-button")
    private WebElement login;

    public void logOutAcc()
    {
        BrowserUtilities.waitForElementToAppear(menu);
        menu.click();
        BrowserUtilities.waitForElementToAppear(logoutBtn);
        logoutBtn.click();
    }

    public WebElement loginBtn()
    {
        BrowserUtilities.waitForElementToAppear(login);
        return login;

    }
}
