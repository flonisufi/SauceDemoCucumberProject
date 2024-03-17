package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class VerifyPricePage {

    public VerifyPricePage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[text()='29.99']")
    private WebElement priceOut;

    @FindBy(css = "img[alt='Sauce Labs Backpack']")
    private WebElement product;

    @FindBy(css = ".inventory_details_price")
    private WebElement priceIn;

    public double setPriceOut()
    {
        BrowserUtilities.waitForElementToAppear(priceOut);
        String formatedPrice = priceOut.getText().split("\\$")[1].trim();
        return Double.parseDouble(formatedPrice);
    }

    public void goToProduct()
    {
        product.click();
    }

    public double setPriceIn()
    {
        BrowserUtilities.waitForElementToAppear(priceIn);
        String formatedPrice = priceIn.getText().split("\\$")[1].trim();
        return Double.parseDouble(formatedPrice);
    }
}
