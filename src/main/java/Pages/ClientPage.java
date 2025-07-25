package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ClientPage extends BasePage{
    @FindBy(xpath = "//button[text()=' Nuevo Cliente ']")
    protected WebElement createNewClientButton;

    @FindBy(id = "nombre")
    protected WebElement nameField;

    @FindBy(id = "dip")
    protected WebElement dipField;

    @FindBy(id = "ventanaModalLabel")
    protected WebElement modalTitle;

    @FindBy(xpath = "//select[@name='grupoclienteId']")
    protected WebElement clientGroupDropDown;

    @FindBy(xpath = "//button[text()='Guardar']")
    protected WebElement saveButton;

    @FindBy(xpath = "//table[@class='table table-bordered table-hover']")
    protected WebElement usersTable;

    @FindBy(css = "table tbody tr:last-child td:last-child button:last-child")
    protected WebElement deleteButtonLastRecord;
    public ClientPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCreateNewClientButton()
    {
        createNewClientButton.click();
    }

    public void fillForm(String name, String ci)
    {
        wait.until(ExpectedConditions.visibilityOf(modalTitle));
        nameField.sendKeys(name);
        dipField.sendKeys(ci);
    }

    public void selectValueInDropDown(String groupClient)
    {
        Select select = new Select(clientGroupDropDown);
        select.selectByVisibleText(groupClient);
    }

    public void clickSaveButton()
    {
        saveButton.click();
    }

    public boolean userAddedToTheTable(String clientName)
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[@class='table table-bordered table-hover']/tbody"),clientName));
        List<WebElement> clientRows = usersTable.findElements(By.tagName("tr"));
        boolean isClientPresent = false;
        for(WebElement clientRow: clientRows)
        {
            if (clientRow.getText().contains(clientName))
            {
                isClientPresent = true;
            }
        }
        return isClientPresent;
    }

    public void clickDeleteButtonLastRecord()
    {
        deleteButtonLastRecord.click();
    }

    public void clickAcceptAlert()
    {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public boolean clientIsNotLongerPresent(String clientName)
    {
        boolean flag = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='"+clientName+"']")));
        System.out.println("this is the status" + flag);
        return flag;
    }
}
