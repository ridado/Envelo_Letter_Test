package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnveloMainPage {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"menu-item-2155\"]/a")
    private WebElement zalogujButton;

//konstruktor

    public EnveloMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
//metody na elementach strony

    public void goToLogIn(){
        zalogujButton.click();
    }

}
