import helpers.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestWithoutPOP {
    private WebDriver driver;


    @Before
    public void setup(){
        driver = WebDriverFactory.createChromedriverWithImplicitlyWait(10);

        driver.get("https://envelo.pl");
    }
    @After
    public void tearDown(){
        driver.quit();
        System.out.println("Test zakończony!");
    }

    @Test
    public void letterAdding(){

        //arrange

        String email = "ttesterski10@gmail.com";
        String password = "Testing!@#456";
        String tytuł = " Pozdrowienia";
        String filePath = "/Users/karol_smieszek/CodersLab/Envelo_Letter_Test/src/main/resources/files/list.pdf";
        String fileName = "list.pdf";
        String letterPrice = "4,90 zł";

        //act

        driver.findElement(By.xpath("//*[@id=\"menu-item-2155\"]/a")).click();

        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        WebElement zalogujButton = driver.findElement(By.id("submitAnchor"));
        zalogujButton.submit();
        WebElement skrzynkaButton = driver.findElement(By.xpath("//*[@id=\"menu-item-2264\"]/a/i"));
        skrzynkaButton.click();
        WebElement nowaPrzesylkaButton = driver.findElement(By.xpath("//*[@id=\"mat-expansion-panel-header-3\"]/span[1]"));
        nowaPrzesylkaButton.click();
        WebElement neoListButton = driver.findElement(By.xpath("//*[@id=\"cdk-accordion-child-3\"]/div/button[1]/span[1]"));
        neoListButton.click();
        WebElement odbiorcaField = driver.findElement(By.id("mat-input-1"));
        odbiorcaField.click();

        WebElement formularzZwrot = driver.findElement(By.id("mat-input-3"));
        formularzZwrot.sendKeys("Pani");
        WebElement formularzUlica = driver.findElement(By.id("mat-input-9"));
        formularzUlica.sendKeys("Bajeczna");
        WebElement formularzImie = driver.findElement(By.id("mat-input-4"));
        formularzImie.sendKeys("Halina");
        WebElement formularzNazwisko = driver.findElement(By.id("mat-input-5"));
        formularzNazwisko.sendKeys("Pajęczyna");
        WebElement formulqrzNrDomu = driver.findElement(By.id("mat-input-10"));
        formulqrzNrDomu.sendKeys("213");
        WebElement formularzKodPocztowy = driver.findElement(By.id("mat-input-12"));
        formularzKodPocztowy.sendKeys("00-675");
        WebElement formularzMiasto = driver.findElement(By.id("mat-input-13"));
        formularzMiasto.sendKeys("Gdańsk");
        WebElement dodajButton = driver.findElement(By.id("letter_hybrid_receiver_modal_add"));
        dodajButton.click();

        WebElement letterTitle= driver.findElement(By.id("mat-input-2"));
        letterTitle.click();
        letterTitle.sendKeys(tytuł);
        WebElement wybierzPlikButton = driver.findElement(By.cssSelector("#letter_page_mailbox_form > input"));
        wybierzPlikButton.sendKeys(filePath);
        WebElement uploadedFileName = driver.findElement(By.cssSelector("app-attachment-panel > mat-card > mat-card-footer"));

        Assertions.assertEquals(fileName, uploadedFileName.getText());

        WebElement wyślijButtom = driver.findElement(By.id("letter_page_submit"));
        wyślijButtom.click();
        WebElement dodajDoKoszykaButton = driver.findElement(By.cssSelector("div > div.col-12.col-sm-6.col-lg-2 > button"));
        dodajDoKoszykaButton.click();

        WebElement actualPrice = driver.findElement(By.xpath("//*/td[3]/p[2]"));

        //assert

        Assertions.assertEquals(letterPrice, actualPrice.getText());

    }
}
