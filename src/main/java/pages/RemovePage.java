package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class RemovePage {

    Faker faker = new Faker();

    public RemovePage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCart;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cart;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement remove;

    @FindBy(id = "checkout")
    private WebElement checkout;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement zipCode;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(css = ".summary_total_label")
    private WebElement total;

    public void addProduct()
    {
        if (addToCart.getText().equalsIgnoreCase("Add to cart"))
        {
            addToCart.click();
        }
    }

    public void goToCartAndRemove()
    {
        cart.click();
        BrowserUtilities.waitForElementToAppear(remove);
        remove.click();
    }

    public void setFirstName(String name)
    {
        BrowserUtilities.waitForElementToAppear(firstName);
        firstName.sendKeys(name);
    }

    public void setLastName(String lstName)
    {
        lastName.sendKeys(lstName);
    }

    public void setZipCode(String zipC)
    {
        zipCode.sendKeys(zipC);
    }

    public void enterInformations(io.cucumber.datatable.DataTable dataTable)
    {
        checkout.click();

        List<Map<String,String>>data = dataTable.asMaps(String.class, String.class);

        for (Map<String,String>row : data)
        {
            String elementName = row.get("Element");

            switch (elementName)
            {
                case "FirstName":
                    setFirstName(faker.name().firstName());
                    break;
                case "LastName":
                    setLastName(faker.name().lastName());
                    break;
                case "ZipCode":
                    setZipCode(faker.address().zipCode());
                    break;

            }

        }
        continueBtn.click();
    }

    public double totalPrice()
    {
        BrowserUtilities.waitForElementToAppear(total);
        String formatedPrice = total.getText().split("\\$")[1].trim();
        return Double.parseDouble(formatedPrice);
    }
}
