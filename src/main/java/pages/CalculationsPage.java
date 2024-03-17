package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.List;

public class CalculationsPage {

    public CalculationsPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart1;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCart2;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addToCart3;

//    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
//    private WebElement addToCart4;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cart;

    @FindBy(id = "checkout")
    private WebElement checkout;

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> prices;

    @FindBy(css = ".summary_subtotal_label")
    private WebElement subtotal;

    public void addProducts()
    {
        addToCart1.click();
        addToCart2.click();
        addToCart3.click();

    }

    public void goToCart()
    {
        cart.click();
    }

    public double priceCalculations()
    {
        double sum = 0;
        for (WebElement price : prices)
        {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",price);
            sum += Double.parseDouble(price.getText().split("\\$")[1].trim());

        }
        return sum;
    }

    public double subTotalPrice()
    {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",subtotal);
        return Double.parseDouble(subtotal.getText().split("\\$")[1].trim());

    }


}
