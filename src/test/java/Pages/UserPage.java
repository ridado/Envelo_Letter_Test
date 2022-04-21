package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"menu-item-2264\"]/a/i")
    private WebElement skrzynkaButton;

    @FindBy(xpath = "//*[@id=\"mat-expansion-panel-header-3\"]/span[1]")
    private WebElement nowaPrzesylkaButton;

    @FindBy(xpath = "//*[@id=\"cdk-accordion-child-3\"]/div/button[1]/span[1]")
    private WebElement neoListButton;

    public UserPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNeoList(){
        skrzynkaButton.click();
        nowaPrzesylkaButton.click();
        neoListButton.click();
    }
}
