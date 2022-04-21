package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    private final WebDriver driver;

    @FindBy(id = "username")
    private WebElement emailfield;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submitAnchor")
    private WebElement submitButton;


    public LogInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void userLogIn(String email, String password){
        emailfield.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
