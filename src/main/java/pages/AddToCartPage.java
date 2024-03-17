package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class AddToCartPage {

    public AddToCartPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCart;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement shopCartBadge;

    public void addProduct()
    {

            addToCart.click();
    }

    public int cardBadge()
    {


        return Integer.parseInt(shopCartBadge.getText());
    }
}
