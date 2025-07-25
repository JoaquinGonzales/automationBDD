package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SalePage extends BasePage{
    @FindBy(xpath = "//h4/following-sibling::select")
    protected WebElement productGroupSelect;

    @FindBy(xpath = "//p[@class='card-text']/following-sibling::button")
    protected WebElement addProductButton;

    @FindBy(xpath = "//input[@placeholder='Ingrese CI']")
    protected WebElement searchClientInputField;

    @FindBy(xpath = "//button[text()=' Buscar ']")
    protected WebElement searchButton;

    @FindBy(xpath = "//button[text()=' Pagar ']")
    protected WebElement payButton;

    public SalePage(WebDriver driver) {
        super(driver);
    }

    public void setProductGroupInDropDown(String productGroup)
    {
        Select select = new Select(productGroupSelect);
        select.selectByVisibleText(productGroup);
    }

    public void clickOnAddButtonForFirstElement()
    {
        addProductButton.click();
    }

    public void setClientCodeInField(String clientCode)
    {
        searchClientInputField.sendKeys(clientCode);
        searchButton.click();
    }

    public void clickOnPayButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(payButton));
        payButton.click();
    }

    public boolean saleRegisteredSuccessfully()
    {
        boolean flag = false;
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        if (alert != null)
        {
            flag = true;
        }
        alert.accept();
        return flag;
    }

}
