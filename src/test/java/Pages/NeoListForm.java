package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NeoListForm {

    private final WebDriver driver;

    @FindBy(id = "mat-input-1")
    WebElement odbiorca;

    @FindBy(id = "mat-input-3")
    WebElement zwrotGrzecznosciowy;

    @FindBy(id = "mat-input-9")
    WebElement ulica;

    @FindBy(id = "mat-input-4")
    WebElement imie;

    @FindBy(id = "mat-input-5")
    WebElement nazwisko;

    @FindBy(id = "mat-input-10")
    WebElement nrDomu;

    @FindBy(id = "mat-input-12")
    WebElement kodPocztowy;

    @FindBy(id = "mat-input-13")
    WebElement miasto;

    @FindBy(id = "letter_hybrid_receiver_modal_add")
    WebElement dodajButton;

    @FindBy(id = "mat-input-2")
    WebElement tytulListu;

    @FindBy(css = "#letter_page_mailbox_form > input")
    WebElement wybierzPlik;

    @FindBy(css = "app-attachment-panel > mat-card > mat-card-footer")
    WebElement nameAddedFile;

    @FindBy(css = "#letter_page_submit")
    WebElement wyslijPrzycisk;


    public NeoListForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void formFillUp(String zwrot, String name, String surname, String street, String number,
                           String postalCode, String city, String title, String path){
        odbiorca.click();
        zwrotGrzecznosciowy.sendKeys(zwrot);
        imie.sendKeys(name);
        nazwisko.sendKeys(surname);
        ulica.sendKeys(street);
        nrDomu.sendKeys(number);
        kodPocztowy.sendKeys(postalCode);
        miasto.sendKeys(city);
        dodajButton.click();

        tytulListu.sendKeys(title);
        wybierzPlik.sendKeys(path);

    }
    public String isFileCorrect(){
        return nameAddedFile.getText();
    }
}

