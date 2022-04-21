package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {

    private final WebDriver driver;

    @FindBy(css = "div > div.col-12.col-sm-6.col-lg-2 > button")
    WebElement dodajDoKoszyka;

    public SummaryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addToCart(){
        dodajDoKoszyka.click();
    }
}
