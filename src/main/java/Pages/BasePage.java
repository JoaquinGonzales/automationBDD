package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    Duration TIMEOUT = Duration.ofSeconds(10);
    private int TIMEOUT2 = 10;
    Duration POLLING = Duration.ofSeconds(10);
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT2), this);
    }

    public void goToHome()
    {
        driver.get("http://200.110.50.84/");
        driver.manage().window().maximize();
    }

}
