package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ClientPage extends BasePage{
    @FindBy(xpath = "//button[text()=' Nuevo Cliente ']")
    protected WebElement createNewClientButton;

    @FindBy(id = "nombre")
    protected WebElement nameField;

    @FindBy(id = "codigo")
    protected WebElement codeField;

    @FindBy(id = "tipoDocumento")
    protected WebElement documentTypeDropDown;

    @FindBy(id="numeroDocumento")
    protected WebElement documentNumberfield;
    @FindBy(id = "email")
    protected WebElement emailField;
    @FindBy(id = "ventanaModalLabel")
    protected WebElement modalTitle;

    @FindBy(xpath = "//select[@name='grupoclienteId']")
    protected WebElement clientGroupDropDown;

    @FindBy(xpath = "//button[text()=' Guardar ']")
    protected WebElement saveButton;

    @FindBy(xpath = "//table[@class='table table-bordered table-hover']")
    protected WebElement usersTable;

    @FindBy(css = "table tbody tr:last-child td:last-child button:last-child")
    protected WebElement deleteButtonLastRecord;

    @FindBy(xpath = "//div[text()=' Código es obligatorio. ']")
    protected WebElement codeFieldWarningMessage;

    @FindBy(xpath = "//div[text()=' Nombre es obligatorio. ']")
    protected WebElement nameFieldWarningMessage;

    @FindBy(xpath = "//div[text()=' Tipo de documento es obligatorio. ']")
    protected WebElement documentTypeDropDownWarningMessage;

    @FindBy(xpath = "//div[text()=' Número de documento es obligatorio. ']")
    protected WebElement documentNumberFieldWarningMessage;

    @FindBy(xpath = "//div[text()=' Correo electrónico es obligatorio. ']")
    protected WebElement emailFieldWarningMessage;

    //div[text()=' Correo electrónico es obligatorio. ']

    public ClientPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCreateNewClientButton()
    {
        createNewClientButton.click();
    }

    public void fillForm(String clientCode, String name, String ci, String clientEmail)
    {
        wait.until(ExpectedConditions.visibilityOf(modalTitle));
        codeField.sendKeys(clientCode);
        nameField.sendKeys(name);
        Select select = new Select(documentTypeDropDown);
        select.selectByVisibleText("Carnet de Identidad");
        documentNumberfield.sendKeys(ci);
        emailField.sendKeys(clientEmail);
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
        return flag;
    }

    public void leaveFormInBlank() {
        wait.until(ExpectedConditions.visibilityOf(modalTitle));
        codeField.click();
        codeField.sendKeys("");
        codeField.sendKeys(Keys.TAB);
        nameField.sendKeys(Keys.TAB);
        documentTypeDropDown.sendKeys(Keys.TAB);
        documentNumberfield.sendKeys(Keys.TAB);
        emailField.sendKeys(Keys.TAB);
        clientGroupDropDown.sendKeys(Keys.TAB);
    }

    public boolean validatecodeFieldMandatoryMessage() {
        return codeFieldWarningMessage.isDisplayed();
    }

    public boolean validateNameFieldMandatoryMessageIdDisplayed() {
        return nameFieldWarningMessage.isDisplayed();
    }

    public boolean validateDocumentTypeDropDownMandatoryMessageIdDisplayed() {
        return documentTypeDropDownWarningMessage.isDisplayed();
    }

    public boolean validateDocumentNumberFieldMandatoryMessageIdDisplayed() {
        return documentNumberFieldWarningMessage.isDisplayed();
    }

    public boolean validateEmailFieldMandatoryMessageIdDisplayed() {
        return emailFieldWarningMessage.isDisplayed();
    }
}
