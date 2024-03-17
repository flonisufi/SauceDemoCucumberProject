package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class PlaceOrderPage {

    public PlaceOrderPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeProd1;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement removeProd2;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    private WebElement removeProd3;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addProd1;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement addProd2;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement addProd3;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cart;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(css = ".complete-header")
    private WebElement confirmMessage;


    public void addProductsToCart()
    {
        removeProd1.click();
        removeProd2.click();
        removeProd3.click();
        addProd1.click();
        BrowserUtilities.waitForElementToAppear(addProd2);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",addProd2);
        addProd2.click();
        addProd3.click();
        BrowserUtilities.waitForElementToAppear(cart);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",cart);

    }

    public void finish()
    {
        BrowserUtilities.waitForElementToAppear(finishBtn);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",finishBtn);
        finishBtn.click();
    }

    public String orderMessage()
    {
        BrowserUtilities.waitForElementToAppear(confirmMessage);
        return confirmMessage.getText();
    }
}
