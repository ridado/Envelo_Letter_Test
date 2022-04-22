package bdd;

import Pages.*;
import helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnveloCreateLetterStepsDefinition {
    private WebDriver driver;

    @Given("user is on main page and click on zaloguj się button and input {string} and {string}")
    public void userIsOnMainPageAndClickOnZalogujSięButtonAndInputAnd(String arg0, String arg1) {
//        tu można zmienić na sterownik innej przeglądarki używając metod z klasy WebDriverFactory
        driver = WebDriverFactory.createChromedriverWithImplicitlyWait(10);

        driver.get("https://envelo.pl");

        EnveloMainPage enveloMainPage = new EnveloMainPage(driver);
        LogInPage logInPage = new LogInPage(driver);

        enveloMainPage.goToLogIn();
        logInPage.userLogIn(arg0,arg1);
    }

    @When("user clicks on incoming box, choose nowa przesyłka, Neolist")
    public void userClicksOnIncomingBoxChooseNowaPrzesyłkaNeolist() {
        UserPage userPage = new UserPage(driver);
        userPage.createNeoList();
    }
    @When("user fills recipient data, list tile and add file")
    public void userFillsRecipientDataListTileAndAddFile() {
        String zwrot = "Pani";
        String imie = " Barbara";
        String nazwisko = " Kowalska";
        String ulica = " Sezamkowa";
        String nr = "12";
        String kodPocztowy = "12-987";
        String miasto = " Katowice";
        String tytul = "Pozdrowienia z wakacji";
//        scieżka do pliku zlokalizowanego na komputerze
        String path = "/Users/karol_smieszek/CodersLab/Envelo_Letter_Test/src/main/resources/files/list.pdf";

        NeoListForm neoListForm = new NeoListForm(driver);
        neoListForm.formFillUp(zwrot, imie, nazwisko, ulica, nr, kodPocztowy, miasto, tytul, path);

    }
    @And("check is file name correct and clicks send button")
    public void checkIsFileNameCorrectAndClicksSendButton() {
        NeoListForm neoListForm = new NeoListForm(driver);
        String fileName = "list.pdf";

        Assertions.assertEquals(fileName, neoListForm.isFileCorrect(), "nazwa pliku jest inna!");
        driver.findElement(By.id("letter_page_submit")).click();


    }

    @Then("clicks add to cart button and chcecks is price correct")
    public void clicksAddToCartButtonAndChcecksIsPriceCorrect() {
        String cena = "4,90 zł";
        SummaryPage summaryPage = new SummaryPage(driver);
        CartPage cartPage = new CartPage(driver);

        summaryPage.addToCart();
        Assertions.assertEquals(cena, cartPage.getActualPrice(), "Ceny róznią się od siebie!");

        driver.quit();

    }
}
