package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(xpath = "//a[text()=' Clientes']")
            protected WebElement menuClient;

    @FindBy(xpath = "//a[text()=' Ventas']")
    protected WebElement menuSales;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMenuClient()
    {
        menuClient.click();
    }

    public void clickOnMenuSales()
    {
        menuSales.click();
    }
}
