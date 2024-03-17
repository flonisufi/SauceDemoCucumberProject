package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SortingPage {

    public SortingPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".product_sort_container")
    private WebElement sort;

    @FindBy(css = ".active_option")
    private WebElement sortText;

    public void sorting()
    {
        BrowserUtilities.waitForElementToAppear(sort);
        BrowserUtilities.select(sort,"za");
    }

    public String sortingText()
    {
        BrowserUtilities.waitForElementToAppear(sortText);
        return sortText.getText();
    }
}
